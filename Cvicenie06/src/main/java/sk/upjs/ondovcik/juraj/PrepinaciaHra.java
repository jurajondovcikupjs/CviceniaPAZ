package sk.upjs.ondovcik.juraj;

import java.awt.Color;
import java.awt.event.MouseEvent;

import sk.upjs.jpaz2.*;


public class PrepinaciaHra extends WinPane {
    /**
     * Policka hracej dosky
     */
    private boolean[][] doska = new boolean[6][6];

    /**
     * Indikuje, ci hra bezi (hra konci, ked sa dosiahlo vyherne rozlozenie)
     */
    private boolean hraBezi = true;

    public PrepinaciaHra() {
        this.kresliMriezku();
        this.zamiesaj(30);
        this.kresliDosku();
    }

    /**
     * Nakresli mriezku
     */
    public void kresliMriezku() {
        Turtle k = new Turtle();
        this.add(k);

        for (int i = 1; i < 6; i++) {
            k.setPosition(i * 50, 0);
            k.moveTo(i * 50, this.getHeight());
        }

        for (int i = 1; i < 6; i++) {
            k.setPosition(0, i * 50);
            k.moveTo(this.getWidth(), i * 50);
        }

        this.remove(k);
    }

    /**
     * Nakresli farebne kamene na zaklade obsahu policok
     * v this.doska
     */
    public void kresliDosku() {
        // ???
    }

    /**
     * Overi, ci riadok r a stlpec s su platne suradnice
     */
    public boolean dobraSuradnica(int r, int s) {
        return (r >= 0) && (r < 6) && (s >= 0) && (s < 6);
    }

    /**
     * Zrealizuje tah, kedy bolo zatlaceny prepinac na policku
     * v riadku r a stlpci s
     */
    public void tah(int r, int s) {
        int[][] smery = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // ???
    }

    /**
     * Vytvori startovacie rozlozenie kamenov tak, ze spravi
     * zadany pocet nahodnych prepnuti (tahov)
     */
    public void zamiesaj(int pocetMiesani) {
        // ???
    }

    /**
     * Vrati, ci v aktualnom stave policok je kresliaca plocha
     * jednofarebna
     */
    public boolean jeVyherna() {
        return false;
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        // ???
    }

    public static void main(String[] args) {
        new PrepinaciaHra();
    }
}