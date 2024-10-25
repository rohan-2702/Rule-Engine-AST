# 🌟 AST Rule Engine System

The **AST Rule Engine System** is a powerful and flexible solution that evaluates complex business rules using an Abstract Syntax Tree (AST) structure. Developed using Java, Spring Boot, and MySQL, this system provides users with the ability to create dynamic rules, evaluate user attributes, and determine eligibility based on custom criteria. 

Built for scalability and performance, this rule engine can handle various logical and arithmetic operations, making it ideal for any rule-driven applications such as eligibility verification, fraud detection, or recommendation engines.

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
- **Error Handling**: Custom validation and error response handling

## 📦 Prerequisites

To run this project locally, ensure you have the following installed:

- JDK 21 or later (Strong Requirement)
- Docker and Docker Compose
- MySQL 
- Maven (for building the project)
- IntelliJ IDEA

## ⚙️ Setup & Run

Follow these steps to set up and run the application:

### 1. Clone the Repository
```bash
git clone https://github.com/rohan-2702/Rule-Engine-AST.git
cd ruleEngine
```

## For Running application locally using Mysql .(Recommended)
   
### 2. Setup Databse Configuration.
  - Ensure MySQL is installed and running.
  - Create a new database name rule_engine_db in MySQL.
  ```bash
    CREATE DATABASE rule_engine;
  ```
 ### 3. Configure application.properties :
   - Update the src/main/resources/application.properties file with your MySQL configuration:
   ```bash
     spring.datasource.url=jdbc:mysql://localhost:3306/rule_engine
     spring.datasource.username=your_username
     spring.datasource.password=your_password
   ```
### 4. Build project. 
  - Use Maven (use Intellij Maven terminal) to clean and package project
  ```bash
    mvn clean package
```
  - After building start application ( You can also run main springboot app file)
```bash
   mvn spring-boot:run
```

## For Running application using docker-compose file. (Optional)
- No need to create database 
- Just build  New Connection in MYSQL workbench. 
- Use username: rohan
- Use password: rohan
- Use Port No: 3309
- Just Change Configuration for root password in docker-compose file.
```bash
MYSQL_ROOT_PASSWORD: your_root_password
```
 a. Build Application
```bash
mvn clean install
mvn clean package
```
b. Run with Docker Compose.
```bash
docker-compose up
```

### 5. Access the Dashboard (Make sure port 8080 is free)
   - Once the application is running, you can access the weather monitoring dashboard by visiting:
     ```bash
        http://localhost:8080/
     ```
## 📋 API Endpoints (Use POSTMAN to test )
The following REST APIs are available:
- [API Documentaion Link]()
  
1. **Create Rule**
   - `POST /api/rules/create`
   - **body** ((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) AND (salary > 50000 OR experience > 5)
   - Create a new AST on the basis of rule.

2. **Combine Rules**
   - `POST /api/rules/combine`
   - **body** [((age > 30 AND department = 'Marketing') OR (experience > 5 AND salary > 60000)) AND location = 'London'" ,"age < home"]
   - Returns a single AST having multiple rules.

3. **Get All Rules**
   - `GET /api/rules/all`
   - Returns all rules saved in database.
  
## 📊 Rule Design Choices
- Abstract Syntax Tree (AST): Rules are parsed into an AST for efficient processing, making it easier to manage complex nested conditions.
- Logical & Arithmetic Operations: The engine supports operations such as AND, OR, NOT, >, <, =, and more.
- Dynamic Rule Support: Users can define rules on the fly, making the system flexible for different use cases.
-Tokenization & Parsing: The system uses a custom-built tokenizer and parser to break down rule strings and convert them into AST nodes.

## 🚀 Additional Features
- Custom Error Handling: Provides detailed error messages for invalid rules or malformed requests.
- Scalability: Built with scalability in mind, using a MySQL backend for persistent storage of rules and evaluations.

## 🧪 Test Cases
The system has been thoroughly tested for the following:

- Rule Creation: Ensures rules are correctly tokenized and parsed into ASTs.
- Rule Evaluation: Verifies the correct evaluation of various input data against dynamic rules.
- Edge Cases: Handles null values, incorrect operators, and malformed expressions.
- Performance: Tests the system's efficiency in parsing and evaluating large rule sets.

## 🏆 Achievements & Performance
- Optimized Rule Evaluation: The AST approach reduces the complexity of rule evaluation, improving processing time for large rule sets.
- Flexible Rule Management: Supports combining multiple rules into a single structure, streamlining rule management for complex business logic.

## 📚 Documentation
- [Detailed Documentation](Link)

## 📬 Contact
For any inquiries, feel free to reach out to me:

- Rohan Chintalwar
- Email: rohanchintalwar27@gmail.com
