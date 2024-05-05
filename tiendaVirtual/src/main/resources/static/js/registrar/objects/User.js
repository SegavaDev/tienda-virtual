class User {

    cedula;
    p_nombre;
    s_nombre;
    p_apellido;
    s_apellido;
    rol;
    email;
    passWord;
    empresa;
    telefono;
    sexo;

    constructor(
        cedula,
        p_nombre,
        s_nombre,
        p_apellido,
        s_apellido,
        rol,
        email,
        passWord,
        telefono,
        sexo,
        empresa = null
    ) {

        this.cedula = cedula,
        this.p_nombre = p_nombre,
        this.s_nombre = s_nombre,
        this.p_apellido = p_apellido,
        this.s_apellido = s_apellido,
        this.rol = rol,
        this.email = email,
        this.passWord = passWord,
        this.telefono = telefono,
        this.sexo = sexo,
        this.empresa = empresa
    }

    get empresa () {
        return this.empresa;
    }

    get rol() {
        return this.rol;
    }

    set empresa(nit) {
        this.empresa = nit;
    }

}

export default User;