class Registro {

    constructor(empresa, administrador) {
        this._empresa = empresa,
        this._administrador = administrador
    }

    get empresa() {
        return this._empresa;
    }

    get administrador() {
        return this._administrador;
    }

    set empresa(empresa) {
        this._empresa = empresa;
    }

    set administrador(administrador) {
        this._administrador = administrador;
    }
    
}

export default Registro;