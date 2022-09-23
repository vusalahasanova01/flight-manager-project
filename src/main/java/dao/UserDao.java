package dao;

import model.Flight;
import model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    private final DaoImp<User> user = new DaoImp<>();
    private final String filePath = "src/main/java/file/User.bin";

    @Override
    public List<User> getAll() {
        return user.getAll(filePath);
    }

    @Override
    public Optional<User> getById(int index) {
        return getAll().stream().filter(u -> index == u.getId()).findFirst();
    }

    @Override
    public boolean saveData(List<User> list) {
        return user.saveData(list, filePath);
    }

    @Override
    public boolean uptadeData(int id, User value) {
        if (getById(id).isEmpty()) {
            return false;
        } else {
            List<User> userList = user.getAll(filePath);
            userList.remove(id);
            value.setId(id);
            userList.add(value);
            user.saveData(userList, filePath);
            return true;
        }
    }

    @Override
    public boolean addData(int id, User value) {
        List<User> userList = getAll();
        if(getById(id).isPresent()){
            return false;
        }
        userList.add(value);
        saveData(userList);
        return true;
    }

    @Override
    public boolean delete(int index) {
        Optional<User> userOptional = getById(index);
        if (userOptional.isEmpty()) {
            return false;
        } else {
            List<User> userList = user.getAll(filePath);
            userList.remove(userOptional.get());
            user.saveData(userList, filePath);
            return true;
        }
    }
}
