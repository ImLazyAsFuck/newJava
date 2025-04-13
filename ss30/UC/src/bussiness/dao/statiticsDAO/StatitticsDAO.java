package bussiness.dao.statiticsDAO;

import bussiness.model.departmentModel.Department;

public interface StatitticsDAO{
    int totalEmployeeInInDepartment();
    int totalEmployee();
    Department departmentWithMostEmployees();
    Department departmentWithMostSalary();
}
