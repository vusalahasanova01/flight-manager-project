package command;

import controller.FlightController;
import exception.CheckFlightException;
import util.Util;

import java.time.temporal.UnsupportedTemporalTypeException;

public class FlightById {
    FlightController flightController = new FlightController();
    public void flightInformation(){
        try {
            int id = Util.callResultInt("Enter  the id of which end you want to search: ");
            String info = flightController.getById(id).toString();
            System.out.println(info);
        }
        catch (CheckFlightException f){
            System.out.println("there is no id in the system.");
        }

    }
}