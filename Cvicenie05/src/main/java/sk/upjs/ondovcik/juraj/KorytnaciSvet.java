package sk.upjs.ondovcik.juraj;

import java.awt.event.MouseEvent;
import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet extends AnimatedWinPane {
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
        //sucet vsetkych x a y
        double allX = 0;
        double allY = 0;
        //prejdenie vsetkych korytnaciek a spocitanie ich x a y
        for (int j = 0; j < this.korytnacky.length; j++) {
            allX += this.korytnacky[j].getX();
            allY += this.korytnacky[j].getY();
        }
        //nastavenie kazdej korytnacky na tazisko a vratit ju naspat
        for (int i = 0; i < this.korytnacky.length; i++) {
            double oldX = this.korytnacky[i].getX();
            double oldY = this.korytnacky[i].getY();
            this.korytnacky[i].moveTo(allX / (double) this.korytnacky.length, allY / (double) this.korytnacky.length);
            this.korytnacky[i].setPosition(oldX, oldY);
        }
    }

    public int[] histogram(double x, double y, double d) {
        //najst najvzdialenejsiu korytnacku
        double dist = 0;
        int index = 0;
        for (int i = 0; i < korytnacky.length; i++) {
            if (this.korytnacky[i].distanceTo(x, y) > dist) {
                dist = this.korytnacky[i].distanceTo(x, y);
                index = i;
            }
        }
        //System.out.println("Najvzdialenejsia korytnacka je na indexe: " + index);
        int[] pole = new int[ (int) (this.korytnacky[index].distanceTo(x, y) / d) + 1];
        //for (int i = 0; i < korytnacky.length; i++) {
        //    System.out.println(korytnacky[i].distanceTo(x, y));
        //}

        //upravenie pola - histogramu
        for (int k = 0; k < korytnacky.length; k++) {
            int zona = (int) ((this.korytnacky[k].distanceTo(x, y) / d));
            pole[zona]++;

        }

        return pole;
    }

    public void testHistogram(double x, double y, double d) {
        int[] p = this.histogram(x, y, d);
        System.out.print("histogram(" + x + ", " + y + ", " + d + "): ");
        System.out.println(Arrays.toString(p));
    }

    public void doStvorca(double dlzkaStrany) {
        //vypocitat medzeru medzi korytnackami a plus pomocna korytnacka
        double medzera = dlzkaStrany / (this.korytnacky.length / 4.0 + 1);
        Turtle pomoc = new Turtle();
        pomoc.setVisible(true);
        this.add(pomoc);
        //na zaciatok
        pomoc.penUp();
        pomoc.step(dlzkaStrany / 2.0);
        pomoc.turn(90);
        pomoc.step(- (dlzkaStrany / 2.0));
        pomoc.step(medzera);
        //rozmiestnit korytnacky
        for (int i = 0; i < this.korytnacky.length; i++) {
            korytnacky[i].setPosition(pomoc.getX(), pomoc.getY());
            pomoc.step(medzera);
            if (i % (this.korytnacky.length / 4) == (this.korytnacky.length / 4) - 1) {
                pomoc.turn(90);
                pomoc.step(medzera);
            }
        }
        this.remove(pomoc);
    }
}