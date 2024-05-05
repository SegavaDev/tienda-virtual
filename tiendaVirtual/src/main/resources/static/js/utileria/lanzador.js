import { darkLight, templateButton, validarModoDark } from "./darkLight.js";
import { inyectarFooter } from "../template_global/Footer.js";
import { verPass, verPassLogin } from "../registrar/tools/verPass.js";

export function lanzadorGlobal() {
    // Inyectar btn Dark/Light
    document.querySelector("main").insertAdjacentHTML("afterbegin", templateButton());
    // Validar modo oscuro
    validarModoDark();

    // Botón modo oscuro
    document.querySelector(".btnDarkLight").addEventListener("click", darkLight);

    // Inyectar footer
    inyectarFooter()
}

export function lanzadorVerPassLogin() {
    // Mostrar/ocultar password
    verPassLogin();
}

export function lanzadorVerPassRegistrar() {
    // Mostrar/ocultar password
    verPass();
}