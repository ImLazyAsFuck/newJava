package src.bussiness.dao.student;

import src.bussiness.dao.AppDAO;
import src.bussiness.model.Student;

public interface StudentDAO extends AppDAO<Student>{
    int getCountStudentByStatus(boolean status);

    Student findById(int id);
}
