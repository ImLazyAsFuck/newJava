package practice.business;


import practice.entity.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TeacherManager {
    private List<Teacher> teachers = new ArrayList<>();
    private int nextId = 1;
    private ClassRoomManager classRoomManager;

    public TeacherManager(ClassRoomManager classRoomManager) {
        this.classRoomManager = classRoomManager;
    }

    public void addTeacher(Teacher teacher) {
        if (!isDuplicatePhone(teacher.getPhone()) && !isDuplicateEmail(teacher.getEmail())) {
            teacher.setTeacherId(nextId++);
            teachers.add(teacher);
            System.out.println("Thêm giảng viên thành công!");
        } else {
            System.out.println("Số điện thoại hoặc email bị trùng!");
        }
    }

    public void displayTeachers() {
        teachers.stream()
                .sorted(Comparator.comparing(Teacher::getTeacherId, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public void updateTeacher(int teacherId, Teacher updatedTeacher) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher != null) {
            teacher.setName(updatedTeacher.getName());
            teacher.setSubject(updatedTeacher.getSubject());
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy giảng viên!");
        }
    }

    public void deleteTeacher(int teacherId) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher != null && !classRoomManager.hasClassForTeacher(teacherId)) {
            teachers.remove(teacher);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì giảng viên đã được xếp lớp hoặc không tồn tại!");
        }
    }

    private boolean isDuplicatePhone(String phone) {
        return teachers.stream().anyMatch(t -> t.getPhone().equals(phone));
    }

    private boolean isDuplicateEmail(String email) {
        return teachers.stream().anyMatch(t -> t.getEmail().equals(email));
    }

    public Teacher findTeacherById(int teacherId) {
        return teachers.stream().filter(t -> t.getTeacherId() == teacherId).findFirst().orElse(null);
    }
}