package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HomeTurtle extends Turtle {

    public void spirala(File subor, int[] cisla, int pocetRiadkov) {
        int cols = cisla.length / pocetRiadkov;
        int[][] mat = new int[pocetRiadkov][cols];
        int idx = 0;
        int top = 0, bottom = pocetRiadkov - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right && idx < cisla.length) {
            for (int i = left; i <= right && idx < cisla.length; i++)
                mat[top][i] = cisla[idx++];
            top++;
            for (int i = top; i <= bottom && idx < cisla.length; i++)
                mat[i][right] = cisla[idx++];
            right--;
            for (int i = right; i >= left && idx < cisla.length; i--)
                mat[bottom][i] = cisla[idx++];
            bottom--;
            for (int i = bottom; i >= top && idx < cisla.length; i--)
                mat[i][left] = cisla[idx++];
            left++;
        }

        try (PrintWriter pw = new PrintWriter(subor)) {
            for (int i = 0; i < pocetRiadkov; i++) {
                for (int j = 0; j < cols; j++) {
                    pw.print(mat[i][j]);
                    if (j < cols - 1) pw.print(" ");
                }
                pw.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Subor sa nenasiel");
        }
    }



}
