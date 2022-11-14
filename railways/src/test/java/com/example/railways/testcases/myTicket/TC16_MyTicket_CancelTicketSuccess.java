package com.example.railways.testcases.myTicket;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.pageObjects.*;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16_MyTicket_CancelTicketSuccess extends BaseTest {

    @Test
    public void TC_MyTicket_Cancel1Ticket() {
        Log.info("TC16-User can cancel a ticket");
        Log.info("Pre-condition: Create and activate a new account");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Login with valid account");
        homePage.getTab(Tab.LOGIN).click();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        loginPage.login(getEmail(), getPassword());
        Log.info("Book a ticket");
        loginPage.getTab(Tab.BOOK_TICKET).click();
        BookTicketPage bookTicketPage = new BookTicketPage(DriverManager.getDriver());
        DriverManager.scrollToView(bookTicketPage.getBtnBookTicket());
        bookTicketPage.getBtnBookTicket().click();
        Log.info("Click on \"My ticket\" tab");
        bookTicketPage.getTab(Tab.MY_TICKET).click();

        MyTicketPage myTicketPage = new MyTicketPage(DriverManager.getDriver());
        DriverManager.scrollToView(myTicketPage.getTblMyTicket());
        Log.info("Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.getBtnCancel().click();
        Log.info("Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        DriverManager.switchToAlert().accept();

        Log.info("Expected: The canceled ticket is disappeared.");
        Assert.assertTrue(myTicketPage.getDivContent().getText().contains("You haven't booked any tickets yet."));
    }
}
