import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConstructorTest extends BaseTest {

    @Override
    public void setUp() {
        super.setUp();
        loadPage(mainPage);
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Булки»")
    public void clickOnBunButton() {
        mainPage.clickOnSauceButtonOnMainPage();
        mainPage.clickOnBunButtonOnMainPage();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getBunListButtonOnMainPage()));
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Соусы»")
    public void clickOnSouceButton() {
        mainPage.clickOnSauceButtonOnMainPage();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getSauceListButtonOnMainPage()));
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам: «Начинки»")
    public void clickOnFillingButton() {
        mainPage.clickOnFillingButtonOnMainPage();
        waitUntil(ExpectedConditions.presenceOfElementLocated(mainPage.getFillingListButtonOnMainPage()));
    }

}
