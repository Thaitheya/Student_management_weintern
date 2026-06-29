# Student Management System

A **Java Console-Based Student Management System** built using Core Java. This project demonstrates CRUD operations, object-oriented programming principles, collections, file handling, and clean code practices without using any frameworks.

## Features

* Add Student
* View All Students
* Search Student by ID
* Update Student (Partial Update Supported)
* Delete Student
* Calculate Average GPA
* Save Student Data to File
* Load Student Data from File
* Console-based Interactive Menu

## Technologies Used

* Java 17+ (or your Java version)
* Collections (`ArrayList`)
* Object-Oriented Programming (OOP)
* File I/O (`BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter`)
* Exception Handling
* Enums

## Project Structure

```text
src/
│
├── enums/
│   ├── GradeEnum.java
│   └── StudentEnum.java
│
├── model/
│   └── Student.java
│
├── service/
│   └── StudentService.java
│
└── Main.java
```

## Application Menu

```text
===== Student Management =====

1. Add Student
2. View All Students
3. Search Student By ID
4. Update Student
5. Delete Student
6. Calculate Average GPA
7. Exit
```

## Sample Output

```text
------------------------------------------------------------------
ID    NAME                 AGE   GRADE      SUBJECT
------------------------------------------------------------------
1     Thaitheya            15    A          ENGLISH
2     John                 18    B          MATHS
------------------------------------------------------------------
```

## Concepts Covered

* Classes and Objects
* Encapsulation
* Constructors
* Java Collections
* Enums
* CRUD Operations
* Searching and Updating Objects
* Partial Updates
* File Persistence
* Scanner Input Handling
* Formatted Console Output

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/Thaitheya/Student_management_weintern.git
```

2. Open the project in IntelliJ IDEA or any Java IDE.

3. Build and run the `Main.java` file.

## Future Enhancements

* Input validation
* Student sorting (Name, GPA, Age)
* Search by Name
* Department-wise filtering
* File format migration to CSV
* Unit testing with JUnit
* Database integration using JDBC
* Spring Boot REST API version

## Author

**Thaitheyasudan P K**

GitHub: https://github.com/Thaitheya
