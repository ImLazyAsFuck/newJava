package bussiness.dao.employeeDAO;

import bussiness.config.ConnectionDB;
import bussiness.model.departmentModel.Department;
import bussiness.model.employeeModel.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO{
    @Override
    public Department findDepartmentByName(String departmentName){
        Connection con = null;
        CallableStatement cs = null;
        Department department = null;
        try{
            con = ConnectionDB.openConnection();

        }
    }

    @Override
    public List<Department> findDepartmentByAgeGroup(int minAge, int maxAge){
        return List.of();
    }

    @Override
    public List<Employee> findAll(int page, int pageSize){
        return List.of();
    }

    @Override
    public boolean save(Employee employee){
        return false;
    }

    @Override
    public boolean update(Employee employee){
        return false;
    }

    @Override
    public boolean delete(Employee employee){
        return false;
    }
}
