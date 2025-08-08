# Spring Boot Feature Showcase API

A modular **Spring Boot REST API** built to demonstrate the implementation of various backend features.  
This project started as a simple in-memory CRUD API and will be expanded to include database integration, authentication, and caching.

---

## ✨ Current Features

- **User CRUD Operations** — Create, Read, Update, Delete users  
- **In-memory storage** using `HashMap`  
- **Validation**:
  - Email format check
  - Duplicate email prevention
  - UUID format validation
- **Custom exception handling** with proper HTTP status codes:
  - `400 Bad Request`
  - `404 Not Found`
  - `409 Conflict`
- **RESTful endpoint design** with clean separation of Controller, Service, and Repository layers

---

## 🚀 Planned Features

- **Relational/NoSQL database integration** (MySQL / MongoDB)  
- **JWT-based authentication & authorization**  
- **Role-based access control** (admin, user)  
- **Redis caching** for performance optimization  
- **Cache invalidation strategies**  
- **Standardized API responses** with `@RestControllerAdvice`

---

## 🛠 Tech Stack

- **Java 24**  
- **Spring Boot 3**  
- **Maven**  
- **In-memory HashMap** (current storage)  
- Future: **MySQL / MongoDB**, **Redis**, **JWT**

---

## 📌 Purpose

This is a **learning and portfolio project** to explore and implement backend concepts in Spring Boot.  
Each stage of the project focuses on adding a specific backend feature to build a more complete service.

---
