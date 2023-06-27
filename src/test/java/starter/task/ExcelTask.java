package starter.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.search.SearchForm.EXCEL;
import static starter.search.SearchForm.EXCELDOC;

public class ExcelTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(EXCEL),
                Click.on(EXCELDOC));
    }

    public static ExcelTask Excel() {
        return instrumented(ExcelTask.class);
    }

}
