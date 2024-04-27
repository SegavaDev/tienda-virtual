export function modalError(mensaje, url = null) {
    const template = //html
        `
        <div class="w-100 h-100 position-fixed bg-light bg-opacity-75 z-3 d-flex align-items-center justify-content-center" id="mensajeError">
            <div class="w-75 h-75 rounded-2 d-flex flex-column align-items-center justify-content-center modoOSBri">
                <div class="row h-50 w-75 align-content-center">
                    <h3 class="text-center fs-3 " id="mensaje">${mensaje}</h3>
                </div>
                <div class="row align-content-center justify-content-center">
                    <img src="./assets/error.gif" alt="imagen error" class="img-fluid w-50">
                </div>
                <button class="btn btn-outline-danger w-25">Ok</button>
            </div>
        </div>
        `

    document.querySelector("main").insertAdjacentHTML("beforebegin", template);
    const mensajeError = document.getElementById("mensajeError");

    mensajeError.querySelector("button")
        .addEventListener("click", (e) => {
            if (url === null) {
                mensajeError.remove();
            }
            else {
                window.location.href = url;
            }
        })
}