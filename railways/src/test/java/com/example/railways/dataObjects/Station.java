package com.example.railways.dataObjects;

import com.example.railways.common.constant.Browser;

import java.util.Arrays;

public enum Station {
    SAI_GON("Sài Gòn"),
    PHAN_THIET("Phan Thiết"),
    NHA_TRANG("Nha Trang"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    QUANG_NGAI("Quảng Ngãi"),
    IGNORE("Ignore");

    private final String name;

    Station(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Station fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(Station.values())
                .filter(v -> v.getName().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
