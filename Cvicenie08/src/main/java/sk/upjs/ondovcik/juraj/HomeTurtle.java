package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HomeTurtle extends Turtle {

    public void spirala(File subor, int[] cisla, int pocetRiadkov) {

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(subor);
            for (int i = 0; i < cisla.length; i++) {
                pw.println(cisla[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Subor sa nenasiel");
        } finally {
            if (pw != null) pw.close();
        }


    }
}
