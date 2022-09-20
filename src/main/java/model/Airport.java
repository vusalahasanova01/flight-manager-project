package model;

public enum Airport {
    ISTANBUL("IST"),
    BAKU("BK"),
    MOSCOW("MSC"),
    NEW_YORK("NWY"),
    TOKYO("TKY"),
    KYIV("KYV");

    private final String code;
    Airport(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
