import bookingManage.BookingManager;
import controller.BookingController;
import controller.FlightController;
import controller.UserController;


public class Main {

    public static void main(String[] args) {
//        System.out.println(new UserController().getAll());
//        System.out.println(new BookingController().getAll());
//        System.out.println(new FlightController().getAll());
        BookingManager.start();
    }
}
