package service;

import bookingManager.BookingManager;
import dao.UserDao;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService userService = new UserService();
    UserDao userDao = new UserDao();
    List<User> realData;
    User testUser;

    @BeforeEach
    public void setTestEnv() {
        realData = userService.getAll();
        userDao.saveData(new ArrayList<>());
        testUser = new User("Vusala", "Hasanova", "vusu01", "Vusala2001");
    }

    @AfterEach
    public void endTestEnv() {
        userDao.saveData(realData);
    }

    @Test
    public void getByIdTest() {
        userDao.addData(testUser.getId(), testUser);
        User user = userService.getById(testUser.getId()).orElseThrow();
        assertEquals(testUser, user);

    }

    @Test
    public void deleteTest() {
        userDao.addData(testUser.getId(), testUser);
        userService.delete(testUser.getId());
        assertEquals(0, userService.getAll().size());
    }

    @Test
    public void getAllTest() {
        userDao.addData(testUser.getId(), testUser);
        List<User> allUser = userService.getAll();
        assertEquals(testUser, allUser.get(0));
    }

    @Test
    public void registerTest() {
        Optional<User> registerUser = registerUser(testUser);
        assertEquals(testUser.getUsername(), registerUser.get().getUsername());

    }

    @Test
    public void loginCheckTest() {
        Optional<User> loginUser = loginUser(testUser);
        assertEquals(BookingManager.getLogged(), loginUser.get().getId());

    }

    private Optional<User> loginUser(User testUser) {
        userService.loginCheck(testUser.getUsername(), testUser.getPassword());
        return userService.getAll()
                .stream().filter(u -> u.getUsername().equals(testUser.getUsername())
                        && u.getPassword().equals(testUser.getPassword())).findFirst();

    }

    private Optional<User> registerUser(User testUser) {
        userService.register(testUser.getName(), testUser.getSurname(), testUser.getUsername(), testUser.getPassword());
        return userService.getAll()
                .stream().filter(u -> u.getName().equals(testUser.getName())
                        && u.getSurname().equals(testUser.getSurname())
                        && u.getUsername().equals(testUser.getUsername())
                        && u.getPassword().equals(testUser.getPassword())).findFirst();
    }


}
