package dao;

import model.Flight;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao <Flight> {

    private final String filePath = "src/main/java/file/Flight.bin";
    private final DaoImp<Flight> flightDaoImp = new DaoImp<>();

    @Override
    public List<Flight> getAll() {
        return flightDaoImp.getAll(filePath);
    }

    @Override
    public Optional<Flight> getById(int index) {
        return getAll().stream().filter(f -> index == f.getId()).findFirst();
    }

    @Override
    public boolean delete(int index) {
      if(getById(index).isEmpty()){
          return false;
      }
      else{
          List <Flight> flightList = flightDaoImp.getAll(filePath);
          flightList.remove(index);
          flightDaoImp.saveData(flightList,filePath);
          return true;
      }
    }

    @Override
    public boolean saveData(List<Flight> list) {
        return flightDaoImp.saveData(list,filePath);
    }

    @Override
    public boolean uptadeData(int id, Flight value) {
       if(getById(id).isEmpty()){
           return false;
       }
       else{
           List <Flight> flightList = new ArrayList<>();
           flightList.remove(id);
           value.setId(id);
           flightList.add(value);
           flightDaoImp.saveData(flightList,filePath);
           return true;
       }
    }

    @Override
    public boolean addData(int id, Flight value) {
        if(getById(id).isEmpty()){
            List <Flight> flightList = new ArrayList<>();
            flightList.add(value);
            flightDaoImp.saveData(flightList,filePath);
            return true;
        }
        else {
            return false;
        }
    }
}
