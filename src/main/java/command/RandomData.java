package command;

import controller.FlightController;
import dao.FlightDao;
import model.Airline;
import model.Airport;
import model.Flight;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomData {
    private static final  FlightDao flightDao = new FlightDao();
    public static  void randData(){
        for (int i = 0; i < 70; i++) {
           Flight flight = generateFlight();
           flightDao.addData(flight.getId(),flight);
        }
    }

    public static Flight generateFlight(){
    Random rnd = new Random();
        Airline airline = Airline.values()[rnd.nextInt(Airline.values().length)];
        Airport whereFrom = Airport.values()[rnd.nextInt(Airport.values().length)];
        Airport whereTo = Airport.values()[rnd.nextInt(Airport.values().length)];
        while (whereTo.equals(whereFrom)) {
            whereTo = Airport.values()[rnd.nextInt(Airport.values().length)];
        }
        LocalDateTime beginDateTime = LocalDateTime.now()
                .plusDays(rnd.nextInt(10)-1)
                .plusHours(rnd.nextInt(24)-1)
                .plusMinutes(rnd.nextInt(60)-1);
        LocalDateTime finishDateTime = beginDateTime.plusHours(rnd.nextInt(12));
        int capacity = rnd.nextInt(150);
        return new Flight(whereFrom,whereTo,airline,beginDateTime,finishDateTime,capacity);
    }
}
