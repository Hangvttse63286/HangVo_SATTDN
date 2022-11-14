package com.example.railways.pageObjects;

import com.example.railways.common.constant.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TimetablePage extends BasePage {

    private final By tblTimetable = By.xpath("//table[contains(@class, 'WideTable')]");
    private final By lnkCheckPrices = By.xpath("//table[contains(@class, 'WideTable')]//a[contains(@href, 'Price')]");
    private final By lnkBookTickets = By.xpath("//table[contains(@class, 'WideTable')]//a[contains(@href, 'Book')]");
    private final String linkXPath = "//td[.='%s']/following-sibling::td[.='%s']/..//a[contains(@href, '%s')]";

    public TimetablePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTblTimetable() {
        return driver.findElement(tblTimetable);
    }

    public List<WebElement> getLnkCheckPrices() {
        return driver.findElements(lnkCheckPrices);
    }

    public List<WebElement> getLnkBookTickets() {
        return driver.findElements(lnkBookTickets);
    }

    public WebElement getLnk(Station departStation, Station arriveStation, String lnk) {
        return getTblTimetable().findElement(By.xpath(String.format(linkXPath, departStation.getName(), arriveStation.getName(), lnk)));
    }
}
