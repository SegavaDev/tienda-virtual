export function formCrearEmpresa() {
    const template = //html
        `
            <form class="container-fluid d-flex flex-column align-items-center justify-content-center gap-3 w-75 h-50">

                <div class="d-flex flex-column gap-3 align-items-center justify-content-center h-50">
                    <div class="input-group flex-nowrap inputsData">
                        <span class="input-group-text">&#x1f3ed;&#xfe0e;</span>
                        <input type="number" class="form-control" placeholder="Nit" name="nit" required>
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

                <div class="d-flex align-items-center justify-content-around w-75 h-50">

                    <button type="button" class="btn btn-danger rounded-3 d-flex align-items-center justify-content-center fs-4 btnLR">Cancelar</button>

                    <button type="button" class="btn btn-primary rounded-3 d-flex align-items-center justify-content-center fs-4 btnLR">Siguiente</button>
                    
                </div>

            </form>
        `

        return template;
}