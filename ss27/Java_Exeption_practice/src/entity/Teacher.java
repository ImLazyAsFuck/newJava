package entity;

public class Teacher implements IApp{
    private String teacherId;
    private String subject;

    public Teacher(String teacherId, String subject){
        this.teacherId = teacherId;
        this.subject = subject;
    }

    public Teacher(){
    }

    public String getTeacherId(){
        return teacherId;
    }

    public void setTeacherId(String teacherId){
        this.teacherId = teacherId;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    public void inputData(){

    }
}
