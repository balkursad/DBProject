package de.bahn.step_definitions;

import de.bahn.pages.Homepage;
import de.bahn.pages.TravelSelectPage;
import de.bahn.utilities.ConfigurationReaders;
import de.bahn.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Homepage_stepDefs {
    Homepage homepage = new Homepage();
    TravelSelectPage travelSelectPage = new TravelSelectPage();

    @Given("user is on the Homepage")
    public void user_is_on_the_Homepage() {
        Driver.getDriver().get(ConfigurationReaders.getProperty("URL"));
    }

    @Given("accept all cookies")
    public void accept_all_cookies() {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        WebElement shadowElement = (WebElement)js.executeScript("return document.querySelector(\"body > div:nth-child(1)\").shadowRoot.querySelector(\"#consent-layer > div.consent-layer__btn-container > button.btn.btn--secondary.js-accept-all-cookies\")");
        shadowElement.click();
    }

    @When("user clicks the {string}")
    public void user_clicks_the(String module) {
    homepage.moduleSelection(module);
    }

    @Then("verify that user is on related {string} page")
    public void verify_that_user_is_on_related_page(String module) {
    homepage.verifyTitle(module);
    }

    @When("user enter the {string} on von box")
    public void user_enter_the_on_von_box(String string) {
    homepage.vonBox.sendKeys("Mainz Hbf");
    }
    @When("user enter the {string} on nach box")
    public void user_enter_the_on_nach_box(String string) {
    homepage.nachBox.sendKeys("Ingelheim"+ Keys.ENTER);
    }
    @When("user select the next day with using arrow near the date data")
    public void user_select_the_next_day_with_using_arrow_near_the_date_data() {
    homepage.date.click();
    }
    @When("user click timeset and type {int}")
    public void user_click_timeset_and_type(Integer int1) {
    homepage.time.sendKeys("2000");
    }
    @When("user select zwei reisende Personen")
    public void user_select_zwei_reisende_personen() {
    Select select = new Select(homepage.travelers);
    select.selectByValue("2");
    select.getFirstSelectedOption().click();
    }
    @When("user select first age gap {string}")
    public void user_select_first_age_gap(String string) {
    Select select = new Select(homepage.agePerson1);
    select.selectByVisibleText("27-64 Jahre");
    select.getFirstSelectedOption().click();
    }
    @When("user select second age gap {string}")
    public void user_select_second_age_gap(String string) {
    Select select = new Select(homepage.agePerson2);
    select.selectByIndex(0);
    select.getFirstSelectedOption().click();
    }
    @When("user select first class")
    public void user_select_first_class() {
    homepage.firstClass.click();
    }
    @When("user click suchen button")
    public void user_click_suchen_button() {
    homepage.suchenButton.click();
    }
    @Then("verify that the information top on the page match with entered data")
    public void verify_that_the_information_top_on_the_page_match_with_entered_data() {
    travelSelectPage.verifyTravellersSummary();
    }

   // @When("user click the suchen button")
    public void user_click_the_suchen_button() {
    homepage.suchenButton.click();
    }

    @When("user click again suchen button on the select page")
    public void user_click_again_suchen_button_on_the_select_page() {
    travelSelectPage.suchenButton.click();
    }
    @Then("verify that there is error message about filling nach Box")
    public void verify_that_there_is_error_message_about_filling_this_area() {
    Assert.assertEquals("Bitte geben Sie hier eine Haltestelle ein.", travelSelectPage.nachErrorMsg.getText());
    }

    @Then("verify that there is error message about filling von Box")
    public void verifyThatThereIsErrorMessageAboutFillingVonBox() {
    Assert.assertEquals("Bitte geben Sie hier eine Haltestelle ein.", travelSelectPage.vonErrorMsg.getText());
    }
}
