import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountTest extends BaseTest {

    private String email;
    private String password;
    private String token;

    @Override
    public void setUp() {
        super.setUp();
        RestAssured.baseURI = SITE_URL;
        email = Utils.randomEmail();
        password = Utils.randomPassword();
        String name = Utils.randomName();
        token = ApiClient.createUser(email, password, name);
        loadPage(loginPage);
        loginPage.fillForm(email, password);
        loginPage.clickOnloginButton();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getBunListButtonOnMainPage()));
        loadPage(accountPage);
        waitUntil(ExpectedConditions.urlContains("profile"));
    }

    @Override
    public void tearDown() {
        super.tearDown();
        ApiClient.deleteUser(token);
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void myAccountFromMainPage() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(accountPage.getProfileInAcc()));
    }

    @Test
    @DisplayName("Проверь переход по клику на «Конструктор»")
    public void constructorFromAccountPageConstrBtn() {
        accountPage.clickOnConstructorBtnInAcc();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getBunListButtonOnMainPage()));
    }

    @Test
    @DisplayName("Проверь переход по клику на логотип Stellar Burgers")
    public void constructorFromAccountPageLogoBtn() {
        accountPage.clickOnLogoBtnInAcc();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getBunListButtonOnMainPage()));
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете.")
    public void exitFromAccountPageLogoBtn() {
        accountPage.clickOnExitBtnInAcc();
        waitUntil(ExpectedConditions.urlContains(loginPage.address()));
    }

}
