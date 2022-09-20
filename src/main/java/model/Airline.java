package model;

public enum Airline {
    SINGAPORE_AIRLINES("SA"),
    QATAR_AIRWAYS("QA"),
    TURKEY_AIRLINES("TA"),
    AZAL("AZ"),
    JETBLUE("JB"),
    ALASKA_AIRLINES("AA"),
    BRITISH_AIRWAYS("BA");
    private final String code;


    Airline(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
