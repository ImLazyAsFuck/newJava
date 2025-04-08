package practice.business;


import practice.entity.CourseRegistration;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationManager {
    private List<CourseRegistration> registrations = new ArrayList<>();
    private int nextId = 1;

    public void addRegistration(CourseRegistration reg) {
        reg.setCrId(nextId++);
        registrations.add(reg);
        System.out.println("Đăng ký khóa học thành công!");
    }

    public void cancelRegistration(int crId) {
        CourseRegistration reg = findRegistrationById(crId);
        if (reg != null && reg.getStatus() == CourseRegistration.Status.PENDING) {
            reg.setStatus(CourseRegistration.Status.DROPPED);
            System.out.println("Hủy đăng ký thành công!");
        } else {
            System.out.println("Không thể hủy vì trạng thái không phải PENDING hoặc không tìm thấy!");
        }
    }

    public void approveRegistration(int crId) {
        CourseRegistration reg = findRegistrationById(crId);
        if (reg != null && reg.getStatus() == CourseRegistration.Status.PENDING) {
            reg.setStatus(CourseRegistration.Status.ENROLLED);
            System.out.println("Duyệt đăng ký thành công!");
        } else {
            System.out.println("Không thể duyệt vì trạng thái không phải PENDING hoặc không tìm thấy!");
        }
    }

    public void displayRegistrationsByCourse(String courseId) {
        registrations.stream()
                .filter(r -> r.getCourseId().equals(courseId))
                .forEach(System.out::println);
    }

    public boolean hasRegistrationForStudent(String studentId) {
        return registrations.stream().anyMatch(r -> r.getStudentId().equals(studentId) && r.getStatus() != CourseRegistration.Status.DROPPED);
    }

    private CourseRegistration findRegistrationById(int crId) {
        return registrations.stream().filter(r -> r.getCrId() == crId).findFirst().orElse(null);
    }
}