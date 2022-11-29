package com.example.tadashboard.dataObjects;

public enum Url {
    TA_LOGIN("http://localhost/TADashboard/login.jsp");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        return url;
    }
}
