package de.bahn.pages;

import de.bahn.utilities.BrowserUtils;
import de.bahn.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    public Homepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath ="//div[@style='height: 100%; width: 100%; position: fixed; top: 0px; left: 0px; z-index: 2001; background-color: rgba(0, 0, 0, 0.7); padding: 1.25rem; box-sizing: border-box;']")
    public WebElement shadowRoot;

    @FindBy (xpath = "//a[.='Tickets & Angebote']")
    public WebElement ticketsAngebote;

    @FindBy (xpath = "//a[.='Info & Services']")
    public WebElement infoServices;

    @FindBy (xpath = "//a[.='Geschäftskunden']")
    public WebElement geschäftskunden;

    @FindBy (id = "qf-from")
    public WebElement vonBox;

    @FindBy ( id = "qf-to")
    public WebElement nachBox;

    @FindBy ( xpath = "(//button[@title='Einen Tag später'])[1]")
    public WebElement date;

    @FindBy ( id = "qf-time")
    public WebElement time;

    @FindBy ( id = "qf-travellers")
    public WebElement travelers;

    @FindBy ( id = "qf-traveller-type1")
    public WebElement agePerson1;

    @FindBy ( id = "qf-traveller-type2")
    public WebElement agePerson2;

    @FindBy (xpath = "//label[.='1. Klasse']")
    public WebElement firstClass;

    @FindBy ( id = "qf-search-city")
    public WebElement suchenButton;


    public void moduleSelection(String module){

        switch (module){
            case "Tickets & Angebote":
                ticketsAngebote.click();
                break;
            case "Info & Services":
                infoServices.click();
                break;
            case "Geschäftskunden":
                geschäftskunden.click();

        }
    }

    public void verifyTitle(String module){
        String ticketsAngeboteTitle = "Bahntickets & Angebote der Deutschen Bahn",
                infoServicesTitle = "Info & Services",
                geschäftskundenTitle = "bahnbusiness: Programm für Geschäftskunden der Deutschen Bahn";

        switch (module){
            case "Tickets & Angebote":
                BrowserUtils.verifyTitle(ticketsAngeboteTitle);
                break;
            case "Info & Services":
                BrowserUtils.verifyTitle(infoServicesTitle);
                break;
            case "Geschäftskunden":
                BrowserUtils.verifyTitle(geschäftskundenTitle);
        }


    }
}
