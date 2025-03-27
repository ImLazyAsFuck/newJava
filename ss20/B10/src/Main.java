import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args){
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        System.out.println();
        System.out.println("== Công việc quá hạn chưa hoàn thành ==");
        tasks.stream()
                .filter(t ->
                        !t.isCompleted())
                .forEach(t ->
                        System.out.println(t.getTitle() + " (Giao cho " + t.getAssignedTo().getName() + ", hạn chót: " + t.getDueDate() + ")"));
        System.out.println();

        long total = tasks.stream()
                .filter(Task::isCompleted)
                .count();
        System.out.print("Tổng số công việc hoàn thành: " + total + "\n");
        System.out.println();

        System.out.println("== Thống kê công việc theo người dùng ==");
        List.of(u1, u2, u3).forEach(u -> {
            int expired = 0;
            int totalJob = 0;
            for (Task task : tasks) {
                if(task.getAssignedTo().equals(u)) {
                    totalJob++;
                }
                if(task.isCompleted()) {
                    expired++;
                }
            }
            System.out.printf("Tên: %-10s | Email: %-20s | Tổng việc: %-5s | Quá hạn: %-10s\n",
                    u.getName(), u.getEmail().orElse("null"), totalJob, expired);
        });
    }
}