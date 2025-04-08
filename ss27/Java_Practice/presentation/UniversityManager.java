package practice.presentation;


import practice.business.*;
import practice.entity.*;

import java.util.Scanner;

public class UniversityManager {
    private static Scanner scanner = new Scanner(System.in);
    private static ClassRoomManager classRoomManager = new ClassRoomManager();
    private static CourseManager courseManager = new CourseManager(classRoomManager);
    private static TeacherManager teacherManager = new TeacherManager(classRoomManager);
    private static CourseRegistrationManager regManager = new CourseRegistrationManager();
    private static StudentManager studentManager = new StudentManager(regManager);
    private static ScheduleManager scheduleManager = new ScheduleManager();

    public static void main(String[] args) {
        int choice;
        do {
            displayMainMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: manageCourses(); break;
                case 2: manageTeachers(); break;
                case 3: manageStudents(); break;
                case 4: manageRegistrations(); break;
                case 5: manageClassRooms(); break;
                case 6: System.out.println("Thoát chương trình!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private static void displayMainMenu() {
        System.out.println("\n=== MENU QUẢN LÝ ĐẠI HỌC ===");
        System.out.println("1. Quản lý khóa học");
        System.out.println("2. Quản lý giảng viên");
        System.out.println("3. Quản lý sinh viên");
        System.out.println("4. Đăng ký khóa học");
        System.out.println("5. Quản lý lớp học");
        System.out.println("6. Thoát");
        System.out.print("Chọn: ");
    }

    private static void manageCourses() {
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ KHÓA HỌC ===");
            System.out.println("1. Danh sách khóa học");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: courseManager.displayCourses(); break;
                case 2:
                    Course course = new Course();
                    course.inputData(scanner);
                    courseManager.addCourse(course);
                    break;
                case 3:
                    System.out.print("Nhập mã khóa học cần cập nhật: ");
                    String courseId = scanner.nextLine();
                    Course updatedCourse = new Course();
                    updatedCourse.inputData(scanner);
                    courseManager.updateCourse(courseId, updatedCourse);
                    break;
                case 4:
                    System.out.print("Nhập mã khóa học cần xóa: ");
                    courseManager.deleteCourse(scanner.nextLine());
                    break;
                case 5: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void manageTeachers() {
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ GIẢNG VIÊN ===");
            System.out.println("1. Danh sách giảng viên");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: teacherManager.displayTeachers(); break;
                case 2:
                    Teacher teacher = new Teacher();
                    teacher.inputData(scanner);
                    teacherManager.addTeacher(teacher);
                    break;
                case 3:
                    System.out.print("Nhập mã giảng viên cần cập nhật: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    Teacher updatedTeacher = new Teacher();
                    updatedTeacher.inputData(scanner);
                    teacherManager.updateTeacher(teacherId, updatedTeacher);
                    break;
                case 4:
                    System.out.print("Nhập mã giảng viên cần xóa: ");
                    teacherManager.deleteTeacher(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void manageStudents() {
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: studentManager.displayStudents(); break;
                case 2:
                    Student student = new Student();
                    student.inputData(scanner);
                    studentManager.addStudent(student);
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần cập nhật: ");
                    String studentId = scanner.nextLine();
                    Student updatedStudent = new Student();
                    updatedStudent.inputData(scanner);
                    studentManager.updateStudent(studentId, updatedStudent);
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    studentManager.deleteStudent(scanner.nextLine());
                    break;
                case 5: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void manageRegistrations() {
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ ĐĂNG KÝ KHÓA HỌC ===");
            System.out.println("1. Đăng ký khóa học");
            System.out.println("2. Hủy đăng ký");
            System.out.println("3. Duyệt đăng ký");
            System.out.println("4. Xem danh sách đăng ký theo khóa học");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CourseRegistration reg = new CourseRegistration();
                    reg.inputData(scanner);
                    regManager.addRegistration(reg);
                    break;
                case 2:
                    System.out.print("Nhập mã đăng ký cần hủy: ");
                    regManager.cancelRegistration(Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    System.out.print("Nhập mã đăng ký cần duyệt: ");
                    regManager.approveRegistration(Integer.parseInt(scanner.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhập mã khóa học: ");
                    regManager.displayRegistrationsByCourse(scanner.nextLine());
                    break;
                case 5: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void manageClassRooms() {
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ LỚP HỌC ===");
            System.out.println("1. Danh sách lớp học");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Phân công giảng viên");
            System.out.println("6. Thêm sinh viên vào lớp");
            System.out.println("7. Tạo lịch học");
            System.out.println("8. Cập nhật trạng thái lớp");
            System.out.println("9. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: classRoomManager.displayClassRooms(); break;
                case 2:
                    ClassRoom classRoom = new ClassRoom();
                    classRoom.inputData(scanner);
                    classRoomManager.addClassRoom(classRoom);
                    break;
                case 3:
                    System.out.print("Nhập mã lớp học cần cập nhật: ");
                    int classroomId = Integer.parseInt(scanner.nextLine());
                    ClassRoom updatedClassRoom = new ClassRoom();
                    updatedClassRoom.inputData(scanner);
                    classRoomManager.updateClassRoom(classroomId, updatedClassRoom);
                    break;
                case 4:
                    System.out.print("Nhập mã lớp học cần xóa: ");
                    classRoomManager.deleteClassRoom(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhập mã lớp học: ");
                    int classId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập mã giảng viên: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    classRoomManager.assignTeacher(classId, teacherId);
                    break;
                case 6:
                    System.out.print("Nhập mã lớp học: ");
                    int classId2 = Integer.parseInt(scanner.nextLine());
                    Student student = new Student();
                    student.inputData(scanner);
                    classRoomManager.addStudentToClass(classId2, student);
                    break;
                case 7:
                    Schedule schedule = new Schedule();
                    schedule.inputData(scanner);
                    scheduleManager.addSchedule(schedule);
                    break;
                case 8:
                    System.out.print("Nhập mã lớp học: ");
                    int classId3 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập trạng thái (PENDING/PROGRESS/CLOSE): ");
                    ClassRoom.Status status = ClassRoom.Status.valueOf(scanner.nextLine().toUpperCase());
                    classRoomManager.updateStatus(classId3, status);
                    break;
                case 9: break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

}