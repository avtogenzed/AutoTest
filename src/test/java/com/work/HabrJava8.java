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

public class HabrJava8 {
    private Driver webDriver = new Driver();

    @Before
    public void openWeb() {
        webDriver.openHabr();
        PageFactory.initElements(webDriver.getWebDriver(), this);// инициализация @FindBy
    }

    @Test
    public void registrationOnTutBy() {
        List<WebElement> rows = webDriver.getWebDriver().findElements(By.xpath("//table[@class='@@tableName@@']//tr"));
        for(WebElement row: rows) {
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

    private WebElement setById(String inputText) {
        WebElement forumHref = webDriver.getWebDriver().findElement(By.id(inputText));
        return forumHref;
    }
}
