package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Korytnackovo extends WinPane {

    private Turtle[] turtles;

	public Korytnackovo() {

        this.turtles = new Turtle[10];

        for (int i = 0; i < 10; i++) {
            Turtle turtle = new Turtle();
            this.add(turtle);
            turtle.setPosition(Math.random()*this.getWidth(), Math.random()*this.getHeight());
            this.turtles[i] = turtle;
        }
    }

    void posunITu(int idx, double dlzka) {
        this.turtles[idx].step(dlzka);
    }

    public void nahodneFarby() {
        for (int i = 0; i < 10; i++) {
            Color color = new Color((int) (Math.random()*256),(int) (Math.random()*256),(int) (Math.random()*256));
            this.turtles[i].setPenColor(color);
        }
    }

    Color sFarbouVon(int index) {
        return this.turtles[index].getPenColor();
    }

    public void krok() {
        for (int i = 0; i < 10; i++) {
            int index = i;
            int nextIndex = i + 1;
            if (index == 9) {
                nextIndex = 0;
            }
            this.turtles[index].turnTowards(this.turtles[nextIndex].getPosition());
            this.turtles[index].step(this.turtles[index].distanceTo(this.turtles[nextIndex].getPosition()) / 10);
        }
    }

    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {
        super.onMousePressed(x, y, detail);
        this.turtles[(int) (Math.random() * 10)].setPosition(x,y);
    }

}
