package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ClickPane extends WinPane {

    private Turtle franklin;
    private double[][] dots;
    private int dotsCount;

    public ClickPane() {
        this.franklin = new Turtle();
        this.franklin.setFillColor(Color.red);
        this.add(this.franklin);
        this.franklin.setTransparency(1.0);

        this.dots = new double[1000][3];
        this.dotsCount = 0;

        loadClicksFromFile("dots.txt");
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        // lave tlacidlo
        if (detail.getButton() == MouseEvent.BUTTON1) {
            double r = Math.random() * 9 + 2;
            // nakreslit bodku
            this.franklin.setPosition(x, y);
            this.franklin.dot(r);

            // vlozit bodku do pola
            this.dots[this.dotsCount][0] = x;
            this.dots[this.dotsCount][1] = y;
            this.dots[this.dotsCount][2] = r;
            this.dotsCount++;
        }
        // prave tlacidlo
        if (detail.getButton() == MouseEvent.BUTTON3) {
            saveClicksToFile("dots.txt");
        }
    }

    public void saveClicksToFile(String filename) {
        System.out.println("saving");
        // otvorit subor na zapis - writing
        // cyklus cez kazdu bodku -> zapis do suboru

        File file = new File(filename);
        try (PrintWriter pw = new PrintWriter(file)) {

            for (int i = 0; i < this.dotsCount; i++) {
                double[] dot = this.dots[i];
                pw.println(dot[0] + " " + dot[1] + " " + dot[2]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("problem");
        }

    }

    public void loadClicksFromFile(String filename) {
        // otvorim subor na citanie
        // prechadzam subor -> kazdu bodku pridam do pola a nakreslim
        System.out.println("loading");
        try (Scanner sc = new Scanner(new File(filename))){
            sc.useLocale(Locale.US);
            while (sc.hasNextDouble()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double r = sc.nextDouble();
                System.out.println(x + " " + y + " " + r);

                drawDot(x, y, r);
                addToArray(x, y, r);

            }

        } catch (FileNotFoundException e) {
            System.out.println("problem");
        }

    }

    public void drawDot(double x, double y, double r) {
        this.franklin.setPosition(x, y);
        this.franklin.dot(r);
    }

    public void addToArray(double x, double y, double r) {
        this.dots[this.dotsCount][0] = x;
        this.dots[this.dotsCount][1] = y;
        this.dots[this.dotsCount][2] = r;
        this.dotsCount++;
    }

}
