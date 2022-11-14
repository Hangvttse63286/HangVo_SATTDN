package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

@Getter
public class MyTicketPage extends BasePage{

    @FindBy(xpath = "//div[@class='message']")
    private WebElement note;

    @FindBy(xpath = "//div[@class='Filter']")
    private WebElement filter;

    @FindBy(xpath = "//form[@name='FilterForm']//select[@name='FilterDpStation']")
    private WebElement filterDpStationCbx;

    @FindBy(xpath = "//form[@name='FilterForm']//select[@name='FilterArStation']")
    private WebElement filterArStationCbx;

    @FindBy(xpath = "//form[@name='FilterForm']//input[@name='FilterDpDate']")
    private WebElement filterDpDateTxt;

    @FindBy(xpath = "//form[@name='FilterForm']//select[@name='FilterStatus']")
    private WebElement filterStatusCbx;

    @FindBy(xpath = "//form[@name='FilterForm']//input[@type='submit']")
    private WebElement filterBtn;

    @FindBy(xpath = "//table[@class='MyTable']")
    private WebElement myTicketTbl;

    @FindBy(xpath = "//table[@class='MyTable']//tr[@class!='TableSmallHeader']")
    private Set<WebElement> myTicketList;

    @FindBy(xpath = "//table[@class='MyTable']//input[@type='button' and @value='Cancel']")
    private Set<WebElement> cancelBtnList;

    @FindBy(xpath = "//table[@class='MyTable']//input[@type='button' and @value='Delete']")
    private Set<WebElement> deleteBtnList;

    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement filterErrMsg;

    public MyTicketPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRemovedRow(WebElement button) {
        return button.findElement(By.xpath("/ancestor::tr"));
    }
}
