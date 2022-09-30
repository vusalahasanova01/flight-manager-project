package service;

import dao.FlightDao;
import model.Airline;
import model.Airport;
import model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightServiceTest {
    FlightService flightService = new FlightService();
    FlightDao flightDao = new FlightDao();
    List<Flight> realData;
    Flight testFlight;

    @BeforeEach
    public void setTestFlight(){
        realData = flightService.getAll();
        flightDao.saveData(new ArrayList<>());
        testFlight = new Flight(Airport.ISTANBUL, Airport.BAKU, Airline.TURKEY_AIRLINES,"2022-09-30 22:06",
                "2022-10-01 12:06",30);
    }

    @AfterEach
    public void endTestFlight(){
        flightDao.saveData(realData);
    }

    @Test
    public void testgetAll() {
     flightDao.addData(testFlight.getId(),testFlight);
        List<Flight> flights = flightService.getAll();
        assertEquals(testFlight,flights.get(0));
    }
    @Test
    public void testGetById(){
        flightDao.addData(testFlight.getId(),testFlight);
        Flight flight = flightService.getById(testFlight.getId()).orElseThrow();
        assertEquals(testFlight,flight);
    }

    @Test
    public void testGetTimeTable(){
        flightDao.addData(testFlight.getId(),testFlight);
        List<Flight> timeTableFLights = flightService.getTimeTableFLights();
        assertEquals(timeTableFLights.get(0),testFlight);
    }

    @Test
    public void testDeleteFlight(){
        flightDao.addData(testFlight.getId(),testFlight);
        flightService.delete(testFlight.getId());
        assertEquals(new ArrayList<>(),flightService.getAll());
    }

    @Test
    public void  searchFlightByInform(){
        Flight flight = testAddFlight(Airport.ISTANBUL,Airport.BAKU, Airline.TURKEY_AIRLINES,"2022-09-24 02:06",
                "2022-09-24 10:06",30);
        List<Flight> flightList = flightService.searchFlightByInform("ISTANBUL", "Baku", "24-09-2022 02:06", 30);
        assertEquals(flight.getId(),flightList.get(0).getId());
    }
    private Flight testAddFlight(Airport whereFrom, Airport whereto, Airline airline
            , String timeForBegin, String timeForFinish, int freeSeats){
        flightService.addFlight(whereFrom, whereto,airline,timeForBegin,
                timeForFinish,freeSeats);
        return flightService.getAll()
                .get(0);
    }



}
