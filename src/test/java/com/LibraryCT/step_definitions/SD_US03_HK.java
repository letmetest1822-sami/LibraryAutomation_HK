package com.LibraryCT.step_definitions;

import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SD_US03_HK {

    String actualPopularGenre;

    @When("I execute a query to find the most popular book genre")
    public void iExecuteAQueryToFindTheMostPopularBookGenre() {

        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb inner  join books b on bb.book_id = b.id inner join book_categories bc on b.book_category_id=bc.id group by name order by 2 desc;");

        actualPopularGenre = DB_Util.getFirstRowFirstColumn();

//        DB_Util.displayAllData();

    }

    @Then("verify that {string} is the most popular book genre.")
    public void verifyThatClassicIsTheMostPopularBookGenre(String genre){

        Assert.assertEquals(genre, actualPopularGenre);

    }

}