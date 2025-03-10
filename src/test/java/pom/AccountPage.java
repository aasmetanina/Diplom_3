package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String address() {
        return "account";
    }

    private By profileInAcc = By.xpath(".//a[text()='Профиль']");
    private By exitBtnInAcc = By.xpath(".//button[text()='Выход']");
    private By constructorBtnInAcc = By.xpath(".//p[text()='Конструктор']");
    private By logoBtnInAcc = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");

    public By getProfileInAcc() {
        return profileInAcc;
    }

    @Step("нажимаю на кнопку 'Выход'")
    public void clickOnExitBtnInAcc() {
        driver.findElement(exitBtnInAcc).click();
    }

    @Step("нажимаю на кнопку 'Конструктор'")
    public void clickOnConstructorBtnInAcc() {
        driver.findElement(constructorBtnInAcc).click();
    }

    @Step("нажимаю на кнопку Логотип")
    public void clickOnLogoBtnInAcc() {
        driver.findElement(logoBtnInAcc).click();
    }

}
