package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

@Getter
public class TicketPricePage extends BasePage {

    @FindBy(xpath = "//table[contains(@class,'NoBorder')]")
    private WebElement loc_tblTicketPriceList;

    @FindBy(xpath = "//table[contains(@class,'NoBorder')]//a[contains(@href,'Price')]")
    Set<WebElement> loc_btnCheckPrices;

    @FindBy(xpath = "//table[contains(@class,'MedTable')]")
    private WebElement loc_tblTicketPrice;

    @FindBy(xpath = "//table[contains(@class,'MedTable')]//tr[@class='TableSmallHeader']/th")
    private WebElement loc_thTrain;

    @FindBy(xpath = "//table[contains(@class,'NoBorder')]")
    private WebElement loc_tblSeat;

    @FindBy(xpath = "//table[contains(@class,'NoBorder')]//a[contains(@href,'Book')]")
    Set<WebElement> loc_btnBookTickets;

    public TicketPricePage(WebDriver driver) {
        super(driver);
    }

    public void checkPrice(String departStation, String arriveStation) {
        WebElement checkPriceBtn = loc_tblTicketPriceList.findElement(By.xpath("//li[contains(., '" + departStation + "') and contains(., '" + arriveStation + "')]/ancestor::tr//a[contains(@href,'Price')]"));
        checkPriceBtn.click();
    }

    public WebElement getTrainFromList(WebElement checkPriceBtn) {
        return checkPriceBtn.findElement(By.xpath("/ancestor::tr//li[contains(@class,'ListSmall')]"));
    }

    public WebElement getSeatFromList(WebElement bookTicketBtn) {
        return bookTicketBtn.findElement(By.xpath("/ancestor::tr//li[contains(@class,'ListSmall')]"));
    }
}
