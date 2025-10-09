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
        double radius = height / 6.0;
        double circlePointX = startX;
        double circlePointY = startY - height / 6.0;

        for (int i = 0; i < stepCount; i++) {
            //ak je korytnacka v hornej tretine, tak farba cierna
            // farby su RGB podla obrazka vlajky
            if (this.getY() <= startY - height / 2.0 + height / 3.0) {
                // no ale ak je v kruhu, tak cervena
                this.setPenColor(Color.BLACK);

                //vzdialenost od stredu slnka
                if (this.distanceTo(circlePointX, circlePointY) <= radius) {
                    this.setPenColor(new Color(206, 17, 38));
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

    // pomocna funkcia pre jeden trojuholnik
    public void triangle(double sideLength) {
        this.openPolygon();
        this.turn(90);
        this.step(sideLength / 2.0);
        this.turn(-120);
        this.step(sideLength);
        double pointX = this.getX();
        double pointY = this.getY();
        this.turn(-120);
        this.step(sideLength);
        this.turn(-120);
        this.step(sideLength / 2.0);
        this.turn(-90);
        this.setPosition(pointX, pointY);
        this.closePolygon();
        this.step(- sideLength / 2.0);
    }

    public void littleTree(int levelCount, double width) {
        // premenne
        double startX = this.getX();
        double startY = this.getY();
        double startDirection = this.getDirection();
        Color fillColorLight = new Color(0, 153, 0);
        Color fillColorDark = new Color(0, 130, 0);

        // kmen
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

        // koruna
        for (int i = 0; i < levelCount; i++) {
            if (i % 2 == 0) {
                this.setFillColor(fillColorLight);
            } else {
                this.setFillColor(fillColorDark);
            }
            this.triangle(width);
            width = width * 0.8;
        }
        // navrat do povodneho stavu
        this.setPosition(startX, startY);
        this.setDirection(startDirection);
    }
}

