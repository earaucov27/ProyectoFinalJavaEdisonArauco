# E-commerce Application

## Descripción

Este proyecto es una aplicación de comercio electrónico desarrollada con Spring Boot. Permite la gestión de productos, clientes, carritos de compra y comprobantes de venta.

## Evidencias

Las evidencias de funcionamiento a través de Postman las podrán encontrar al final de este README.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Springdoc OpenAPI 3

## Requisitos Previos

- Java 17 o superior
- MySQL
- Maven

# Configuración del Proyecto

## Configuración de la Base de Datos

- Crea una base de datos en MySQL:
  
```sql
CREATE DATABASE e_commerce;
```

## Actualiza el archivo application.properties con tu configuración de MySQL:

```properties
spring.application.name=ProyectoFinalJavaEdisonArauco
spring.datasource.url=jdbc:mysql://localhost:3306/e_commerce
spring.datasource.username=tu_usuario_configurado
spring.datasource.password=tu_contraseña_configurada
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update

# Swagger UI
springfox.documentation.swagger.v2.path=/api-docs
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
    │               ├── config
    │               │   └── SwaggerConfig.java
    │               ├── controllers
    │               │   ├── ClientController.java
    │               │   ├── ProductController.java
    │               │   ├── InvoiceController.java
    │               │   └── CartController.java
    │               ├── entities
    │               │   ├── Client.java
    │               │   ├── Product.java
    │               │   ├── Invoice.java
    │               │   └── Cart.java
    │               ├── repositories
    │               │   ├── ClientRepository.java
    │               │   ├── ProductRepository.java
    │               │   ├── InvoiceRepository.java
    │               │   └── CartRepository.java
    │               ├── services
    │               │   ├── ClientService.java
    │               │   ├── ProductService.java
    │               │   ├── InvoiceService.java
    │               │   └── CartService.java
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

- Crear un producto
  
  URL: POST ```/api/v1/products```
  ```json
  {
      "title": "Producto de Ejemplo",
      "stock": 100,
      "price": 29.99
  }
  ```

- Leer productos
  
  URL: GET ```/api/v1/products```

- Leer un producto por ID
  
  URL: GET ```/api/v1/products/{id}```

- Actualizar un producto por ID
  
  URL: PUT ```/api/v1/products/{id}```
  ```json
  {
      "title": "Producto Actualizado",
      "stock": 150,
      "price": 39.99
  }
  ```

## Clientes

- Registrar un cliente
  
  URL: POST ```/api/v1/auth/register```
  ```json
  {
      "name": "Juan",
      "lastname": "Pérez",
      "docnumber": 123456789
  }
  ```

- Actualizar el perfil de un cliente
  
  URL: PUT ```/api/v1/auth/me```
  ```json
  {
      "id": 1,
      "name": "Juan Actualizado",
      "lastname": "Pérez Actualizado",
      "docnumber": 987654321
  }
  ```

## Carritos

- Agregar producto al carrito
  
  URL: POST ```/api/v1/carts/{clientId}/{productId}/{quantity}```

- Quitar producto del carrito
  
  URL: DELETE ```/api/v1/carts/{cartId}```

- Leer los productos del carrito de un cliente (con delivered en false)
  
  URL: GET ```/api/v1/carts/{clientId}```

## Comprobantes

- Generar comprobante
  
  URL: POST ```/api/v1/invoices```
  ```json
  {
      "clientId": 1
  }
  ```

- Leer el último comprobante emitido para el cliente
  
  URL: GET ```/api/v1/invoices/{clientId}```

# Evidencias

## Crear Producto
![image](https://github.com/user-attachments/assets/bbc570f8-69d1-4fcb-9ab9-b7a384197e39)

## Listar Productos
![image](https://github.com/user-attachments/assets/8b1102b3-bc79-4ec9-aa7f-70fc1d6afd01)

## Listar Producto por ID
![image](https://github.com/user-attachments/assets/02271912-59b5-4501-92e4-6988c70bb6fb)

## Modificar Producto
![image](https://github.com/user-attachments/assets/b9ca6be5-f25a-4809-9c47-9c6a79fb6f85)

## Registrar Cliente
![image](https://github.com/user-attachments/assets/955ead58-3cc3-4e54-831b-17490e7045fa)

## Actualizar Cliente
![image](https://github.com/user-attachments/assets/c74a825b-437f-4fe7-8f8c-c03613ef2f2b)

## Agregar Producto al Carrito
![image](https://github.com/user-attachments/assets/c70d756a-95e4-4a78-9b1c-802e05885bac)

## Quitar Producto del Carrito
![image](https://github.com/user-attachments/assets/07d03ad3-885c-4d42-b6a2-f03c9e47d76e)

## Leer productos del carrito
![image](https://github.com/user-attachments/assets/6f252789-b6af-4a8e-acb1-1cb68f5476df)

## Generar Comprobante
![image](https://github.com/user-attachments/assets/e28fd9d7-0ff0-43b0-af3b-356a6047fd2c)

## Leer Comprobante del Cliente
![image](https://github.com/user-attachments/assets/df3bdf4e-f160-429b-8222-c004bece678f)


## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir lo que te gustaría cambiar.

## Licencia

Este proyecto está bajo la licencia MIT.

### Clonar el Repositorio

```bash
git clone https://github.com/earaucov27/ProyectoFinalJavaEdisonArauco.git
```
