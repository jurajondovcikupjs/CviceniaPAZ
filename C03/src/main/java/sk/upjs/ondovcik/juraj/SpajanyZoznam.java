package sk.upjs.ondovcik.juraj;

/**
 * Trieda zapuzdrujuca spajany zoznam a manipulaciu s nim
 */
public class SpajanyZoznam {

    /**
     * Sukromna trieda reprezentujuca jeden uzol spajaneho zoznamu
     */
    private static class Uzol {
        double hodnota;
        Uzol dalsi;
    }

    /**
     * Referencia na prvy uzol spajaneho zoznamu
     */
    private Uzol prvy = null;

    /**
     * Prida novu hodnotu na zaciatok spajaneho zoznamu
     *
     * @param hodnota
     *            pridavana hodnota
     */
    public void pridajNaZaciatok(double hodnota) {
        Uzol pridavany = new Uzol();
        pridavany.hodnota = hodnota;
        pridavany.dalsi = prvy;
        prvy = pridavany;
    }

    @Override
    public String toString() {
        String vysledok = "[";
        Uzol aktualny = prvy;
        while (aktualny != null) {
            if (aktualny != prvy)
                vysledok += ", ";

            vysledok += aktualny.hodnota;
            aktualny = aktualny.dalsi;
        }

        return vysledok + "]";
    }

    public void vlozUsporiadane(double hodnota) {
        Uzol novy = new Uzol();
        novy.hodnota = hodnota;
        if (prvy == null || hodnota <= prvy.hodnota) {
            novy.dalsi = prvy;
            prvy = novy;
            return;
        }
        Uzol aktualny = prvy;
        while (aktualny.dalsi != null && aktualny.dalsi.hodnota < hodnota) {
            aktualny = aktualny.dalsi;
        }
        novy.dalsi = aktualny.dalsi;
        aktualny.dalsi = novy;
    }

    public void odstranZaporne() {
        while (prvy != null && prvy.hodnota < 0) {
            prvy = prvy.dalsi;
        }
        Uzol aktualny = prvy;
        while (aktualny != null && aktualny.dalsi != null) {
            if (aktualny.dalsi.hodnota < 0) {
                aktualny.dalsi = aktualny.dalsi.dalsi;
            } else {
                aktualny = aktualny.dalsi;
            }
        }
    }

    public static void vlozNahodneHodnoty(SpajanyZoznam zoznam, int pocet) {
        for (int i = 0; i < pocet; i++) {
            zoznam.pridajNaZaciatok((int) (500 - Math.random() * 1000) / 10.0);
        }
    }

    public static void vlozNahodneUsporiadaneHodnoty(SpajanyZoznam zoznam, int pocet) {
        int hodnota = (int) (500 + Math.random() * 1000);
        for (int i = 0; i < pocet; i++) {
            zoznam.pridajNaZaciatok(hodnota / 10.0);
            hodnota -= (int) (Math.random() * 100);
        }
    }

    public static void main(String[] args) {
        // Demo
        SpajanyZoznam zoznam = new SpajanyZoznam();
        vlozNahodneHodnoty(zoznam, 20);
        System.out.println("Pred: " + zoznam);
        System.out.println("odstranZaporne()");
        zoznam.odstranZaporne();
        System.out.println("Po: " + zoznam);

        System.out.println();

        zoznam = new SpajanyZoznam();
        vlozNahodneUsporiadaneHodnoty(zoznam, 20);
        //zoznam.pridajNaZaciatok(10);
        System.out.println("Pred: " + zoznam);
        System.out.println("vlozUsporiadane(...)");
        zoznam.vlozUsporiadane(10);
        System.out.println("Po: " + zoznam);
    }
}