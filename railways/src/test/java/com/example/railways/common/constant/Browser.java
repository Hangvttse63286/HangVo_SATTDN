package com.example.railways.common.constant;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String name;

    Browser(String name) {
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
