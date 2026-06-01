package sk.upjs.ondovcik.juraj;

import java.util.Arrays;

public class Train {

    public static void main(String[] args) {
        int[] vozne = new int[]{3,4,6,1};
        int sucetVoznov = 14; //hardcoded pre jednoduchost zatial
        boolean[] tabulka = new boolean[sucetVoznov / 2 + 1];

        tabulka[0] = true;
        for (int v = 0; v < vozne.length; v++) {
            for (int t = tabulka.length - 1 - vozne[v]; t >= 0; t--) {
                if (tabulka[t]) {
                    tabulka[t + vozne[v]] = true;
                }
            }
        }
        System.out.println(Arrays.toString(tabulka));
        System.out.println(tabulka[tabulka.length - 1] ? "Ano" : "Nie");
    }

}
