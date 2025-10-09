package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {

    public void flagOfMalawi(int stepCount, double height) {
        // zakladne premenne a ich hodnoty
        double width = 2.0 * height;
        double startX = this.getX();
        double startY = this.getY();
        double startDirection = this.getDirection();

        for (int i = 0; i < stepCount; i++) {
            //ak je korytnacka v hornej tretine, tak farba cierna
            // farby su RGB podla obrazka vlajky
            if (this.getY() <= startY - height / 2.0 + height / 3.0) {
                // no ale ak je v kruhu, tak cervena
                this.setPenColor(Color.BLACK);
                double centerX = startX;
                double centerY = startY - height / 2.0 + height / 3.0;
                double radius = height / 6.0;
                double dx = this.getX() - centerX;
                double dy = this.getY() - centerY;

                if (dy <= 0 && dx * dx + dy * dy <= radius * radius) {
                    this.setPenColor(new Color(206, 17, 38)); // Red semicircle
                }

            } else if (this.getY() <= startY - height / 2.0 + 2 * height / 3.0) {
                //ak je korytnacka v strednej tretine, tak farba cervena
                Color penColor = new Color(206, 17, 38);
                this.setPenColor(penColor);
            } else {
                //a ak je zase v dolnej tretine, tak farba zelena
                Color penColor = new Color(51, 158, 53);
                this.setPenColor(penColor);
            }

            this.turn(Math.random() * 360);
            this.step(5);

            // ... prikazy, resp. podmienka, ktore zabezpecia, ze korytnacka
            // nevyjde mimo definovanej obdlznikovej oblasti
            if (this.getX() < (startX - width / 2.0) || this.getX() > (startX + width / 2.0) || this.getY() < (startY - height / 2.0) || this.getY() > (startY + height / 2.0)) {
                this.step(-5);
            }
        }

        // ... prikazy, ktore obnovia vychodiskovy stav
        this.setPosition(startX, startY);
        this.setDirection(startDirection);
    }

    public void littleTree(int levelCount, double width) {
        double startX = this.getX();
        double startY = this.getY();
        double startDirection = this.getDirection();

        this.setFillColor(new Color(153 , 76, 0));
        this.penUp();
        this.openPolygon();
        this.turn(90);
        this.step(width / 8.0);
        this.turn(-90);
        this.step(width / 8.0);
        this.turn(-90);
        this.step(width / 4.0);
        this.turn(-90);
        this.step(width / 8.0);
        this.turn(-90);
        this.step(width / 8.0);
        this.turn(-90);
        this.step(width / 8.0);
        this.closePolygon();

    }
}

