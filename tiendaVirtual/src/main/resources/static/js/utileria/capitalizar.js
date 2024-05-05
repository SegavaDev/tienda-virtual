export function capitalizar(texto) {
    if (texto !== null) {
        return texto.charAt(0).toUpperCase() + texto.slice(1);
    }
    else {
        return null;
    }
}