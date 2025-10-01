package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		AnimatedWinPane sandbox = new AnimatedWinPane();

		// create new turtle and add it to the "sandbox"
		SmartTurtle franklin = new SmartTurtle();
		sandbox.add(franklin);

        franklin.mill(5, 50);
	}
}