package stepdefinitions;

import co.com.devco.automation.screenplay.as400.screen5250.utils.PrintScreen;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ValidarTarifaDb;
import tasks.Prueba;
import tasks.Run;
import tasks.caso_tarifa.ReviewApi;

import java.util.List;
import java.util.Map;

public class EnterToIseriesStepDefinitions {


    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        PrintScreen.setPrintIndicator(true);
    }

    @Given("The user opens the session and logs in")
    public void theUserOpensTheSessionAndLogsIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(Prueba.on());
    }

    @Given("the user performs a direct query to the DB")
    public void theUserPerformsADirectQueryToTheDB() {
        OnStage.theActorInTheSpotlight().attemptsTo(Run.query());

    }

    @Given("The user connects and consult")
    public void theUserConnectsAndConsult(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(ReviewApi.with(data.get(0)));
        //OnStage.theActorInTheSpotlight().attemptsTo(PruebaMongoDB.querys());
    }

    @Then("He should see that the rate and date are correct")
    public void heShouldSeeThatTheRateAndDateAreCorrect() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ValidarTarifaDb.on()
        ));
    }
}
