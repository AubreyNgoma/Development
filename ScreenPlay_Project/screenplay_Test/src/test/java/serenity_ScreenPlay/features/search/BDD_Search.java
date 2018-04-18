package serenity_ScreenPlay.features.search;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.pages.PageObject;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = "src/test/resources/Features/BDD_Search.feature")
public class BDD_Search extends PageObject {
}
