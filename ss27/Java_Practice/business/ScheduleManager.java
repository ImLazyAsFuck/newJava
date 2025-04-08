package practice.business;


import practice.entity.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<Schedule> schedules = new ArrayList<>();
    private int nextId = 1;

    public void addSchedule(Schedule schedule) {
        schedule.setScheduleId(nextId++);
        schedules.add(schedule);
        System.out.println("Tạo lịch học thành công!");
    }
}
