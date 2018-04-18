package serenity_ScreenPlay.features.search;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import serenity_ScreenPlay.tasks.OpenTheApplication;
import serenity_ScreenPlay.tasks.Search;
import serenity_ScreenPlay.ui.GoogleSearchPage;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

public class AEM_StepDefinitions {

    Actor Aubrey = Actor.named("Aubrey");
    GoogleSearchPage googlesearchpage = new GoogleSearchPage();
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication = new OpenTheApplication(googlesearchpage);

    @Given("^I navigate to google search page$")
    public void i_navigate_to_google_search_page() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Development\\chromedriver_win32\\chromedriver.exe");
        herBrowser = new ChromeDriver();
        Aubrey.can(BrowseTheWeb.with(herBrowser));
        givenThat(Aubrey).wasAbleTo(openTheApplication);

    }


    @When("^I enter the key word AEM and enter$")
    public void i_enter_the_key_word_AEM_and_enter() throws Exception {
        when(Aubrey).attemptsTo(Search.forTheTerm("AEM", "q"));

    }

    @Then("^I validate that the key word is on the list$")
    public void i_validate_that_the_key_word_is_on_the_list() throws Exception {
        then(Aubrey).should(eventually(seeThat(TheWebPage.title(), containsString("AEM"))));

    }

    @Then("^I close the browser$")
    public void i_close_the_browser() throws Exception {
        herBrowser.close();
    }

}
