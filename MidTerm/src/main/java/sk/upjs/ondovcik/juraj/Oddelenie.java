package sk.upjs.ondovcik.juraj;

import java.util.ArrayList;
import java.util.List;

public class Oddelenie {
    private List<Oddelenie> podOddelenia = new ArrayList<>();
    private int hodnota;

    public Oddelenie(int hodnota) {
        this.hodnota = hodnota;
    }

    public void pridajPodOddelenie(Oddelenie oddelenie) {
        podOddelenia.add(oddelenie);
    }

    public void vypisFirmu() {
        vypisFirmu(0);
    }

    public void vypisFirmu(int level) {
        for (int i = 0; i < level; i++)
            System.out.print(' ');
        System.out.println(hodnota);
        for (Oddelenie dieta : podOddelenia)
            dieta.vypisFirmu(level + 1);
    }

    @Override
    public String toString() {
        String result = Integer.toString(hodnota);
        if (!podOddelenia.isEmpty()) {
            result += "(";
            boolean f = true;
            for (Oddelenie odd : podOddelenia) {
                if (!f)
                    result += " ";
                result += odd.toString();
                f = false;
            }
            result += ")";
        }
        return result;
    }

    public int richestDepartment() {
        if (podOddelenia.isEmpty())
            return hodnota;
        int maxSum = Integer.MIN_VALUE;
        for (Oddelenie odd : podOddelenia) {
            int sum = odd.sumSubtree();
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

    // Helper method to compute the sum of the subtree rooted at this node
    private int sumSubtree() {
        int sum = hodnota;
        for (Oddelenie odd : podOddelenia) {
            sum += odd.sumSubtree();
        }
        return sum;
    }

    public static void main(String[] args) {
        Oddelenie oddelenie1 = new Oddelenie(-17);
        Oddelenie oddelenie2 = new Oddelenie(3);
        Oddelenie oddelenie3 = new Oddelenie(11);
        Oddelenie oddelenie4 = new Oddelenie(12);
        Oddelenie oddelenie5 = new Oddelenie(7);
        Oddelenie oddelenie6 = new Oddelenie(-2);
        Oddelenie oddelenie7 = new Oddelenie(-2);
        Oddelenie oddelenie8 = new Oddelenie(6);
        Oddelenie oddelenie9 = new Oddelenie(1);
        Oddelenie oddelenie10 = new Oddelenie(-13);
        Oddelenie oddelenie11 = new Oddelenie(2);


        oddelenie1.pridajPodOddelenie(oddelenie2);
        oddelenie1.pridajPodOddelenie(oddelenie3);
        oddelenie1.pridajPodOddelenie(oddelenie4);
        oddelenie2.pridajPodOddelenie(oddelenie5);
        oddelenie2.pridajPodOddelenie(oddelenie6);
        oddelenie3.pridajPodOddelenie(oddelenie7);
        oddelenie4.pridajPodOddelenie(oddelenie8);
        oddelenie4.pridajPodOddelenie(oddelenie9);
        oddelenie4.pridajPodOddelenie(oddelenie10);
        oddelenie8.pridajPodOddelenie(oddelenie11);

        System.out.println(oddelenie1.toString());
        System.out.println("Richest department: " + oddelenie1.richestDepartment());
    }
}