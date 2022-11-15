package com.example.railways.testcases.myTicket;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.*;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TC16_MyTicket_CancelTicketSuccess extends BaseTest {

    @Test
    public void TC_MyTicket_Cancel1Ticket() {
        ExtentTestManager.logMessage("TC16-User can cancel a ticket");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Login with valid account");
        homePage.getTab(Tab.LOGIN).click();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Book a ticket");
        loginPage.getTab(Tab.BOOK_TICKET).click();
        BookTicketPage bookTicketPage = new BookTicketPage(DriverManager.getDriver());
        DriverManager.scrollToView(bookTicketPage.getBtnBookTicket());
        bookTicketPage.getBtnBookTicket().click();
        ExtentTestManager.logMessage("Click on \"My ticket\" tab");
        bookTicketPage.getTab(Tab.MY_TICKET).click();

        MyTicketPage myTicketPage = new MyTicketPage(DriverManager.getDriver());
        DriverManager.scrollToView(myTicketPage.getTblMyTicket());
        ExtentTestManager.logMessage("Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.getBtnCancel().click();
        ExtentTestManager.logMessage("Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        DriverManager.switchToAlert().accept();

        ExtentTestManager.logMessage("Expected: The canceled ticket is disappeared.");
        Assert.assertTrue(myTicketPage.getDivContent().getText().contains("You haven't booked any tickets yet."));
    }
}
