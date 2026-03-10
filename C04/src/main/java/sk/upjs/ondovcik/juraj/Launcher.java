package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		Osoba janko = new Osoba("Janko");
		Osoba jozko = new Osoba("Jozko");
		Osoba maria = new Osoba("Maria");
		Osoba karol = new Osoba("Karol");
		Osoba lucia = new Osoba("Lucia");
		Osoba peter = new Osoba("Peter");
		janko.pridajDieta(jozko);
		janko.pridajDieta(maria);
		janko.pridajDieta(karol);
		karol.pridajDieta(lucia);
		lucia.pridajDieta(peter);
			   //Janko 0
		//Jozko, Maria, Karol 1
					  //Lucia 2
					  //Peter 3


		System.out.println(janko.pocetJedinacikovVGeneracii(0));
		System.out.println(janko.pocetJedinacikovVGeneracii(1));
		System.out.println(janko.pocetJedinacikovVGeneracii(2));
		System.out.println(janko.pocetJedinacikovVGeneracii(3));
	}
}
