package practice.entity;


import practice.util.Validation;

import java.util.Scanner;

public class Teacher extends Person implements IApp {
    private int teacherId;
    private String subject;

    public Teacher() {}

    @Override
    public void inputData(Scanner scanner) {
        this.setName(Validation.inputName(scanner));
        this.setAge(Validation.inputAge(scanner));
        this.setAddress(Validation.inputAddress(scanner));
        this.setPhone(Validation.inputPhone(scanner));
        this.setEmail(Validation.inputEmail(scanner));
        this.setSex(Validation.inputSex(scanner));
        this.subject = Validation.inputSubject(scanner);
    }

    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", subject='" + subject + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
