package pruebas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExcelTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    public static ExcelTask ValidateFieldEmail() {
        return instrumented(ExcelTask.class);
    }

}
