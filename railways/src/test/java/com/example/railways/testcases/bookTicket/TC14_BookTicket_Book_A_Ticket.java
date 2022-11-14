package com.example.railways.testcases.bookTicket;

import com.example.railways.common.constant.SeatType;
import com.example.railways.common.constant.Station;
import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.pageObjects.*;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class TC14_BookTicket_Book_A_Ticket extends BaseTest {

    @Test
    public void TC_BookTicket_Book1Ticket() {
        Log.info("TC14-User can book 1 ticket at a time");
        Log.info("Pre-condition: Create and activate a new account");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Login with valid account");
        homePage.getTab(Tab.LOGIN).click();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        loginPage.login(getEmail(), getPassword());
        Log.info("Click on \"Book ticket\" tab");
        loginPage.getTab(Tab.BOOK_TICKET).click();

        Date startDate = Utilities.getDateAheadFromCurrentDate(3);
        Date endDate = Utilities.getDateAheadFromCurrentDate(30);

        String departDate = Utilities.formatDateToString(Utilities.generateRandomDate(startDate, endDate), "M/d/yyyy");
        Station departStation = Station.SAI_GON;
        Station arriverStation = Station.NHA_TRANG;
        SeatType seatType = SeatType.SBC;
        int ticketAmount = 1;
        Log.info("Depart Date: " + departDate
                + " - Depart Station: " + departStation.getName()
                + " - Arrive Station: " + arriverStation.getName()
                + " - Seat Type: " + seatType.getName()
                + " - Ticket Amount: " + ticketAmount);

        BookTicketPage bookTicketPage = new BookTicketPage(DriverManager.getDriver());
        DriverManager.scrollToView(bookTicketPage.getBtnBookTicket());
        Log.info("Select a \"Depart date\" from the list");
        Log.info("Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        Log.info("Select \"Soft bed with air conditioner\" for \"Seat type\"");
        Log.info("Select \"1\" for \"Ticket amount\"");
        Log.info("Click on \"Book ticket\" button");
        bookTicketPage.bookTicket(departDate, departStation, arriverStation, seatType, ticketAmount);

        SuccessPage successPage = new SuccessPage(DriverManager.getDriver());
        String successDepartDate = successPage.getRowValue("Depart Date");
        String successDepartStation = successPage.getRowValue("Depart Station");
        String successArriveStation = successPage.getRowValue("Arrive Station");
        String successSeatType = successPage.getRowValue("Seat Type");
        String successTicketAmount = successPage.getRowValue("Amount");

        Log.info("Expected: Message \"Ticket Booked Successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
        Assert.assertEquals(successPage.getMsgBookTicketSuccess().getText(), "Ticket Booked Successfully!");
        Assert.assertTrue(successDepartDate.equals(departDate)
                && successDepartStation.equals(departStation.getName())
                && successArriveStation.equals(arriverStation.getName())
                && successSeatType.equals(seatType.getName())
                && successTicketAmount.equals(String.valueOf(ticketAmount)));
    }
}
