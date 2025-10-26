# jg-fakestoreapi-cusca-gt
Prueba Técnica para Desarrollador Backend SpringBoot.

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

```bash
git clone https://github.com/jmgiron/jg-fakestoreapi-test.git
cd jg-fakestoreapi-test

### 2️⃣ Run with Maven (Local)
```bash
mvn clean package -DskipTests
mvn spring-boot:run


Once running, access the API docs at:
👉 http://localhost:8080/swagger-ui/index.html
<img width="1919" height="1025" alt="swagger" src="https://github.com/user-attachments/assets/f607f3eb-e89e-4885-847c-3c1b9f6eef5b" />


3️⃣ Run with Docker (optional)
If you prefer Docker, everything is preconfigured.
```bash
docker-compose up --build


---

🧰 Project Structure
```bash
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
```bash
/docs/FakeStoreAPI.postman_collection.json

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
