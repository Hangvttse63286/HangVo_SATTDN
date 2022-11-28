package com.example.railways.testcases;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.dataObjects.Station;
import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
import com.example.railways.pageObjects.BookTicketPage;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.pageObjects.MyTicketPage;
import com.example.railways.pageObjects.SuccessPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(ReportListener.class)
public class FTTC02_MyTicket_Filter extends BaseTest {

    @Test(description = "User can filter 'Manage ticket' table with Arrive station")
    public void myTicket_Filter_By_ArStation() throws InterruptedException {
        List<Station> arStationList = new ArrayList<>();

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
        HomePage homePage = new HomePage();

        ExtentTestManager.logMessage("Login with a valid account ");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage();
        loginPage.login(getEmail(), getPassword());
        homePage = new HomePage();

        ExtentTestManager.logMessage("Book more than 6 tickets with different Arrive Station");
        homePage.clickTab(Tab.BOOK_TICKET);
        BookTicketPage bookTicketPage = new BookTicketPage();
        SuccessPage successPage;
        do {
            arStationList.add(bookTicketPage.bookTicket());
            successPage = new SuccessPage();
            if (!(arStationList.size() > 6))
                successPage.clickTab(Tab.BOOK_TICKET);
        } while (!(arStationList.size() > 6));

        ExtentTestManager.logMessage("Click on 'My ticket' tab");
        successPage.clickTab(Tab.MY_TICKET);
        MyTicketPage myTicketPage = new MyTicketPage();

        ExtentTestManager.logMessage("Select one of booked arrive station in 'Arrive Station' textbox");
        Station filterArStation = arStationList.get(Utilities.getRandomNumber(0, arStationList.size()));
        int numOfFilterTicket = myTicketPage.filterByArStation(filterArStation);

        ExtentTestManager.logMessage("Expected: 'Manage ticket' table shows correct ticket(s)");
        Assert.assertTrue(myTicketPage.isFilterResultMatch(filterArStation, numOfFilterTicket), "Filter result does not match");
    }
}
