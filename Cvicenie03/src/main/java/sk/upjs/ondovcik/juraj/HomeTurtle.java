package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {

    //pomocny stvorec
    public void square(double squareSize, Color fillColor) {
        this.penUp();
        this.openPolygon();
        this.setFillColor(fillColor);
        for (int i = 0; i < 4; i++) {
            this.step(squareSize);
            this.turn(90);
        }
        this.closePolygon();
    }

    //hlavna metoda
    public void squares(double size) {
        double startX = this.getX();
        double startY = this.getY();
        double startDirection = this.getDirection();
        this.penUp();
        //nastavim poziciu na roh
        this.setPosition(startX - size / 2.0, startY - size / 2.0);
        this.turn(90);
        int amount = 0;
        Color fillColor = Color.RED;
        //pocet stvorcov
        while (size > 1) {
            if (amount % 2 == 0) {
                fillColor = Color.RED;
            } else {
                fillColor = Color.BLACK;
            }
            amount++;
            System.out.println(size);
            this.setFillColor(Color.RED);
            this.square(size, fillColor);
            this.step(size / 2);
            this.turn(45);
            size = this.distanceTo(this.getX() + size / 2, this.getY() + size / 2);

        }
        System.out.println("Koniec");
        this.setPosition(startX, startY);
        this.setDirection(startDirection);
    }
    //prvocislo
    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //goldbach
    public int goldbach(int n) {
        //1 nie je prvocislo
        if (n == 1) {
            return -1;
        }
        for (int q = 0; q * q < n ; q++) {
            if (isPrime(n - 2 * q * q)) {
                return n - 2 * q * q;
            }
        }
        return -1;
    }

    //kombinovane cislo
    public int combinedNumber(int n, int m) {
        int position = 1;
        int combinedNumber = 0;
        //kym obe nebudu 0
        while (n != 0 || m != 0) {
            int lastn = n % 10;
            int lastm = m % 10;

            //porovnam a pripocitam vacsie cislo
            if (lastn > lastm) {
                combinedNumber = combinedNumber + lastn * position;
            } else {
                combinedNumber = combinedNumber + lastm * position;
            }
            n = n / 10;
            m = m / 10;
            position = position * 10;
        }
        return combinedNumber;
    }
}
