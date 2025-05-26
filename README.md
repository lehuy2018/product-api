# Product API

A simple Spring Boot RESTful API to manage products with full CRUD functionality and name-based search.

## 🚀 Features

- Create, read, update, delete products
- Search products by name (case-insensitive)
- Built with Spring Boot + Spring Data JPA + H2/MySQL

## 📦 API Endpoints

| Method | Endpoint                       | Description             |
|--------|--------------------------------|-------------------------|
| GET    | `/api/products`                | Get all products        |
| POST   | `/api/products`                | Create a new product    |
| PUT    | `/api/products/{id}`           | Update a product        |
| DELETE | `/api/products/{id}`           | Delete a product        |
| GET    | `/api/products/search?name=...`| Search products by name |

## 🧪 Example Request (via Postman)

### Create product
- **POST** `/api/products`
- **Body**:
```json
{
  "name": "Laptop",
  "price": 1500.0
}

### Search product
- **GET** `/api/products/search?name=lap`