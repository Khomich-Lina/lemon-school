package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPagePageFactory {
    private WebDriver driver;

    public MainPagePageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "search")
    private WebElement getSearch1Field;


    public void enterSearchTerm(String searchTerm) {
        getSearch1Field.sendKeys(searchTerm);
    }



}
