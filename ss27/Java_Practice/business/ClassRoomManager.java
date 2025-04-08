package practice.business;


import practice.entity.ClassRoom;
import practice.entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassRoomManager {
    private List<ClassRoom> classRooms = new ArrayList<>();
    private int nextId = 1;

    public void addClassRoom(ClassRoom classRoom) {
        if (!isDuplicateClassRoomName(classRoom.getClassRoomName())) {
            classRoom.setClassroomId(nextId++);
            classRooms.add(classRoom);
            System.out.println("Thêm lớp học thành công!");
        } else {
            System.out.println("Tên lớp học bị trùng!");
        }
    }

    public void displayClassRooms() {
        classRooms.stream()
                .sorted(Comparator.comparing(ClassRoom::getCreated, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public void updateClassRoom(int classroomId, ClassRoom updatedClassRoom) {
        ClassRoom classRoom = findClassRoomById(classroomId);
        if (classRoom != null && classRoom.getStatus() != ClassRoom.Status.CLOSE) {
            classRoom.setClassRoomName(updatedClassRoom.getClassRoomName());
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không thể cập nhật vì trạng thái là CLOSE hoặc không tìm thấy!");
        }
    }

    public void deleteClassRoom(int classroomId) {
        ClassRoom classRoom = findClassRoomById(classroomId);
        if (classRoom != null && classRoom.getListStudents().isEmpty() && classRoom.getTeacherId() == 0) {
            classRooms.remove(classRoom);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không thể xóa vì lớp đã có sinh viên hoặc giảng viên!");
        }
    }

    public void assignTeacher(int classroomId, int teacherId) {
        ClassRoom classRoom = findClassRoomById(classroomId);
        if (classRoom != null) {
            classRoom.setTeacherId(teacherId);
            System.out.println("Phân công giảng viên thành công!");
        } else {
            System.out.println("Không tìm thấy lớp học!");
        }
    }

    public void addStudentToClass(int classroomId, Student student) {
        ClassRoom classRoom = findClassRoomById(classroomId);
        if (classRoom != null) {
            classRoom.getListStudents().add(student);
            System.out.println("Thêm sinh viên vào lớp thành công!");
        } else {
            System.out.println("Không tìm thấy lớp học!");
        }
    }

    public void updateStatus(int classroomId, ClassRoom.Status newStatus) {
        ClassRoom classRoom = findClassRoomById(classroomId);
        if (classRoom != null) {
            classRoom.setStatus(newStatus);
            System.out.println("Cập nhật trạng thái thành công!");
        } else {
            System.out.println("Không tìm thấy lớp học!");
        }
    }

    private boolean isDuplicateClassRoomName(String classRoomName) {
        return classRooms.stream().anyMatch(c -> c.getClassRoomName().equals(classRoomName));
    }

    public ClassRoom findClassRoomById(int classroomId) {
        return classRooms.stream().filter(c -> c.getClassroomId() == classroomId).findFirst().orElse(null);
    }

    public boolean hasClassForCourse(String courseId) {
        return classRooms.stream().anyMatch(c -> c.getCourseId().equals(courseId));
    }

    public boolean hasClassForTeacher(int teacherId) {
        return classRooms.stream().anyMatch(c -> c.getTeacherId() == teacherId);
    }
}