package command;

import controller.FlightController;
import exception.CheckFlightException;
import model.Flight;
import util.Util;

import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Optional;

public class FlightById {
    FlightController flightController = new FlightController();
    public void flightInformation(){

        try {
            int id = Util.callResultInt("Enter  the id of which end you want to search: ");
            Optional<Flight> flight = flightController.getById(id);

            String info = flight.isPresent() ? flight.get().prettyFormat() : "-";
            System.out.println(info);
        }
        catch (CheckFlightException f){
            System.out.println("there is no id in the system.");
        }

    }
}