package sk.upjs.ondovcik.juraj;

import java.util.Arrays;

public class Matematika {

    private char[] operatory = {'+', '-', '*', '/'};
    private char[] p = new char[3]; // changed from int[] to char[]
    private boolean[] uzBoloPouzite = new boolean[4];

    private void generuj(int odIndexu) {
        if (odIndexu == p.length) {
            if (findOperators(new int[]{10, 5, 4, 2}, 58)) System.out.println(Arrays.toString(p));
            return;
        }
        for (int i = 0; i < operatory.length; i++) {
            if (uzBoloPouzite[i])
                continue;
            uzBoloPouzite[i] = true;
            p[odIndexu] = operatory[i];
            generuj(odIndexu + 1);
            uzBoloPouzite[i] = false;
        }
    }

    public boolean findOperators(int[] numbers, int result) {
        int cislo = numbers[0];
        for (int i = 1; i < p.length + 1; i++) {
            if (p[i - 1] == '+')
                cislo += numbers[i];
            else if (p[i - 1] == '-')
                cislo -= numbers[i];
            else if (p[i - 1] == '*')
                cislo *= numbers[i];
            else if (p[i - 1] == '/')
                cislo /= numbers[i];
        }

        return cislo == result;
    }

    public static void main(String[] args) {
        System.out.println("+:" + (int) '+');
        System.out.println("-:" + (int) '-');
        System.out.println("*:" + (int) '*');
        System.out.println("/:" + (int) '/');
        Matematika matematika = new Matematika();
        matematika.generuj(0);

        //matematika.findOperators(new int[]{10, 5, 4, 2}, 58);
        //System.out.println(matematika.findOperators(new int[]{10, 5, 4, 2}, 58));
    }

}