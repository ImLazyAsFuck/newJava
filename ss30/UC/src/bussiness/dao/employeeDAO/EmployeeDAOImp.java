package bussiness.dao.employeeDAO;

import bussiness.config.ConnectionDB;
import bussiness.model.departmentModel.Department;
import bussiness.model.employeeModel.Employee;
import bussiness.model.employeeModel.EmployeeStatus;
import bussiness.model.employeeModel.Gender;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO{
    @Override
    public Employee findEmployeeByName(String departmentName){
        Connection con = null;
        CallableStatement cs = null;
        Employee employee = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call find_employee_by_name(?)}");
            cs.setString(1, departmentName);
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                employee = new Employee();
                employee.setEmployeeId(rs.getString("e_id"));
                employee.setEmployeeName(rs.getString("e_name"));
                employee.setEmail(rs.getString("e_email"));
                employee.setPhone(rs.getString("e_phone"));
                String genderStr = rs.getString("e_gender");
                if (genderStr != null) {
                    employee.setGender(Gender.valueOf(genderStr.toUpperCase()));
                }
                employee.setSalary(rs.getDouble("e_salary"));
                employee.setSalaryLevel(rs.getInt("e_salary_level"));

                LocalDate birthDate = rs.getDate("e_birth_date").toLocalDate();
                DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedBirthDate = birthDate.format(birthDateFormatter);

                System.out.println("Ngày sinh định dạng dd/MM/yyyy: " + formattedBirthDate);
                employee.setDepartmentId(rs.getInt("e_department_id"));
                employee.setAddress(rs.getString("e_address"));
                String statusStr = rs.getString("e_status");
                if (statusStr != null) {
                    employee.setStatus(EmployeeStatus.valueOf(statusStr.toUpperCase()));
                }
            }
            return employee;
        }catch(SQLException e){
            System.out.println("\u001B[31mError while find employee by name department\u001B[0m");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown error while find employee by name department\u001B[0m");
        }
        return null;
    }

    @Override
    public List<Employee> findEmployeeByAgeGroup(int minAge, int maxAge, int page, int size){
        Connection con = null;
        CallableStatement cs = null;
        List<Employee> employees = new ArrayList<>();
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call find_employee_by_age(?,?,?,?)}");
            cs.setInt(1, minAge);
            cs.setInt(2, maxAge);
            cs.setInt(3, page);
            cs.setInt(4, size);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("e_id"));
                employee.setEmployeeName(rs.getString("e_name"));
                employee.setEmail(rs.getString("e_email"));
                employee.setPhone(rs.getString("e_phone"));
                String genderStr = rs.getString("e_gender");
                if (genderStr != null) {
                    employee.setGender(Gender.valueOf(genderStr.toUpperCase()));
                }
                employee.setSalary(rs.getDouble("e_salary"));
                employee.setSalaryLevel(rs.getInt("e_salary_level"));

                LocalDate birthDate = rs.getDate("e_birth_date").toLocalDate();
                DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedBirthDate = birthDate.format(birthDateFormatter);

                System.out.println("Ngày sinh định dạng dd/MM/yyyy: " + formattedBirthDate);
                employee.setDepartmentId(rs.getInt("e_department_id"));
                employee.setAddress(rs.getString("e_address"));
                String statusStr = rs.getString("e_status");
                if (statusStr != null) {
                    employee.setStatus(EmployeeStatus.valueOf(statusStr.toUpperCase()));
                }
                employees.add(employee);
            }
            return employees;
        }catch(SQLException e){
            System.out.println("\u001B[31mError while find employee by age group\u001B[0m");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown error while find employee by age group\u001B[0m");
        }
        ConnectionDB.closeConnection(con, cs);
        return null;
    }

    @Override
    public List<Employee> findAll(int page, int pageSize){
        Connection con = null;
        CallableStatement cs = null;
        List<Employee> employees = new ArrayList<>();
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call find_all_employee(?,?)}");
            cs.setInt(1, page);
            cs.setInt(2, pageSize);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("e_id"));
                employee.setEmployeeName(rs.getString("e_name"));
                employee.setEmail(rs.getString("e_email"));
                employee.setPhone(rs.getString("e_phone"));
                String genderStr = rs.getString("e_gender");
                if (genderStr != null) {
                    employee.setGender(Gender.valueOf(genderStr.toUpperCase()));
                }
                employee.setSalary(rs.getDouble("e_salary"));
                employee.setSalaryLevel(rs.getInt("e_salary_level"));

                LocalDate birthDate = rs.getDate("e_birth_date").toLocalDate();
                DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedBirthDate = birthDate.format(birthDateFormatter);

                System.out.println("Ngày sinh định dạng dd/MM/yyyy: " + formattedBirthDate);
                employee.setDepartmentId(rs.getInt("e_department_id"));
                employee.setAddress(rs.getString("e_address"));
                String statusStr = rs.getString("e_status");
                if (statusStr != null) {
                    employee.setStatus(EmployeeStatus.valueOf(statusStr.toUpperCase()));
                }
                employees.add(employee);
            }
            return employees;
        }catch(SQLException e){
            System.out.println("\u001B[31mError while find all employee\u001B[0m");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown error while find all employee\u001B[0m");
        }
        ConnectionDB.closeConnection(con, cs);
        return employees;
    }

    @Override
    public boolean save(Employee employee) {
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call create_employee(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, employee.getEmployeeId());
            cs.setString(2, employee.getEmployeeName());
            cs.setString(3, employee.getEmail());
            cs.setString(4, employee.getPhone());
            cs.setString(5, employee.getGender().toString());
            cs.setInt(6, employee.getSalaryLevel());
            cs.setBigDecimal(7, new BigDecimal(employee.getSalary()));
            cs.setDate(8, Date.valueOf(employee.getBirthDate()));
            cs.setString(9, employee.getAddress());
            cs.setString(10, employee.getStatus().toString());
            cs.setInt(11, employee.getDepartmentId());

            cs.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("\u001B[31mError while saving employee: " + e.getMessage() + "\u001B[0m");

        } catch (Exception e) {
            System.out.println("\u001B[31mUnknown error while saving employee: " + e.getMessage() + "\u001B[0m");

        }
        ConnectionDB.closeConnection(con, cs);
        return false;
    }



    @Override
    public boolean update(Employee employee){
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call update_employee(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, employee.getEmployeeId());
            cs.setString(2, employee.getEmployeeName());
            cs.setString(3, employee.getEmail());
            cs.setString(4, employee.getPhone());
            cs.setString(5, employee.getGender().toString());
            cs.setInt(6, employee.getSalaryLevel());
            cs.setBigDecimal(7, new BigDecimal(employee.getSalary()));
            cs.setDate(8, Date.valueOf(employee.getBirthDate()));
            cs.setString(9, employee.getAddress());
            cs.setString(10, employee.getStatus().toString());
            cs.setInt(11, employee.getDepartmentId());
            cs.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("\u001B[31mError while saving employee: " + e.getMessage() + "\u001B[0m");

        } catch (Exception e) {
            System.out.println("\u001B[31mUnknown error while saving employee: " + e.getMessage() + "\u001B[0m");

        }
        ConnectionDB.closeConnection(con, cs);
        return false;
    }

    @Override
    public boolean delete(Employee employee){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call delete_employee(?)}");
            cs.setString(1, employee.getEmployeeId());
            cs.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("\u001B[31mError while deleting employee: " + e.getMessage() + "\u001B[0m");
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown error while deleting employee: " + e.getMessage() + "\u001B[0m");
        }
        ConnectionDB.closeConnection(con, cs);
        return false;
    }
}
