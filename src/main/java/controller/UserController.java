package controller;

import exception.CheckPasswordException;
import exception.CheckUsernameException;
import model.User;
import service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {
    UserService userService = new UserService();

    public List<User> getAll() {
        return userService.getAll();
    }

    public Optional<User> getId(int index) {
        return userService.getById(index);
    }

    public boolean delete(int index) {
        return userService.delete(index);
    }

    public boolean loginCheck(String username, String password) {
        return userService.loginCheck(username, password);
    }

    public void logout() {
        userService.logout();
    }

    public boolean exit() {
       return userService.exit();
    }

    public boolean register(String name, String surname, String username, String password)
            throws CheckPasswordException, CheckUsernameException {
        return userService.register(name, surname, username, password);
    }
}
