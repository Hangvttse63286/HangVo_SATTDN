package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class BookTicketPage extends BasePage{

    @FindBy(xpath = "//form//select[@name='Date']")
    private WebElement departDateCbx;

    @FindBy(xpath = "//form//select[@name='DepartStation']")
    private WebElement departStationCbx;

    @FindBy(xpath = "//form//select[@name='ArriveStation']")
    private WebElement arriveStationCbx;

    @FindBy(xpath = "//form//select[@name='SeatType']")
    private WebElement seatTypeCbx;

    @FindBy(xpath = "//form//select[@name='TicketAmount']")
    private WebElement ticketAmountCbx;

    @FindBy(xpath = "//form//input[@type='submit' and @value='Book ticket']")
    private WebElement bookTicketBtn;

    @FindBy(xpath = "//p[@class='message error']")
    private WebElement errorMsg;

    @FindBy(xpath = "//form//label[@class='validation-error']")
    private WebElement validationErrMsg;

    public BookTicketPage(WebDriver driver) {
        super(driver);
    }

    public void selectOption (WebElement combobox, String value) {
        combobox.findElement(By.xpath("/option[@value='"+value+"']")).click();
    }


}