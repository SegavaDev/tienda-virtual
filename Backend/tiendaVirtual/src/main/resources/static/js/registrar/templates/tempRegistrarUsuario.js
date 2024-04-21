export function formCrearUsuario() {
    const template = //html
        `
        <form class="row align-items-center justify-content-center" id="formUser">

            <div class="row col-lg-11 col-md-10 col-10 align-items-center justify-content-start g-1">
                <div class="row g-1">
                    <p class="fs-5">Los campos con <span class="text-danger">*</span> son obligatorios</p>
                </div>
                <!-- Cédula -->
                <div class="d-flex col-xl-6 col-lg-10 col-md-8 col-sm-8">
                    <div class="input-group flex-nowrap inputsData position-relative">
                        <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                        <span class="input-group-text"> &#x2714;</span>
                        <input type="number" class="form-control" placeholder="cédula" name="cedula" required>
                    </div>
                </div>

                <!-- Nombres -->
                <div class="row g-1">
                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">&#x270d;</span>
                            <input type="text" class="form-control" placeholder="Primer nombre" name="p_nombre" required>
                        </div>
                    </div>
                    <div class="col-xl-6 col-md-12 col-sm-12">
                        <div class="input-group flex-nowrap inputsData">
                            <span class="input-group-text">&#x270d;</span>
                            <input type="text" class="form-control" placeholder="Segundo nombre" name="s_nombre">
                        </div>
                    </div>
                </div>

                <!-- Apellidos -->
                <div class="row g-1">
                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">&#x270d;</span>
                            <input type="text" class="form-control" placeholder="Primer apellido" name="p_apellido" required>
                        </div>
                    </div>
                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData">
                            <span class="input-group-text">&#x270d;</span>
                            <input type="text" class="form-control" placeholder="Segundo apellido" name="s_apellido">
                        </div>
                    </div>
                </div>

                <div class="row g-1">
                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">👥</span>
                            <select name="sexo" id="sexo" class="form-select" required>
                                <option disabled selected>Sexo</option>
                                <option value="F">Femenino</option>
                                <option value="M">Masculino</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">👤</span>
                            <select name="rol" id="rol" class="form-select" required>
                                <option disabled selected>Rol</option>
                                <option value="administrador">Administrador</option>
                                <option value="cliente">Cliente</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row g-1">
                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">&#x1f4ec;&#xfe0e;</span>
                            <input type="email" class="form-control" placeholder="Email" name="email" required>
                        </div>                            
                    </div>

                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">📱</span>
                            <input type="tel" class="form-control" placeholder="Teléfono" name="telefono" required>
                        </div>
                    </div>
                </div>

                <div class="row g-1">
                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">&#x1f512;&#xfe0e;</span>
                            <input type="password" id="pass" class="form-control" placeholder="Contraseña" name="password" required>
                        </div>
                    </div>

                    <div class="col-xl-6 col-md-12  col-sm-12">
                        <div class="input-group flex-nowrap inputsData position-relative">
                            <span class="text-danger position-absolute end-0 z-1 pe-2 fs-4">*</span>
                            <span class="input-group-text">&#x1f512;&#xfe0e;</span>
                            <input type="password" class="form-control" placeholder="Repita contraseña" name="password2" required>
                        </div>
                    </div>
                </div>
            </div>

            <div class="d-flex align-items-center justify-content-center gap-2 btnsRegUsuario">

                <a href="/" class="btn btn-danger rounded-3 d-flex align-items-center justify-content-center fs-4 btnLR" id="cancelar">Cancelar</a>

                <button type="submit" class="btn btn-primary rounded-3 d-flex align-items-center justify-content-center fs-4 btnLR">Siguiente</button>
                
            </div>

        </form>
        `;

        const imagen = `<img src="./assets/registrar persona.png" alt="Market virtual" class="img-fluid"></img>`;
        document.getElementById("marcoDerecho").insertAdjacentHTML("beforeend", imagen);

        return template;
}