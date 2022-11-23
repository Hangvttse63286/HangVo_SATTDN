package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class MyTicketPage extends BasePage {

    private final By divContent = By.id("content");
    private final By divNote = By.className("message");
    private final By frmFilter = By.className("Filter");
    private final By ddlFilterDpStation = By.name("FilterDpStation");
    private final By ddlFilterArStation = By.name("FilterArStation");
    private final By txtFilterDpDate = By.name("FilterDpDate");
    private final By ddlFilterStatus = By.name("FilterStatus");
    private final By btnFilter = By.xpath("//form[@name='FilterForm']//input[@type='submit']");
    private final By tblMyTicket = By.className("MyTable");
    private final By trMyTickets = By.className("TableSmallHeader");
    private final By btnCancels = By.xpath("//table[@class='MyTable']//input[@type='button' and @value='Cancel']");
    private final By btnDeletes = By.xpath("//table[@class='MyTable']//input[@type='button' and @value='Delete']");
    private final By lblFilterError = By.xpath("//div[contains(@class,'error')]");
    private final String btnCancelXPath = "//table[@class='MyTable']//input[@type='button' and @value='Cancel' and contains(@onclick,'%s')]";

    public MyTicketPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getDivContent() {
        return driver.findElement(divContent);
    }

    private WebElement getDivNote() {
        return driver.findElement(divNote);
    }

    private WebElement getFrmFilter() {
        return driver.findElement(frmFilter);
    }

    private Select getDdlFilterDpStation() {
        return new Select(driver.findElement(ddlFilterDpStation));
    }

    private Select getDdlFilterArStation() {
        return new Select(driver.findElement(ddlFilterArStation));
    }

    private WebElement getTxtFilterDpDate() {
        return driver.findElement(txtFilterDpDate);
    }

    private Select getDdlFilterStatus() {
        return new Select(driver.findElement(ddlFilterStatus));
    }

    private WebElement getBtnFilter() {
        return driver.findElement(btnFilter);
    }

    private WebElement getTblMyTicket() {
        return driver.findElement(tblMyTicket);
    }

    private List<WebElement> getTrMyTickets() {
        return driver.findElements(trMyTickets);
    }

    private List<WebElement> getBtnCancels() {
        return driver.findElements(btnCancels);
    }

    private WebElement getBtnCancel(int id) {
        return driver.findElement(By.xpath(String.format(btnCancelXPath, id)));
    }

    private List<WebElement> getBtnDeletes() {
        return driver.findElements(btnDeletes);
    }

    private WebElement getLblFilterError() {
        return driver.findElement(lblFilterError);
    }

    private WebElement getRemovedRow(WebElement button) {
        return button.findElement(By.xpath("//ancestor::tr"));
    }

    public void scrollToTblMyTicket() {
        DriverManager.scrollToView(getTblMyTicket());
    }

    public String getDivContentText() {
        return getDivContent().getText();
    }

    public void cancelTicket(int id) {
        scrollToTblMyTicket();
        getBtnCancel(id).click();
    }

    public Boolean isTicketDisplayed(int id) {
        try {
            DriverManager.setImplicitlyWait(3);
            return getBtnCancel(id).findElement(By.xpath("//ancestor::tr")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            DriverManager.implicitlyWait();
        }
    }
}
