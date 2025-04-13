package bussiness.service.userService;

import bussiness.dao.userDAO.UserDAO;
import bussiness.dao.userDAO.UserDAOImp;

public class UserServiceImp implements UserService{
    private final UserDAO userDAO = new UserDAOImp();
    @Override
    public boolean login(String username, String password){
        return userDAO.login(username, password);
    }
}
