package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TicketPriceListPage extends BasePage {
    private final By tblTicketPriceList = By.xpath("//table[contains(@class,'NoBorder')]");
    private final String btnCheckPriceXPath = "//li[contains(text(), '%s to %s')]/ancestor::tr//a[contains(@href, 'Price')]";

    private WebElement getTblTicketPriceList() {
        return DriverManager.findElement(tblTicketPriceList);
    }

    private WebElement getBtnCheckPrice(Station dpStation, Station arStation) {
        return getTblTicketPriceList().findElement(By.xpath(String.format(btnCheckPriceXPath, dpStation.getName(), arStation.getName())));
    }

    public Boolean clickBtnCheckPrice(Station dpStation, Station arStation) {
        try {
            DriverManager.scrollToView(getBtnCheckPrice(dpStation, arStation));
            getBtnCheckPrice(dpStation, arStation).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
