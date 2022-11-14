package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final By btnCancel = By.xpath("//table[@class='MyTable']//input[@type='button' and @value='Cancel' and last()]");
    private final By btnDeletes = By.xpath("//table[@class='MyTable']//input[@type='button' and @value='Delete']");
    private final By msgFilterError = By.xpath("//div[contains(@class,'error')]");

    public MyTicketPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDivContent() {
        return driver.findElement(divContent);
    }

    public WebElement getDivNote() {
        return driver.findElement(divNote);
    }

    public WebElement getFrmFilter() {
        return driver.findElement(frmFilter);
    }

    public Select getDdlFilterDpStation() {
        return new Select(driver.findElement(ddlFilterDpStation));
    }

    public Select getDdlFilterArStation() {
        return new Select(driver.findElement(ddlFilterArStation));
    }

    public WebElement getTxtFilterDpDate() {
        return driver.findElement(txtFilterDpDate);
    }

    public Select getDdlFilterStatus() {
        return new Select(driver.findElement(ddlFilterStatus));
    }

    public WebElement getBtnFilter() {
        return driver.findElement(btnFilter);
    }

    public WebElement getTblMyTicket() {
        return driver.findElement(tblMyTicket);
    }

    public List<WebElement> getTrMyTickets() {
        return driver.findElements(trMyTickets);
    }

    public List<WebElement> getBtnCancels() {
        return driver.findElements(btnCancels);
    }

    public WebElement getBtnCancel() {
        return driver.findElement(btnCancel);
    }

    public List<WebElement> getBtnDeletes() {
        return driver.findElements(btnDeletes);
    }

    public WebElement getMsgFilterError() {
        return driver.findElement(msgFilterError);
    }

    public WebElement getRemovedRow(WebElement button) {
        return button.findElement(By.xpath("//ancestor::tr"));
    }
}
