package serenity_ScreenPlay.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheApplication implements Task {

    PageObject anyclass;
    public OpenTheApplication(PageObject anyClass) {
        this.anyclass = anyClass;
    }

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(anyclass)
        );
    }
}
