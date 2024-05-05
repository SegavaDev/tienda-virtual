import { apiRegistro } from "./api/apiRegistroUser.js";
import { asignarModalMensaje } from "./tools/asignarModal.js";
import { capitalizar } from "../utileria/capitalizar.js";
import { formCrearEmpresa } from "./templates/tempRegistrarEmpresa.js";
import Empresa from "./objects/Empresa.js";
import Registro from "./objects/Registro.js";

export function registrarEmpresa(marcoIzquierdo, user) {

    // Modificar título
    const titulo = document.getElementById("titulo");
    titulo.textContent = "Registrar empresa";

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
        const res = apiRegistro(registro);

        asignarModalMensaje(res);

    })
}