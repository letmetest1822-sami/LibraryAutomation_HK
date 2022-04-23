package com.LibraryCT.pages;

import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement usernameInputBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordInputBox;

    @FindBy(tagName = "button")
    public WebElement signInButton;


    public void loginAsLibrarian(){

        usernameInputBox.sendKeys(ConfigurationReader.getProperty("librarianUsername"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        signInButton.click();

    }


    public void loginAsStudent(){

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        usernameInputBox.sendKeys(ConfigurationReader.getProperty("studentUsername"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        signInButton.click();

    }


}
