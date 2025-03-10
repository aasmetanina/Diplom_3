package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String address() {
        return "login";
    }

    private By emailLogin = By.xpath(".//input[@type = 'text']");
    private By passwordLogin = By.xpath(".//input[@type = 'password']");
    private By loginBtmLoc = By.xpath(".//button[text()='Войти']");
    private By recoverPasswordBtm = By.xpath(".//a[text()='Восстановить пароль']");

    @Step("Заполняю форму входа")
    public void fillForm(String email, String password) {
        driver.findElement(emailLogin).sendKeys(email);
        driver.findElement(passwordLogin).sendKeys(password);
    }

    @Step("Нажимаю на кнопку 'Войти'")
    public void clickOnloginButton() {
        driver.findElement(loginBtmLoc).click();
    }

    @Step("Нажимаю на кнопку 'Восстановить пароль'")
    public void clickOnrecoverPasswordBtm() {
        driver.findElement(recoverPasswordBtm).click();
    }

}


