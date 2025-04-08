package practice.entity;


import practice.util.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CourseRegistration implements IApp {
    private int crId;
    private String studentId;
    private String courseId;
    private LocalDate regDate = LocalDate.now();
    private Status status = Status.PENDING;

    public enum Status { PENDING, ENROLLED, DROPPED }

    public CourseRegistration() {}

    @Override
    public void inputData(Scanner scanner) {
        this.studentId = Validation.inputStudentId(scanner);
        this.courseId = Validation.inputCourseId(scanner);
    }

    public int getCrId() { return crId; }
    public void setCrId(int crId) { this.crId = crId; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public LocalDate getRegDate() { return regDate; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "CourseRegistration{" +
                "crId=" + crId +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", regDate=" + regDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", status=" + status +
                '}';
    }
}