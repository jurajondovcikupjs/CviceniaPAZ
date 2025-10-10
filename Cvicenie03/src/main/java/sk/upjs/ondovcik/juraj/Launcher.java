package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class Launcher {

	public static void main(String[] args) {

        HomeTurtle franklin = new HomeTurtle();
        WinPane sandbox = new WinPane(500, 500);
        sandbox.add(franklin);

        franklin.squares(300);

	}
}
