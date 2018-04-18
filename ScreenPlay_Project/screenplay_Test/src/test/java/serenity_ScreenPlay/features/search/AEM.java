package serenity_ScreenPlay.features.search;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.pages.PageObject;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/AEM.Feature",plugin = {"pretty", "html:target/cucumber-html-report"})
public class AEM extends PageObject {
}
