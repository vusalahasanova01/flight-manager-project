package service;
import dao.BookingDao;
import dao.FlightDao;
import exception.CheckFlightException;
import model.Booking;
import model.Flight;
import model.Passenger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService {
    BookingDao bookingDao = new BookingDao();
    FlightDao flightDao =new FlightDao();
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
                .stream().filter(b -> b.getUserId()==id)
                .collect(Collectors.toList());
    }
    public boolean addTicket(Passenger passenger, int selectedFlightId){
        Booking newBooking = new Booking(passenger,selectedFlightId);
        Flight flight = flightDao.getById(selectedFlightId).orElse(null);
        if (flight == null){
            return false;
        }
        flight.decrementFreeSeats();
        int index = flightDao.getAll().indexOf(flight);
        flightDao.uptadeData(index,flight);
        return bookingDao.addData(newBooking.getId(),newBooking);
    }
}
