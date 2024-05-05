export function templateButton() {
    const template = //html
        `
            <button class="btn btn-dark d-flex align-items-center justify-content-center position-absolute fs-1 text-center btnDarkLight"></button>
        `;
    
    return template;
}

export function darkLight() {
    // Modo light
    if (document.querySelector(".modoOSBri").classList.contains("marco__dark")) {
        modoLight();
    }
    else {
        // Modo dark
        modoDark(true);
    }
}

export async function validarModoDark() {
    await JSON.parse(localStorage.getItem("modo_oscuro")) === null ||
        await JSON.parse(localStorage.getItem("modo_oscuro")) === false ?
        modoLight() : modoDark(true);
    ;
}

function modoLight() {
    cambio();
    JSON.stringify(localStorage.setItem("modo_oscuro", false));
}

function modoDark(validacion) {
    cambio(validacion);
    JSON.stringify(localStorage.setItem("modo_oscuro", true));
}

function cambio(validacion = false) {
    const clases = document.querySelectorAll(".modoOSBri");
    const btn = document.querySelector(".btnDarkLight");

    btn.innerHTML = !validacion ? `🌜` : `🌞`;

    clases.forEach(
        clase => {
            if (validacion) {
                clase.classList.toggle("marco__dark", true);
                btn.classList.toggle("btn-light", true);
                btn.classList.toggle("btn-dark", false);
            }
            else {
                clase.classList.toggle("marco__dark", false);
                btn.classList.toggle("btn-light", false);
                btn.classList.toggle("btn-dark", true);
            }
        }
    )
}