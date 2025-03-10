package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected final WebDriver driver;

    public abstract String address();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //скролл до элемента
    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //ожидание кликабельности элемента
    public void waitUntilClickable(WebElement element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
    }
}
