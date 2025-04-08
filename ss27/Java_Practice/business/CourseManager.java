package practice.business;


import practice.entity.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseManager {
    private List<Course> courses = new ArrayList<>();
    private ClassRoomManager classRoomManager;

    public CourseManager(ClassRoomManager classRoomManager) {
        this.classRoomManager = classRoomManager;
    }

    public void addCourse(Course course) {
        if (!isDuplicateCourseId(course.getCourseId()) && !isDuplicateCourseName(course.getCourseName())) {
            courses.add(course);
            System.out.println("Thêm khóa học thành công!");
        } else {
            System.out.println("Mã hoặc tên khóa học bị trùng!");
        }
    }

    public void displayCourses() {
        courses.stream()
                .sorted(Comparator.comparing(Course::getCourseName))
                .forEach(System.out::println);
    }

    public void updateCourse(String courseId, Course updatedCourse) {
        Course course = findCourseById(courseId);
        if (course != null) {
            course.setCourseName(updatedCourse.getCourseName());
            course.setStatus(updatedCourse.isStatus());
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy khóa học!");
        }
    }

    public void deleteCourse(String courseId) {
        Course course = findCourseById(courseId);
        if (course != null && !classRoomManager.hasClassForCourse(courseId)) {
            courses.remove(course);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì khóa học đã có lớp học hoặc không tồn tại!");
        }
    }

    private boolean isDuplicateCourseId(String courseId) {
        return courses.stream().anyMatch(c -> c.getCourseId().equals(courseId));
    }

    private boolean isDuplicateCourseName(String courseName) {
        return courses.stream().anyMatch(c -> c.getCourseName().equals(courseName));
    }

    public Course findCourseById(String courseId) {
        return courses.stream().filter(c -> c.getCourseId().equals(courseId)).findFirst().orElse(null);
    }
}