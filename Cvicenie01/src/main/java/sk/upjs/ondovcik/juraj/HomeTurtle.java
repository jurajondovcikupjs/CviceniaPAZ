package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;
import java.awt.Color;
import java.awt.font.TextHitInfo;

public class HomeTurtle extends Turtle {

    public void arrows(double size) {
        this.penUp();
        this.step(size);
        this.penDown();
        this.turn(-90);
        this.step(size / 2);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size / 2);
        this.turn(-90);
        this.penUp();
        this.step(size);
        this.turn(90);
        this.step(size);
        this.turn(-90);
        this.penDown();
        this.step(size / 2);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size / 2);
        this.turn(-90);
        this.penUp();
        this.step(size);
        this.turn(90);
        this.step(size);
        this.turn(-90);
        this.penDown();
        this.step(size / 2);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size / 2);
        this.turn(-90);
        this.penUp();
        this.step(size);
        this.turn(90);
        this.step(size);
        this.turn(-90);
        this.penDown();
        this.step(size / 2);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size);
        this.turn(120);
        this.step(size / 2);
        this.turn(-90);
        this.penUp();
        this.step(size);
        this.turn(90);
        this.penDown();
    }

    public void cog(double size) {
        this.penUp();
        this.openPolygon();
        this.turn(90);
        this.step(size);
        this.turn(-120);
        this.step(size);
        this.turn(-60);
        this.step(size);
        this.turn(-60);
        this.step(size);
        this.turn(-120);
        this.step(size);
        this.closePolygon();
        this.turn(-90);
    }

    public void tripleCog(double size) {
        this.cog(size);
        this.turn(-90);
        this.step(size);
        this.turn(-120);
        this.step(size);
        this.turn(90);
        this.cog(size);
        this.turn(-90);
        this.step(size);
        this.turn(-120);
        this.step(size);
        this.turn(90);
        this.cog(size);
        this.turn(-90);
        this.step(size);
        this.turn(-120);
        this.step(size);
        this.turn(90);
        this.penDown();
    }

    public void hexagon(double size) {
        this.penUp();
        this.step(size);
        this.penDown();
        this.turn(120);
        for (int i = 0; i < 6; i++) {
            this.step(size);
            this.turn(360 / 6);
        }
        this.turn(-120);
        this.penUp();
        this.step(-size);
        this.penDown();
    }

    public void beehive(double size) {
        this.hexagon(size);
        this.penUp();
        this.turn(- 60);
        this.step(size);
        this.turn( 60);
        this.step(size);
        this.penDown();
        this.hexagon(size);
        this.penUp();
        this.step(-size);
        this.turn(-120);
        this.step(size);
        this.penDown();
        this.hexagon(size);
        this.penUp();
        this.turn(-120);
        this.step(size);
        this.turn(60);
        this.step(size);
        this.penDown();
        this.hexagon(size);
        this.penUp();
        this.step(-size);
        this.turn(-60);
        this.step(size);
        this.step(size);
        this.penDown();
        this.hexagon(size);
        this.penUp();
        this.turn(60);
        this.step(-size);
        this.turn(-120);
        this.step(size);
        this.penDown();
        this.hexagon(size);
        this.penUp();
        this.step(-size);
        this.turn(-60);
        this.step(size);
        this.step(size);
        this.penDown();
        this.hexagon(size);
        this.penUp();
        this.step(-size);
        this.turn(-120);
        this.step(size);
        this.turn(120);
        this.penDown();
    }

}
