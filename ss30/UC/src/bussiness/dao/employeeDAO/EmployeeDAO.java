package bussiness.dao.employeeDAO;

import bussiness.dao.BaseDAO;
import bussiness.model.departmentModel.Department;
import bussiness.model.employeeModel.Employee;

import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee>{
    Department findDepartmentByName(String departmentName);
    List<Department> findDepartmentByAgeGroup(int minAge, int maxAge);
}
