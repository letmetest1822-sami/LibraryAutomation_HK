package com.LibraryCT.step_definitions;

import com.LibraryCT.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class SD_US01_HK {

    int expectedIDCount=0;
    int actualIDCount=0;

    List<String> actualColumnNames;


    @When("Execute query to get all IDs from users")
    public void executeQueryToGetAllIDsFromUsers() {

        DB_Util.runQuery("SELECT id FROM users");
        expectedIDCount=DB_Util.getRowCount();

    }

    @Then("verify all users has unique ID")
    public void verifyAllUsersHasUniqueID() {

        DB_Util.runQuery("SELECT DISTINCT id FROM users");
        actualIDCount=DB_Util.getRowCount();

//        System.out.println("expectedIDCount = " + expectedIDCount);
//        System.out.println("actualIDCount = " + actualIDCount);

        Assert.assertEquals( expectedIDCount, actualIDCount);

    }

    @When("Execute query to get all columns")
    public void executeQueryToGetAllColumns() {

        DB_Util.runQuery("SELECT * FROM users");
        actualColumnNames = DB_Util.getAllColumnNamesAsList();

    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult(List<String> expectedColumnNames) {

//        System.out.println("expectedColumnNames = " + expectedColumnNames);
//        System.out.println("actualColumnNames = " + actualColumnNames);

        Assert.assertEquals(expectedColumnNames,actualColumnNames);


    }

}
