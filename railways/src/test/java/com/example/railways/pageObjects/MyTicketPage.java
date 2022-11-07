package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

@Getter
public class MyTicketPage extends BasePage {

    @FindBy(xpath = "//div[@class='message']")
    private WebElement loc_divNote;

    @FindBy(xpath = "//form[@name='FilterForm']//div[@class='Filter']")
    private WebElement loc_frmFilter;

    @FindBy(xpath = "//form[@name='FilterForm']//select[@name='FilterDpStation']")
    private WebElement loc_ddlFilterDpStation;

    @FindBy(xpath = "//form[@name='FilterForm']//select[@name='FilterArStation']")
    private WebElement loc_ddlFilterArStation;

    @FindBy(xpath = "//form[@name='FilterForm']//input[@name='FilterDpDate']")
    private WebElement loc_txtFilterDpDate;

    @FindBy(xpath = "//form[@name='FilterForm']//select[@name='FilterStatus']")
    private WebElement loc_ddlFilterStatus;

    @FindBy(xpath = "//form[@name='FilterForm']//input[@type='submit']")
    private WebElement loc_btnFilter;

    @FindBy(xpath = "//table[@class='MyTable']")
    private WebElement loc_tblMyTicket;

    @FindBy(xpath = "//table[@class='MyTable']//tr[@class!='TableSmallHeader']")
    private Set<WebElement> loc_trMyTickets;

    @FindBy(xpath = "//table[@class='MyTable']//input[@type='button' and @value='Cancel']")
    private Set<WebElement> loc_btnCancels;

    @FindBy(xpath = "//table[@class='MyTable']//input[@type='button' and @value='Delete']")
    private Set<WebElement> loc_btnDeletes;

    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement loc_msgFilterError;

    public MyTicketPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRemovedRow(WebElement button) {
        return button.findElement(By.xpath("/ancestor::tr"));
    }
}
