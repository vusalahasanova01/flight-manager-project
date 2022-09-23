package dao;

import model.Booking;
import model.Flight;
import model.User;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class BookingDao implements Dao<Booking> {
  private final String filePath = "src/main/java/file/Booking.bin";
  private final DaoImp<Booking> bookingDaoImp = new DaoImp<>();

  @Override
  public List<Booking> getAll() {
    return bookingDaoImp.getAll(filePath);
  }

  @Override
  public Optional<Booking> getById(int index) {
    return bookingDaoImp.getAll(filePath).stream().filter(b -> index == b.getId()).findFirst();
  }

  @Override
  public boolean delete(int id) {
    Optional<Booking> bookingOptional = getById(id);
    if (bookingOptional.isEmpty()) {
      return false;
    } else {
      List<Booking> bookingList = bookingDaoImp.getAll(filePath);
      bookingList.remove(bookingOptional.get());
      bookingDaoImp.saveData(bookingList, filePath);
      return true;
    }
  }

  @Override
  public boolean saveData(List<Booking> list) {
    return bookingDaoImp.saveData(list, filePath);
  }

  @Override
  public boolean uptadeData(int id, Booking value) {
    if (getById(id).isEmpty()) {
      return false;
    } else {
      List<Booking> bookingList = bookingDaoImp.getAll(filePath);
      bookingList.remove(id);
      value.setId(id);
      bookingList.add(value);
      bookingDaoImp.saveData(bookingList, filePath);
      return true;
    }
  }

  @Override
  public boolean addData(int id, Booking value) {
    List<Booking> bookingList = getAll();
    if(getById(id).isPresent()){
      return false;
    }
    bookingList.add(value);
    saveData(bookingList);
    return true;
  }
}
