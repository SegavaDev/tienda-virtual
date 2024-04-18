export  class Empresa {

    constructor(nit, nombre, direccion) {
        this._nit = nit,
        this._nombre = nombre,
        this._direccion = direccion
    }

    get nit() {
        return this.nit;
    }

    get nombre() {
        return this.nombre;
    }

    get direccion() {
        return this.direccion;
    }

    set nit(nit) {
        this._nit = nit;
    }

    set nombre(nombre) {
        this._nombre = nombre;
    }

    set direccion(direccion) {
        this._direccion = direccion;
    }

}