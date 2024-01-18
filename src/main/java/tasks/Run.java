package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.ConsultTable;


public class Run implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        ConsultTable.consultLog();
    }

    public static Run query() {
        return Tasks.instrumented(Run.class);
    }
}
