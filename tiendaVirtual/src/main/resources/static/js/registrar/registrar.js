import { apiRegistro } from "./api/apiRegistroUser.js";
import { asignarModalMensaje } from "./tools/asignarModal.js";
import { cambiarTextBoton } from "./tools/cambioSelectRol.js";
import { capitalizar } from "../utileria/capitalizar.js";
import { formCrearUsuario } from "./templates/tempRegistrarUsuario.js";
import { lanzadorGlobal, lanzadorVerPassRegistrar } from "../utileria/lanzador.js";
import { registrarEmpresa } from "./registrarEmpresa.js";
import { validarData } from "./tools/validarData.js";
import { validarDataUser } from "./tools/validarDataUser.js";
import Registro from "./objects/Registro.js";
import User from "./objects/User.js";

// Lanzador global
lanzadorGlobal();

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

// Botón cancelar
document.getElementById("cancelar").addEventListener("click", (e) => {
    formU.remove();
})

const inputs = {
    cedula: document.querySelector("input[name=cedula]"),
    sexo: document.querySelector("select[name=sexo]"),
    p_nombre: document.querySelector("input[name=p_nombre]"),
    p_apellido: document.querySelector("input[name=p_apellido]"),
    email: document.querySelector("input[name=email]"),
    telefono: document.querySelector("input[type=tel]"),
    rol: document.querySelector("select[name=rol]"),
    password: document.querySelector("input[type=password]")
}

// Validar cédula e mail
validarDataUser([inputs.cedula, inputs.email]);

// Cambia texto de botón submit dependiendo del rol
cambiarTextBoton(inputs.rol);

// Mostrar/ocultar password
lanzadorVerPassRegistrar();

formUser.addEventListener("submit", async (e) => {
    e.preventDefault();

    const formUser = new FormData(formU);

    //Validar campos vacios
    if (!validarData(formUser, inputs)) {

        const user = new User(
            formUser.get("cedula"),
            capitalizar(formUser.get("p_nombre")),
            capitalizar(formUser.get("s_nombre")),
            capitalizar(formUser.get("p_apellido")),
            capitalizar(formUser.get("s_apellido")),
            formUser.get("rol"),
            formUser.get("email"),
            formUser.get("password"),
            formUser.get("telefono"),
            formUser.get("sexo")
        )

        if (user.rol === "USUARIO") {
            const registro = new Registro(user);
            asignarModalMensaje(apiRegistro(registro));
        }
        else {

            // Remover imagen y formulario usuario
            document.getElementById("marcoDerecho").querySelector("img").remove();
            formU.remove();

            // Registrar empresa
            registrarEmpresa(marcoIzquierdo, user);

        }

    }

    else {
        return;
    }

})