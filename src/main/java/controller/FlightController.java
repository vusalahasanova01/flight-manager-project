package controller;

import exception.CheckFlightException;
import model.Airline;
import model.Airport;
import model.Booking;
import model.Flight;
import service.FlightService;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class FlightController {
    FlightService flightService = new FlightService();

    public List<Flight> getAll() {
        return flightService.getAll();
    }

    public Optional<Flight> getById(int index) throws CheckFlightException {
        return flightService.getById(index);
    }

    public boolean delete(int index) {
        return flightService.delete(index);
    }

    public List<Flight> getTimeTableFLights() {
        return flightService.getTimeTableFLights();
    }

    public boolean addFlight(Airport whereFrom, Airport whereto, Airline airline
            , String timeForBegin, String timeForFinish, int freeSeats) {
        return flightService.addFlight(whereFrom, whereto, airline, timeForBegin, timeForFinish, freeSeats);
    }
    public List<Flight> searchFlightByInform(String startLoc, String city,
                                             String flightDate, int numberOfTicket)  {
        return flightService.searchFlightByInform( startLoc, city,flightDate, numberOfTicket);
    }
}
