package com.example.railways.testcases.bookTicket;

import com.example.railways.dataObjects.Station;
import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.BookTicketPage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.pageObjects.TimetablePage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC15_BookTicket_OpenFromTimetablePage extends BaseTest {

    @Test(description = "TC15-User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC_BookTicket_OpenFromTimetablePage() {
        ExtentTestManager.logMessage("TC15-User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        ExtentTestManager.logMessage("Login with valid account");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage();
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Click on \"Timetable\" tab");
        loginPage.clickTab(Tab.TIMETABLE);

        Station timetableDpStation = Station.HUE;
        Station timetableArStation = Station.SAI_GON;
        ExtentTestManager.logMessage("Depart Station: " + timetableDpStation.getName() + " - Arrive Station: " + timetableArStation.getName());

        TimetablePage timetablePage = new TimetablePage();
        ExtentTestManager.logMessage("Click on 'book ticket' link of the route from " + timetableDpStation.getName() + " to " + timetableArStation.getName());
        timetablePage.clickLnk(timetableDpStation, timetableArStation, "Book");

        ExtentTestManager.logMessage("Expected: \"Book ticket\" page is loaded with correct  \"Depart from\" and \"Arrive at\" values.");
        Assert.assertTrue(DriverManager.getCurrentUrl().contains(Url.RAILWAYS_BOOK_TICKET_URL.getUrlLink()));

        BookTicketPage bookTicketPage = new BookTicketPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bookTicketPage.getSelectedDpStation(), timetableDpStation.getName());
        softAssert.assertEquals(bookTicketPage.getSelectedArStation(), timetableArStation.getName());
        softAssert.assertAll();
    }
}
