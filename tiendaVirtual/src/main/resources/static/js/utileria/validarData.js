import { colorError, mensajeError } from "./ErroresForm.js";

const errorMensaje = {
    email: "🔴 Ingrese un correo",
    password: "🔴 Ingrese la contraseña"
};

export function validarData(form, inputs) {

    let hasError = false;

    for (const [key, input] of Object.entries(inputs)) {
        
        let isEmpty = form.get(key)?.length === 0 || form.get(key) === null;
        const error = key === "password" ? colorPassword(input, isEmpty) :
            colorError(input, isEmpty);

        if (error) {
            hasError = true;
            key === "password" ? mensajeError(input.parentElement.parentElement.parentElement, errorMensaje[key], input) :
                mensajeError(input.parentElement.parentElement, errorMensaje[key], input);
        }
        else {
            continue;
        }

    }

    return hasError;

}

function colorPassword(input, isEmpty) {
    let res = false;

    for (const inp of input.parentElement.parentElement.parentElement.querySelectorAll("input[type=password")) {
        res = colorError(inp, isEmpty);
    }

    return res;
}