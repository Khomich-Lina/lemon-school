package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    private By searchButton = By.name("search");

    public WebElement getSearchField() {
        return driver.findElement(searchButton);
    }

    public void enterSearchTerm(String searchTerm) {
        getSearchField().sendKeys(searchTerm);
    }



}
