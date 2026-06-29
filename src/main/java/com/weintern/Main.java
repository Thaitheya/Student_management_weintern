package com.weintern;

import com.weintern.model.Student;
import com.weintern.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();
        service.loadFromFile();

        while (true) {

            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search By Id");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Average");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();

                    service.addStudent(id, name, age, grade, subject);
                    service.saveToFile();
                    System.out.println("Student added successfully!");
                    break;

                case 2:

                    System.out.println("------------------------------------------------------------------");
                    System.out.printf("%-5s %-20s %-5s %-10s %-15s%n",
                            "ID", "NAME", "AGE", "GRADE", "SUBJECT");
                    System.out.println("------------------------------------------------------------------");

                    for (Student s : service.displayAll()) {

                        System.out.printf("%-5d %-20s %-5d %-10s %-15s%n",
                                s.getID(),
                                s.getName(),
                                s.getAge(),
                                s.getGrade(),
                                s.getSubjects());
                    }

                    System.out.println("------------------------------------------------------------------");
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int studentId = Integer.parseInt(scanner.nextLine());

                    Student student = service.searchStudent(studentId);

                    if (student != null) {

                        System.out.println("----------------------------------------------");
                        System.out.printf("%-5s %-20s %-5s %-10s %-15s%n",
                                "ID", "NAME", "AGE", "GRADE", "SUBJECT");
                        System.out.println("----------------------------------------------");

                        System.out.printf("%-5d %-20s %-5d %-10s %-15s%n",
                                student.getID(),
                                student.getName(),
                                student.getAge(),
                                student.getGrade(),
                                student.getSubjects());

                        System.out.println("----------------------------------------------");

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int stuId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Select field to update");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    System.out.println("3. Grade");
                    System.out.println("4. Subject");

                    int updateChoice = Integer.parseInt(scanner.nextLine());

                    switch (updateChoice) {

                        case 1:

                            System.out.print("Enter New Name: ");
                            String newName = scanner.nextLine();

                            service.updateStudent(stuId, newName, -1, null, null);
                            service.saveToFile();
                            System.out.println("Student updated successfully.");
                            break;

                        case 2:

                            System.out.print("Enter New Age: ");
                            int newAge = Integer.parseInt(scanner.nextLine());

                            service.updateStudent(stuId, null, newAge, null, null);
                            service.saveToFile();
                            System.out.println("Student updated successfully.");
                            break;

                        case 3:

                            System.out.print("Enter New Grade: ");
                            String newGrade = scanner.nextLine();

                            service.updateStudent(stuId, null, -1, newGrade, null);
                            service.saveToFile();
                            System.out.println("Student updated successfully.");
                            break;

                        case 4:

                            System.out.print("Enter New Subject: ");
                            String newSubject = scanner.nextLine();

                            service.updateStudent(stuId, null, -1, null, newSubject);
                            service.saveToFile();
                            System.out.println("Student updated successfully.");
                            break;

                        default:
                            System.out.println("Invalid update option.");
                    }

                    break;
                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());

                    boolean deleted = service.deleteStudent(deleteId);
                    service.saveToFile();
                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;
                case 6:
                    double average = service.calculateAverage();

                    System.out.printf("Average GPA: %.2f%n", average);

                    break;

                case 7:
                    service.saveToFile();
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}
