package sk.upjs.ondovcik.juraj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Obec {
    private ArrayList<Domacnost> zoznamDomacnosti;

    public Obec() {
        zoznamDomacnosti = new ArrayList<Domacnost>();
    }

    public void eviduj(Domacnost domacnost) {
        zoznamDomacnosti.add(domacnost);
    }

    public static Obec nacitajEvidenciu(String nazovSuboru) {
        Obec obec = new Obec();
        try (Scanner sc = new Scanner(new File(nazovSuboru))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                obec.eviduj(Domacnost.zoStringu(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obec;
    }
}
