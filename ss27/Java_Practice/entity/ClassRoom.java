package practice.entity;

import practice.util.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoom implements IApp {
    private int classroomId;
    private String classRoomName;
    private String courseId;
    private int teacherId;
    private List<Student> listStudents = new ArrayList<>();
    private LocalDate created = LocalDate.now();
    private Status status = Status.PENDING;

    public enum Status { PENDING, PROGRESS, CLOSE }

    public ClassRoom() {}

    @Override
    public void inputData(Scanner scanner) {
        this.classRoomName = Validation.inputClassRoomName(scanner);
        this.courseId = Validation.inputCourseId(scanner);
        this.teacherId = Validation.inputTeacherId(scanner);
    }

    public int getClassroomId() { return classroomId; }
    public void setClassroomId(int classroomId) { this.classroomId = classroomId; }
    public String getClassRoomName() { return classRoomName; }
    public void setClassRoomName(String classRoomName) { this.classRoomName = classRoomName; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public List<Student> getListStudents() { return listStudents; }
    public LocalDate getCreated() { return created; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classroomId=" + classroomId +
                ", classRoomName='" + classRoomName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", teacherId=" + teacherId +
                ", studentCount=" + listStudents.size() +
                ", created=" + created.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", status=" + status +
                '}';
    }
}