package com.example.railways;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

@Getter
public class TimetablePage extends BasePage {

    @FindBy(xpath = "//table[contains(@class, 'WideTable')]")
    private WebElement timetableTbl;

    @FindBy(xpath = "//table[contains(@class, 'WideTable')]//a[contains(@href, 'Price')]")
    private Set<WebElement> checkPriceLinkList;

    @FindBy(xpath = "//table[contains(@class, 'WideTable')]//a[contains(@href, 'Book')]")
    private Set<WebElement> bookTicketLinkList;

    public TimetablePage(WebDriver driver) {
        super(driver);
    }

    public void checkPrice(String departStation, String arriveStation) {
        timetableTbl.findElement(By.xpath("//td[.='" + departStation + "']/following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href, 'Price')]")).click();
    }

    public void bookTicket(String departStation, String arriveStation) {
        timetableTbl.findElement(By.xpath("//td[.='" + departStation + "']/following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href, 'Book')]")).click();
    }

    public WebElement getDepartStation(WebElement link) {
        return link.findElement(By.xpath("/ancestor::tr/td[count(//th[.='Depart Station']/preceding-sibling::th)+1]"));
    }

    public WebElement getArriveStation(WebElement link) {
        return link.findElement(By.xpath("/ancestor::tr/td[count(//th[.='Arrive Station']/preceding-sibling::th)+1]"));
    }
}
