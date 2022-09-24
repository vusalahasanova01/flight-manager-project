package command;

import controller.FlightController;
import util.Util;

public class AllTimetable {
    FlightController flightController = new FlightController();

    public void AllTimetable() {
            flightController.getTimeTableFLights()
                    .forEach(f -> System.out.println(f.prettyFormat()));
    }

}