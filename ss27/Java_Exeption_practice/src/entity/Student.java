package entity;

public class Student implements IApp{
    private String studentId;
    private double gpa;

    public Student(String studentId, double gpa){
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public Student(){
    }

    public String getStudentId(){
        return studentId;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public double getGpa(){
        return gpa;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    @Override
    public void inputData(){

    }
}
