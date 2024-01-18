package userinterfaces;

import co.com.devco.automation.screenplay.as400.targets.Target;
import co.com.devco.automation.screenplay.as400.targets.Coordinate;

public class LoginScreen {
    public static final Target USERNAME = Target.the("username input").locatedByCoordinate(Coordinate.withRow(5).withInitialColumn(25).andLenght(10));
    public static final Target PASSWORD = Target.the("password input").locatedByCoordinate(Coordinate.withRow(6).withInitialColumn(25).andLenght(10));
}
