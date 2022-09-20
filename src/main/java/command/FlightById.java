package command;

import controller.FlightController;
import util.Util;

import java.time.temporal.UnsupportedTemporalTypeException;

public class FlightById {
    FlightController flightController = new FlightController();
    public void flightInformation(){
       int id = Util.callResultInt("Enter  the id of which end you want to search: ");
       String info = flightController.getId(id).toString();
        System.out.println(info);

    }
}