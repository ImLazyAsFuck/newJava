package bussiness.dao.departmentDAO;

import bussiness.config.ConnectionDB;
import bussiness.model.departmentModel.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class DepartmentDAOImp implements DepartmentDAO{
    @Override
    public Department findDepartmentByName(String departmentName){
        Connection con = null;
        CallableStatement cs = null;
        Department department = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call findDepartmentByName(?)}");
            cs.setString(1, departmentName);
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
            }
            return department;
        }catch(RuntimeException re){
            System.out.println("\u001B[31mError while connecting to SQL\u001B[0m");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown Error while connecting to SQL\u001B[0m");
        }
        return department;
    }

    @Override
    public List findAll(int page, int pageSize, int totalPage) {
        Connection con = null;
        CallableStatement cs = null;
        List<Department> list = null;
        try{
            con = ConnectionDB.openConnection();
//            cs = con.prepareCall("{find}");
        }
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
