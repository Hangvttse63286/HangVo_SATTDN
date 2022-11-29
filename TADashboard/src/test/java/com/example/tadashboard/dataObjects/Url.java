package com.example.tadashboard.dataObjects;

public enum Url {
    TA_LOGIN("http://localhost/TADashboard/login.jsp"),
    TA_DASHBOARD("http://localhost/TADashboard");

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
