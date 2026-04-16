# 💰 Expense Tracker API

A RESTful backend application built using Spring Boot to manage users and their expenses.

## 🚀 Features

- Create and manage users
- Add, update, delete expenses
- Get all expenses
- Get expenses by user
- Filter expenses by category
- Calculate total expenses per user

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate

## 📂 API Endpoints

### 👤 User APIs
- POST /users → Create user
- GET /users → Get all users
- GET /users/{id} → Get user by ID
- DELETE /users/{id} → Delete user

### 💸 Expense APIs
- POST /expenses → Create expense
- GET /expenses → Get all expenses
- GET /expenses/{id} → Get expense by ID
- PUT /expenses/{id} → Update expense
- DELETE /expenses/{id} → Delete expense
- GET /expenses/user/{userId} → Get expenses by user
- GET /expenses/user/{userId}/total → Total expense
- GET /expenses/user/{userId}/category/{category} → Filter by category

## ⚙️ How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the application

## 👨‍💻 Author

Kista Reddy