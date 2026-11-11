# Proyecto 2: Inventario de Tienda - Donde Miguel

## Descripción del proyecto
Aplicación web desarrollada en Java para la gestión del inventario de la tienda "Donde Miguel". Permite registrar productos clasificados en diferentes secciones, llevar el control del stock mediante entradas y salidas, y consultar el valor total del inventario. El sistema no utiliza bases de datos; funciona completamente con persistencia local en archivos de texto (`.txt`), cumpliendo con todos los requisitos exigidos para el proyecto.

## Tecnologías usadas
* Java y Spring Boot
* Vaadin 25 (Solo componentes gratuitos)
* Componentes investigados: `TabSheet`, `Badge` y `NumberField`
* Persistencia de datos en archivos de texto legibles.

## Cómo ejecutarlo
1. Abre la carpeta raíz del proyecto en Visual Studio Code.
2. Ejecuta la aplicación desde tu archivo principal o abre la terminal y escribe el comando `.\mvnw spring-boot:run`.
3. Espera a que la terminal confirme el inicio y abre tu navegador en `http://localhost:8080`.

## Manual de uso

### 1. Pantalla principal y navegación
La interfaz está dividida mediante el componente `TabSheet` en tres pestañas principales: Productos, Movimientos y Reportes. En la vista de productos, el estado del stock se indica visualmente utilizando el componente `Badge`.
[Pantalla principal](capturas/1.PNG)<img width="1910" height="801" alt="1" src="https://github.com/user-attachments/assets/89cc101a-23dc-4e03-afb9-c659879169d6" />


### 2. Registrar Surtimiento
En la pestaña "Movimientos", se registran las entradas de mercancía. El formulario de surtimiento asegura la correcta digitación de cantidades y costos mediante el uso del componente `NumberField`.
[Registro surtimiento](capturas/2.PNG)<img width="1595" height="1025" alt="2" src="https://github.com/user-attachments/assets/fff6d527-09d0-4c8b-bf7d-ce50668e9b5f" />


### 3. Registrar Envíos
Permite registrar las salidas de la tienda, verificando las cantidades a través de los campos numéricos y actualizando el inventario general.
[Registro envíos](capturas/3.PNG)<img width="1782" height="1052" alt="3" src="https://github.com/user-attachments/assets/7114ff49-d64a-4d41-8a62-1418c472d97e" />


### 4. Valores del inventario
En la sección "Reportes", el sistema muestra una tabla resumen con el valor total en dinero de cada categoría (Canasta familiar, Confitería, Mascotas, Aseo general) y el gran total del inventario.
[Valores inventario](capturas/4.PNG)<img width="1841" height="943" alt="4" src="https://github.com/user-attachments/assets/cee3d17f-223f-477c-a051-4f703f3b78b8" />


### 5. Últimos Movimientos
Un registro auditable (bitácora) que permite consultar el historial exacto de todas las transacciones, detallando fechas, cantidades y productos afectados.
[Últimos movimientos](capturas/5.PNG)<img width="1885" height="901" alt="5" src="https://github.com/user-attachments/assets/4d829cc2-5b94-4e7a-ab57-a9999aa08e11" />


## Bonificación (+0.5): Kárdex con costo promedio ponderado
El proyecto incluye la función de bonificación. Al presionar el botón "Kárdex" en la pestaña de Reportes, se abre el historial detallado de recálculo del costo promedio ponderado de los productos tras cada nueva entrada, mostrando las cantidades, costos unitarios de compra y el valor total recalculado.
[Kárdex](capturas/6.PNG)<img width="1475" height="947" alt="6" src="https://github.com/user-attachments/assets/7d02ea2e-be08-4201-b975-fc484da22bf1" />


---
**Autor:** [Miguel Ángel Arias Ramírez]
**Fecha:** 11 de noviembre de 2026
