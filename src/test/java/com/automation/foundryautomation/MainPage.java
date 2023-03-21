package com.automation.foundryautomation;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {


        @FindBy (xpath = "//button[contains(@class, 'css-sqr205')]")

        public WebElement getFreeDemo ;
        @FindBy(xpath = "//button[contains(@class, 'css-kav5qw')]")
        public WebElement signInButton;


        @FindBy (xpath = "//button[contains(@class, 'css-kav5qw')]")
        public WebElement signUpForm;



        @FindBy (xpath = "//span[normalize-space()='Products']")
        public WebElement productModule;









    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
}
