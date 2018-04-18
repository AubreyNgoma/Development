package serenity_ScreenPlay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox {
    public static Target SEARCH_FIELD;

    public static Target findByName(String element){
        return SEARCH_FIELD = Target.the("search field").located(By.name(element));
    }


}


