package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.util.Arrays;

public class Poliarka extends Turtle {

    public double priemer(int[] pole) {
        double sucet = 0;
        for (int i = 0; i < pole.length; i++) {
            sucet += pole[i];
        }
        System.out.println(sucet / pole.length);
        return sucet / pole.length;
    }

    public int pocetOpakovani(int[] pole, int cislo) {
        int pocet = 0;
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == cislo) {
                pocet++;
            }
        }
        System.out.println(pocet);
        return pocet;
    }

    public int[] zdvojPole(int[] pole) {
        int[] novePole = new int[pole.length * 2];
        for (int i = 0; i < pole.length; i++) {
            novePole[i * 2] = pole[i];
            novePole[i * 2 + 1] = pole[i];
        }
        System.out.println(Arrays.toString(novePole));
        return novePole;
    }

    public boolean jeNeklesajuce(int[] pole) {
        for (int i = 0; i < pole.length - 1; i++) {
            if (pole[i] > pole[i + 1]) {
                System.out.println("Pole nie je neklesajuce");
                return false;
            }
        }
        System.out.println("Pole je neklesajuce");
        return true;
    }

    public int indexNajmensieho(int[] pole, int start, int koniec) {
        int indexNajmensieho = start;
        for (int i = start; i <= koniec; i++) {
            if (pole[i] < pole[indexNajmensieho]) {
                indexNajmensieho = i;
            }
        }
        System.out.println(indexNajmensieho);
        return indexNajmensieho;
    }

    public void vymen(int[] pole, int idx1, int idx2) {
        int temp = pole[idx1];
        pole[idx1] = pole[idx2];
        pole[idx2] = temp;
        System.out.println(Arrays.toString(pole));
    }

    public void zahada(int[] pole) {
        for (int i = 0; i < pole.length; i++) {
            vymen(pole, i, indexNajmensieho(pole, i, pole.length - 1));
        }
    }

    public int najcastejsiaHodnota(int[] pole) {
        int najcastejsia = pole[0];
        int vyskyt = 0;

        for (int i = 0; i < pole.length; i++) {
            int najcastejsiTemp = pole[i];
            int vyskytTemp = 0;
            for (int j = 0; j < pole.length; j++) {
                if (pole[j] == najcastejsiTemp) {
                    vyskytTemp++;
                }
            }
            if (vyskytTemp > vyskyt) {
                vyskyt = vyskytTemp;
                najcastejsia = najcastejsiTemp;
            }
        }
        System.out.println(najcastejsia);
        return najcastejsia;
    }

    public int[] bezDuplicity(int[] pole) {
        int[] bezDuplicity = new int[pole.length];
        for (int i = 0; i < pole.length; i++) {
            int hodnota = pole[i];
            for (int j = i + 1; j < pole.length; j++) {
                if (hodnota == pole[j]) {
                    continue;
                } else {
                    bezDuplicity[i] = pole[i];
                }
            }
        }
        System.out.println(Arrays.toString(bezDuplicity));
        return bezDuplicity;
    }





}
