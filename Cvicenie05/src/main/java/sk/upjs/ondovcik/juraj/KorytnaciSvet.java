package sk.upjs.ondovcik.juraj;

import java.awt.event.MouseEvent;
import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet extends WinPane {
    /**
     * Referencia na pole korytnaciek
     */
    private Turtle[] korytnacky = null;

    /**
     * Inicializacna metoda (konstruktor)
     */
    public KorytnaciSvet() {
        this.korytnacky = new Turtle[0];
    }

    /**
     * Metoda na pridanie korytnacky na zadanych suradniciach
     */
    public void pridajKorytnacku(int x, int y) {
        Turtle novaKorytnacka = new Turtle();
        this.add(novaKorytnacka);
        novaKorytnacka.setPosition(x, y);

        Turtle[] noveKorytnacky = new Turtle[this.korytnacky.length + 1];
        System.arraycopy(this.korytnacky, 0, noveKorytnacky, 0, this.korytnacky.length);
        noveKorytnacky[noveKorytnacky.length - 1] = novaKorytnacka;

        this.korytnacky = noveKorytnacky;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        if (!(detail.isAltDown() || detail.isControlDown() || detail.isShiftDown())) {
            this.pridajKorytnacku(x, y);
        }
    }

    public void vystrelNaTazisko() {
        double allX = 0;
        double allY = 0;
        for (int j = 0; j < this.korytnacky.length; j++) {
            allX += this.korytnacky[j].getX();
            allY += this.korytnacky[j].getY();
        }
        for (int i = 0; i < this.korytnacky.length; i++) {
            double oldX = this.korytnacky[i].getX();
            double oldY = this.korytnacky[i].getY();
            this.korytnacky[i].moveTo(allX / (double) this.korytnacky.length, allY / (double) this.korytnacky.length);
            this.korytnacky[i].setPosition(oldX, oldY);
        }
    }

    public int[] histogram(double x, double y, double d) {

        int[] pole = new int[korytnacky.length];

        for (int k = 0; k < korytnacky.length; k++) {
            int zona = (int) (this.korytnacky[k].distanceTo(x, y) / d);

        }

        return pole;
    }

    public void testHistogram(double x, double y, double d) {
        int[] p = this.histogram(x, y, d);
        System.out.print("histogram(" + x + ", " + y + ", " + d + "): ");
        System.out.println(Arrays.toString(p));
    }

    public void doStvorca(double dlzkaStrany) {

        double medzera = dlzkaStrany / (korytnacky.length / 4.0 + 1);
        Turtle pomoc = new Turtle();
        pomoc.setVisible(true);
        this.add(pomoc);

        //pomoc.penUp();
        pomoc.step(dlzkaStrany / 2.0);
        pomoc.turn(90);
        pomoc.step(- dlzkaStrany / 2.0);
        pomoc.step(medzera);
        for (int i = 0; i < korytnacky.length; i++) {
            for (int j = 0; j < this.korytnacky.length / 4; j++) {
                korytnacky[i].setPosition(pomoc.getX(), pomoc.getY());
                pomoc.step(medzera);
            }
            pomoc.turn(90);
            pomoc.step(medzera);
        }
        this.remove(pomoc);
    }
}