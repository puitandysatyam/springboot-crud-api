# Spring Boot CRUD API — In-Memory Storage

A demo **Spring Boot REST API** implementing **CRUD operations** for a `User` resource.  
Data is stored in an **in-memory `HashMap`**, making it lightweight and fast for testing and learning purposes.

## ✨ Features

- Full **CRUD** support (`Create`, `Read`, `Update`, `Delete`)
- **In-memory storage** using `HashMap`
- **Input validation**:
  - Email format check
  - Duplicate email prevention
  - UUID format validation
- **Custom exceptions** with proper HTTP status codes:
  - `400 Bad Request`
  - `404 Not Found`
  - `409 Conflict`
- **RESTful endpoint design**
- Returns meaningful error messages in JSON format
