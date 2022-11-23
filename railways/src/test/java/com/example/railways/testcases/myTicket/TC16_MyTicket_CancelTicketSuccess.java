package com.example.railways.testcases.myTicket;

import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.BookTicketPage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.pageObjects.MyTicketPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TC16_MyTicket_CancelTicketSuccess extends BaseTest {

    @Test(description = "TC16-User can cancel a ticket")
    public void TC_MyTicket_Cancel1Ticket() {
        ExtentTestManager.logMessage("TC16-User can cancel a ticket");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Login with valid account");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Book a ticket");
        loginPage.clickTab(Tab.BOOK_TICKET);
        BookTicketPage bookTicketPage = new BookTicketPage(DriverManager.getDriver());
        bookTicketPage.clickBtnBookTicket();
        ExtentTestManager.logMessage("Click on \"My ticket\" tab");
        bookTicketPage.clickTab(Tab.MY_TICKET);

        MyTicketPage myTicketPage = new MyTicketPage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.cancelTicket();
        ExtentTestManager.logMessage("Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        DriverManager.acceptAlert();

        ExtentTestManager.logMessage("Expected: The canceled ticket is disappeared.");

        Assert.assertFalse(myTicketPage.isExistedTicket(myTicketPage.getDeletedId()));
    }
}
