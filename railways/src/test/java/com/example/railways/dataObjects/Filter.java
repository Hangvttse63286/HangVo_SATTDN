package com.example.railways.dataObjects;

public enum Filter {
    DEPART_STATION("Depart Station"),
    ARRIVE_STATION("Arrive Station"),
    DEPART_DATE("Depart Date"),
    STATUS("Status");

    private final String name;

    Filter(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
