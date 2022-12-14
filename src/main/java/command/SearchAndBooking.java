package command;

import controller.BookingController;
import controller.FlightController;
import exception.CheckFlightException;
import model.Booking;
import model.Flight;
import model.Passenger;
import ui.Menu;
import util.Util;

import java.util.List;

public class SearchAndBooking {
    int numberOfTicket;
    private final FlightController flightController = new FlightController();
    private final BookingController booking = new BookingController();


    public void SearchAndBookFlight() {
        displayFlight();
        askAnswer();
    }

    private List<Flight> searchFlight() {
        String startLoc = Util.callResultSt("Please enter airport name which you want to visit from: ");
        String city = Util.callResultSt("Please enter city where you want go: ");
        String year = Util.callResultSt("Please year of flight: ");
        String month = Util.callResultSt("Please enter month of flight: ");
        String day = Util.callResultSt("Please enter day of flight: ");
        numberOfTicket = Util.callResultInt("Please ticket number which you want: ");
        String date = day + "-" + month + "-" + year + " 00:00";
        return flightController.searchFlightByInform(startLoc, city, date, numberOfTicket);

    }

    private void displayFlight() {
        searchFlight().forEach(f -> System.out.println(f.prettyFormat()));
    }

    private void askAnswer() {
        String answer = Util.callResultSt("Do you want to book flight? y/n");
        if (answer.equals("y")) {
            bookFlight();

        } else if (answer.equals("n")) {
            return;
        } else {
            System.out.println("Your input is wrong,enter again: ");
            askAnswer();
        }
    }

    private void bookFlight() {
        try {
            int flightId = Util.callResultInt("Enter flight id: ");
            if (flightController.getById(flightId).isEmpty()) {

            }
            for (int i = 0; i < numberOfTicket; i++) {
                System.out.println(i + " passenger: ");
                String name = Util.callResultSt("Enter name of passenger: ");
                String surname = Util.callResultSt("Enter suname of passenger :");
                booking.addTicket(new Passenger(name, surname), flightId);
            }
        }
        catch (CheckFlightException f){
            System.out.println("there is no flight with this id. Try again. ");
            bookFlight();
        }
    }


}
