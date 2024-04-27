package com.segavaDev.tiendaVirtual.controllers.publico.registrar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segavaDev.tiendaVirtual.repositories.model.dto.personal.principal.RegistroDTO;
import com.segavaDev.tiendaVirtual.services.Usuario.UsuarioService;
import com.segavaDev.tiendaVirtual.util.validaciones.ExtraerDataExceptionSQL;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/public")
public class RegistrarResController {

    // Service
    private final UsuarioService usuarioService;

    @PostMapping("/registrarse")
    public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody RegistroDTO registroDTO,
            BindingResult result) {
        System.out.println(registroDTO.toString());

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors()
                    .stream()
                    .map(
                            error -> error.getField() + " " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("Errores", errores);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            try {
                if(registroDTO.getEmpresaDTO() == null) {
                    usuarioService.registrarUsuario(registroDTO.getUsuarioDTOcreacion());

                    response.put("Mensaje", " Se ha creado la cuenta con éxito");
                    response.put("hasError", false);
                }
                else {

                    usuarioService.registrarGerencia(registroDTO.getUsuarioDTOcreacion(), registroDTO.getEmpresaDTO());
                    response.put("Mensaje", " Se ha registrado la empresa y su gerente con éxito");
                    response.put("hasError", false);
                }

            } catch (DataIntegrityViolationException v) {
                String mensajeError = v.getCause().getMessage();
                String tabla = ExtraerDataExceptionSQL.nombreTabla(mensajeError);
                String valor = ExtraerDataExceptionSQL.valorDuplicado(mensajeError);

                tabla = tabla.contains("usuario") ? "usuario" : "empresa";

                response.put("hasError", true);
                response.put("Mensaje", "Ya hay otro/a " + tabla + " con el dato (" + valor + ") registrado.");

                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

            } catch (Exception e) {

                System.out.println("Error: " + e);
                response.put("hasError", true);
                response.put("Mensaje", "Ha ocurrido un error inesperado.");

                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
