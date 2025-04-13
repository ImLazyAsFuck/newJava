package bussiness.dao.departmentDAO;

import bussiness.dao.AppDAO;
import bussiness.model.departmentModel.Department;

public interface DepartmentDAO extends AppDAO{
    Department findDepartmentByName(String departmentName);
}
