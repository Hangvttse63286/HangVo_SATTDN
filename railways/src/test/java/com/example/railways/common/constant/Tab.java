package com.example.railways.common.constant;

public enum Tab {
    HOME("Home"),
    FAQ("FAQ"),
    CONTACT("Contact"),
    TIMETABLE("Timetable"),
    TICKET_PRICE("Ticket price"),
    BOOK_TICKET("Book ticket"),
    MY_TICKET("My ticket"),
    CHANGE_PASSWORD("Change password"),
    REGISTER("Register"),
    LOGIN("Login"),
    LOGOUT("Log out");

    private String name;

    Tab(String name) {
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
