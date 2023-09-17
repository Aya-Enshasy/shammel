package com.drivers.shamelproject.q1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
         ArrayList<Person> people = new ArrayList<>();

         people.add(new Student(1, "Student 1", "2000-01-01", 12345, 3.8));
        people.add(new Student(2, "Student 2", "2001-02-02", 54321, 3.9));
        people.add(new Student(3, "Student 3", "2002-03-03", 67890, 4.0));
        people.add(new Student(4, "Student 4", "2003-04-04", 98765, 3.7));
        people.add(new Student(5, "Student 5", "2004-05-05", 56789, 3.5));

        // Create 5 Teacher objects with fictional data
        people.add(new Teacher(101, "Teacher 1", "1970-06-06", 5000));
        people.add(new Teacher(102, "Teacher 2", "1980-07-07", 6000));
        people.add(new Teacher(103, "Teacher 3", "1990-08-08", 7000));
        people.add(new Teacher(104, "Teacher 4", "2000-09-09", 7500));
        people.add(new Teacher(105, "Teacher 5", "2010-10-10", 8000));

         for (Person person : people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println("Student: " + student.getName() +
                        " | ID: " + student.getId() +
                        " | GPA: " + student.getGpa() +
                        " | Student ID: " + student.getStudentId());
            } else if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                System.out.println("Teacher: " + teacher.getName() +
                        " | ID: " + teacher.getId() +
                        " | Salary: " + teacher.getSalary());
            }
        }
}
    static class Person {
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

    static class Student extends Person {
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

    static class Teacher extends Person {
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
    }}