package sk.upjs.ondovcik.juraj;

import java.util.ArrayList;
import java.util.List;

public class Osoba {
    private String meno;
    private List<Osoba> deti = new ArrayList<>();

    public Osoba(String meno) {
        this.meno = meno;
    }

    public void pridajDieta(Osoba dieta) {
        deti.add(dieta);
    }

    public void vypisRodostrom() {
        vypisRodostrom(0);
    }

    public void vypisRodostrom(int level) {
        for (int i = 0; i < level; i++)
            System.out.print(' ');
        System.out.println(meno);
        for (Osoba dieta : deti)
            dieta.vypisRodostrom(level + 1);
    }

    @Override
    public String toString() {
        String result = meno;
        if (!deti.isEmpty()) {
            result += "(";
            boolean f = true;
            for (Osoba dieta : deti) {
                if (!f)
                    result += " ";
                result += dieta.toString();
                f = false;
            }
            result += ")";
        }
        return result;
    }

    public int najstastnejsiDedo() {
        return 0;
    }
}