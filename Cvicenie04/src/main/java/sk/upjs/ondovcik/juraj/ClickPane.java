package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.awt.event.MouseEvent;

public class ClickPane extends WinPane {

    //premenne
    private int clickCount = 0;

    private int startX = 0;
    private int startY = 0;

    private int lastX = 0;
    private int lastY = 0;

    //vyroba bodky
    public void makeADot(int x, int y, int index) {
        Turtle turtle = new Turtle();
        this.add(turtle);
        turtle.setPosition(x, y);
        turtle.dot(10);
        turtle.setDirection(90);
        turtle.printCenter(Integer.toString(index));
        this.remove(turtle);
    }


    //onPressed
    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {
        super.onMousePressed(x, y, detail);
        clickCount++; // zvysime pocitadlo klikov

        if (this.clickCount == 1) { //ak je to prvy klik, tak iba 1 bodku
            this.startX = x;
            this.startY = y;
            makeADot(x, y, 1);
        } else {
            Turtle turtle = new Turtle(); //vytvorim korytnacku na ciaru + bodky
            this.add(turtle);
            if (x >= this.startX - 10 && x <= this.startX + 10 && y >= this.startY - 10 && y <= this.startY + 10) {
                turtle.setPosition(startX, startY); //ak je x a y v okoli startu, tak nastavim na start
            } else {
                turtle.setPosition(x, y);
            }
            turtle.moveTo(this.lastX, this.lastY);
            makeADot((int) turtle.getX(), (int) turtle.getY(), this.clickCount - 1); //bodka na predchadzajucej pozicii
            this.remove(turtle);

            if (x >= this.startX - 10 && x <= this.startX + 10 && y >= this.startY - 10 && y <= this.startY + 10) {
                makeADot(startX, startY, 1); //ak je x a y v okoli startu, tak bodka na starte
                this.clickCount = 0;
            } else {
                makeADot(x, y, this.clickCount);
            }
        }

        this.lastX = x; //ulozenie poslednej pozicie
        this.lastY = y;
    }
}
