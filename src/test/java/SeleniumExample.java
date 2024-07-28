import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumExample {
    public static void main(String[] args) {
        // Вказуємо шлях до драйвера Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        // Створюємо екземпляр WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Переходимо на веб-сторінку
            driver.get("http://www.example.com");

            // Знаходимо елемент за допомогою CSS селектора
            WebElement element = driver.findElement(By.cssSelector("h1"));

            // Виводимо текст елемента на консоль
            System.out.println("Heading: " + element.getText());
        } finally {
            // Закриваємо браузер
            driver.quit();
        }
    }
}
