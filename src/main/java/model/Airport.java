package model;

public enum Airport {
    ISTANBUL("IST", "Istanbul"),
    BAKU("BK", "Baku"),
    MOSCOW("MSC", "Moscow"),
    NEW_YORK("NWY","Newyork"),
    TOKYO("TKY", "Tokyo"),
    KYIV("KYV", "Kyiv");

    private final String code;
    private final String city;
    Airport(String code, String city) {
        this.code = code;
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }
}
