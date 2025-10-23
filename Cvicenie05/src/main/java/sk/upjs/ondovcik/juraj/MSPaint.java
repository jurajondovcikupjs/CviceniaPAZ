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
        drawColorSelector(100,50, Color.RED);
        drawColorSelector(150,50, Color.GREEN);
        drawColorSelector(200,50, Color.BLUE);
    }

    public void drawColorSelector(int x,int y, Color color) {
        this.pen.setPosition(x,y);
        this.pen.setFillColor(color);
        this.pen.dot(20);
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);

        if (x >= 30 && x <= 70 && y >= 30 && y <= 70) {
            this.pen.setFillColor(Color.BLACK);
            System.out.println("Black selected");
            drawColorSelector(50,50, Color.BLACK);
        } else if (x >= 80 && x <= 120 && y >= 30 && y <= 70) {
            this.pen.setFillColor(Color.RED);
            System.out.println("Red selected");
            drawColorSelector(100,50, Color.RED);
        } else if (x >= 130 && x <= 170 && y >= 30 && y <= 70) {
            this.pen.setFillColor(Color.GREEN);
            System.out.println("Green selected");
            drawColorSelector(150,50, Color.GREEN);
        } else if (x >= 180 && x <= 220 && y >= 30 && y <= 70) {
            this.pen.setFillColor(Color.BLUE);
            System.out.println("Blue selected");
            drawColorSelector(200,50, Color.BLUE);
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
