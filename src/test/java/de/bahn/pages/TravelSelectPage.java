package de.bahn.pages;

import de.bahn.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelSelectPage {

    public TravelSelectPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (className = "conSummaryDep")
    public WebElement vonInfo;

    @FindBy (className = "conSummaryArr")
    public WebElement nachInfo;

    @FindBy (className = "conSummaryTime")
    public WebElement time;

    @FindBy (id = "conTravellers")
    public WebElement travellersSummary;

    @FindBy ( id ="searchConnectionButton")
    public WebElement suchenButton;

    @FindBy (id = "errormsg_Z")
    public WebElement nachErrorMsg;

    @FindBy (id = "errormsg_S")
    public WebElement vonErrorMsg;

    public void verifyTravellersSummary(){
        Assert.assertEquals("Mainz Hbf", vonInfo.getText() );
        Assert.assertEquals("Ingelheim", nachInfo.getText() );
        Assert.assertEquals("Ab: 20:00", time.getText());
        Assert.assertEquals("1 reisende Person 27-64 Jahre, 1 Kind 0-5 J., 1. Klasse" , travellersSummary.getText());

    }




}
