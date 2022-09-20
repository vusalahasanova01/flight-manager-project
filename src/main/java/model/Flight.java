package model;

import util.Id;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight  implements Serializable {
    private  int id;
    private Airport whereFrom;
    private Airport whereTo;
    private Airline airline;
    private LocalDateTime timeForBegin;
    private LocalDateTime timeForFinish;
    private int freeSeats;

    public Flight
            ( Airport whereFrom, Airport whereTo, Airline airline, LocalDateTime timeForBegin,
             LocalDateTime timeForFinish, int freeSeats) {
        this.id = Id.getId(DBEnum.FLIGHT_ID).orElseThrow();
        this.whereFrom = whereFrom;
        this.whereTo = whereTo;
        this.airline = airline;
        this.timeForBegin = timeForBegin;
        this.timeForFinish = timeForFinish;
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

    public void setTimeForBegin(LocalDateTime timeForBegin) {
        this.timeForBegin = timeForBegin;
    }

    public LocalDateTime getTimeForFinish() {
        return timeForFinish;
    }

    public void setTimeForFinish(LocalDateTime timeForFinish) {
        this.timeForFinish = timeForFinish;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
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
