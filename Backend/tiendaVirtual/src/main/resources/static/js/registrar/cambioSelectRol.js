export function cambiarTextBoton(select) {
    select.addEventListener("change", (e) => {
        if(select.value === "cliente") {
            document.querySelector("button[type=submit").textContent = "Enviar";
        }
        else {
            document.querySelector("button[type=submit").textContent = "Siguiente";
        }
    })
}