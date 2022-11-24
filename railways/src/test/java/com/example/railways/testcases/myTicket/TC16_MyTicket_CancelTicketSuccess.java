package com.example.railways.testcases.myTicket;

import com.example.railways.common.constant.AssertMessage;
import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.BookTicketPage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.pageObjects.MyTicketPage;
import com.example.railways.pageObjects.SuccessPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

@Listeners(ReportListener.class)
public class TC16_MyTicket_CancelTicketSuccess extends BaseTest {

    @Test(description = "TC16-User can cancel a ticket")
    public void TC_MyTicket_Cancel1Ticket() throws URISyntaxException {
        ExtentTestManager.logMessage("TC16-User can cancel a ticket");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        ExtentTestManager.logMessage("Login with valid account");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage();
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Book a ticket");
        loginPage.clickTab(Tab.BOOK_TICKET);
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.clickBtnBookTicket();
        SuccessPage successPage = new SuccessPage();
        int ticketId = successPage.getBookedTicketId();
        successPage.clickTab(Tab.BOOK_TICKET);
        ExtentTestManager.logMessage("Click on \"My ticket\" tab");
        bookTicketPage.clickTab(Tab.MY_TICKET);

        MyTicketPage myTicketPage = new MyTicketPage();
        ExtentTestManager.logMessage("Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.cancelTicket(ticketId);
        ExtentTestManager.logMessage("Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        DriverManager.acceptAlert();

        ExtentTestManager.logMessage("Expected: The canceled ticket is disappeared.");

        Assert.assertFalse(myTicketPage.isTicketDisplayed(ticketId), AssertMessage.ELEMENT_STILL_DISPLAYED.getMsg() + "ticket with id " + ticketId);
    }
}
