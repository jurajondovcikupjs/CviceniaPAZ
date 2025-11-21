package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class Midtermarka extends Turtle {

    public void pumpkinsExhibition(int lines, int columns) {
        Turtle turtle = new Turtle();
        double startX = turtle.getX();
        double startY = turtle.getY();
        double direction = turtle.getDirection();

        this.penUp();
        if (lines <= 0 || columns <= 0) {
            return;
        }

        if (lines % 2 == 0) {
            this.step(1 + lines / 2 * 10 + (lines - 1) / 2 * 2);
        } else {
            this.step((double) lines / 2 * 12);
        }

        this.turn(-90);
        if (columns % 2 == 0) {
            this.step(1 + columns / 2 * 10 + (columns - 1) / 2 * 2);
        } else {
            this.step((double) columns / 2 * 12);
        }
        this.turn(180);
        this.penUp();
        this.setFillColor(Color.orange);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 1 && j == 1 || i == 1 && j == columns - 2) {
                    this.setFillColor(Color.black);
                    this.dot(4);
                    this.setFillColor(Color.orange);
                } else if ((i == lines - 2 && j > 0) && (i == lines - 2 && j < columns - 1)) {
                    this.setFillColor(Color.black);
                    this.dot(4);
                    this.setFillColor(Color.orange);
                } else {
                    this.dot(5);
                }


                this.penUp();
                this.step(12);
            }
            this.penUp();
            this.step(-12 * columns);
            this.turn(90);
            this.step(12);
            this.turn(-90);
            this.penUp();
        }

        this.setPosition(startX, startY);
        this.setDirection(direction);
    }

    public int finePasswords(String s) {
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        int amount = 0;
        s += ' ';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                hasLower = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                hasUpper = true;
            } else if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            } else if (ch == ' ') {
                if (hasLower && hasUpper && hasDigit) {
                    amount++;
                }
                hasLower = false;
                hasUpper = false;
                hasDigit = false;
            }
        }

        return amount;
    }

    //public boolean digitsMultiplied(int n) {

    //}

}
