package dao;

import model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    private final DaoImp<User> user = new DaoImp<>();
//    private final String filePath = "C:\\WorkSpace\\flightProject\\src\\main\\java\\file\\User.bin";
    private final String filePath = "src/main/java/file/User.bin";

    @Override
    public List<User> getAll() {
        return user.getAll(filePath);
//        FileInputStream fis;
//        try {
//             fis = new FileInputStream(filePath);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        /*try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(filePath))) {
//            System.out.println("trydayam");
            return (List<User>) o.readObject();
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("IOE catche girdi");
            return new ArrayList<>();
        } catch (ClassNotFoundException ex) {
//            System.out.println("CNFE catche girdi");
            return new ArrayList<>();
        }*/
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
//        System.out.println(value);
        if (getById(id).isEmpty()) {
            List<User> userList = user.getAll(filePath);
//            System.out.println(userList);
            userList.add(value);
            user.saveData(userList, filePath);
//            System.out.println(user.getAll(filePath));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int index) {
        if (getById(index).isEmpty()) {
            return false;
        } else {
            List<User> userList = user.getAll(filePath);
            userList.remove(index);
            user.saveData(userList, filePath);
            return true;
        }
    }


}
