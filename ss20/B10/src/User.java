import java.util.Optional;

public class User{
    private int id;
    private String name;
    private Optional<String> email;

    public User(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public User(){
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Optional<String> getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = Optional.of(email);
    }
}
