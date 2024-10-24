# 🌟 AST Rule Engine System

The **AST Rule Engine System** is a powerful and flexible solution that evaluates complex business rules using an Abstract Syntax Tree (AST) structure. 
Developed using Java, Spring Boot, and MySQL, this system provides users with the ability to 
create dynamic rules, evaluate user attributes, and determine eligibility based on custom criteria. 

Built for scalability and performance, this rule engine can handle various logical and arithmetic operations, 
making it ideal for any rule-driven applications such as eligibility verification, fraud detection, or recommendation engines.

## 🚀 Features

- **Dynamic Rule Creation**: Users can create rules with both logical (AND, OR, NOT) and arithmetic operations.
- **AST-Based Parsing**: Converts user-defined rules into an AST for efficient rule evaluation.
- **Rule Evaluation**: Evaluate rules against dynamic input data and return eligibility results.
- **Combining Multiple Rules**: Supports combining multiple rules into a unified structure.
- **REST APIs**: Provides RESTful endpoints for rule creation, rule combination, and rule evaluation.
- **Database Persistence**: Stores rules and associated data in MySQL for quick retrieval and scalability.
- **Error Handling & Validation**: Robust validation for rule expressions and attributes.
- **High Performance**: Optimized parsing and evaluation for fast processing of complex rule sets.

## 🛠️ Technology Stack

- **Backend**: Java, Spring Boot, REST APIs
- **Database**: MySQL (for storing rules and metadata)
- **Business Logic**: Abstract Syntax Tree (AST) parsing, Tokenizer, and Parser
- **Containerization**: Docker (for easy deployment)
- **Monitoring**: Prometheus, Grafana (for performance monitoring)
- **Error Handling**: Custom validation and error response handling

## 📦 Prerequisites

To run this project locally, ensure you have the following installed:

- JDK 21 or later
- Docker and Docker Compose
- MySQL (optional if running through Docker)
- Maven (for building the project)
- Postman (for testing API)

## ⚙️ Setup & Run

Follow these steps to set up and run the application:

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/ast-rule-engine.git
cd ast-rule-engine
 ```
