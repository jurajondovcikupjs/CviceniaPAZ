package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		//WinPane sandbox = new WinPane();

		StringTurtle franklin = new  StringTurtle();
		//sandbox.add(franklin);

        System.out.println(franklin.countChar("", 'a'));
        System.out.println(franklin.isPalindrome("Aba"));
        System.out.println(franklin.containsDoubleSpace("A  ba"));

	}
}
