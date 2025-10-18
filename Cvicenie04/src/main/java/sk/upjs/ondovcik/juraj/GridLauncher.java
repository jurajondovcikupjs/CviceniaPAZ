package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.ObjectInspector;

import java.awt.*;

public class GridLauncher {

    public static void main(String[] args) {
        GridPane g = new GridPane();
        g.drawGrid();

        g.drawDot(5, 3, Color.PINK);
        g.drawDot(2, 1, Color.blue);
        ObjectInspector oi = new ObjectInspector();
        oi.inspect(g);
    }
}
