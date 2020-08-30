package com.work;

import by.texas.Driver;
import by.texas.Helper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTest {
    private Driver webDriver = new Driver();

    @FindBy(xpath = "//*[@id=\"uS8RXIR5L7\"]/yaycclof/yaycb0r/uh2lpklha8g8/div[1]/ul/li[4]/a")
    private WebElement forumField;


    @Before
    public void openWeb() {
  //      webDriver.wait(15);
        webDriver.openWebPage();
        PageFactory.initElements(webDriver.getWebDriver(), this);// инициализация @FindBy
    }

    @Test
    public void trace() {
       String title = webDriver.getWebDriver().getTitle();
        Assert.assertTrue(title.equals("4PDA"));
    }

    @Test
    public void clickForum(){
        forumField.click();
    }

    @Test
    public void getWithoutFindBy() {
        final String X_PATH = "//*[@id=\"RhRz2z1Zd9kC\"]/vjlevueb/vjlewnd/rchnivfdn3z2z/div[1]/ul/li[4]/a";
//        WebElement forumF = webDriver.getWebDriver().findElement(By.xpath(X_PATH));
        WebElement forumF = webDriver.getWebDriver().findElement(By.className("menu-main-item"));
        forumF.click();
    }

    @Test
    public void textOnButton() {
        WebElement forumHref = webDriver.getWebDriver().findElement(By.xpath("//a[text()='ФОРУМ']"));
        forumHref.click();
    }

    @After
    public void closeWeb() {
        Helper.sleep(3);
        webDriver.closeChrome();
    }
}
