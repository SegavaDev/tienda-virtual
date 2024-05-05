export function formCrearEmpresa() {
    const template = //html
        `
        <form class="row align-items-center justify-content-center" method="post" id="formEmpresa">

            <div class="row col-10 align-items-center justify-content-center gap-2 ">
                <div class="input-group flex-nowrap inputsData">
                    <span class="input-group-text">&#x1f3ed;&#xfe0e;</span>
                    <input type="text" class="form-control" placeholder="Nit" name="nit" required>
                </div>

                <div class="input-group flex-nowrap inputsData">
                    <span class="input-group-text">&#x1f5b9;</span>
                    <input type="text" class="form-control" placeholder="Nombre" name="nombre" required>
                </div>

                <div class="input-group flex-nowrap inputsData">
                    <span class="input-group-text">&#x1f5fa;</span>
                    <input type="text" class="form-control" placeholder="Dirección" name="direccion" required>
                </div>
            </div>

            <div class="d-flex align-items-center justify-content-center gap-2 btnsRegEmpresa">

                <a href="/" class="btn btn-danger rounded-3 d-flex align-items-center justify-content-center fs-4 btnLR" id="cancelar">Cancelar</a>

                <button type="submit" class="btn btn-primary rounded-3 d-flex align-items-center justify-content-center fs-4 btnLR" id="siguiente">Enviar</button>
                
            </div>

        </form>
        `

    const imagen = `<img src="./assets/registrar negocio.png" alt="Market virtual" class="img-fluid"></img>`;
    document.getElementById("marcoDerecho").insertAdjacentHTML("beforeend", imagen);

    return template;
}