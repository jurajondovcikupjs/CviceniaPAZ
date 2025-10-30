package sk.upjs.ondovcik.juraj;

import java.awt.*;
import java.awt.event.MouseEvent;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet2 extends WinPane {
    /**
     * Referencia na pole korytnaciek
     */
    private Turtle[] korytnacky = null;

    /**
     * Inicializacna metoda (konstruktor)
     */
    public KorytnaciSvet2() {
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

    public double explozia(double x, double y, double sila) {
        double najvacsiaVzdialenost = 0;
        for (int i = 0; i < this.korytnacky.length; i++) {
            this.korytnacky[i].penUp();
            this.korytnacky[i].setDirectionTowards(x, y);
            this.korytnacky[i].turn(180);
            double s = sila;
            double d = Math.sqrt(Math.pow(this.korytnacky[i].getX() - x, 2) + Math.pow(this.korytnacky[i].getY() - y, 2));
            double vzdialenost = Math.pow(sila, 2) / (Math.pow(d, 4));
            this.korytnacky[i].step(vzdialenost);
            if (vzdialenost > najvacsiaVzdialenost) {
                najvacsiaVzdialenost = vzdialenost;
            }
        }
        return najvacsiaVzdialenost;
    }

    public double casDoPrichodu(double x, double y) {
        double najkratsiCas = 0.0;

        //korytnacka sa otoci uhlom mensim k smeru x,y
        //System.out.println(this.korytnacky[0].getDirection() + this.korytnacky[0].directionTowards(x, y));
        //System.out.println(360 - this.korytnacky[0].directionTowards(x, y));

        double otoconieDoprava = this.korytnacky[0].getDirection() + this.korytnacky[0].directionTowards(x, y);
        double otocenieDolava = 360 - this.korytnacky[0].directionTowards(x, y);

        if (otoconieDoprava < otocenieDolava) {
            this.korytnacky[0].turn(otoconieDoprava);
            najkratsiCas += otoconieDoprava;
        } else {
            this.korytnacky[0].turn(-otocenieDolava);
            najkratsiCas += otocenieDolava;
        }

        najkratsiCas += this.korytnacky[0].distanceTo(x, y);

        return najkratsiCas;
    }

    public int najblizsiaKorytnacka(double x, double y) {
        double najmensiaVzdialenost = Double.MAX_VALUE;
        int indexNajblizsej = -1;

        for (int i = 0; i < this.korytnacky.length; i++) {
            double vzdialenost = this.korytnacky[i].distanceTo(x, y);
            if (vzdialenost < najmensiaVzdialenost) {
                najmensiaVzdialenost = vzdialenost;
                indexNajblizsej = i;
            }
        }
        return indexNajblizsej;
    }

    public void prestrelka(int idxPrvehoStrelca, Color farbaStriel) {

        Turtle zasiahnuti[] = new Turtle[this.korytnacky.length];

        this.korytnacky[idxPrvehoStrelca].turnTowards(this.korytnacky[najblizsiaKorytnacka(this.ko)]);

    }

}