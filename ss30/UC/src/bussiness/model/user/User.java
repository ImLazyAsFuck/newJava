package bussiness.model.user;

public class User{
    private int userName;
    private String userPassword;
    private UserStatus userStatus;

    public User(int userName, String userPassword, UserStatus userStatus){
        this.userName = userName;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
    }

    public User(){
    }

    public UserStatus getUserStatus(){
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus){
        this.userStatus = userStatus;
    }

    public int getUserName(){
        return userName;
    }

    public String getUserPassword(){
        return userPassword;
    }
}
