package com.example.railways.testcases.bookTicket;

import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TC04_BookTicket_UnloggedUser extends BaseTest {

    @Test(description = "TC04-Login page displays when un-logged User clicks on 'Book ticket' tab")
    public void TC_BookTicket_OpenBookTicketWithUnloggedUser() {
        ExtentTestManager.logMessage("TC04-Login page displays when un-logged User clicks on 'Book ticket' tab");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on 'Book ticket' tab");
        homePage.clickTab(Tab.BOOK_TICKET);

        ExtentTestManager.logMessage("Expected: Login page displays instead of Book ticket page");
        Assert.assertTrue(DriverManager.getCurrentUrl().contains(Url.RAILWAYS_LOGIN_URL.getUrlLink()), "Login page does not display");
    }
}
