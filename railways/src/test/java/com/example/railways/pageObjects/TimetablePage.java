package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TimetablePage extends BasePage {
    private final By tblTimetable = By.xpath("//table[contains(@class, 'WideTable')]");
    private final By lnkCheckPrices = By.xpath("//table[contains(@class, 'WideTable')]//a[contains(@href, 'Price')]");
    private final By lnkBookTickets = By.xpath("//table[contains(@class, 'WideTable')]//a[contains(@href, 'Book')]");
    private final String linkXPath = "//td[.='%s']/following-sibling::td[.='%s']/..//a[contains(@href, '%s')]";

    public WebElement getTblTimetable() {
        return DriverManager.findElement(tblTimetable);
    }

    private List<WebElement> getLnkCheckPrices() {
        return DriverManager.findElements(lnkCheckPrices);
    }

    private List<WebElement> getLnkBookTickets() {
        return DriverManager.findElements(lnkBookTickets);
    }

    private WebElement getLnk(Station departStation, Station arriveStation, String lnk) {
        return getTblTimetable().findElement(By.xpath(String.format(linkXPath, departStation.getName(), arriveStation.getName(), lnk)));
    }

    public void clickLnk(Station departStation, Station arriveStation, String lnk) {
        WebElement link = getLnk(departStation, arriveStation, lnk);
        scrollToLnk(link);
        link.click();
    }

    private void scrollToLnk(WebElement lnk) {
        DriverManager.scrollToView(lnk);
    }
}
