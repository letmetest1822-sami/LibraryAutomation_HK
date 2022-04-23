package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.HomePage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class SD_US02_HK {

    LoginPage loginPage = new LoginPage();


    int borrowedBooksUI;
    int borrowedBooksDB;

    @Given("I am in the homepage of the library app")
    public void iAmInTheHomepageOfTheLibraryApp() {




//        BrowserUtils.waitFor(5);
        loginPage.loginAsLibrarian();

    }

    @When("I take borrowed books number")
    public void iTakeBorrowedBooksNumber() {

        HomePage homePage = new HomePage();

        borrowedBooksUI= Integer.parseInt( homePage.borrowedBooksNumber.getText() );

    }


    @Then("borrowed books number information must match with DB")
    public void borrowedBooksNumberInformationMustMatchWithDB() {

        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0");
        borrowedBooksDB= Integer.parseInt( DB_Util.getFirstRowFirstColumn() );

        System.out.println("borrowedBooksUI = " + borrowedBooksUI);
        System.out.println("borrowedBooksDB = " + borrowedBooksDB);

        Assert.assertEquals(borrowedBooksDB, borrowedBooksUI);

    }

}
