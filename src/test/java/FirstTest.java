import org.example.MainPagePageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FirstTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPagePageFactory mainPagePageFactory;


        @BeforeTest
        public void setupDriver() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

            driver = new ChromeDriver();
            driver.get("https://rozetka.com.ua/ua/");
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            mainPagePageFactory = new MainPagePageFactory(driver);
        }

        @Test
        public void searchTest() throws InterruptedException {


            mainPagePageFactory.enterSearchTerm("computer");

            WebElement searchField = driver.findElement(By.name("search"));
            searchField.sendKeys("computer");


            WebElement submitButton = driver.findElement(By.xpath("//button[contains(@class, 'green')]"));
            submitButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           /* WebElement gameLink = wait.until(ExpectedConditions.elementToBeClickable(By
                                .xpath("//a[contains(@title, 'Gran Turismo Sport (PS4, російська версія)')]")));
            */

            WebElement gameLink = driver.findElement(By
                    .xpath("//a[contains(@title, 'Gran Turismo Sport (PS4, російська версія)')]"));
            gameLink.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            assertTrue(driver.getTitle().contains("Gran Turismo Sport (PS4, російська версія)"), "Page title does not contain \"Gran Turismo Sport (PS4, російська версія)\"");

        }

        @AfterTest
        public void closeDriver() {
            driver.quit();
        }



}


//Thread.sleep(1000) *2