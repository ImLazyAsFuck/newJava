package src.bussiness.service.student;

import src.bussiness.model.Student;
import src.bussiness.service.AppService;

public interface StudentService extends AppService<Student>{
    Student findById(int id);

    int getCountStudentByStatus(boolean status);
}
