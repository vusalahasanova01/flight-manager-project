package model;
import bookingManage.BookingManager;
import util.Id;
import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {
    private  int id;
    private int userId;
    private Passenger passenger;
    private int selectedFlightId;


    public Booking(Passenger passenger, int selectedFlightId) {
        this.id = Id.getId(DBEnum.BOOKING_ID).orElseThrow();
        this.userId = BookingManager.getLogged();
        this.passenger = passenger;
        this.selectedFlightId = selectedFlightId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSelectedFlightId() {
        return selectedFlightId;
    }

    public void setSelectedFlightId(int selectedFlightId) {
        this.selectedFlightId = selectedFlightId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && userId == booking.userId && selectedFlightId == booking.selectedFlightId  && Objects.equals(passenger, booking.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, passenger, selectedFlightId);
    }

    @Override
    public String toString() {
        return "Booking{id=%d, userId=%d, passenger=%s, selectedFlightId=%d}".formatted(id, userId, passenger, selectedFlightId);
    }
}
