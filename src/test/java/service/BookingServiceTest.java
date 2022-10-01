package service;

import dao.BookingDao;
import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingServiceTest {
    BookingService bookingService = new BookingService();
    BookingDao bookingDao = new BookingDao();
    List<Booking> realData;
    Booking testBooking;
    Passenger testPassenger;
    Flight testFlight;

    @BeforeEach
    public void setTestFlight() {
        realData = bookingService.getAll();
        bookingDao.saveData(new ArrayList<>());
        testPassenger = new Passenger("Vusala","Hasanova");
        testFlight = new Flight(Airport.ISTANBUL, Airport.BAKU, Airline.TURKEY_AIRLINES,"2022-09-30 22:06",
                "2022-10-01 12:06",30);
        testBooking = new Booking(testPassenger,testFlight.getId());
    }

    @AfterEach
    public void endTestFlight(){
        bookingDao.saveData(realData);
    }

    @Test
    public void testGetAll(){
        bookingDao.addData(testBooking.getId(),testBooking);
        List<Booking> bookings = bookingService.getAll();
        assertEquals(testBooking,bookings.get(0));
    }

    @Test
    public void getById(){
        bookingDao.addData(testBooking.getId(),testBooking);
        Booking booking = bookingService.getById(testBooking.getId()).orElseThrow();
        assertEquals(testBooking,booking);
    }

    @Test
    public void testDelete(){
        bookingDao.addData(testBooking.getId(),testBooking);
        bookingService.delete(testBooking.getId());
        assertEquals(new ArrayList<>(),bookingService.getAll());
    }


}
