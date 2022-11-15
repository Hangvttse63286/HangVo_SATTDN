package com.example.railways.testcases.bookTicket;

import com.example.railways.common.constant.Station;
import com.example.railways.common.constant.Tab;
import com.example.railways.common.constant.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.*;
import com.example.railways.testcases.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC15_BookTicket_OpenFromTimetablePage extends BaseTest {

    @Test
    public void TC_BookTicket_OpenFromTimetablePage() {
        ExtentTestManager.logMessage("TC15-User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Login with valid account");
        homePage.getTab(Tab.LOGIN).click();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Click on \"Timetable\" tab");
        loginPage.getTab(Tab.TIMETABLE).click();

        Station timetableDpStation = Station.HUE;
        Station timetableArStation = Station.SAI_GON;
        ExtentTestManager.logMessage("Depart Station: " + timetableDpStation.getName() + " - Arrive Station: " + timetableArStation.getName());

        TimetablePage timetablePage = new TimetablePage(DriverManager.getDriver());
        WebElement lnkBookTicket = timetablePage.getLnk(timetableDpStation, timetableArStation, "Book");
        DriverManager.scrollToView(lnkBookTicket);
        ExtentTestManager.logMessage("Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");
        lnkBookTicket.click();

        ExtentTestManager.logMessage("Expected: \"Book ticket\" page is loaded with correct  \"Depart from\" and \"Arrive at\" values.");
        Assert.assertTrue(DriverManager.getCurrentUrl().contains(Url.RAILWAYS_BOOK_TICKET_URL.getUrlLink()));

        BookTicketPage bookTicketPage = new BookTicketPage(DriverManager.getDriver());
        DriverManager.scrollToView(bookTicketPage.getBtnBookTicket());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bookTicketPage.getDdlDepartStation().getFirstSelectedOption().getText(), timetableDpStation.getName());
        softAssert.assertEquals(bookTicketPage.getDdlArriveStation().getFirstSelectedOption().getText(), timetableArStation.getName());
        softAssert.assertAll();
    }
}
