package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String address() {
        return "register";
    }

    private By nameInpLoc = By.xpath(".//div[label[text()='Имя']]/input");
    private By emailInpLoc = By.xpath(".//div[label[text()='Email']]/input");
    private By passwordInpLoc = By.xpath(".//div[label[text()='Пароль']]/input");
    private By registerBtnLoc = By.xpath(".//button[text()='Зарегистрироваться']");
    private By incorrectPasswordTxtLoc = By.xpath(".//p[text()='Некорректный пароль']");
    private By loginBtnOnRegistrPage = By.xpath(".//a[text()='Войти']");

    public By getIncorrectPasswordTxtLoc() {
        return incorrectPasswordTxtLoc;
    }

    @Step("Заполняю форму регистрации")
    public void fillForm(String name, String email, String password) {
        driver.findElement(nameInpLoc).sendKeys(name);
        driver.findElement(emailInpLoc).sendKeys(email);
        driver.findElement(passwordInpLoc).sendKeys(password);
    }

    @Step("Нажимаю на кнопку Зарегистироваться")
    public void clickOnRegisterButton() {
        driver.findElement(registerBtnLoc).click();
    }

    @Step("Нажимаю на кнопку Войти")
    public void clickOnLoginBtnOnRegistrPage() {
        driver.findElement(loginBtnOnRegistrPage).click();
    }
}