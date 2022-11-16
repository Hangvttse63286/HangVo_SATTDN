package com.example.railways.dataObjects;

public enum Status {
    NEW("New"),
    PAID("Paid"),
    EXPIRED("Expired");

    private final String name;

    Status(String name) {
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
