import java.time.LocalDate;

public class Person{
    private String name;
    private LocalDate birthday;

    public Person(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public Person(){
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    public void printInfo(){
        System.out.println("Tên: " + this.name);
        System.out.println("Ngày sinh: " + this.birthday);
        LocalDate now = LocalDate.now();
        System.out.println("Tuổi: " + (now.getYear() - this.birthday.getYear()));
        System.out.println();
    }
}
