package src.bussiness.dao.student;

import src.bussiness.config.ConnectionDB;
import src.bussiness.model.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements StudentDAO{
    Connection conn = null;
    CallableStatement callSt = null;
    List<Student> students = null;

    @Override
    public int getCountStudentByStatus(boolean status){
        return 0;
    }

    @Override
    public Student findById(int id){
        Connection conn = null;
        CallableStatement cstmt = null;
        Student student = null;
        try{
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call getStudentById(?)}");
            cstmt.setInt(1, id);
            ResultSet rs = cstmt.executeQuery();
            if(rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("status"));
            }
        }catch(SQLException e){
            e.fillInStackTrace();
        }catch(Exception e){
            e.fillInStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent(){
        Connection conn = null;
        CallableStatement cstmt = null;
        try{
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call getAllStudent()}");
            ResultSet rs = cstmt.executeQuery();
            students = new ArrayList<>();
            while(rs.next()){
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setStatus(rs.getBoolean("status"));
                students.add(s);
            }
        }catch(SQLException e){
            e.fillInStackTrace();
        }catch(Exception e){
            e.fillInStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return students;
    }

    @Override
    public boolean save(Student student){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_student(?,?,?)}");
            callSt.setString(1, student.getName());
            callSt.setInt(2, student.getAge());
            callSt.setBoolean(3, student.isStatus());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public boolean update(Student student){
        Connection conn = null;
        CallableStatement cstmt = null;
        try{
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call updateStudent(?,?,?,?)}");
            cstmt.setInt(1, student.getId());
            cstmt.setString(2, student.getName());
            cstmt.setInt(3, student.getAge());
            cstmt.setBoolean(4, student.isStatus());
            cstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.fillInStackTrace();
        }catch(Exception e){
            e.fillInStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    @Override
    public boolean delete(Student student){
        return false;
    }
}
