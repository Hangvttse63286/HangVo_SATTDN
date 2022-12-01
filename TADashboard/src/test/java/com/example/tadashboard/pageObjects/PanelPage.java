package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PanelPage extends BasePage {
    private final By lnkAddNew = By.xpath("//a[.='Add New']");

    private WebElement getLnkAddNew() {
        return DriverManager.findElement(lnkAddNew);
    }

    public void clickLnkAddNew() {
        getLnkAddNew().click();
    }
}
