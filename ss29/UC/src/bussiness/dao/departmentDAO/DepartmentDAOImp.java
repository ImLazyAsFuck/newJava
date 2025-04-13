package bussiness.dao.departmentDAO;

import bussiness.model.departmentModel.Department;

import java.util.List;

public class DepartmentDAOImp implements DepartmentDAO{
    @Override
    public Department findDepartmentByName(String departmentName){
        return null;
    }

    @Override
    public List findAll(){
        return List.of();
    }

    @Override
    public boolean save(Object o){
        return false;
    }

    @Override
    public boolean update(Object o){
        return false;
    }

    @Override
    public boolean delete(Object o){
        return false;
    }
}
