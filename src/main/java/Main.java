import bookingManage.BookingManager;
import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import model.Airline;
import model.Airport;


public class Main {

    public static void main(String[] args) {
       System.out.println(new UserController().getAll());
       System.out.println(new BookingController().getAll());
       System.out.println(new FlightController().getAll());
       FlightController flightController = new FlightController();


       flightController.addFlight(Airport.ISTANBUL,Airport.BAKU, Airline.AZAL,"2022-12-10 11:50",
               "2022-12-11 02:50",30);
        BookingManager.start();
    }
}
