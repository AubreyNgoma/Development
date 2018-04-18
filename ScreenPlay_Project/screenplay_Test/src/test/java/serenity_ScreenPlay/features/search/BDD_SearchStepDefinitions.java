package serenity_ScreenPlay.features.search;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import serenity_ScreenPlay.tasks.OpenTheApplication;
import serenity_ScreenPlay.tasks.Search;
import serenity_ScreenPlay.ui.WikipediaSearchPage;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;


public class BDD_SearchStepDefinitions {

    Actor Aubrey = Actor.named("Aubrey");

    WikipediaSearchPage wikiPage = new WikipediaSearchPage();
    @Managed(uniqueSession = true)
    WebDriver browser;
    OpenTheApplication openTheApplication = new OpenTheApplication(wikiPage);

    @Given("^I Navigate to the wikipedai home page$")
    public void i_Navigate_to_the_wikipedai_home_page() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Development\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        Aubrey.can(BrowseTheWeb.with(browser));
        givenThat(Aubrey).wasAbleTo(openTheApplication);
    }


    @When("^I search the term Behaviour Driven Developmnet and enter$")
    public void i_search_the_term_Behaviour_Driven_Developmnet_and_enter() throws Exception {
        when(Aubrey).attemptsTo(Search.forTheTerm("Behaviour Driven Development", "search"));
    }

    @Then("^I should confirm it's the correct page$")
    public void i_should_confirm_it_s_the_correct_page() throws Exception {
        then(Aubrey).should(eventually(seeThat(TheWebPage.title(), containsString("Behavior-driven development"))));
    }

    @Then("^I close the wikipedai page and browser$")
    public void i_close_the_wikipedai_page_and_browser() throws Exception {
        browser.close();
    }
}
