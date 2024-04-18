import Registro from "./objects/Registro.js";
import { formCrearEmpresa } from "./templates/tempRegistrarEmpresa.js";

// Marco de formularios

const marcoIzquierdo =  document.getElementById("marcoIzquierdo");

// Registrar empresa

// Título
document.getElementById("titulo").textContent = "Registrar empresa";

// Inyectar formulario de registro de empresa
marcoIzquierdo.insertAdjacentHTML("beforeend", formCrearEmpresa());