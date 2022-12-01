package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.dataObjects.GlobalSettingSubMenu;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    private final By header = By.id("header");
    private final By mnuMainMenu = By.id("main-menu");
    private final By mnuGlobalSettingMenu = By.xpath("//li[@class='mn-setting']");
    private final By btnChoosePanel = By.id("btnChoosepanel");
    private final By divChoosePanels = By.cssSelector(".ccpanels");
    private final By btnCreateNewPanel = By.xpath("//div[@class='cpbutton']//span[.='Create new panel']");
    private final By tabOverview = By.xpath("//a[.='Overview']");
    private final By tabExecutionDashboard = By.xpath("//a[.='Execution Dashboard']");
    private final By popupAddPage = By.id("div_popup");
    private final By popupAddPanel = By.xpath("//div[@class='ui-dialog editpanelDlg']");
    private final By txtAddPanelDisplayName = By.id("txtDisplayName");
    private final By ddlAddPanelChartType = By.id("cbbChartType");
    private final By ddlAddPanelCategory = By.id("cbbCategoryField");
    private final By ddlAddPanelSeries = By.id("cbbSeriesField");
    private final By txtAddPageName = By.id("name");
    private final By ddlAddPageParentPage = By.id("parent");
    private final By ddlAddPageNumOfCol = By.id("columnnumber");
    private final By ddlAddPageAfterPage = By.id("afterpage");
    private final By chkAddPagePublic = By.id("ispublic");
    private final By btnAddPageOk = By.id("OK");
    private final By btnAddPageCancel = By.id("Cancel");
    private final String headMenuTabXPath = "//ul[@class='head-menu']//a[contains(text(), '%s')]";
    private final String subMnuAdministerXPath = "//..//a[.='%s']";
    private final String pageXPath = "//a[contains(text(),'%s')]";
    private final String globalSettingMenuTabXPath = " //a[.='%s']";

    protected WebElement getHeader() {
        return DriverManager.findElement(header);
    }

    protected WebElement getMnuMainMenu() {
        return DriverManager.findElement(mnuMainMenu);
    }

    protected WebElement getMnuGlobalSettingMenu() {
        return getMnuMainMenu().findElement(mnuGlobalSettingMenu);
    }

    protected WebElement getTabOverview() {
        return getMnuMainMenu().findElement(tabOverview);
    }

    protected WebElement getTabExecutionDashboard() {
        return getMnuMainMenu().findElement(tabExecutionDashboard);
    }

    protected WebElement getHeadMenuTab(HeadMenuTab tab) {
        return getHeader().findElement(By.xpath(String.format(headMenuTabXPath, tab.getTab())));
    }

    protected WebElement getSubMnuAdminister(HeadMenuTab subTab) {
        return getHeadMenuTab(HeadMenuTab.ADMINISTER).findElement(By.xpath(String.format(subMnuAdministerXPath, subTab.getTab())));
    }

    public void clickTabOverview() {
        getTabOverview().click();
    }

    public Boolean isTabOverviewClickable() {
        try {
            clickTabOverview();
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }

    public void clickTabExecutionDashboard() {
        getTabExecutionDashboard().click();
    }

    public Boolean isTabExecutionDashboardClickable() {
        try {
            clickTabExecutionDashboard();
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }


    public Boolean isHeadMenuTabClickable(HeadMenuTab tab) {
        try {
            clickHeadMenuTab(tab);
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }


    public void clickSubMnuAdminister(HeadMenuTab subTab) {
        hoverHeadMenuTab(HeadMenuTab.ADMINISTER);
        getSubMnuAdminister(subTab).click();
    }

    protected WebElement getPageTab(String page) {
        page = page.replaceAll("\\s+", " ");
        return getMnuMainMenu().findElement(By.xpath(String.format(pageXPath, page)));
    }

    protected WebElement getChildPage(String parentPage, String childPage) {
        hoverPageTab(parentPage);
        childPage = childPage.replaceAll("\\s+", " ");
        return getPageTab(parentPage).findElement(By.xpath("//.." + String.format(pageXPath, childPage)));
    }

    protected WebElement getFirstChildPage(String parentPage) {
        hoverPageTab(parentPage);
        return getPageTab(parentPage).findElement(By.xpath("//..//li/a"));
    }

    public Boolean isChildPageAdded(String parentPage, String childPage) {
        try {
            hoverPageTab(parentPage);
            getChildPage(parentPage, childPage);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void hoverPageTab(String page) {
        DriverManager.moveToElement(getPageTab(page));
    }

    public void clickPageTab(String page) {
        getPageTab(page).click();
    }

    protected WebElement getPopupAddPage() {
        return DriverManager.findElement(popupAddPage);
    }

    protected WebElement getTxtAddPageName() {
        return getPopupAddPage().findElement(txtAddPageName);
    }

    protected Select getDdlAddPageParentPage() {
        return new Select(getPopupAddPage().findElement(ddlAddPageParentPage));
    }

    protected Select getDdlAddPageNumOfCol() {
        return new Select(getPopupAddPage().findElement(ddlAddPageNumOfCol));
    }

    protected Select getDdlAddPageAfterPage() {
        return new Select(getPopupAddPage().findElement(ddlAddPageAfterPage));
    }

    protected WebElement getChkAddPagePublic() {
        return getPopupAddPage().findElement(chkAddPagePublic);
    }

    protected WebElement getBtnAddPageOk() {
        return getPopupAddPage().findElement(btnAddPageOk);
    }

    protected WebElement getBtnAddPageCancel() {
        return getPopupAddPage().findElement(btnAddPageCancel);
    }

    public void clickHeadMenuTab(HeadMenuTab tab) {
        hoverHeadMenuTab(tab);
        getHeadMenuTab(tab).click();
    }

    public void hoverHeadMenuTab(HeadMenuTab tab) {
        DriverManager.moveToElement(getHeadMenuTab(tab));
    }

    protected WebElement getGlobalSettingMenuTab(GlobalSettingSubMenu tab) {
        return getMnuGlobalSettingMenu().findElement(By.xpath(String.format(globalSettingMenuTabXPath, tab.getTab())));
    }

    public void clickGlobalSettingMenuTab(GlobalSettingSubMenu tab) {
        hoverMnuGlobalSettingMenu();
        getGlobalSettingMenuTab(tab).click();
    }

    public void hoverMnuGlobalSettingMenu() {
        DriverManager.moveToElement(getMnuGlobalSettingMenu());
    }

    public void addNewPage(String name, String parentPage, int numOfCol, String displayAfterPage, boolean isPublic) throws InterruptedException {
        sendKeyToTxtAddPageName(name);
        selectForDdlAddPageParentPage(parentPage);
        getDdlAddPageNumOfCol().selectByVisibleText(String.valueOf(numOfCol));
        selectForDdlAddPageAfterPage(displayAfterPage);
        if(getChkAddPagePublic().isSelected() != isPublic)
            getChkAddPagePublic().click();
        clickBtnAddPageOk();
    }

    public void sendKeyToTxtAddPageName(String name) {
        getTxtAddPageName().sendKeys(name);
    }

    public void selectForDdlAddPageParentPage(String parentPage) {
        getDdlAddPageParentPage().selectByVisibleText(parentPage);
    }

    public void selectForDdlAddPageAfterPage(String displayAfterPage) {
        getDdlAddPageAfterPage().selectByVisibleText(displayAfterPage);
    }

    public void clickBtnAddPageOk() throws InterruptedException {
        getBtnAddPageOk().click();
        Thread.sleep(500);
    }

    public void clickBtnAddPageCancel() {
        getBtnAddPageCancel().click();
    }

    public void deletePage(String page) throws InterruptedException {
        Thread.sleep(500);
        clickPageTab(page);
        clickGlobalSettingMenuTab(GlobalSettingSubMenu.DELETE);
        DriverManager.acceptAlert();
    }

    public void deleteChildPage(String parentPage, String childPage) throws InterruptedException {
        Thread.sleep(500);
        getChildPage(parentPage, childPage).click();
        clickGlobalSettingMenuTab(GlobalSettingSubMenu.DELETE);
        DriverManager.acceptAlert();
    }
}
