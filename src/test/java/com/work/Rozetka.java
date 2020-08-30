package com.work;

import by.texas.Driver;
import by.texas.Helper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Rozetka {
    private Driver webDriver = new Driver();

    @Before
    public void openWeb() {
        webDriver.openRozetka();
        PageFactory.initElements(webDriver.getWebDriver(), this);// инициализация @FindBy
    }

    @Test
    public void sortingDropDown() {
        WebElement dropDown = setByLabel("Sony");
        dropDown.click();

    }

    @Test
    public void registrationOnTutBy() {
        sortingDropDown();
        List<WebElement> rows = webDriver.getWebDriver().findElements(By.xpath("//ul[@class='catalog-grid']"));
//        List<WebElement> rows = webDriver.getWebDriver().findElements(By.xpath("//table[@class='catalog-grid']"));
        for(WebElement row: rows) {
            System.out.println("-----------********-------------");
            WebElement key = row.findElement(By.xpath("./td[1]"));
            key.getText();
            WebElement val = row.findElement(By.xpath("./td[2]"));
            val.getText();
        }
    }

    @After
    public void closeWeb() {
        Helper.sleep(3);
        webDriver.closeChrome();
    }

    private WebElement setHref(String hrefName) {
        String xPath = "//a[text()='@@name@@']";
        xPath = xPath.replace("@@name@@", hrefName);
        WebElement forumHref = webDriver.getWebDriver().findElement(By.xpath(xPath));
        return forumHref;
    }

    private WebElement setXPath(String hrefName) {
        String xPath = "//a[@class=='@@name@@']";
        xPath = xPath.replace("@@name@@", hrefName);
        WebElement forumHref = webDriver.getWebDriver().findElement(By.xpath(xPath));
        return forumHref;
    }

    private WebElement setById(String inputText) {
        WebElement forumHref = webDriver.getWebDriver().findElement(By.id(inputText));
        return forumHref;
    }

    private WebElement setByName(String inputText) {
        WebElement forumHref = webDriver.getWebDriver().findElement(By.name(inputText));
        return forumHref;
    }

    private WebElement setByClass(String inputText) {
        WebElement dropDown = webDriver.getWebDriver().findElement(By.className(inputText));
        return dropDown;
    }

    private WebElement setByLabel(String inputText) {
        WebElement dropDown = webDriver.getWebDriver().findElement(By.xpath("//label[contains(text(),'Sony')]"));
        return dropDown;
    }
}
