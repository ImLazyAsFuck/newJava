package bussiness.dao.employeeDAO;

import bussiness.dao.BaseDAO;
import bussiness.model.departmentModel.Department;
import bussiness.model.employeeModel.Employee;

import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee>{
    Employee findEmployeeByName(String departmentName);
    List<Employee> findEmployeeByAgeGroup(int minAge, int maxAge, int page, int size);
}
