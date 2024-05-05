class Empresa {

    nit;
    nombre;
    direccion;

    constructor(nit, nombre, direccion) {
        this.nit = nit,
        this.nombre = nombre,
        this.direccion = direccion
    }

    get nit() {
        return this.nit;
    }

}

export default Empresa;