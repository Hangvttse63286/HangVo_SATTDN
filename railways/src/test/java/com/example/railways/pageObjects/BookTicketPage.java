package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class BookTicketPage extends BasePage{

    @FindBy(xpath = "//form//select[@name='Date']")
    private WebElement loc_ddlDepartDate;

    @FindBy(xpath = "//form//select[@name='DepartStation']")
    private WebElement loc_ddlDepartStation;

    @FindBy(xpath = "//form//select[@name='ArriveStation']")
    private WebElement loc_ddlArriveStation;

    @FindBy(xpath = "//form//select[@name='SeatType']")
    private WebElement loc_ddlSeatType;

    @FindBy(xpath = "//form//select[@name='TicketAmount']")
    private WebElement loc_ddlTicketAmount;

    @FindBy(xpath = "//form//input[@type='submit' and @value='Book ticket']")
    private WebElement loc_btnBookTicket;

    @FindBy(xpath = "//p[@class='message error']")
    private WebElement loc_msgError;

    @FindBy(xpath = "//form//label[@class='validation-error']")
    private WebElement loc_msgValidationError;

    public BookTicketPage(WebDriver driver) {
        super(driver);
    }

    public void selectOption (WebElement combobox, String value) {
        combobox.findElement(By.xpath("/option[@value='"+value+"']")).click();
    }


}