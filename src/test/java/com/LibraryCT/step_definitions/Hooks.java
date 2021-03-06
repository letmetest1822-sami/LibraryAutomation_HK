package com.LibraryCT.step_definitions;

import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.DB_Util;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.*;


public class Hooks {

    @Before (value="@db", order = 1)
    public void setupDB(){

        DB_Util.createConnection("jdbc:mysql://"+ ConfigurationReader.getProperty("ip") +":3306/library2", ConfigurationReader.getProperty("dbUsername"), ConfigurationReader.getProperty("dbPassword"));

    }

    @Before (value="@ui", order = 0)
    public void setupUI(){

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }

    @After ("@ui")
    public void teardown(Scenario scenario){

        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();

    }

    @After("@db")
    public void dbTearDown() {
        DB_Util.destroy();
    }

}
