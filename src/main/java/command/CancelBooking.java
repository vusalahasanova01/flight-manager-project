package command;

import controller.BookingController;
import model.Booking;
import util.Util;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Optional;

public class CancelBooking {
    private final BookingController booking =  new BookingController();
    public void cancelBooking(){
        int cancelId = Util.callResultInt("Enter id which you want to cancel:");
        Optional<Booking> bookingId = booking.getId(cancelId);
        if (bookingId.isPresent()){
            if(booking.cancelBooking(cancelId)){
                System.out.println("You cancel ticket succcessfully");
            }
            else {
                System.out.println("Your ticket not canceled");
            }
        }
        else {
            System.out.println("There is no  ticket which id = "+ cancelId);
        }

    }
}
