import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.*;

public abstract class BaseTest {
    protected static final String SITE_URL = "https://stellarburgers.nomoreparties.site/";

    private WebDriver driver;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected MainPage mainPage;
    protected AccountPage accountPage;


    @Before
    public void setUp() {
        switch (System.getProperty("browser")) {
            case "yandex": {
                WebDriverManager.chromiumdriver()
                        .driverVersion("132.0.6834.83")
                        .setup();
                driver = new ChromeDriver(new ChromeOptions().setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex"));
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            default:
                throw new IllegalArgumentException("incompatible browser");
        }
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        mainPage = new MainPage(driver);
        accountPage = new AccountPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    protected void loadPage(BasePage page) {
        driver.get(SITE_URL + page.address());
    }

    public void waitUntil(ExpectedCondition<?> condition) {
        new WebDriverWait(driver, 10).until(condition);
    }
}
