# jg-fakestoreapi-cusca-gt
Prueba Técnica para Desarrollador Backend SpringBoot.

Un servicio backend ligero desarrollado con **Spring Boot 3**, diseñado para interactuar con la API de una tienda de productos ficticia.
Este proyecto implementa la prueba técnica solicitada por Touch Technologies para el puesto de Desarrollador Backend en el Banco Cuscatlán Guatemala. 
Presenta diseño RESTful, integración con Docker y documentación de la API de Postman. 
Desarrollado e implementado por el Ing. Jonathan Girón.
---

A lightweight backend service developed with **Spring Boot 3**, designed to interact with a fake product store API.
This project serves as an implementation of the technical test requested by Touch Technologies for the Backend Developer position for Banco Cuscatlan Guatemala, showcasing RESTful design, Docker integration, and Postman API documentation. Developed and implemented by Ing. Jonathan Giron.

---

## 🚀 Features

- REST API using **Spring Boot 3.2**
- Integration with **FakeStore API**
- H2 in-memory database
- **Swagger UI** for API visualization
- **Postman collection** for quick testing
- Docker-ready setup

---

## ⚙️ Minimum Requirements

| Component | Version |
|------------|----------|
| **Java JDK** | 17 or higher |
| **Maven** | 3.8+ |
| **Docker** | Optional (if running inside a container) |
| **Git** | Latest stable version |

---

### 1️⃣ Clone the Repository  

```shell
git clone https://github.com/jmgiron/jg-fakestoreapi-test.git
cd jg-fakestoreapi-test
```

### 2️⃣ Run with Maven (Local)
```shell
mvn clean package -DskipTests
mvn spring-boot:run
```


<img width="1534" height="728" alt="image" src="https://github.com/user-attachments/assets/eb558b15-ffa5-4d79-833b-d7c61eb131ff" />



Once running, access the API docs at:
👉 http://localhost:8080/swagger-ui/index.html
<img width="1919" height="1025" alt="swagger" src="https://github.com/user-attachments/assets/f607f3eb-e89e-4885-847c-3c1b9f6eef5b" />


3️⃣ Run with Docker (optional)
If you prefer Docker, everything is preconfigured.
```shell
docker-compose up --build
```


---

🧰 Project Structure
```shell
jg-fakestoreapi-cusca-gt/
├── src/
│   ├── main/
│   │   ├── java/com/jg/fakestoreapi/
│   │   │   ├── controller/    # REST Controllers
│   │   │   ├── model/         # Entity Models
│   │   │   └── service/       # Business Logic
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
├── pom.xml
├── Dockerfile
└── docker-compose.yml
```


---

🧪 API Endpoints

| Method     | Endpoint             | Description                                    |
| ---------- | -------------------- | ---------------------------------------------- |
| **GET**    | `/api/products`      | Retrieves all products from the FakeStore API. |
| **GET**    | `/api/products/{id}` | Retrieves product details by ID.               |
| **POST**   | `/api/products`      | Creates a new product (mock).                  |
| **PUT**    | `/api/products/{id}` | Updates a product (mock).                      |
| **DELETE** | `/api/products/{id}` | Deletes a product (mock).                      |


---

📬 Postman Collection
```shell
/docs/FakeStoreAPI.postman_collection.json
```


<img width="1519" height="946" alt="image" src="https://github.com/user-attachments/assets/c204bfbb-3328-4b30-8c94-ed13f4c8ea72" />



You can import this file directly into Postman to explore and test all available API endpoints.

🧱 Structure Overview
| # | Request Name      | Method | Endpoint        | Description                                                      |
| - | ----------------- | ------ | --------------- | ---------------------------------------------------------------- |
| 1 | **List Products** | GET    | `/api/products` | Fetches a list of all available products from the FakeStore API. |
| 2 | **Create Client** | POST   | `/api/clients`  | Creates a new client with name, email, and address.              |
| 3 | **Create Order**  | POST   | `/api/orders`   | Registers an order for a specific client and product list.       |
| 4 | **Pay Order**     | POST   | `/api/payments` | Simulates a payment process for an order.                        |


💡 Example Request Payloads
🧾 Create Client

```shell
json
POST /api/clients
{
  "name": "John Doe",
  "email": "john@example.com",
  "address": "123 Main"
}
```
<img width="1535" height="649" alt="image" src="https://github.com/user-attachments/assets/98af778c-91c1-4002-9a8d-613b78081b8a" />



📦 Create Order
```shell
json
POST /api/orders
{
  "clientId": 1,
  "items": [
    {
      "productId": 1,
      "title": "Sample",
      "unitPrice": 10.0,
      "quantity": 2
    }
  ]
}
```
<img width="875" height="844" alt="image" src="https://github.com/user-attachments/assets/4ecbb02a-bfa7-4ba1-aed2-5ec6ddf904a2" />


💳 Pay Order
```shell
json
POST /api/payments
{
  "orderId": 1,
  "method": "CARD",
  "amount": 20.0
}
```
<img width="1467" height="546" alt="image" src="https://github.com/user-attachments/assets/dc02e438-aa42-42e2-be45-5b90726c6319" />

---

📘 Swagger UI
Swagger is automatically available when the app runs.

URL:
👉 http://localhost:8080/swagger-ui/index.html

---

🧱 Technologies Used

Spring Boot 3.2
Java 17
Spring Data JPA
H2 Database
Spring WebFlux (WebClient)
Swagger / OpenAPI
Lombok
Docker

---


👨‍💻 Author

Jonathan Giron
🔗 https://github.com/jmgiron
For the technical test requested by Touch Technologies for the Backend Developer position for Banco Cuscatlan Guatemala.

📝 License
This project is carried out for technical evaluation purposes for a job offer.
