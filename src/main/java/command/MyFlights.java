package command;

import bookingManager.BookingManager;
import controller.BookingController;

public class MyFlights {
    BookingController bookingController = new BookingController();
    public void showUserBooking(){
        bookingController.getUserBooking(BookingManager.getLogged())
                .forEach(b-> System.out.println(b.prettyFormat()));
    }
}
