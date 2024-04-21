import { apiRegistro } from "./api/apiRegistroUser.js";
import { cambiarTextBoton } from "./cambioSelectRol.js";
import { capitalizar } from "../utileria/capitalizar.js";
import { colorError, mensajeError, errorPass } from "./ErroresForm.js";
import { formCrearEmpresa } from "./templates/tempRegistrarEmpresa.js";
import { formCrearUsuario } from "./templates/tempRegistrarUsuario.js";
import { inyectarFooter } from "../template_global/Footer.js";
import Empresa from "./objects/Empresa.js";
import Registro from "./objects/Registro.js";
import User from "./objects/User.js";

// Inyectar footer
inyectarFooter()

// Marco de formularios

const marcoIzquierdo = document.getElementById("marcoIzquierdo");

// Registrar usuario

// Título
const titulo = document.getElementById("titulo");
titulo.textContent = "Crear Usuario";

// Inyectar formulario de registro de usuario
marcoIzquierdo.insertAdjacentHTML("beforeend", formCrearUsuario());

// Formulario usuario
const formU = document.getElementById("formUser");

// Boton cancelar
document.getElementById("cancelar").addEventListener("click", (e) => {
    formU.remove();
})

const rol = document.getElementById("rol");

cambiarTextBoton(rol);

formUser.addEventListener("submit", (e) => {
    e.preventDefault();

    const formUser = new FormData(formU);

    const sexo = document.getElementById("sexo");

    const errSexo = colorError(sexo, formUser.get("sexo") === null) ? mensajeError(sexo.parentElement.parentElement, "🔴 Seleccione un sexo", sexo) : false;
    const errRol = colorError(rol, formUser.get("rol") === null) ? mensajeError(rol.parentElement.parentElement, "🔴 Seleccione un rol", rol) : false;
    const errPass = errorPass(document.querySelectorAll("input[type=password]"), formUser.get("password") !== formUser.get("password2")) ?
        mensajeError(document.querySelector("input[type=password]").parentElement.parentElement.parentElement,
            "🔴 Las contraseñas no coinciden", document.querySelector("input[type=password]")
        ) : false;

    if (
        !errSexo &&
        !errRol &&
        !errPass
    ) {

        const user = new User(
            formUser.get("cedula"),
            capitalizar(formUser.get("p_nombre")),
            capitalizar(formUser.get("s_nombre")),
            capitalizar(formUser.get("p_apellido")),
            capitalizar(formUser.get("s_apellido")),
            formUser.get("rol"),
            formUser.get("email"),
            formUser.get("password")
        )

        if(user.rol === "cliente") {
            const registro = new Registro(user);
            apiRegistro(registro);
        }
        else {

            // Registrar empresa

            titulo.textContent = "Registrar empresa";

            // Remover formulario usuario e imagen

            document.getElementById("marcoDerecho").querySelector("img").remove();
            
            formU.remove();

            // Inyectar formulario empresa

            marcoIzquierdo.insertAdjacentHTML("beforeend", formCrearEmpresa());

            const formEmp = document.getElementById("formEmpresa");

            formEmp.addEventListener("submit", (e) => {
                e.preventDefault();
            
                const formEmpresa = new FormData(formEmp);
            
                const empresa = new Empresa(
                    formEmpresa.get("nit"),
                    capitalizar(formEmpresa.get("nombre")),
                    formEmpresa.get("direccion")
                );

                user.empresa = empresa.nit;
            
                const registro = new Registro(user, empresa);
                apiRegistro(registro);
            
            }) 
        }

    }

    else {
        return;
    }

})

/*  */