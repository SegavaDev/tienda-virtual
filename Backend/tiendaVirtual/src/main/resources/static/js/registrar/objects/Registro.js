class Registro {

    user;
    empresa;

    constructor(user, empresa = null) {
        this.user = user,
        this.empresa = empresa
    }
    
}

export default Registro;