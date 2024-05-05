export function verPass() {
    const btnVerPass = document.getElementById("verPass");
    const pass = document.querySelector("input[name=password]");
    const pass2 = document.querySelector("input[name=password2");

    btnVerPass.innerHTML = `🙈`;

    btnVerPass.addEventListener("click", (e) => {
        btnVerPass.classList.toggle("btn-danger");
        btnVerPass.innerHTML = btnVerPass.classList.contains("btn-danger") ?
            "🙉" : "🙈";

        if (pass.type === "password" && pass2.type === "password") {
            pass.type = "text";
            pass2.type = "text";
        }
        else {
            pass.type = "password";
            pass2.type = "password";
        }
    })
}

export function verPassLogin() {
    const btnVerPass = document.getElementById("verPass");
    const pass = document.querySelector("input[name=password]");

    btnVerPass.innerHTML = `🙈`;

    btnVerPass.addEventListener("click", (e) => {
        btnVerPass.classList.toggle("btn-danger");
        btnVerPass.innerHTML = btnVerPass.classList.contains("btn-danger") ?
            "🙉" : "🙈";

        pass.type = pass.type === "password" ? "text" : "password";
    })
}