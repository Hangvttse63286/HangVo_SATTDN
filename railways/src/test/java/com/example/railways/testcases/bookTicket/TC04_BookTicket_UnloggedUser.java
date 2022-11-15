package com.example.railways.testcases.bookTicket;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.constant.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TC04_BookTicket_UnloggedUser extends BaseTest {

    @Test
    public void TC_BookTicket_OpenBookTicketWithUnloggedUser() {
        Log.info("TC04-Login page displays when un-logged User clicks on \"Book ticket\" tab");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Click on \"Book ticket\" tab");
        homePage.getTab(Tab.BOOK_TICKET).click();

        Log.info("Expected: Login page displays instead of Book ticket page");
        Assert.assertTrue(DriverManager.getCurrentUrl().contains(Url.RAILWAYS_LOGIN_URL.getUrlLink()));
    }
}
