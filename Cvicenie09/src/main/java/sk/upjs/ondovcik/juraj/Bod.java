package sk.upjs.ondovcik.juraj;

public class Bod {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public void nastav(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void nastav(Bod bod) {
        this.x = bod.x;
        this.y = bod.y;
    }

    public boolean rovnakeSuradnice(Bod bod) {
        return this.x == bod.x && this.y == bod.y;
    }

    public double vzdialenostK(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double vzdialenostK(Bod bod) {
        return vzdialenostK(bod.x, bod.y);
    }

    public void posunO(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void posunutyBod(double dx, double dy) {

    }
}
