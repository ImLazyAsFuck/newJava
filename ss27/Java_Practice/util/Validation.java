package practice.util;


import practice.entity.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validation {
    private static final String PHONE_REGEX = "^(0[35789])[0-9]{8}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static String inputCourseId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã khóa học (5 ký tự, bắt đầu bằng C): ");
            String courseId = scanner.nextLine();
            if (courseId.matches("^C[a-zA-Z0-9]{4}$")) return courseId;
            System.out.println("Mã khóa học không hợp lệ!");
        }
    }

    public static String inputCourseName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên khóa học (20-100 ký tự): ");
            String courseName = scanner.nextLine();
            if (courseName.length() >= 20 && courseName.length() <= 100) return courseName;
            System.out.println("Tên khóa học phải từ 20-100 ký tự!");
        }
    }

    public static String inputName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên (tối đa 150 ký tự): ");
            String name = scanner.nextLine();
            if (!name.isEmpty() && name.length() <= 150) return name;
            System.out.println("Tên không hợp lệ!");
        }
    }

    public static int inputAge(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tuổi (tối thiểu 18): ");
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age >= 18) return age;
                System.out.println("Tuổi phải từ 18 trở lên!");
            } catch (NumberFormatException e) {
                System.out.println("Tuổi phải là số!");
            }
        }
    }

    public static String inputAddress(Scanner scanner) {
        while (true) {
            System.out.print("Nhập địa chỉ: ");
            String address = scanner.nextLine();
            if (!address.isEmpty()) return address;
            System.out.println("Địa chỉ không được để trống!");
        }
    }

    public static String inputPhone(Scanner scanner) {
        while (true) {
            System.out.print("Nhập số điện thoại (định dạng VN): ");
            String phone = scanner.nextLine();
            if (phone.matches(PHONE_REGEX)) return phone;
            System.out.println("Số điện thoại không hợp lệ!");
        }
    }

    public static String inputEmail(Scanner scanner) {
        while (true) {
            System.out.print("Nhập email: ");
            String email = scanner.nextLine();
            if (email.matches(EMAIL_REGEX)) return email;
            System.out.println("Email không hợp lệ!");
        }
    }

    public static Person.Sex inputSex(Scanner scanner) {
        while (true) {
            System.out.print("Nhập giới tính (MALE/FEMALE/OTHER): ");
            try {
                return Person.Sex.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Giới tính không hợp lệ!");
            }
        }
    }

    public static String inputStudentId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã sinh viên (5 ký tự, bắt đầu bằng SV): ");
            String studentId = scanner.nextLine();
            if (studentId.matches("^SV[a-zA-Z0-9]{3}$")) return studentId;
            System.out.println("Mã sinh viên không hợp lệ!");
        }
    }

    public static double inputGpa(Scanner scanner) {
        while (true) {
            System.out.print("Nhập điểm trung bình (0-10): ");
            try {
                double gpa = Double.parseDouble(scanner.nextLine());
                if (gpa >= 0 && gpa <= 10) return gpa;
                System.out.println("Điểm phải từ 0-10!");
            } catch (NumberFormatException e) {
                System.out.println("Điểm phải là số!");
            }
        }
    }

    public static String inputSubject(Scanner scanner) {
        while (true) {
            System.out.print("Nhập chuyên môn: ");
            String subject = scanner.nextLine();
            if (!subject.isEmpty()) return subject;
            System.out.println("Chuyên môn không được để trống!");
        }
    }

    public static int inputTeacherId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã giảng viên: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Mã giảng viên phải là số!");
            }
        }
    }

    public static String inputClassRoomName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên lớp học (15-50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 15 && name.length() <= 50) return name;
            System.out.println("Tên lớp phải từ 15-50 ký tự!");
        }
    }

    public static int inputClassroomId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã lớp học: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Mã lớp học phải là số!");
            }
        }
    }

    public static LocalDateTime inputStartTime(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        while (true) {
            System.out.print("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
            try {
                return LocalDateTime.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng thời gian không hợp lệ!");
            }
        }
    }

    public static LocalDateTime inputEndTime(Scanner scanner, LocalDateTime startTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        while (true) {
            System.out.print("Nhập thời gian kết thúc (yyyy-MM-dd HH:mm:ss): ");
            try {
                LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine(), formatter);
                if (endTime.isAfter(startTime)) return endTime;
                System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu!");
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng thời gian không hợp lệ!");
            }
        }
    }
}