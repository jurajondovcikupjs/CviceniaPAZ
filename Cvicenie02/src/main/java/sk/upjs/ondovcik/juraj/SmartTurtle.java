package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.awt.*;


public class SmartTurtle extends Turtle {

    public void isosceles(double legLength, double angle) {
        this.turn(angle / 2);
        this.step(legLength);
        double x = this.getX();
        double y = this.getY();
        this.step(-legLength);
        this.turn(angle);
        this.step(legLength);
        this.moveTo(x, y);
    }

    public void mill(double armAmount, double armLength) {
        for (int i = 0; i < armAmount; i++) {
            this.isosceles(armLength, 45);
            this.turn(-45);
            this.step(- armLength);
            this.turn(45 / 2);
            this.turn((360 - (armAmount * 45)) / armAmount);

        }
    }

    public void dotCircle(int stepCount, double radius) {
        double startX = this.getX();
        double startY = this.getY();
        for (int i = 0; i < stepCount; i++) {
            this.turn(Math.random() * 360);
            this.setPenColor(Color.RED);
            this.step(5);

            if (this.getX() > (radius / 2 + startX) || this.getX() < (startX - radius / 2) || this.getY() > (radius / 2 + startY) || this.getY() < (startY - radius / 2)) {
                this.step(-5);
            }
        }
        this.setPosition(startX, startY);
    }


}
