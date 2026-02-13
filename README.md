# 🚀 Job Portal Backend System (Dockerized)

A **Job Portal Backend Application** built using **Spring Boot**, **JWT Authentication**, **MySQL**, and **Docker**, following layered architecture and industry best practices.

This system allows:

* Users to register & login securely
* Companies to post jobs
* Users to apply for jobs
* All APIs secured using JWT
* Entire application + database dockerized using Docker Compose

---

## 📌 Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* JWT (JSON Web Token)

### Database

* MySQL 8

### Build Tool

* Maven

### DevOps / Deployment

* Docker
* Docker Compose

### Tools

* IntelliJ IDEA
* Postman

---

## 🏗 Architecture

Layered Architecture:

```
Controller Layer  -->  Service Layer  -->  Repository Layer  -->  Database
```

---

## 📂 Project Structure

```
jobportal
│
├── src/main/java/com/jobportal
│   ├── controller
│   │   ├── UserController.java
│   │   ├── CompanyController.java
│   │   ├── JobController.java
│   │   └── JobApplicationController.java
│   │
│   ├── service
│   │   ├── UserService.java
│   │   ├── CompanyService.java
│   │   ├── JobService.java
│   │   └── JobApplicationService.java
│   │
│   ├── repository
│   │   ├── UserRepository.java
│   │   ├── CompanyRepository.java
│   │   ├── JobRepository.java
│   │   └── JobApplicationRepository.java
│   │
│   ├── entity
│   │   ├── User.java
│   │   ├── Company.java
│   │   ├── Job.java
│   │   └── JobApplication.java
│   │
│   ├── security
│   │   ├── JwtUtil.java
│   │   └── JwtFilter.java
│   │
│   ├── config
│   │   └── SecurityConfig.java
│   │
│   └── JobportalApplication.java
│
├── src/main/resources
│   ├── application.properties
│   └── application-docker.properties
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🔐 Security Flow (JWT)

1. User logs in
2. Server generates JWT token
3. Client sends token in every request header
4. JwtFilter validates token
5. If valid → request allowed

Header format:

```
Authorization: Bearer <token>
```

---

## 📊 Database Tables

```
users
companies
jobs
job_applications
```

---

## 🔗 Entity Relationships

```
User 1 ---- * JobApplication * ---- 1 Job
Company 1 ---- * Job
```

---

## 🌐 API Endpoints

### 🔑 Auth APIs

| Method | Endpoint            | Description     |
| ------ | ------------------- | --------------- |
| POST   | /api/users/register | Register user   |
| POST   | /api/users/login    | Login & get JWT |

---

### 🏢 Company APIs

| Method | Endpoint            | Description       |
| ------ | ------------------- | ----------------- |
| POST   | /api/companies      | Create company    |
| GET    | /api/companies      | Get all companies |
| GET    | /api/companies/{id} | Get company by id |

---

### 💼 Job APIs

| Method | Endpoint              | Description   |
| ------ | --------------------- | ------------- |
| POST   | /api/jobs/{companyId} | Create job    |
| GET    | /api/jobs             | Get all jobs  |
| GET    | /api/jobs/{id}        | Get job by id |

---

### 📄 Apply Job APIs

| Method | Endpoint                                 | Description   |
| ------ | ---------------------------------------- | ------------- |
| POST   | /api/applications/apply?userId=1&jobId=1 | Apply for job |

---

## 🐳 Docker Setup

### Dockerfile

Builds Spring Boot jar into image.

### docker-compose.yml

Runs:

* MySQL container
* Spring Boot container

Connected in same network.

---

## ▶ Run Project Using Docker

```bash
mvn clean package
docker build -t jobportal-app .
docker compose up
```

---

## ▶ Run Project Without Docker

```bash
mvn spring-boot:run
```

---

## 🧠 Key Concepts Implemented

* JWT Authentication
* Password Encryption using BCrypt
* Stateless Security
* One-to-Many & Many-to-One Mapping
* DTO-ready architecture
* Exception handling
* Docker multi-container orchestration
* Environment-based configuration


Sahil Saifi
Backend Java Engineer

