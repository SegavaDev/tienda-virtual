import { apiValidarDataUser } from "../api/apiValidarDataUser.js";
import { colorError, mensajeError } from "./ErroresForm.js";

const mensajeErr = {
    cedula: "🔴 Ésta cédula ya está registrada",
    email: "🔴 Éste email ya está registrado"
}

// Se recive un objeto con inputs capturados
export function validarDataUser(fuente) {
    let hasError = false;
    const btnSubmit = document.querySelector("button[type=submit]");

    for (let campo of fuente) {

        campo.addEventListener("input", async (e) => {
            hasError = await consultar(campo, campo.dataset.id);
            const condicionErr = document.querySelector("form").querySelectorAll('[id*="error"]');

            if (condicionErr.length === 0) {
                btnSubmit.disabled = false;
            }
            else {
                btnSubmit.disabled = true;
            }
        })
    }
}

async function consultar(campo, key) {
    const data = {
        [key]: campo.value
    }

    const res = await apiValidarDataUser(data, key);
    if (res.result) {
        const existError = campo.parentElement.parentElement.querySelector(`#error${key}`) || false;

        if (existError) {
            existError.remove();
        }

        colorError(campo, res.result);
        mensajeError(campo.parentElement.parentElement, mensajeErr[key], campo);
        return true;
    }
    else {
        colorError(campo, res.result);
        return false;
    }
}