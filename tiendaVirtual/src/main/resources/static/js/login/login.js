import { verPassLogin } from "../registrar/tools/verPass.js";
import { lanzadorGlobal } from "../utileria/lanzador.js";
import { validarData } from "../utileria/validarData.js";
import { apiLogin } from "./api/apiLogin.js";

// lanzador footer, modo oscuro/light
lanzadorGlobal();

// Mostrar/ocultar password
verPassLogin();

// Capturar formulario
const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
    e.preventDefault();

    // Inputs
    const inputs = {
        email: document.querySelector("input[type=email]"),
        password: document.querySelector("input[type=password]")
    }

    // Generar data formulario
    const formData = new FormData(form);

    if(!validarData(formData, inputs)) {

        const data = {
            "username": formData.get("email"),
            "password": formData.get("password")
        };

        apiLogin(data);
    }
    else {
        return;
    }
})