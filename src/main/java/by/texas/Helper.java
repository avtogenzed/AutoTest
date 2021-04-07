package by.texas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.function.Function;

public class Helper {

    public static void sleep(int time) {
        int secondTime = time * 1000;
        try {
            Thread.sleep(secondTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String stringGeneration() {
        final String ALL_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        final int lengthNameEmail = 10;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lengthNameEmail; i++) {
            int randomCharAt = random.nextInt(ALL_SYMBOLS.length());
            char randomChar = ALL_SYMBOLS.charAt(randomCharAt);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String birthdayGeneration() {
        StringBuilder sb = new StringBuilder();
        final int limit = 2;
        sb.append(0);
        int day = randomNumbers(0, 9);
        sb.append(day);

        sb.append(".");
        sb.append(0);
        int month = randomNumbers(0, 9);
        sb.append(month);

        sb.append(".");
        int year = randomNumbers(1970, 2001);
        sb.append(year);

        return sb.toString();
    }

    private static int randomNumbers(int min, int max) {
        Random random = new Random();
        int result = random.nextInt((max - min) + 1) + min;
        return result;
    }

    public static String randomPhone() {
        int min = 1;
        int max = 9;
        Random random = new Random();
        int result = random.nextInt((max - min) + 1) + min;
        return String.valueOf(result);
    }

    public static String realPhone() {
        int phone = 447734274;
        return String.valueOf(phone);
    }

    public static WebElement waitById(WebDriver driver,String id) {
        final int WAITING_TIME = 10;
        WebElement webElement = new WebDriverWait(driver, WAITING_TIME)
                .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        return webElement;
    }
//-----------------------------------------------------------------------
    public enum ExpectedElementState {PRESENT, VISIBLE, CLICKABLE}

    private static Function<By, ExpectedCondition<WebElement>> decodeStateExtractor(ExpectedElementState state) {
        switch (state) {
            case PRESENT: return ExpectedConditions::presenceOfElementLocated;//criteria -> ExpectedConditions.presenceOfElementLocated(criteria);
            case VISIBLE: return criteria -> ExpectedConditions.visibilityOfElementLocated(criteria);
            case CLICKABLE: return criteria -> ExpectedConditions.elementToBeClickable(criteria);
        }
        throw new IllegalArgumentException("Element state condition is not recognized");
    }

    public static WebElement endeavorUntilElement(WebDriver driver, By criteria, ExpectedElementState expectedState) {
        final int WAITING_TIME = 10;
        Function<By, ExpectedCondition<WebElement>> stateExtractor = decodeStateExtractor(expectedState);
        WebElement webElement = new WebDriverWait(driver, WAITING_TIME)
                .until(stateExtractor.apply(criteria));
        return webElement;
    }
}
