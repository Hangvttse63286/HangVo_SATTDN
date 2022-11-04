package com.example.railways;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimetablePage extends BasePage {

    @FindBy(xpath = "//table[contains(@class, 'MyTable')]")
    private WebElement timetableTbl;

    public TimetablePage(WebDriver driver) {
        super(driver);
    }

    public void checkPrice(String departStation, String arriveStation) {
        timetableTbl.findElement(By.xpath("//td[.='" + departStation + "']/following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href, 'Price')]")).click();
    }

    public void bookTicket(String departStation, String arriveStation) {
        timetableTbl.findElement(By.xpath("//td[.='" + departStation + "']/following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href, 'Book')]")).click();
    }
}
