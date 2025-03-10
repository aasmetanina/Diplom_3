import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPageTest extends BaseTest {

    @Override
    public void setUp() {
        super.setUp();
        loadPage(registerPage);
    }

    @Test
    @DisplayName("Проверяю Успешную регистрацию")
    public void registerSuccessfully() {
        String name = Utils.randomName();
        String email = Utils.randomEmail();
        String password = Utils.randomPassword();
        registerPage.fillForm(name, email, password);
        registerPage.clickOnRegisterButton();

        waitUntil(ExpectedConditions.urlContains("/login"));
    }

    @Test
    @DisplayName("Проверяю ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void registerShortPassword() {
        String name = Utils.randomName();
        String email = Utils.randomEmail();
        String password = "short";
        registerPage.fillForm(name, email, password);
        registerPage.clickOnRegisterButton();

        waitUntil(ExpectedConditions.presenceOfElementLocated(registerPage.getIncorrectPasswordTxtLoc()));
    }

}
