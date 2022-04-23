package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BooksPage;
import com.LibraryCT.pages.HomePage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SD_US05_HK {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();

    @Given("I login as a librarian")
    public void iLoginAsALibrarian() {

        loginPage.loginAsLibrarian();

    }

    @And("I navigate to {string} page")
    public void iNavigateToPage(String tabName) {

        homePage.booksTab.click();

    }

    @When("I open book {string}")
    public void iOpenBook(String bookName) {

        DB_Util.runQuery("select name, author,year from books where name='"+bookName+"';");

//        booksPage.searchBox.sendKeys(bookName);
//        BrowserUtils.waitFor(3);

        booksPage.searchBook(bookName);

    }

    @Then("book information must match the Database")
    public void bookInformationMustMatchTheDatabase() {

        List<String> expectedBookInfo = DB_Util.getRowDataAsList(1);

        Assert.assertEquals(expectedBookInfo, booksPage.actualBookInfo());

    }

}
