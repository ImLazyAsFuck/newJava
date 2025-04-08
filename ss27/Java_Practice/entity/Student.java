package practice.entity;


import practice.util.Validation;

import java.util.Scanner;

public class Student extends Person implements IApp {
    private String studentId;
    private double gpa;

    public Student() {}

    @Override
    public void inputData(Scanner scanner) {
        this.setName(Validation.inputName(scanner));
        this.setAge(Validation.inputAge(scanner));
        this.setAddress(Validation.inputAddress(scanner));
        this.setPhone(Validation.inputPhone(scanner));
        this.setEmail(Validation.inputEmail(scanner));
        this.setSex(Validation.inputSex(scanner));
        this.studentId = Validation.inputStudentId(scanner);
        this.gpa = Validation.inputGpa(scanner);
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", gpa=" + gpa +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
