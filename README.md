Bank Management System
📌 Project Overview
The Bank Management System is a console-based Java application designed to simulate core banking operations. The project focuses on applying Core Java (OOP principles) along with JDBC and MySQL to build a structured, scalable, and maintainable backend-style system.

This project is part of my backend development portfolio and demonstrates my understanding of real-world application design, layered architecture, and database interaction.

🎯 Objectives
Simulate real-world banking operations
Apply Object-Oriented Programming concepts in Java
Implement database connectivity using JDBC
Perform CRUD operations on a relational database
Follow clean code and layered architecture principles
🛠️ Technologies Used
Programming Language: Java (Core Java)
Database: MySQL
Database Connectivity: JDBC
IDE: IntelliJ IDEA / Eclipse
Build Tool: Manual / JDK
Architecture: Layered Architecture (DAO, Service, Model)
🧱 Project Architecture
The project follows a layered design to separate concerns and improve maintainability:

Model Layer Contains entity classes such as Account, Customer, and Transaction that represent database tables.

DAO Layer (Data Access Object) Handles all database operations such as inserting, updating, retrieving, and deleting records using JDBC.

Service Layer Contains business logic and validations, acting as an intermediary between the DAO layer and the UI.

Utility Layer Manages database connections and reusable helper methods.

UI Layer (Console) Provides a menu-driven console interface for user interaction.

✨ Features Implemented
Create new bank accounts
View account details
Deposit money
Withdraw money
Transfer funds between accounts
Check account balance
View transaction history
Input validation and basic exception handling
🗄️ Database Design
The application uses a MySQL database with tables such as:

customers – stores customer information
accounts – stores account details and balances
transactions – records all debit and credit operations
Primary and foreign keys are used to maintain relational integrity.

⚙️ Setup & Installation
Clone the repository
Create a MySQL database
Execute the SQL scripts to create required tables
Update database credentials in the DB utility class
Compile and run the main class
▶️ How to Run
Run the main class from your IDE
Follow the console menu to perform banking operations
🚧 Project Status
Completed

📚 Learning Outcomes
Through this project, I strengthened my understanding of:

Java OOP principles
JDBC and database connectivity
SQL queries and relational databases
Layered application design
Real-world backend problem solving
👤 Author
Fardaws Jawad Aspiring Java Backend Developer

📄 License
This project is for learning and portfolio purposes.
