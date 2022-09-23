package service;

import dao.FlightDao;
import exception.CheckFlightException;
import model.Airline;
import model.Airport;
import model.Flight;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
    FlightDao flightDao = new FlightDao();

    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    public Optional<Flight> getById(int index) throws CheckFlightException{
        Optional<Flight> flight = flightDao.getById(index);
        if (flight.isPresent()) {
            return flight;
        } else {
            throw new CheckFlightException();
        }

    }

    public boolean addFlight(Airport whereFrom, Airport whereto, Airline airline
            , String timeForBegin, String timeForFinish, int freeSeats) {
        Flight addedFlight = new Flight(whereFrom, whereto, airline, timeForBegin, timeForFinish, freeSeats);
        return flightDao.addData(addedFlight.getId(), addedFlight);

    }

    public List<Flight> getTimeTableFLights() {
        return getAll().
                stream().filter(f ->
                        {
                            LocalDateTime startDate = f.getTimeForBegin();
                            return startDate.isAfter(LocalDateTime.now()) &&
                                    startDate.isBefore(LocalDateTime.now().plusHours(24));
                        }
                ).collect(Collectors.toList());
    }

    public boolean delete(int index) {
        return flightDao.delete(index);
    }

    public List <Flight> searchFlightByInform(String startLoc, String city,
                                             String flightDate, int numberOfTicket) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(flightDate, dateTimeFormatter);

        return flightDao.getAll().stream()
                .filter(f ->
                        f.getWhereFrom().name().equalsIgnoreCase(startLoc)
                                && f.getWhereTo().getCity().equals(city)
                                && f.getTimeForBegin().getYear() == date.getYear()
                                && f.getTimeForBegin().getDayOfYear() == date.getDayOfYear()
                                && f.getFreeSeats() >= numberOfTicket
                ).collect(Collectors.toList());


    }
}



