package com.drivers.shamelproject.apis.model;

public class Person {
    private int id;
    private String name;
    private String birthdate;

    public Person() {
    }

    public Person(int id, String name, String birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}

class Student extends Person {
    private int studentId;
    private double gpa;

    public Student() {
    }

    public Student(int id, String name, String birthdate, int studentId, double gpa) {
        super(id, name, birthdate);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Double.compare(student.gpa, gpa) == 0;
    }
}

 class Teacher extends Person {
    private double salary;

    public Teacher() {
    }

    public Teacher(int id, String name, String birthdate, double salary) {
        super(id, name, birthdate);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}