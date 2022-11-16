package com.example.railways.dataObjects;

public enum Message {
    BOOK_TICKET_SUCCESS("Ticket Booked Successfully!"),
    CHANGE_PASSWORD_SUCCESS("Your password has been updated!"),
    UNLOGGED_WELCOME_TEXT("Welcome guest!"),
    LOGGED_WELCOME_TEXT("Welcome "),
    LOGIN_BLANK_FIELD("There was a problem with your login and/or errors exist in your form."),
    LOGIN_FAILED_SEVERAL_TIMES("You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes."),
    LOGIN_INVALID_ACCOUNT("Invalid username or password. Please try again."),
    MY_TICKET_EMPTY("You haven't booked any tickets yet."),
    REGISTER_SUCCESS("You're here"),
    REGISTER_FAILED("There're errors in the form. Please correct the errors and try again."),
    REGISTER_PASSWORD_EMPTY("Invalid password length"),
    REGISTER_PID_EMPTY("Invalid ID length");

    private final String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
