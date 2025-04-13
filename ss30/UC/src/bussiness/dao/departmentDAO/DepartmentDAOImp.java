package bussiness.dao.departmentDAO;

import bussiness.config.ConnectionDB;
import bussiness.model.departmentModel.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public List findAll(int page, int pageSize) {
        Connection con = null;
        CallableStatement cs = null;
        List<Department> list = new ArrayList<Department>();
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call find_all_department(?,?)}");
            cs.setInt(1, page);
            cs.setInt(2, pageSize);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setDepartmentId(rs.getInt("d_id"));
                department.setDepartmentName(rs.getString("d_name"));
                department.setDepartmentDescription(rs.getString("d_description"));
                department.setDepartmentStatus(rs.getBoolean("d_status"));
                list.add(department);
            }
        }catch(SQLException e){
            System.out.println("\u001B[31mError while connecting to SQL\u001B[0m");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown Error while connecting to SQL\u001B[0m");
        }
        return list;
    }

    @Override
    public boolean save(Department department){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call create_department(?,?,?)}");
            cs.setString(1, department.getDepartmentName());
            cs.setString(2, department.getDepartmentDescription());
            cs.setBoolean(3, department.isDepartmentStatus());
            cs.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("\u001B[31mError while creating department\u001B[0m");
            return false;
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown Error creating department\u001B[0m");
            return false;
        }
    }

    @Override
    public boolean update(Department department){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call update_department(?,?,?,?)}");
            cs.setInt(1, department.getDepartmentId());
            cs.setString(2, department.getDepartmentName());
            cs.setBoolean(3, department.isDepartmentStatus());
            cs.setString(4, department.getDepartmentDescription());
            cs.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("\u001B[31mError while updating department\u001B[0m");
            return false;
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown Error updating department\u001B[0m");
            return false;
        }
    }

    @Override
    public boolean delete(Department department){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call delete_department(?)}");
            cs.setInt(1, department.getDepartmentId());
            cs.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("\u001B[31mError while deleting department\u001B[0m");
            return false;
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown Error deleting department\u001B[0m");
            return false;
        }
    }
}
