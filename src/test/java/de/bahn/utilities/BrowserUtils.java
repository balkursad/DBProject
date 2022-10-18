package de.bahn.utilities;

import org.junit.Assert;

public class BrowserUtils {

    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle() );

    }
}
