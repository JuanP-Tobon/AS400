package tasks;

import co.com.devco.automation.screenplay.as400.model.Session;
import co.com.devco.automation.screenplay.as400.screen5250.controllers.OpenSession;
import co.com.devco.automation.screenplay.as400.screen5250.interactions.Enter;
import co.com.devco.automation.screenplay.as400.screen5250.interactions.Hit;
import co.com.devco.automation.screenplay.as400.screen5250.questions.Text;
import co.com.devco.automation.screenplay.as400.screen5250.utils.KeysScreen;
import co.com.devco.automation.screenplay.as400.screen5250.waits.Wait;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;
import co.com.devco.automation.screenplay.as400.targets.Target;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import userinterfaces.LoginScreen;
import userinterfaces.MainScreen;

public class Prueba implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Session session = new Session("PUB400.COM", 23, false);
        OpenSession.openSessionTn5250(session);
        actor.attemptsTo(
                Enter.theValue("JTOBON").into(LoginScreen.USERNAME),
                Enter.theValue(System.getProperty("password")).into(LoginScreen.PASSWORD),
                Hit.the(KeysScreen.ENTER),
                Wait.string("IBM i Main Menu"),
                Enter.theValue("STRSQL").into(MainScreen.COMAND_LINE),
                Hit.the(KeysScreen.ENTER)
        );


        String texto = Text.of(Target.the("").locatedByCoordinate(Coordinate.withRow(17).withInitialColumn(10).andLenght(8)));
        System.out.println("ESTE ES EL TEXTO: " + texto);

    }

    public static Prueba on() {
        return Tasks.instrumented(Prueba.class);
    }
}
