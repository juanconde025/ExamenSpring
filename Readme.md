# **Examen SpringBoot**

Exam of SpringBoot that is a management system of coworking in areas about spaces/places for reserved and book. Built with **Spring Boot** and **PostgreSQL**

---

## **🚀 Technologies Used**
- **Java 17** - Main programming language
- **Spring Boot** - Framework for backend development
- **PostgreSQL** - Relational database
- **Spring Data JPA** - Database management
- **Swagger** - API documentation

---

## **📂 Project Structure**
```
📦 ExamenSpring
 ┣ 📂 src/main/java/com/examen
 ┃ ┣ 📂 controllers     # REST controllers
 ┃ ┣ 📂 services        # Business logic
 ┃ ┣ 📂 exceptions      # Managament of Exceptions
 ┃ ┣ 📂 repositories    # Database access (JPA)
 ┃ ┣ 📂 entities        # Entity classes
 ┃ ┗ 📜 ExamenSpringApplication.java  # Main entry point
 ┣ 📂 src/main/resources
 ┃ ┣ 📜 application.properties  # Configuration file
 ┃ ┗ 📜 schema.sql              # Database schema
 ┣ 📜 pom.xml                   # Maven dependencies
 ┣ 📜 README.md                 # This file 📄
```

---

## **⚙️ Installation & Configuration**
### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/juanconde025/ExamenSpring
cd ExamenSpring
```

### **2️⃣ Setup PostgreSQL Database**
Ensure you have PostgreSQL installed and create a database:
```sql
CREATE DATABASE coworktech;
```


### **4️⃣ Build and Run**
```bash
mvn clean install
mvn spring-boot:run
```
API will be available at `http://localhost:8081`.


---

## **📡 Available Endpoints**

### **🔹 CRUD**
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/api/auth/register` | Register a new user |
| POST   | `/api/auth/login` | Login and obtain JWT |


Full API documentation is available in **Swagger** at `http://localhost:8080/swagger-ui.html/`.

---



## **👨‍💻 Authors**
**[Michel Adrian Torrado Roa]**  
GitHub: [@MichelAdrianTorradoRoa](https://github.com/MichelAdrianTorradoRoa)
**[Juan David Conde Martinez] 
GitHub: [@JuanConde](https://github.com/juanconde025)  
 
