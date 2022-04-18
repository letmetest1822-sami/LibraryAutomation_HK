package com.LibraryCT.step_definitions;

import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SD_US04_HK {

    @When("I execute a query to find the most popular user")
    public void iExecuteAQueryToFindTheMostPopularUser() {

        DB_Util.runQuery("select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id group by full_name order by 2 desc ;");

//        DB_Util.displayAllData();

    }

    @Then("verify {string} is the user who reads the most")
    public void verifyTestStudentNumberIsTheUserWhoReadsTheMost(String expectedStudentName){

        Assert.assertEquals(expectedStudentName, DB_Util.getFirstRowFirstColumn());

    }
}