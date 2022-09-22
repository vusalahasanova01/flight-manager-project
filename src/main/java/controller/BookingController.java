package controller;

import model.Booking;
import model.Passenger;
import service.BookingService;

import java.util.List;
import java.util.Optional;

public class BookingController {
    BookingService bookingService = new BookingService();
    public List <Booking> getAll(){
        return bookingService.getAll();
    }
    public Optional<Booking> getId(int index){
        return  bookingService.getById(index);
    }
    public boolean delete(int index){
        return bookingService.delete(index);
    }
    public boolean cancelBooking(int id){
       return  bookingService.cancelFlight(id);
    }
    public List <Booking> getUserBooking(int id){
        return bookingService.getUserBooking(id);
    }
    public boolean addTicket(Passenger passenger, int selectedFlightId){
        return bookingService.addTicket(passenger,selectedFlightId);
    }
}
