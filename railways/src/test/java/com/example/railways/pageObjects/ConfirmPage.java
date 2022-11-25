package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends BasePage {
    private final By txtConfirm = By.id("confirmationCode");
    private final By btnConfirm = By.id("//form//input[@type='submit']");
}
