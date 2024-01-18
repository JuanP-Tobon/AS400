package userinterfaces;

import co.com.devco.automation.screenplay.as400.targets.Target;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;

public class MainScreen {
    public static final Target COMAND_LINE = Target.the("").locatedByCoordinate(Coordinate.withRow(20).withInitialColumn(7).andLenght(10));
}
