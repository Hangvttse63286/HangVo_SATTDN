package com.example.railways.testcases.bookTicket;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.SeatType;
import com.example.railways.dataObjects.Station;
import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.*;
import com.example.railways.testcases.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Date;

@Listeners(ReportListener.class)
public class TC14_BookTicket_Book_A_Ticket extends BaseTest {

    @Test
    public void TC_BookTicket_Book1Ticket() {
        ExtentTestManager.logMessage("TC14-User can book 1 ticket at a time");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Login with valid account");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.scrollToBtnLogin();
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Click on \"Book ticket\" tab");
        loginPage.clickTab(Tab.BOOK_TICKET);

        Date startDate = Utilities.getDateAheadFromCurrentDate(3);
        Date endDate = Utilities.getDateAheadFromCurrentDate(30);

        String departDate = Utilities.formatDateToString(Utilities.generateRandomDate(startDate, endDate), "M/d/yyyy");
        Station departStation = Station.SAI_GON;
        Station arriverStation = Station.NHA_TRANG;
        SeatType seatType = SeatType.SBC;
        int ticketAmount = 1;
        ExtentTestManager.logMessage("Depart Date: " + departDate
                + " - Depart Station: " + departStation.getName()
                + " - Arrive Station: " + arriverStation.getName()
                + " - Seat Type: " + seatType.getName()
                + " - Ticket Amount: " + ticketAmount);

        BookTicketPage bookTicketPage = new BookTicketPage(DriverManager.getDriver());
        bookTicketPage.scrollToBtnBookTicket();
        ExtentTestManager.logMessage("Select a \"Depart date\" from the list");
        ExtentTestManager.logMessage("Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        ExtentTestManager.logMessage("Select \"Soft bed with air conditioner\" for \"Seat type\"");
        ExtentTestManager.logMessage("Select \"1\" for \"Ticket amount\"");
        ExtentTestManager.logMessage("Click on \"Book ticket\" button");
        bookTicketPage.bookTicket(departDate, departStation, arriverStation, seatType, ticketAmount);

        SuccessPage successPage = new SuccessPage(DriverManager.getDriver());
        String successDepartDate = successPage.getRowValue("Depart Date");
        String successDepartStation = successPage.getRowValue("Depart Station");
        String successArriveStation = successPage.getRowValue("Arrive Station");
        String successSeatType = successPage.getRowValue("Seat Type");
        String successTicketAmount = successPage.getRowValue("Amount");

        ExtentTestManager.logMessage("Expected: Message \"Ticket Booked Successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(successPage.getLblBookTicketSuccessText(), Message.BOOK_TICKET_SUCCESS.getMsg());
        softAssert.assertEquals(successDepartDate, departDate);
        softAssert.assertEquals(successDepartStation, departStation.getName());
        softAssert.assertEquals(successArriveStation, arriverStation.getName());
        softAssert.assertEquals(successSeatType, seatType.getName());
        softAssert.assertEquals(successTicketAmount, (String.valueOf(ticketAmount)));
        softAssert.assertAll();

    }
}
