package sk.upjs.ondovcik.juraj;

import java.util.*;

public class Osoba {
    private String meno;
    private List<Osoba> deti = new ArrayList<Osoba>();

    public Osoba(String meno) {
        this.meno = meno;
    }

    public void pridajDieta(Osoba dieta) {
        deti.add(dieta);
    }

    public int pocetJedinacikovVGeneracii(int generacia) {
        if (deti.isEmpty()) {
            return 0;
        }
        //System.out.println(deti.size());

        int pocet = 0;
        if (deti.size() == 1 && generacia == 1) {
            pocet++;
            return pocet;
        }
        for (Osoba dieta : deti) {
            pocet += dieta.pocetJedinacikovVGeneracii(generacia - 1);
        }

        return pocet;
    }


}