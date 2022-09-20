package model;

import util.Id;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private  int id;
    private User user;
    private Passenger passenger;
    private Flight selectedFlight;
    private int selectedSeat;

    public Booking( User user, Passenger passenger, Flight selectedFlight, int selectedSeat) {
        this.id = Id.getId(DBEnum.BOOKING_ID).orElseThrow();
        this.user = user;
        this.passenger = passenger;
        this.selectedFlight = selectedFlight;
        this.selectedSeat = selectedSeat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public void setSelectedFlight(Flight selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public int getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(int selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && selectedSeat == booking.selectedSeat && Objects.equals(user, booking.user) && Objects.equals(passenger, booking.passenger) && Objects.equals(selectedFlight, booking.selectedFlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, passenger, selectedFlight, selectedSeat);
    }

    @Override
    public String toString() {
        return "Booking{id=%d, user=%s, passenger=%s, selectedFlight=%s, selectedSeat=%d}"
                .formatted(id, user, passenger, selectedFlight, selectedSeat);
    }
}
