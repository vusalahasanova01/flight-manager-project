package model;

public enum DBEnum {
    USER_ID("UserId.txt"),
    FLIGHT_ID("FlightId.txt"),
    BOOKING_ID("BookingId.txt");
    private final String fileName;

    DBEnum(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
