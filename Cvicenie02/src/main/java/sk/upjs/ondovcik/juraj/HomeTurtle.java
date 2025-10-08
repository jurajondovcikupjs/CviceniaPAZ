package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class HomeTurtle extends Turtle {

    public void flagOfMalawi(int stepCount, double height) {
        double width = 2.0 * height;
        double startX = this.getX();
        double startY = this.getY();
        double flagStartX = startX - width / 2.0;
        double flagStartY = startY - height / 2.0;
        for (int i = 0; i < stepCount; i++) {
            if (this.getY() <= startY - height / 2.0 + height / 3.0) {
                this.setPenColor(Color.BLACK);
            } else if (this.getY() <= startY - height / 2.0 + 2 * height / 3.0) {
                Color penColor = new Color(206, 17, 38);
                this.setPenColor(penColor);
            } else {
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
    }

    // ... prikazy, ktore obnovia vychodiskovy stav
}

