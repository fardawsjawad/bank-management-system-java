🏦 Bank Management System – Database Schema
📌 Overview

This repository contains the MySQL database schema for a Bank Management System, designed to support core banking operations such as:

User management

Role management

Account creation and lifecycle management

Financial transactions

Employment and address profiling

The schema is designed with data integrity, normalization, and scalability in mind and is intended to be used with a Core Java (JDBC) backend application.

🛠️ Technologies Used

Database: MySQL

Design Tool: MySQL Workbench (Reverse Engineering for ER Diagram)

Backend Integration: Core Java (JDBC)

🗂️ Database Structure
1️⃣ Users

Stores personal and identity information of bank customers.

Key features:

Unique constraints on username, email, passport number, and phone number

Auto-generated username using a database trigger

Primary Key:

user_id

2️⃣ Roles

Defines system roles assigned to users.

Examples:

ADMIN

USER

Relationship:

One user → One role

Linked to Users via foreign key

3️⃣ Accounts

Represents bank accounts owned by users.

Supported account types:

SAVINGS

CURRENT

Account status lifecycle:

ACTIVE, FROZEN, SUSPENDED, DORMANT, CLOSED, DELETED

Key features:

Account number auto-generated using a sequence table and trigger

Supports overdraft limits

Tracks opening and closing dates

Relationship:

One user → Multiple accounts

4️⃣ Transactions

Stores all financial transactions.

Supported transaction types:

DEPOSIT

WITHDRAW

TRANSFER

Transaction states:

PENDING, COMPLETED, FAILED, CANCELLED, REVERSED

Key features:

Supports internal transfers between accounts

Stores balance after transaction for audit purposes

5️⃣ EmploymentProfile

Stores employment and financial background details of users.

Purpose:

KYC (Know Your Customer)

Risk and compliance checks

Constraint:

One employment profile per user

6️⃣ UserAddress

Stores user address information.

Supported address types:

RESIDENTIAL

MAILING

OFFICE

PERMANENT

TEMPORARY

Key features:

Users can have multiple addresses

Indexed for faster lookup

🔗 Relationships Summary
Parent Table	Child Table	Relationship Type
Users	Roles	One-to-One
Users	Accounts	One-to-Many
Accounts	Transactions	One-to-Many
Users	EmploymentProfile	One-to-One
Users	UserAddress	One-to-Many

All foreign key relationships use CASCADE rules to maintain referential integrity.

⚙️ Triggers Used
🔹 Username Generation

Automatically generates a unique username during user creation if none is provided.

Format:

USER000001

🔹 Account Number Generation

Generates a unique account number for each account using a sequence table.

Format:

ACC000001

📄 Files Included
database/
├── bank_management_system_schema.sql
├── er_diagram.png


bank_management_system_schema.sql → Complete database schema

er_diagram.png → Entity Relationship diagram (generated via MySQL Workbench)

🚀 How to Use the Schema

Clone the repository

Open MySQL terminal or MySQL Workbench

Run the schema file:

SOURCE bank_management_system_schema.sql;


The database and all tables will be created automatically

🎯 Project Purpose

This schema is part of a Core Java backend project built to demonstrate:

Strong understanding of relational database design

Practical use of constraints and triggers

Real-world banking domain modeling

Readiness for JDBC, JPA, and Hibernate integration

📌 Future Enhancements

Audit logs for account and transaction changes

Support for multiple roles per user

Integration with JPA/Hibernate entities

Soft-delete strategy for historical data preservation

👤 Author

Fardaws Jawad
Backend Java Developer (Fresher)
📌 Focus: Core Java • JDBC • MySQL • Backend Development
