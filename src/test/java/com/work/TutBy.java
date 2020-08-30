package com.work;

import by.texas.Driver;
import by.texas.Helper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TutBy {
    private Driver webDriver = new Driver();

    @Before
    public void openWeb() {
        webDriver.openTutBy();
        PageFactory.initElements(webDriver.getWebDriver(), this);// инициализация @FindBy
    }

    @Test
    public void registrationOnTutBy() {
        WebElement enter = setHref("Войти");
        enter.click();

        WebElement registration = setHref("Зарегистрироваться");
        registration.click();

//        WebElement email = Helper.waitById(webDriver.getWebDriver(),"field-email");
        WebElement email = Helper.endeavorUntilElement(webDriver.getWebDriver(),
                By.id("field-email"), Helper.ExpectedElementState.CLICKABLE);
        email.sendKeys(Helper.stringGeneration());
        WebElement password = setById("field-password");
        password.sendKeys(Helper.stringGeneration());
        WebElement fio = setById("field-fio");
        fio.sendKeys(Helper.stringGeneration());
        WebElement birthday = setById("field-birthday");
        birthday.sendKeys(Helper.birthdayGeneration());
        WebElement phone = setById("field-phone");
        phone.sendKeys(Helper.randomPhone());

        WebElement ok = Helper.waitById(webDriver.getWebDriver(),"reg_submit");
        ok.click();

        Assert.assertNotNull(Helper.waitById(webDriver.getWebDriver(),"field-phone-notice"));
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

    @After
    public void closeWeb() {
        Helper.sleep(3);
        webDriver.closeChrome();
    }
}
