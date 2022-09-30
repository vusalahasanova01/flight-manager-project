import bookingManager.BookingManager;
import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import model.Airline;
import model.Airport;


public class Main {

    public static void main(String[] args) {
      FlightController flightController = new FlightController();
      flightController.addFlight(Airport.ISTANBUL,Airport.BAKU, Airline.TURKEY_AIRLINES,"2022-09-24 02:06",
              "2022-09-25 10:06",30);
        flightController.addFlight(Airport.BAKU,Airport.KYIV, Airline.AZAL,"2022-10-23 02:06",
                "2022-10-23 10:06",50);
        flightController.addFlight(Airport.MOSCOW,Airport.BAKU, Airline.JETBLUE,"2022-09-26 02:06",
                "2022-09-27 09:06",43);
        flightController.addFlight(Airport.NEW_YORK,Airport.TOKYO, Airline.QATAR_AIRWAYS,"2022-12-23 02:06",
                "2022-12-24 10:06",65);
        flightController.addFlight(Airport.ISTANBUL,Airport.TOKYO, Airline.TURKEY_AIRLINES,"2022-09-24 15:46",
                "2022-09-25 10:06",59);
        flightController.addFlight(Airport.BAKU,Airport.MOSCOW, Airline.AZAL,"2022-09-24 16:06",
                "2022-09-24 23:06",41);
        flightController.addFlight(Airport.KYIV,Airport.ISTANBUL, Airline.SINGAPORE_AIRLINES,"2023-01-23 15:56",
                "2023-01-24 17:06",72);
        flightController.addFlight(Airport.MOSCOW,Airport.ISTANBUL, Airline.JETBLUE,"2023-09-23 02:06",
                "2023-02-23 13:06",130);
        flightController.addFlight(Airport.TOKYO,Airport.BAKU, Airline.ALASKA_AIRLINES,"2023-10-23 02:06",
                "2022-10-23 14:06",112);
        flightController.addFlight(Airport.ISTANBUL,Airport.MOSCOW, Airline.TURKEY_AIRLINES,"2022-11-23 02:06",
                "2022-11-23 12:06",23);
       System.out.println(new UserController().getAll());
       System.out.println(new BookingController().getAll());
       System.out.println(new FlightController().getAll());
        BookingManager.start();
    }
}
