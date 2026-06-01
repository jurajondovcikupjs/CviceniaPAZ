package sk.upjs.ondovcik.juraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mesto {
    private String name;
    private double fastTime;
    private double slowTime;
    private double fastPrice;
    private double slowPrice;

    public Mesto(String name, double fastTime, double slowTime, double fastPrice, double slowPrice) {
        this.name = name;
        this.fastTime = fastTime;
        this.slowTime = slowTime;
        this.fastPrice = fastPrice;
        this.slowPrice = slowPrice; // OPRAVENÉ: Tu bol preklep (slowTime)
    }

    public String getName() {
        return name;
    }

    public double getFastTime() {
        return fastTime;
    }

    public double getSlowTime() {
        return slowTime;
    }

    public double getFastPrice() {
        return fastPrice;
    }

    public double getSlowPrice() {
        return slowPrice;
    }

    public static void main(String[] args) {
        double timeLimit = 15.0;
        Mesto M1 = new Mesto("M1", 3.0, 5.0, 50.0, 120.0);
        Mesto M2 = new Mesto("M2", 4.0, 9.0, 30.0, 70.0);
        Mesto M3 = new Mesto("M3", 3.0, 4.0, 70.0, 90.0);

        Mesto[] mesta = new Mesto[]{M1, M2, M3};
        double[][] matrix = new double[mesta.length + 1][(int) timeLimit + 1];

        // Inicializácia na -1 (reprezentuje nedosiahnuteľný čas)
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], -1);
        }
        matrix[0][0] = 0; // Na začiatku (v čase 0) je cena 0
        //matrix[0][3] = 5;

        // Plnenie matice
        for (int j = 1; j < matrix.length; j++) {
            if (j == 1) {
                matrix[j][(int) mesta[j - 1].getSlowTime()] = (int) mesta[j - 1].getSlowPrice();
                matrix[j][(int) mesta[j - 1].getFastTime()] = (int) mesta[j - 1].getFastPrice();
            } else {
                for (int t = 0; t <= timeLimit; t++) {
                    if (matrix[j - 1][t] != -1) { // Ak je tento čas dosiahnuteľný
                        // Skúšame pomalú cestu
                        int slowTime = (int) mesta[j - 1].getSlowTime();
                        if (t + slowTime <= timeLimit) {
                            int novyCas = t + (int) slowTime;

                            // Použijeme tvoju premennú getSlowPrice(), ale vnímame ju ako zisk
                            double novyZisk = matrix[j - 1][t] + mesta[j - 1].getSlowPrice();

                            // Ak je políčko prázdne (-1) ALEBO sme našli väčší zisk
                            if (matrix[j][novyCas] == -1 || novyZisk > matrix[j][novyCas]) {
                                matrix[j][novyCas] = novyZisk;
                            }
                        }

                        // Skúšame rýchlu cestu
                        int fastTime = (int) mesta[j - 1].getFastTime();
                        if (t + fastTime <= timeLimit) {
                            int novyCas = t + (int) fastTime;

                            // Použijeme tvoju premennú getSlowPrice(), ale vnímame ju ako zisk
                            double novyZisk = matrix[j - 1][t] + mesta[j - 1].getFastPrice();

                            // Ak je políčko prázdne (-1) ALEBO sme našli väčší zisk
                            if (matrix[j][novyCas] == -1 || novyZisk > matrix[j][novyCas]) {
                                matrix[j][novyCas] = novyZisk;
                            }
                        }
                    }
                }
            }
        }

        //rekonštrukcia
        double max = Double.MIN_VALUE;
        int index = 0;
        List<Boolean> choices = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1][i] > max) {
                max = matrix[matrix.length - 1][i];
                index = i;
            }
        }
        //System.out.println("Maximálny zisk: " + max);
        for (int i = matrix.length - 1; i > 0; i--) {
            if (index - (int) mesta[i - 1].getFastTime() >= 0 && matrix[i][index] == matrix[i - 1][index - (int) mesta[i - 1].getFastTime()] + mesta[i - 1].getFastPrice()) {
                choices.add(true); // Rýchla cesta
                index -= (int) mesta[i - 1].getFastTime();
            } else if (index - (int) mesta[i - 1].getSlowTime() >= 0 && matrix[i][index] == matrix[i - 1][index - (int) mesta[i - 1].getSlowTime()] + mesta[i - 1].getSlowPrice()) {
                choices.add(false); // Pomalá cesta
                index -= (int) mesta[i - 1].getSlowTime();
            }
        }
        Collections.reverse(choices);




        // Pekné vypísanie matice s indexmi
        System.out.print("Čas (ID) : ");
        for (int j = 0; j <= timeLimit; j++) System.out.printf("%5d ", j);
        System.out.println("\n----------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i == 0 ? "Štart    : " : "Mesto M" + i + " : ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    System.out.print("    . "); // Prehľadnejšie ako -1.0
                } else {
                    System.out.printf("%5.0f ", matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println(choices);
    }
}