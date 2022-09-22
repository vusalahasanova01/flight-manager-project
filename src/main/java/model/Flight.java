package model;

import util.Id;

import java.awt.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Flight implements Serializable {
    private int id;
    private Airport whereFrom;
    private Airport whereTo;
    private Airline airline;
    private LocalDateTime timeForBegin;
    private LocalDateTime timeForFinish;
    //  private LocalDateTime timeForBegin;
    //  private LocalDateTime timeForFinish;
    private int freeSeats;

    public Flight
            (Airport whereFrom, Airport whereTo, Airline airline, String timeForBegin,
             String timeForFinish, int freeSeats) {
        this.id = Id.getId(DBEnum.FLIGHT_ID).orElseThrow();
        this.whereFrom = whereFrom;
        this.whereTo = whereTo;
        this.airline = airline;
        setTimeForBegin(timeForBegin);
        setTimeForFinish(timeForFinish);
        this.freeSeats = freeSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Airport getWhereFrom() {
        return whereFrom;
    }

    public void setWhereFrom(Airport whereFrom) {
        this.whereFrom = whereFrom;
    }

    public Airport getWhereTo() {
        return whereTo;
    }

    public void setWhereTo(Airport whereTo) {
        this.whereTo = whereTo;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public LocalDateTime getTimeForBegin() {
        return timeForBegin;
    }

    private LocalDateTime setTimeForFlight(String timeForFlight) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return  LocalDateTime.parse(timeForFlight, formatter);
    }
    public void setTimeForBegin(String  timeForBegin){
        this.timeForBegin = setTimeForFlight(timeForBegin);
    }
    public void setTimeForFinish(String timeForFinish){
       this.timeForFinish = setTimeForFlight(timeForFinish);
    }

    public LocalDateTime getTimeForFinish() {
        return timeForFinish;
    }


    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public void decrementFreeSeats(){
        freeSeats--;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && freeSeats == flight.freeSeats && whereFrom == flight.whereFrom && whereTo == flight.whereTo && airline == flight.airline && Objects.equals(timeForBegin, flight.timeForBegin) && Objects.equals(timeForFinish, flight.timeForFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, whereFrom, whereTo, airline, timeForBegin, timeForFinish, freeSeats);
    }

    @Override
    public String toString() {
        return "Flight{id=%d, whereFrom=%s, whereTo=%s, airline=%s, timeForBegin=%s, timeForFinish=%s, freeSeats=%d}"
                .formatted(id, whereFrom, whereTo, airline, timeForBegin, timeForFinish, freeSeats);
    }
}
