import { modalAcceso } from "../../utileria/modalAcceso.js";
import { modalError } from "../../utileria/modalError.js";

export async function asignarModalMensaje(response) {
    const data = await response;

    if(data.hasError) {
        modalError(data.Mensaje);
    }
    else {
        modalAcceso(data.Mensaje, "/");
    }
}