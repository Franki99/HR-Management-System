# HR Management System

This project is a Java CRUD application designed to help HR departments manage employees, job candidates, and departments.

## Features

- Create, Read, Update, and Delete operations for Employees, Job Candidates, and Departments.
- Store and retrieve data using a relational database.
- Simple command-line interface for interaction.

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- PostgreSQ (preferred relational database)
- Maven (for dependency management)

## Setup Instructions

1. Clone the repository:

https://github.com/Franki99/HR-Management-System.git

2. Set up your database:

   - Install MySQL or your preferred relational database.
   - Create a database named `hr_management_system`.
   - Create tables for `employees`, `candidates`, and `departments` with appropriate fields. You can use the following SQL statements as a reference:

   ```sql
   CREATE TABLE Employees (
       employee_id INT PRIMARY KEY AUTO_INCREMENT,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       department_id INT,
       ...
   );

   CREATE TABLE JobCandidates (
       candidate_id INT PRIMARY KEY AUTO_INCREMENT,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       ...
   );

   CREATE TABLE Departments (
       department_id INT PRIMARY KEY AUTO_INCREMENT,
       department_name VARCHAR(50),
       ...
   );
3. Update the application.properties file with your database connection details
4. Build and run the project:
**Usage**
Upon running the application, you'll be presented with a menu to perform CRUD operations on Employees, Job Candidates, and Departments.
Follow the prompts to add, view, update, or delete records.
Make sure to input valid data according to the fields specified.
**Contributors**
   Ntaganira Divanni
