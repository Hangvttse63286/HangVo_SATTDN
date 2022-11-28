package com.example.railways.testcases;

import com.example.railways.common.constant.AssertMessage;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.dataObjects.SeatType;
import com.example.railways.dataObjects.Station;
import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
import com.example.railways.pageObjects.BookTicketPage;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.pageObjects.SuccessPage;
import com.example.railways.pageObjects.TicketPriceListPage;
import com.example.railways.pageObjects.TicketPricePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class FTTC01_BookTicket_After_CheckPrice extends BaseTest {

    @Test(description = "User can book ticket after checking price")
    public void bookTicket_After_CheckPrice() {
        Station dpStation = Station.HUE;
        Station arStation = Station.NHA_TRANG;
        SeatType seatType = SeatType.SB;
        Long totalPrice;

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
        HomePage homePage = new HomePage();

        ExtentTestManager.logMessage("Login with a valid account ");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage();
        loginPage.login(getEmail(), getPassword());
        homePage = new HomePage();

        ExtentTestManager.logMessage("Click on 'Ticket price' tab");
        homePage.clickTab(Tab.TICKET_PRICE);
        TicketPriceListPage ticketPriceListPage = new TicketPriceListPage();

        ExtentTestManager.logMessage("Click 'Check Price' in section 'Trains depart from " + Station.HUE.getName() + " for checking price " + Station.HUE.getName() + " to " + Station.NHA_TRANG.getName());
        ticketPriceListPage.clickBtnCheckPrice(dpStation, arStation);
        TicketPricePage ticketPricePage = new TicketPricePage();
        totalPrice = ticketPricePage.getPrice(seatType);

        ExtentTestManager.logMessage(" On Ticket price page, click 'Book ticket' with " + seatType.getName());
        ticketPricePage.clickBookTicket(seatType);
        BookTicketPage bookTicketPage = new BookTicketPage();

        ExtentTestManager.logMessage("Expected: 'Book ticket' page displays default values correctly: Depart Station, Arrive Station, Seat Type");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bookTicketPage.getSelectedDpStation(), dpStation.getName(), AssertMessage.VALUE_MISMATCH_WITH_EXPECTED.getMsg() + "dll Depart Station");
        softAssert.assertEquals(bookTicketPage.getSelectedArStation(), arStation.getName(), AssertMessage.VALUE_MISMATCH_WITH_EXPECTED.getMsg() + "dll Arrive Station");
        softAssert.assertEquals(bookTicketPage.getSelectedSeatType(), seatType.getName(), AssertMessage.VALUE_MISMATCH_WITH_EXPECTED.getMsg() + "dll Seat Type");
        softAssert.assertAll();

        ExtentTestManager.logMessage("Click 'Book ticket' with default information");
        bookTicketPage.clickBtnBookTicket();
        SuccessPage successPage = new SuccessPage();

        ExtentTestManager.logMessage("Expected: Ticket information display price correctly");
        Assert.assertEquals(successPage.getTotalPrice(), totalPrice, AssertMessage.VALUE_MISMATCH_WITH_EXPECTED.getMsg() + "col Total Price");
    }
}
