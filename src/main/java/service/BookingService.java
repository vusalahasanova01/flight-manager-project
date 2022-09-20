package service;

import dao.BookingDao;
import exception.CheckFlightException;
import model.Booking;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService {
    BookingDao bookingDao = new BookingDao();
    public List <Booking>  getAll() {
       return bookingDao.getAll();
    }
    public Optional <Booking> getById(int index){
        return bookingDao.getById(index);
    }
    public boolean delete(int index){
        return  bookingDao.delete(index);
    }
    public boolean cancelFlight(int id) throws CheckFlightException {
        if (bookingDao.getById(id).isEmpty()) {
            throw new CheckFlightException();
        }
        else{
            return  bookingDao.delete(id);
        }
    }
    public List <Booking> getUserBooking(int id){
        return bookingDao.getAll()
                .stream().filter(b -> b.getUser().getId()==id).collect(Collectors.toList());
    }
}
