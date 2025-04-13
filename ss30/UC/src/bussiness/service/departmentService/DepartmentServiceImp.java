package bussiness.service.departmentService;

import bussiness.dao.departmentDAO.DepartmentDAO;
import bussiness.dao.departmentDAO.DepartmentDAOImp;
import bussiness.model.departmentModel.Department;

import java.util.List;

public class DepartmentServiceImp implements DepartmentService{
    private final DepartmentDAO departmentDAO = new DepartmentDAOImp();

    @Override
    public Department findDepartment(String departmentName){
        return departmentDAO.findDepartmentByName(departmentName);
    }

    @Override
    public List<Department> findAll(int page, int pageSize){
        return departmentDAO.findAll(page, pageSize);
    }

    @Override
    public boolean save(Department department){
        return departmentDAO.save(department);
    }

    @Override
    public boolean update(Department department){
        return departmentDAO.update(department);
    }

    @Override
    public boolean delete(Department department){
        return departmentDAO.delete(department);
    }
}
