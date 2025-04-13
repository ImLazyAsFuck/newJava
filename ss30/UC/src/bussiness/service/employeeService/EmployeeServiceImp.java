package bussiness.service.employeeService;

import bussiness.dao.employeeDAO.EmployeeDAO;
import bussiness.dao.employeeDAO.EmployeeDAOImp;
import bussiness.model.employeeModel.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService{
    private final EmployeeDAO employeeDAO = new EmployeeDAOImp();

    @Override
    public Employee findEmployeeByName(String departmentName){
        return employeeDAO.findEmployeeByName(departmentName);
    }

    @Override
    public List<Employee> findEmployeeByAgeGroup(int minAge, int maxAge, int page, int size){
        return employeeDAO.findEmployeeByAgeGroup(minAge, maxAge, page, size);
    }

    @Override
    public List<Employee> findAll(int page, int pageSize){
        return employeeDAO.findAll(page, pageSize);
    }

    @Override
    public boolean save(Employee employee){
        return employeeDAO.save(employee);
    }

    @Override
    public boolean update(Employee employee){
        return employeeDAO.update(employee);
    }

    @Override
    public boolean delete(Employee employee){
        return employeeDAO.delete(employee);
    }
}
