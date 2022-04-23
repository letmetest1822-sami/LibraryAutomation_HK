package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BooksPage;
import com.LibraryCT.pages.HomePage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SD_US06_HK {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();

    List<String> actualCategories;

    @Given("I log in as a librarian")
    public void iLogInAsALibrarian() {

        loginPage.loginAsLibrarian();

    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String tabName) {

        homePage.booksTab.click();

    }

    @And("I take all book categories in UI")
    public void iTakeAllBookCategoriesInUI() {

            actualCategories = new ArrayList<>();

            for (int i = 1; i < 21; i++) {
                actualCategories.add(booksPage.allOptions.get(i).getText());
            }

    }

    @And("I execute a query to get book categories")
    public void iExecuteAQueryToGetBookCategories() {

        DB_Util.runQuery("select name from book_categories;");

    }

    @Then("verify book categories must match the book_categories table from DB.")
    public void verifyBookCategoriesMustMatchTheBook_categoriesTableFromDB() {

        Assert.assertEquals(DB_Util.getColumnDataAsList(1), actualCategories);

    }

}
