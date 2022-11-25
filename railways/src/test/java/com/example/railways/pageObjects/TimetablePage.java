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
}
