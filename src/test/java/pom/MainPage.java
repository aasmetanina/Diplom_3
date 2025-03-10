package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String address() {
        return "";
    }

    private By loginInAccBtmLoc = By.xpath(".//button[text()='Войти в аккаунт']");
    private By accountButtonOnMainPage = By.xpath(".//p[text()='Личный Кабинет']");
    private By orderButtonOnMainPage = By.xpath(".//button[text()='Оформить заказ']");
    private By bunButtonOnMainPage = By.xpath(".//span[text()='Булки']");
    private By bunListButtonOnMainPage = By.xpath(".//h2[text()='Булки']");
    private By sauceButtonOnMainPage = By.xpath(".//span[text()='Соусы']");
    private By sauceListButtonOnMainPage = By.xpath(".//h2[text()='Соусы']");
    private By fillingButtonOnMainPage = By.xpath(".//span[text()='Начинки']");
    private By fillingListButtonOnMainPage = By.xpath(".//h2[text()='Начинки']");


    @Step("нажимаю на кнопку 'Войти в аккаунт'")
    public void clickOnlogininAccButton() {
        driver.findElement(loginInAccBtmLoc).click();
    }

    @Step("нажимаю на кнопку 'Личный кабинет'")
    public void clickOnAccountButtonOnMainPage() {
        driver.findElement(accountButtonOnMainPage).click();
    }

    public By getOrderButtonOnMainPage() {
        return orderButtonOnMainPage;
    }

    @Step("нажимаю на кнопку 'Булки'")
    public void clickOnBunButtonOnMainPage() {
        driver.findElement(bunButtonOnMainPage).click();
    }

    @Step("нажимаю на кнопку 'Соусы'")
    public void clickOnSauceButtonOnMainPage() {
        driver.findElement(sauceButtonOnMainPage).click();
    }

    @Step("нажимаю на кнопку 'Начинки'")
    public void clickOnFillingButtonOnMainPage() {
        driver.findElement(fillingButtonOnMainPage).click();
    }

    public By getBunListButtonOnMainPage() {
        return bunListButtonOnMainPage;
    }

    public By getSauceListButtonOnMainPage() {
        return sauceListButtonOnMainPage;
    }

    public By getFillingListButtonOnMainPage() {
        return fillingListButtonOnMainPage;
    }
}
