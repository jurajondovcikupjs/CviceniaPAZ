package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class GrafickyEditor extends WinPane {

    final Turtle pen;
    private boolean leftPressed;

    public GrafickyEditor() {
        this.pen = new Turtle();
        this.add(this.pen);
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);

        this.pen.setPosition(x,y);
    }

    @Override
    protected void onMouseMoved(int x, int y, MouseEvent detail) {
        super.onMouseMoved(x, y, detail);
        if (detail.isAltDown()) {
            Point2D startPos = this.pen.getPosition();
            this.pen.setDirectionTowards(x,y);
            this.pen.moveTo(x,y);
            this.pen.setPosition(startPos);
        }
    }

    @Override
    protected void onMouseDragged(int x, int y, MouseEvent detail) {
        super.onMouseDragged(x, y, detail);

        if (this.leftPressed) {
            this.pen.moveTo(x, y);
        }
    }

    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {
        super.onMousePressed(x, y, detail);

        if (detail.getButton() == MouseEvent.BUTTON1) {
            this.leftPressed = true;
        }
    }

    @Override
    protected void onMouseReleased(int x, int y, MouseEvent detail) {
        super.onMouseReleased(x, y, detail);

        if (detail.getButton() == MouseEvent.BUTTON1) {
            this.leftPressed = false;
        }
    }
}
