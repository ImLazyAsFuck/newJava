package bussiness.dao.statiticsDAO;

import bussiness.config.ConnectionDB;
import bussiness.model.departmentModel.Department;

import java.sql.*;

public class StatitticsDAOImp implements StatitticsDAO {
    @Override
    public int totalEmployeeInInDepartment(){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call count_employees_by_department(?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.executeQuery();
            return cs.getInt(1);
        }catch(SQLException e){
            System.out.println("\u001B[31mError while count employee by departmentu001B[0m");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown error while count employee by department: " + e.getMessage());
        }
        ConnectionDB.closeConnection(con, cs);
        return 0;
    }

    @Override
    public int totalEmployee(){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call count_total_employees(?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.executeQuery();
            return cs.getInt(1);
        }catch(SQLException e){
            System.out.println("\u001B[31mError while count total employee");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown error while count total employee: " + e.getMessage());
        }
        ConnectionDB.closeConnection(con, cs);
        return 0;
    }

    @Override
    public Department departmentWithMostEmployees(){
        Connection con = null;
        CallableStatement cs = null;
        Department department = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call department_with_most_employees()}");
            ResultSet rs = cs.executeQuery();
            if(rs.next()){

            }
        }catch(SQLException e){
            System.out.println("\u001B[31mError while count total employee");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown error while count total employee: " + e.getMessage());
        }
        ConnectionDB.closeConnection(con, cs);
    }

    @Override
    public Department departmentWithMostSalary(){
        return null;
    }
}
