package sk.upjs.ondovcik.juraj;

import java.awt.*;
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

        double najkratsiCas = Double.POSITIVE_INFINITY;

        //pre kazdu korytnacku vypocitame cas: minimalny uhol pre otocenie + vzdialenost
        for (int i = 0; i < this.korytnacky.length; i++) {
            Turtle t = this.korytnacky[i];
            double aktualnySmer = t.getDirection();
            double smerNaCiel = t.directionTowards(x,y);

            //vypocitame uhol otocenia
            double uholOtocenia = Math.abs(smerNaCiel - aktualnySmer);
            if (uholOtocenia > 180.0) {
                uholOtocenia = 360.0 - uholOtocenia;
            }

            double vzdialenost = t.distanceTo(x, y);
            double cas = uholOtocenia + vzdialenost;

            if (cas < najkratsiCas) {
                najkratsiCas = cas;
            }
        }


        return najkratsiCas;
    }

    public int najblizsiaKorytnacka(double x, double y, int excludeIdx, boolean[] zasiahnuti) {

        // najde index najblizsej korytnacky na suradniciach x,y okrem excludeIdx
        double najmensiaVzdialenost = Double.MAX_VALUE;
        int indexNajblizsej = -1;

        for (int i = 0; i < this.korytnacky.length; i++) {
            // vynecha korytnacku s indexom excludeIdx (teda seba)
            if (i == excludeIdx) {
                continue;
            }
            double vzdialenost = this.korytnacky[i].distanceTo(x, y);
            // ak je tato korytnacka blizsie ako doteraz najblizsia a este nebola zasiahnuta
            if (vzdialenost < najmensiaVzdialenost && !jeZasiahnuta(i, zasiahnuti)) {
                najmensiaVzdialenost = vzdialenost;
                indexNajblizsej = i;
            }
        }
        return indexNajblizsej;
    }

    // metoda vrati true, ak je korytnacka s danym indexom zasiahnuta
    public boolean jeZasiahnuta(int idxKorytnacky, boolean[] zasiahnuti) {
        for (int i = 0; i < zasiahnuti.length; i++) {
            if (i == idxKorytnacky && zasiahnuti[i]) {
                return true;
            }
        }
        return false;
    }

    // metoda vykresli strelu z (x1, y1) do (x2, y2) s danou farbou
    public void strela(double x1, double y1, double x2, double y2, Color farbaStriel) {
        Turtle strela = new  Turtle();
        this.add(strela);
        strela.setPosition(x1, y1);
        strela.setPenColor(farbaStriel);
        strela.penDown();
        strela.turnTowards(x2, y2);
        strela.step(strela.distanceTo(x2, y2));
        this.remove(strela);
    }


    public void prestrelka(int idxPrvehoStrelca, Color farbaStriel) {

        //lokalne pole na sledovanie zasiahnutych korytnaciek
        boolean zasiahnuti[] = new boolean[this.korytnacky.length];
        int aktualnyStrelecIdx = idxPrvehoStrelca;

        while (true) {
            // ziskame referenciu na aktualneho strelca
            Turtle strelec = this.korytnacky[aktualnyStrelecIdx];

            // najdeme najblizsiu korytnacku, ktoru este nezasiahol
            int idxCielu = this.najblizsiaKorytnacka(strelec.getX(), strelec.getY(), aktualnyStrelecIdx, zasiahnuti);
            if (idxCielu == -1) {
                break; // vsetky korytnacky su zasiahnute, koncime prestrelku
            }
            // ak sme nasli ciel, vystrelime na neho
            Turtle ciel = this.korytnacky[idxCielu];
            strela(strelec.getX(), strelec.getY(), ciel.getX(), ciel.getY(), farbaStriel);
            zasiahnuti[idxCielu] = true;
            // nastavime noveho strelca na praveho zasiahnuteho
            aktualnyStrelecIdx = idxCielu;
            strelec.turnTowards(ciel.getX(), ciel.getY());
        }
    }
}