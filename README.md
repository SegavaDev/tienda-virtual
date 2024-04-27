# PROYECTO DE PRÁCTICA

# 🛍️ Tienda virtual

***Este proyecto se realiza como práctica.***

## 🛠️ Tecnologías usadas:

<div style="display: flex; justify-content: space-evenly">
    <img src="./assets/html.png" alt="html logo" width=100px; height=90px>
    <img src="./assets/css.png" alt="html logo" width=100px; height=90px>
    <img src="./assets/javaScript.png" alt="html logo" width=100px; height=90px>
    <img src="./assets/java.png" alt="html logo" width=100px; height=90px>
    <img src="./assets/Spring Boot.png" alt="html logo" width=100px; height=90px>
    <img src="./assets/jwt.png" alt="html logo" width=100px; height=90px>
    <img src="./assets/MySQL.png" alt="html logo" width=100px; height=90px;>
    <img src="./assets/bootstrap.png" alt="html logo" width=100px; height=90px>
</div>

---

## ✅ Estado:
=> **En proceso ( éste repositorio solo muestra un login funcional, la continuación del proyecto se realiza en un repositorio privado, si desea conocer sobre los avances del mismo, no dude en escribir al email segava.dev@gmail.com )**

|No.| 📦 Módulo | 🚩 Estado | 🚧 Pendiente |
|:-:|:---------:|:---------:|:--------------:|
|1  |Login      |En proceso |Mejoras visuales|

---

## 📑 Pasos:

1. **Cree la base de datos con MySQL:**

    ~~~sql
        CREATE DATABASE IF NOT EXISTS tienda_virtual;
    ~~~

1. **Descargue y descomprima el .zip o clone el proyecto**

1. **Configure properties:**
    1. Ruta dentro del proyecto: **Backend/tiendaVirtual/src/main/resources/application.properties**

    2. Cambie usuario y contraseña de su base de datos:
        * **spring.datasource.username=su_usuaro**
        * **spring.datasource.password=su_contraseña**
        * Haga mas cambios si asi lo requiere

1. **Inicialice el sistema:**

    * Ruta: Backend/tiendaVirtual/src/main/java/com/segavaDev/tiendaVirtual/TiendaVirtualApplication.java

    * Desde visual code:
        ![Imagen guia](./assets/VISUAL%20CODE.png)

    * Desde terminal:

        ~~~bash
            cd /ruta/a/tu/proyecto

            mvn package
        ~~~

        ejemplo:
        ~~~bash
            cd Descargas/tienda-virtual-master/Backend/tiendaVirtual

            mvn package
        ~~~

        o si lo clonó

        ~~~bash
            cd Descargas/tienda-virtual/Backend/tiendaVirtual

            mvn package
        ~~~


        luego
        ~~~bash
            cd target

            java -jar tiendaVirtual-0.0.1-SNAPSHOT.jar
        ~~~

1. **URL's navegador web:**
    * http://localhost:3001


---
# 🔐 Licencia

<p xmlns:cc="http://creativecommons.org/ns#" xmlns:dct="http://purl.org/dc/terms/"><a property="dct:title" rel="cc:attributionURL" href="https://github.com/SegavaDev/tienda-virtual">Tienda virtual</a> © 2024 por <a rel="cc:attributionURL dct:creator" property="cc:attributionName" href="https://github.com/SegavaDev">Sergio Garavito</a> tiene licencia bajo <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">CC BY-NC-SA 4.0 <img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/cc.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/by.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/nc.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/sa.svg?ref=chooser-v1" alt=""></a></p>