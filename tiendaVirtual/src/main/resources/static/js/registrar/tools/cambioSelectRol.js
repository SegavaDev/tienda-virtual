export function cambiarTextBoton(select) {
    select.addEventListener("change", (e) => {
        if (select.value === "USUARIO") {
            document.querySelector("button[type=submit").textContent = "Enviar";
        }
        else {
            document.querySelector("button[type=submit").textContent = "Siguiente";
        }
    })
}