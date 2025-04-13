package bussiness.service.employeeService;

import bussiness.model.employeeModel.Employee;
import bussiness.service.BaseService;

import java.util.List;

public interface EmployeeService extends BaseService<Employee>{
    Employee findEmployeeByName(String departmentName);
    List<Employee> findEmployeeByAgeGroup(int minAge, int maxAge, int page, int size);
}
