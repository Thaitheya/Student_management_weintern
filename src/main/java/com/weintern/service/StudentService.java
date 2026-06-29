package com.weintern.service;

import com.weintern.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    public List<Student> displayAll() {
        return students;
    }

    public void addStudent(int id,
                           String name,
                           int age,
                           String grade,
                           String subjects) {

        Student student = new Student(id, name, age, grade, subjects);
        students.add(student);
    }

    public Student searchStudent(int id) {
        for(Student student: students) {
            if(student.getID() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(int id, String name, int age, String grade, String subject) {

        for (Student student : students) {

            if (student.getID() == id) {

                if (name != null && !name.isBlank()) {
                    student.setName(name);
                }

                if (age != -1) {
                    student.setAge(age);
                }

                if (grade != null && !grade.isBlank()) {
                    student.setGrade(grade.toUpperCase());
                }

                if (subject != null && !subject.isBlank()) {
                    student.setSubjects(subject.toUpperCase());
                }

                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for(Student student: students) {
            if(student.getID() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }
    public double calculateAverage() {

        if (students.isEmpty()) {
            return 0.0;
        }
        double total = 0;

        for (Student student : students) {

            switch (student.getGrade().toUpperCase()) {
                case "A":
                    total += 5.0;
                    break;
                case "B":
                    total += 4.0;
                    break;
                case "C":
                    total += 3.0;
                    break;
                case "D":
                    total += 2.0;
                    break;
                case "E":
                    total += 1.0;
                    break;
                default:
                    total += 0.0;
            }
        }

        return total / students.size();
    }
    public void saveToFile() {

        try (FileWriter writer = new FileWriter("students.txt")) {

            for (Student student : students) {
                writer.write(
                        student.getID() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getGrade() + "," +
                                student.getSubjects()
                );

                writer.write(System.lineSeparator());
            }

            System.out.println("Students saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    public void loadFromFile() {

        File file = new File("students.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Student student = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4]
                );

                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}
