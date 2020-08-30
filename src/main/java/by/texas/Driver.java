package by.texas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private WebDriver webDriver;

    public Driver () {
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Artem\\IdeaProjects\\AutoTest\\chromedriver.exe");
        //3bf0e106a93382efd7a5bb3b55b182a6
        webDriver.manage().window().maximize();
    }

    public void openWebPage(){
        webDriver.get("https://4pda.ru/");
    }

    public void openTutBy(){
        webDriver.get("https://www.tut.by/");
    }

    public void openHabr() {
        webDriver.get("https://habr.com/ru/company/luxoft/blog/270383/");
    }

    public void openLocal() {
        webDriver.get("http://localhost:8080/login");
    }

    public void openRozetka() {
        webDriver.get("https://rozetka.com.ua/all-tv/c80037/");
    }

    public void closeChrome() {
        webDriver.quit();
    }

    public void wait(int time) {
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
