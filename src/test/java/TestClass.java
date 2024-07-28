import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestClass {

    private WebDriver driver;

    @BeforeClass
    void setupClass(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // додайте цей аргумент для дозволу будь-яких походжень
         driver = new ChromeDriver(options);
         driver.manage().window().maximize();
    }

    @Test
    public void validLoginTest() throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/calculator");

        WebElement firstNumber = driver.findElement(By.id("number1"));
        WebElement secondNumber = driver.findElement(By.id("number2"));
        Select dropdown = new Select(driver.findElement(By.id("function")));
        WebElement calculateButton = driver.findElement(By.id("calculate"));


        // Enter numbers and select operator
        firstNumber.clear();
        firstNumber.sendKeys("7");
        secondNumber.clear();
        secondNumber.sendKeys("3");

        // Select operator "+"
       dropdown.selectByValue("plus");

        // Click on Calculate button
        calculateButton.click();

        WebElement resultField = driver.findElement(By.id("answer"));
        // Verify the result
        String result = resultField.getText();
        Assert.assertEquals(result, "10", "The result of 7 + 3 should be 10.");
    }

    @AfterClass
    void tearDownClass(){
        driver.quit();
    }
}
