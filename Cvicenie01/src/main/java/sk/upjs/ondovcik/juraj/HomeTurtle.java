package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;
import java.awt.Color;

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
        this.setFillColor(Color.RED);
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
    }

}
