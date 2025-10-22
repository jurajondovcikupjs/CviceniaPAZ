package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.awt.event.MouseEvent;

public class ClickPane extends WinPane {

    private int clickCount = 1;
    private boolean wasReset = false;

    private int startX = 0;
    private int startY = 0;

    private int lastX = 0;
    private int lastY = 0;

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);
        if (clickCount == 1) {
            wasReset = false;
        }
        //dufam ze je ok ak sa korytnacka vola korytnacka a nie franklin :)
        Turtle turtle = new Turtle();
        this.add(turtle);
        turtle.setPosition(x, y);
        turtle.setVisible(false);
        if (this.clickCount == 1) {
            this.startX = x;
            this.startY = y;
        }

        if (this.clickCount > 1) {
            turtle.moveTo(this.lastX, this.lastY);
            turtle.dot(10);
            turtle.setDirection(90);
            turtle.printCenter(Integer.toString(this.clickCount - 1));
            turtle.setPosition(x, y);
        }

        if (x >= this.startX - 10 && x <= this.startX + 10 && y >= this.startY - 10 && y <= this.startY + 10 && this.clickCount > 2) {
            turtle.setPosition(this.startX, this.startY);
            this.clickCount = 1;
            wasReset = true;
        }

        turtle.dot(10);
        turtle.setDirection(90);
        turtle.printCenter(Integer.toString(this.clickCount));
        this.lastX = x;
        this.lastY = y;

        if (!wasReset) {
            this.clickCount++;

        }





    }
}
