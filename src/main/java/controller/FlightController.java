package controller;

import model.Booking;
import model.Flight;
import service.FlightService;

import java.util.List;
import java.util.Optional;

public class FlightController {
    FlightService flightService = new FlightService();
    public List<Flight> getAll(){
        return flightService.getAll();
    }
    public Optional<Flight> getId(int index){
        return flightService.getById(index);
    }
    public boolean delete(int index) {
        return flightService.delete(index);
    }
    public List<Flight> getTimeTableFLights(){
        return flightService.getTimeTableFLights();
    }
}
