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
//            System.out.println("IOE catche girdi");
            return new ArrayList<>();
        } catch (ClassNotFoundException ex){
//            System.out.println("CNFE catche girdi");
            return new ArrayList<>();
        }
    }

    public <B> boolean saveData(List<B> list,String fileName) {
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
            o.writeObject(list);
//            System.out.println(list);
//            System.out.println(fileName);
            return true;
        } catch (IOException e) {
            System.out.println("File not found in data");
            return false;
        }

    }
}
