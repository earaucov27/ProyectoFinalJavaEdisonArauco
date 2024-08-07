# E-commerce Application

## Descripción

Este proyecto es una aplicación de comercio electrónico desarrollada con Spring Boot. Permite la gestión de productos, clientes, carritos de compra y comprobantes de venta.

## Evidencias

Las Evidencias de funcionamiento a traves de postman las podran encontrar al final de este README

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

## Requisitos Previos

- Java 17 o superior
- MySQL
- Maven

# Configuración del Proyecto

## Configuración de la Base de Datos

- Crea una base de datos en MySQL:
  
```sql
CREATE DATABASE ecommerce;
```

## Actualiza el archivo application.properties con tu configuración de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
```

## Compilar y Ejecutar la Aplicación

```bash
mvn clean install
mvn spring-boot:run
```

## Estructura del Proyecto

```css
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── ecommerce
    │               ├── controllers
    │               │   ├── ClientController.java
    │               │   ├── ProductController.java
    │               │   ├── InvoiceController.java
    │               │   ├── InvoiceDetailController.java
    │               ├── entities
    │               │   ├── Client.java
    │               │   ├── Product.java
    │               │   ├── Invoice.java
    │               │   ├── InvoiceDetail.java
    │               ├── repositories
    │               │   ├── ClientRepository.java
    │               │   ├── ProductRepository.java
    │               │   ├── InvoiceRepository.java
    │               │   ├── InvoiceDetailRepository.java
    │               ├── services
    │               │   ├── ClientService.java
    │               │   ├── ProductService.java
    │               │   ├── InvoiceService.java
    │               │   ├── InvoiceDetailService.java
    │               └── EcommerceApplication.java
    └── resources
        ├── application.properties
```

## Clase Principal EcommerceApplication

```java
package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
}
```

# Probar la API con Postman

## Productos

- Crear o actualizar un producto
  
  URL: POST ```/api/v1/products```
```json
{
    "id": 1, // incluir solo si se está actualizando
    "description": "Producto 1 Modificado",
    "code": "P001",
    "stock": 200,
    "price": 19.99
}
```
- Leer productos
  
  URL: GET ```json /api/v1/products ```

- Leer un producto
  
  URL: GET ```/api/v1/products/{id}```

- Eliminar un producto
  
  URL: DELETE ```json /api/v1/products/{id}```

## Clientes

- Registrar un cliente
  
  URL: POST ```/api/v1/auth/register```
```json
{
    "name": "John",
    "lastname": "Doe",
    "docnumber": "12345678901"
}
```

- Actualizar el perfil de un cliente
  
  URL: POST ```/api/v1/auth/register``` (Incluyendo el ID del cliente en el body)
```json
{
    "id": 1,
    "name": "John Updated",
    "lastname": "Doe Updated",
    "docnumber": "12345678901"
}
```

## Carrito

- Agregar producto al carrito
  
  URL: POST ```/api/v1/carts```
```json
{
    "clientId": 1,
    "productId": 1,
    "amount": 2
}
```
- Quitar producto del carrito
  
  URL: DELETE ```/api/v1/carts```
```json
{
    "clientId": 1,
    "productId": 1,
    "amount": 1
}
```
## Comprobantes

- Generar comprobante
  
  URL: POST ```/api/v1/invoices```
```json
{
    "clientId": 1,
    "details": [
        {
            "productId": 1,
            "amount": 2,
            "price": 19.99
        }
    ]
}
```
- Leer comprobante del cliente
  
  URL: GET ```/api/v1/invoices/{cid}```

## Detalles del Comprobante

- Crear detalle de comprobante

URL: POST ```/api/v1/invoice-details```

```json
{
    "invoiceId": 1,
    "productId": 1,
    "amount": 2,
    "price": 19.99
}
```
- Leer detalles de comprobante
  
  URL: GET ```/api/v1/invoice-details```
  
- Leer un detalle de comprobante
  
  URL: GET ```/api/v1/invoice-details/{id}```
  
- Eliminar un detalle de comprobante
  
  URL: DELETE ```/api/v1/invoice-details/{id}```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir lo que te gustaría cambiar.

## Licencia

Este proyecto está bajo la licencia MIT.

### Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/ecommerce.git
cd ecommerce
```

# Evidencias

## Crear Producto
![image](https://github.com/earaucov27/PreEntrega2EdisonArauco/assets/78817982/98e9ca8e-506f-4248-974a-a2939ec4b82c)

## Listar Productos
![image](https://github.com/earaucov27/PreEntrega2EdisonArauco/assets/78817982/2ed3d409-aa40-47c6-a6d3-a104132d7f98)

## Listar Producto por ID
![image](https://github.com/earaucov27/PreEntrega2EdisonArauco/assets/78817982/beb0d5f7-7e9a-470e-b35e-bf72ace3fd2f)

## Modificar Producto
![image](https://github.com/earaucov27/PreEntrega2EdisonArauco/assets/78817982/d002ed2e-9e9b-4433-9b73-539dc7cf6ab8)

## Listar Producto Modificado 
![image](https://github.com/earaucov27/PreEntrega2EdisonArauco/assets/78817982/ad7551c1-909e-4de6-b405-c88727c97340)

## Borrar Producto
![image](https://github.com/earaucov27/PreEntrega2EdisonArauco/assets/78817982/8d2b3b73-0780-435f-81b7-b2f3d95ac2c5)
