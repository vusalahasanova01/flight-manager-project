package service;

import dao.FlightDao;
import exception.CheckFlightException;
import model.Flight;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
    FlightDao flightDao = new FlightDao();

    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    public Optional<Flight> getById(int index) {
        Optional<Flight> flight = flightDao.getById(index);
        if (flight.isPresent()) {
            return flight;
        } else {
            throw new CheckFlightException();
        }
    }
 public List<Flight> getTimeTableFLights(){
    return  getAll().
            stream().filter(f ->
                    {
                        LocalDateTime startDate = f.getTimeForBegin();
                        return startDate.isAfter(LocalDateTime.now())&&
                                startDate.isBefore(LocalDateTime.now().plusHours(24));
                    }
            ).collect(Collectors.toList());
    }
    public boolean delete(int index) {
        return flightDao.delete(index);
    }



}
