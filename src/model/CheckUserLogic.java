package model;

import dao.UserDAO;

public class CheckUserLogic {
    public User execute(User user) {
    UserDAO dao = new UserDAO();
    return dao.findUser(user);
    }
}