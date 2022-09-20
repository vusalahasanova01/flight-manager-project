package service;

import bookingManage.BookingManager;
import dao.UserDao;
import exception.CheckPasswordException;
import exception.CheckUsernameException;
import model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {
    UserDao userDao = new UserDao();

    public List<User> getAll() {
        return userDao.getAll();
    }

    public Optional<User> getById(int index) {
        return userDao.getById(index);
    }

    public boolean delete(int index) {
        return userDao.delete(index);
    }

    public boolean loginCheck(String username, String password) {
        Optional<User> opUser = userDao.getAll().stream()
                .filter(u ->
                        (u.getUsername().equals(username) && u.getPassword().equals(password)))
                .findFirst();

        if (opUser.isPresent() && BookingManager.getLogged() == -1 ) {
           User loginUser = opUser.get();
            BookingManager.setLogged(loginUser.getId());
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        BookingManager.logout();
    }

    public boolean exit() {
        return false;
    }

    public boolean register(String name, String surname, String username, String password)
            throws CheckPasswordException, CheckUsernameException {
        if (!checkUsername(username)) {
            throw new CheckUsernameException();
        } else if (!checkPassword(password)) {
            throw new CheckPasswordException();
        } else {
            User addedUser = new User(name, surname, username, password);
            userDao.addData(addedUser.getId(), addedUser);
            return true;
        }
    }

    public boolean checkUsername(String username) {
        List<User> all = userDao.getAll();
        if (all == null) {
            return true;
        }
        return all.stream().noneMatch(u -> u.getUsername().equals(username));

    }

    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        char ch;
        boolean capitalWord = false;
        boolean lowerCaseWord = false;
        boolean numberWord = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                numberWord = true;
            } else if (Character.isUpperCase(ch)) {
                capitalWord = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseWord = true;
            }
        }
        return capitalWord && lowerCaseWord && numberWord;
    }


}
