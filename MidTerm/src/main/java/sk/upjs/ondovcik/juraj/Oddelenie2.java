package sk.upjs.ondovcik.juraj;

import java.util.ArrayList;
import java.util.List;

public class Oddelenie2 {
    private List<Oddelenie2> podOddelenia = new ArrayList<>();
    private int hodnota;

    public Oddelenie2(int hodnota) {
        this.hodnota = hodnota;
    }

    public void pridajPodOddelenie(Oddelenie2 oddelenie) {
        podOddelenia.add(oddelenie);
    }

    public void vypisFirmu() {
        vypisFirmu(0);
    }

    public void vypisFirmu(int level) {
        for (int i = 0; i < level; i++)
            System.out.print(' ');
        System.out.println(hodnota);
        for (Oddelenie2 dieta : podOddelenia)
            dieta.vypisFirmu(level + 1);
    }

    @Override
    public String toString() {
        String result = Integer.toString(hodnota);
        if (!podOddelenia.isEmpty()) {
            result += "(";
            boolean f = true;
            for (Oddelenie2 odd : podOddelenia) {
                if (!f)
                    result += " ";
                result += odd.toString();
                f = false;
            }
            result += ")";
        }
        return result;
    }

    public int totalProfit() {
        // Remove subdepartments with negative total profit and sum the rest
        int sum = hodnota;
        // Use iterator to safely remove while iterating
        java.util.Iterator<Oddelenie2> it = podOddelenia.iterator();
        while (it.hasNext()) {
            Oddelenie2 odd = it.next();
            int subProfit = odd.totalProfit();
            if (subProfit < 0) {
                it.remove();
            } else {
                sum += subProfit;
            }
        }
        // If this node's total is negative, signal to parent to remove it
        return Math.max(sum, 0);
    }

    public static void main(String[] args) {
        Oddelenie2 oddelenie = new Oddelenie2(20);
        Oddelenie2 oddelenie1 = new Oddelenie2(10);
        Oddelenie2 oddelenie2 = new Oddelenie2(-8);
        Oddelenie2 oddelenie3 = new Oddelenie2(-2);
        oddelenie.pridajPodOddelenie(oddelenie1);
        oddelenie.pridajPodOddelenie(oddelenie2);
        oddelenie.pridajPodOddelenie(oddelenie3);
        System.out.println(oddelenie);
        System.out.println("Total profit: " + oddelenie.totalProfit());
        System.out.println(oddelenie);
    }
}
