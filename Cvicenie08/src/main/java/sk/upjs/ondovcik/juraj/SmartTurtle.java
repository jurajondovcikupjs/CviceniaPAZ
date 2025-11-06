package sk.upjs.ondovcik.juraj;


import sk.upjs.jpaz2.Turtle;

public class SmartTurtle extends Turtle {

    public int stringToInt(String s, int defaultValue) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e ) {
            return defaultValue;
        }
    }

}
