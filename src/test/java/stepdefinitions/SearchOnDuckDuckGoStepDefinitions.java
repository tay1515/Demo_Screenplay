package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;
import starter.task.ExcelTask;
import starter.navigation.NavigateTo;
import starter.search.SearchFor;
import starter.search.SearchResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.everyItem;

public class SearchOnDuckDuckGoStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} is on the DuckDuckGo home page")
    public void on_the_DuckDuckGo_home_page(String actor) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(variables).getProperty("environments.default.webdriver.base.url");
        System.out.println("url " + url);
        //theActorCalled(actor).attemptsTo(Open.url(username));
        theActorCalled(actor).attemptsTo(NavigateTo.theDuckDuckGoHomePage(url));
    }

    @When("he searches for {string}")
    public void search_for(String term) {
        withCurrentActor(
                SearchFor.term(term)
        );
    }

    @Then("all the result titles should contain the word {string}")
    public void all_the_result_titles_should_contain_the_word(String term) {
           theActorInTheSpotlight()
                   .should(seeThat(SearchResult.titles(), everyItem(CoreMatchers.containsStringIgnoringCase(term))));

    }

    @Given("Open page excel")
    public void openPageExcel() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(variables).getProperty("environments.dev.webdriver.base.url");
        System.out.println("url " + url);
        //theActorCalled(actor).attemptsTo(Open.url(username));
        theActorCalled("pruebas").attemptsTo(NavigateTo.theDuckDuckGoHomePage(url));
    }

    @When("clic on download")
    public void clicOnDownload() {
        theActorInTheSpotlight().attemptsTo(ExcelTask.Excel());
    }
}
