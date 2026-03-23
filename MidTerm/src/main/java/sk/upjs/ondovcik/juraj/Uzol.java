package sk.upjs.ondovcik.juraj;

import java.util.*;

public class Uzol {

    private int hmotnost;
    private List<Uzol> deti = new ArrayList<>();

    public Uzol(int hmotnost) {
        this.hmotnost = hmotnost;
    }

    public void pridajDieta(Uzol dieta) {
        deti.add(dieta);
    }

    public void vypisRodostrom() {
        vypisRodostrom(0);
    }

    public void vypisRodostrom(int level) {
        for (int i = 0; i < level; i++)
            System.out.print(' ');

        System.out.println(hmotnost);
        for (Uzol dieta : deti)
            dieta.vypisRodostrom(level + 1);
    }

    @Override
    public String toString() {
        String result = Integer.toString(hmotnost);
        if (deti.size() != 0) {
            result += "(";
            boolean f = true;
            for (Uzol dieta : deti) {
                if (!f)
                    result += " ";
                result += dieta.toString();
                f = false;
            }
            result += ")";
        }

        return result;
    }

    public int jesen() {
        int sum = hmotnost;

        if (deti.isEmpty()) return sum;

        for (Uzol dieta : deti) {
            sum += dieta.jesen();
            dieta.deti.clear();
        }
        return sum;
    }

        public static void main(String[] args) {
            Uzol rodic = new Uzol(10);
            Uzol dieta1 = new Uzol(5);
            Uzol dieta2 = new Uzol(3);
            Uzol dieta3 = new Uzol(8);
            rodic.pridajDieta(dieta1);
            rodic.pridajDieta(dieta2);
            dieta2.pridajDieta(dieta3);
            System.out.println(rodic);
            System.out.println(rodic.jesen());
            System.out.println(rodic);
        }
}