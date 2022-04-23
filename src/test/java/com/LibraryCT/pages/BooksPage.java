package com.LibraryCT.pages;

import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BooksPage {

    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//td")
    public List<WebElement> bookInfo;

    @FindBy(xpath = "//option")
    public List<WebElement> allOptions;


    public List<String> actualBookInfo(){

        List<String> actualBookInfo = new ArrayList<>();

        actualBookInfo.add(bookInfo.get(2).getText());
        actualBookInfo.add(bookInfo.get(3).getText());
        actualBookInfo.add(bookInfo.get(5).getText());

        return actualBookInfo;

    }

    public void searchBook (String bookName){

        searchBox.sendKeys(bookName);

        //BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(3);

    }




}
