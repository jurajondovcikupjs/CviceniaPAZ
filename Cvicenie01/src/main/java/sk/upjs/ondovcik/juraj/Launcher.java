package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		WinPane sandbox = new WinPane();
        sandbox.setWidth(500);
        sandbox.setHeight(500);

		// create new turtle and add it to the "sandbox"
		HomeTurtle franklin = new HomeTurtle();
		sandbox.add(franklin);

        franklin.beehive(50);

	}
}