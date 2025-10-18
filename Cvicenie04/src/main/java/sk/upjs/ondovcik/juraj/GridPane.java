package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GridPane extends WinPane {

    private boolean lastWasRed = false;

    public void drawGrid() {
        Turtle franklin = new Turtle();
        this.add(franklin);

        for (int i = 0; i < 6; i++) {
            franklin.setPosition(i * 50, 0);
            franklin.moveTo(i * 50, 300);
        }

        for (int y = 0; y < 300; y = y + 50) {
            franklin.setPosition(0, y);
            franklin.moveTo(300, y);
        }

        this.remove(franklin);


    }

    public void drawDot(int column, int row, Color dotColor) {
        int x = column * 50 + 25;
        int y = row * 50 + 25;

        Turtle franklin = new Turtle();
        this.add(franklin);

        franklin.setPosition(x, y);
        franklin.setFillColor(dotColor);
        franklin.dot(20);

        this.remove(franklin);
    }

    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        Color c = Color.RED;
        if (this.lastWasRed) {
            c = Color.BLUE;
        }
        this.lastWasRed = !this.lastWasRed;
        int column = x / 50;
        int row = y / 50;
        this.drawDot(column, row, c);
    }


}
