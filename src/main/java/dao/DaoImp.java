package dao;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImp <T>  {

    public List <T> getAll(String fileName)  {
        try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List <T>) o.readObject();
        } catch (IOException e) {
            return new ArrayList<>();
        } catch (ClassNotFoundException ex){
            return new ArrayList<>();
        }
    }

    public <B> boolean saveData(List<B> list,String fileName) {
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
            o.writeObject(list);
            return true;
        } catch (IOException e) {
            System.out.println("File not found in data");
            return false;
        }

    }
}
