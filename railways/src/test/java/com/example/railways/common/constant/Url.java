package com.example.railways.common.constant;

public enum Url {
    RAILWAYS_URL("http://www.railwayb2.somee.com/"),
    RAILWAYS_LOGIN_URL("http://www.railwayb2.somee.com/Account/Login.cshtml"),
    RAILWAYS_REGISTER_URL("http://www.railwayb2.somee.com/Account/Register.cshtml"),
    RAILWAYS_HOME_URL("http://www.railwayb2.somee.com/Page/HomePage.cshtml"),
    RAILWAYS_FAQ_URL("http://www.railwayb2.somee.com/Page/FAQ.cshtml"),
    RAILWAYS_CONTACT_URL("http://www.railwayb2.somee.com/Page/Contact.cshtml"),
    RAILWAYS_TIMETABLE_URL("http://www.railwayb2.somee.com/Page/TrainTimeListPage.cshtml"),
    RAILWAYS_TICKET_PRICE_URL("http://www.railwayb2.somee.com/Page/TrainPriceListPage.cshtml"),
    RAILWAYS_BOOK_TICKET_URL("http://www.railwayb2.somee.com/Page/BookTicketPage.cshtml"),
    RAILWAYS_MY_TICKET_URL("http://www.railwayb2.somee.com/Page/ManageTicket.cshtml"),
    RAILWAYS_CHANGE_PASSWORD_URL("http://www.railwayb2.somee.com/Account/ChangePassword.cshtml"),
    RAILWAYS_FORGOT_PASSWORD_URL("http://www.railwayb2.somee.com/Account/ForgotPassword.cshtml"),
    RAILWAYS_CONFIRM_URL("http://www.railwayb2.somee.com/Account/Confirm.cshtml"),
    RAILWAYS_BOOK_TICKET_SUCCESS_URL("http://www.railwayb2.somee.com/Page/SuccessPage.cshtml");

    private final String urlLink;

    Url(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getUrlLink() {
        return this.urlLink;
    }

    @Override
    public String toString() {
        return urlLink;
    }
}
