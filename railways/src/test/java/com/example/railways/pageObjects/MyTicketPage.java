package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.dataObjects.Filter;
import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class MyTicketPage extends BasePage {
    private final By divContent = By.id("content");
    private final By divNote = By.className("message");
    private final By frmFilter = By.className("Filter");
    private final By ddlFilterDpStation = By.name("FilterDpStation");
    private final By ddlFilterArStation = By.name("FilterArStation");
    private final By txtFilterDpDate = By.name("FilterDpDate");
    private final By ddlFilterStatus = By.name("FilterStatus");
    private final By btnFilter = By.xpath("//form[@name='FilterForm']//input[@type='submit']");
    private final By tblMyTicket = By.className("MyTable");
    private final By trMyTickets = By.xpath("//tr[@class!='TableSmallHeader']");
    private final By btnCancels = By.xpath("//table[@class='MyTable']//input[@type='button' and @value='Cancel']");
    private final By btnDeletes = By.xpath("//table[@class='MyTable']//input[@type='button' and @value='Delete']");
    private final By lblFilterError = By.xpath("//div[contains(@class,'error')]");
    private final String btnCancelXPath = "//table[@class='MyTable']//input[@type='button' and @value='Cancel' and contains(@onclick,'%s')]";
    private final String filterTicketXPath = "//td[position()=count(//tr[@class='TableSmallHeader']/th[.='%s']/preceding-sibling::th)+1 and .='%s']/..";

    private WebElement getTblMyTicket() {
        return DriverManager.findElement(tblMyTicket);
    }

    private List<WebElement> getTickets() {
        return getTblMyTicket().findElements(trMyTickets);
    }

    private Select getDdlFilterDpStation() {
        return new Select(DriverManager.findElement(ddlFilterDpStation));
    }

    private Select getDdlFilterArStation() {
        return new Select(DriverManager.findElement(ddlFilterArStation));
    }

    private WebElement getTxtFilterDpDate() {
        return DriverManager.findElement(txtFilterDpDate);
    }

    private Select getDdlFilterStatus() {
        return new Select(DriverManager.findElement(ddlFilterStatus));
    }

    private WebElement getBtnFilter() {
        return DriverManager.findElement(btnFilter);
    }

    private List<WebElement> getTicketByArStation(Station arStation) {
        return getTblMyTicket().findElements(By.xpath(String.format(filterTicketXPath, Filter.ARRIVE_STATION.getName(), arStation.getName())));
    }

    public void filterByArStation(Station arStation) {
        DriverManager.scrollToView(getBtnFilter());
        getDdlFilterArStation().selectByVisibleText(arStation.getName());
        getBtnFilter().click();
    }

    public Boolean isFilterResultMatch(Station arStation) {
        return getTickets().equals(getTicketByArStation(arStation));
    }
}
