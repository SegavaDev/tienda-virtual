-- Active: 1710377841819@@127.0.0.1@3306@tienda_virtual
CREATE DATABASE IF NOT EXISTS tienda_virtual;

INSERT INTO
    roles (nombre, descripcion, permisos)
VALUES (
        "GERENTE", "Quien está a cargo de la empresa", "Todos los permisos"
    ),
    (
        "ADMINISTRADOR", "Quien está a cargo de una tienda o sucursal", "Todos los permisos excepto modificar Gerentes"
    ),
    (
        "CAJA", "Quien está en el punto de venta", "Crear y ver (ventas, facturas, clientes(usuarios)), ver inventario"
    ),
    (
        "USUARIO", "Quien realiza compras", "Ver productos en tienda virtual"
    );