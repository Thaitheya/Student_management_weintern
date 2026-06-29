package com.weintern.model;


public class Student {
    private int ID;
    private String name;
    private int age;
    private String grade;
    private String subjects;

    public Student(int ID, String name, int age, String grade, String subjects) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.subjects = subjects;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
