package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theDuckDuckGoHomePage(String url) {
        return Task.where("{0} opens the DuckDuckGo home page",
                Open.url(url));
                //Open.browserOn().the(DuckDuckGoHomePage.class));
    }
}
