package command;

import controller.BookingController;
import exception.CheckFlightException;
import model.Booking;
import util.Util;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Optional;

public class CancelBooking {
    private final BookingController booking =  new BookingController();
    public void cancelBooking(){
        try {
            booking.getAll().forEach(b -> System.out.println(b.toString()));
            int cancelId = Util.callResultInt("Enter id which you want to cancel:");
            Optional<Booking> bookingId = booking.getId(cancelId);
            if (bookingId.isPresent()) {
                int index = booking.getAll().indexOf(bookingId.get());

                if (booking.cancelBooking(index)) {
                    System.out.println("You cancel ticket succcessfully");
                } else {
                    System.out.println("Your ticket not canceled");
                }
            }
            else{
                System.out.println("======================");
            }
        }
        catch(CheckFlightException f){
            System.out.println("There is no  ticket with this  id");
        }

    }
}
