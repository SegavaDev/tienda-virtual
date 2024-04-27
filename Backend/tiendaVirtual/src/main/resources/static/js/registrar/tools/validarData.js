import { colorError, mensajeError } from "./ErroresForm.js";

const errorMensaje = {
    cedula: "🔴 Ingrese una cédula",
    p_nombre: "🔴 Ingrese un nombre",
    p_apellido: "🔴 Ingrese un Apellido",
    email: "🔴 Ingrese un correo",
    telefono: "🔴 Ingrese un teléfono",
    sexo: "🔴 Seleccione un sexo",
    rol: "🔴 Seleccione un rol",
    password: "🔴 Complete las contraseñas",
    passwordDif: "🔴 Las contraseñas no coinciden"
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

    if (form.get("password") !== form.get("password2") && form.get("password2")?.length !== 0) {
        hasError = true;
        mensajeError(inputs.password.parentElement.parentElement.parentElement, errorMensaje.passwordDif, inputs.password);
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