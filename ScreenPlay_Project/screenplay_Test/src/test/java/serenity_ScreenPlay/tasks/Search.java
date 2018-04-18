package serenity_ScreenPlay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

import serenity_ScreenPlay.ui.SearchBox;

public class Search implements Task {

    private final String searchTerm;
    private final String element;
    protected Search(String searchTerm, String element) {
        this.searchTerm = searchTerm;
        this.element = element;
    }

    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm)
                     .into(element)
                     .thenHit(ENTER)
        );
    }


    @Step("Enter all #fields")
    public <T extends Actor> void enterFields(T actor)
    {
        actor.attemptsTo(
                Enter.theValue(searchTerm)
                        .into(SearchBox.findByName(element))
                        .thenHit(TAB)
        );
    }
    public static Search forTheTerm(String searchTerm, String element) {
        return instrumented(Search.class, searchTerm, element);
    }

}
