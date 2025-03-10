import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends BaseTest {

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
    }

    @Override
    public void tearDown() {
        super.tearDown();
        ApiClient.deleteUser(token);
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPage() {
        loadPage(mainPage);
        mainPage.clickOnlogininAccButton();
        loginPage.fillForm(email, password);
        loginPage.clickOnloginButton();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getOrderButtonOnMainPage()));
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginFromMyAccountPage() {
        loadPage(mainPage);
        mainPage.clickOnAccountButtonOnMainPage();
        loginPage.fillForm(email, password);
        loginPage.clickOnloginButton();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getOrderButtonOnMainPage()));
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginFromRegisterPage() {
        loadPage(registerPage);
        registerPage.clickOnLoginBtnOnRegistrPage();
        loginPage.fillForm(email, password);
        loginPage.clickOnloginButton();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getOrderButtonOnMainPage()));
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordPage() {
        loadPage(forgotPasswordPage);
        forgotPasswordPage.clickOnRecoverBtm();
        loginPage.fillForm(email, password);
        loginPage.clickOnloginButton();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getOrderButtonOnMainPage()));
    }

}
