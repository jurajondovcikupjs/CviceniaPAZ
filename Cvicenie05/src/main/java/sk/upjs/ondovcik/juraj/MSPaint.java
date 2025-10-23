package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MSPaint extends WinPane {

    final Turtle pen;
    private boolean leftPressed;
    private boolean rightPressed;
    private String currentTool = "brush";

    public MSPaint() {
        this.setTitle("MS Paint (2)");
        this.setPosition(100, 50);
        this.resize(1280, 720);
        this.pen = new Turtle();
        this.add(this.pen);
        this.pen.setVisible(false);
        this.pen.setPosition(0, 0);
        drawColorSelector(50,50, Color.BLACK);
        drawColorSelector(80,50, Color.RED);
        drawColorSelector(110,50, Color.GREEN);
        drawColorSelector(140,50, Color.BLUE);
    }

    public void drawColorSelector(int x,int y, Color color) {
        this.pen.setPosition(x,y);
        this.pen.setPenColor(color);
        this.pen.dot(20);
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);

        if (x >= 30 && x <= 70 && y >= 30 && y <= 70) {
            this.pen.setPenColor(Color.BLACK);
            System.out.println("Black selected");
        } else if (x >= 60 && x <= 100 && y >= 30 && y <= 70) {
            this.pen.setPenColor(Color.RED);
            System.out.println("Red selected");
        } else if (x >= 90 && x <= 130 && y >= 30 && y <= 70) {
            this.pen.setPenColor(Color.GREEN);
            System.out.println("Green selected");
        } else if (x >= 120 && x <= 160 && y >= 30 && y <= 70) {
            this.pen.setPenColor(Color.BLUE);
            System.out.println("Blue selected");
        }
    }

    @Override
    protected void onMouseDragged(int x, int y, MouseEvent detail) {
        this.pen.setPosition(x, y);
        if (this.currentTool.equals("brush")) {
            this.pen.dot(10);
        } else if (this.currentTool.equals("pen")) {
           this.pen.moveTo(x,y);
        }

    }

    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {
        super.onMousePressed(x, y, detail);

        if (detail.getButton() == MouseEvent.BUTTON1) {
            this.leftPressed = true;
        } else if (detail.getButton() == MouseEvent.BUTTON3) {
            this.rightPressed = true;
        }
    }

    @Override
    protected void onMouseReleased(int x, int y, MouseEvent detail) {
        super.onMouseReleased(x, y, detail);

        if (detail.getButton() == MouseEvent.BUTTON1) {
            this.leftPressed = false;
        } else if (detail.getButton() == MouseEvent.BUTTON3) {
            this.rightPressed = false;
        }
    }
}
