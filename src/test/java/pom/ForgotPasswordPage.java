package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String address() {
        return "forgot-password";
    }

    private By accountBtmoOnForgotPage = By.xpath(".//a[text()='Войти']");


    @Step("Нажимаю на кнопку 'Войти'")
    public void clickOnRecoverBtm() {
        driver.findElement(accountBtmoOnForgotPage).click();
    }
}
