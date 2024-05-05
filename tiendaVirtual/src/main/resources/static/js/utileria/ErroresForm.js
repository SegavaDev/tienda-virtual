export function colorError(parent, condicion) {
    return condicion ? conError(parent) : sinError(parent);
}

function conError(parent) {

    parent.style.border = "2px red solid";

    return true;

}

function sinError(parent) {

    parent.style.border = "2px #dee2e6 solid";
    const presente = document.getElementById(`error${parent.dataset.id}`) || null;

    if (presente !== null) {
        presente.remove();
        return false;
    }
    else {
        return false;
    }

}

export function mensajeError(parent, mensaje, tipo) {

    const presente = document.getElementById(`error${tipo.dataset.id}`) || null;

    if (presente === null) {
        const template = `
            <div class="col" id="error${tipo.dataset.id}">
                <p class="text-danger text-center">${mensaje}</p>
            </div>
        `;

        parent.insertAdjacentHTML("beforeend", template);

        return true;
    }
    else {
        return true;
    }

}

export function errorPass(listPass, condicion) {
    listPass.forEach(
        pass => {
            colorError(pass, condicion);
        }
    );

    return condicion;
}