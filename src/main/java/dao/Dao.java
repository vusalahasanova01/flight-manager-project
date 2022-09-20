package dao;

import model.Passenger;

import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

public interface Dao <T>{
  List <T> getAll() ;
  Optional <T> getById(int index);
  boolean delete(int index);
  boolean saveData(List<T> list);
  boolean uptadeData (int id,T value);
  boolean addData(int id, T value);

}
