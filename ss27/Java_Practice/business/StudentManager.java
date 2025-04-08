package practice.business;


import practice.entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private CourseRegistrationManager regManager;

    public StudentManager(CourseRegistrationManager regManager) {
        this.regManager = regManager;
    }

    public void addStudent(Student student) {
        if (!isDuplicateStudentId(student.getStudentId()) && !isDuplicatePhone(student.getPhone()) && !isDuplicateEmail(student.getEmail())) {
            students.add(student);
            System.out.println("Thêm sinh viên thành công!");
        } else {
            System.out.println("Mã sinh viên, số điện thoại hoặc email bị trùng!");
        }
    }

    public void displayStudents() {
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    public void updateStudent(String studentId, Student updatedStudent) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setGpa(updatedStudent.getGpa());
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên!");
        }
    }

    public void deleteStudent(String studentId) {
        Student student = findStudentById(studentId);
        if (student != null && !regManager.hasRegistrationForStudent(studentId)) {
            students.remove(student);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì sinh viên đã đăng ký khóa học hoặc không tồn tại!");
        }
    }

    private boolean isDuplicateStudentId(String studentId) {
        return students.stream().anyMatch(s -> s.getStudentId().equals(studentId));
    }

    private boolean isDuplicatePhone(String phone) {
        return students.stream().anyMatch(s -> s.getPhone().equals(phone));
    }

    private boolean isDuplicateEmail(String email) {
        return students.stream().anyMatch(s -> s.getEmail().equals(email));
    }

    public Student findStudentById(String studentId) {
        return students.stream().filter(s -> s.getStudentId().equals(studentId)).findFirst().orElse(null);
    }
}