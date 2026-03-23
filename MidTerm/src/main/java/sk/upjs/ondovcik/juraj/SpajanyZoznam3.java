package sk.upjs.ondovcik.juraj;

public class SpajanyZoznam3 {

    private static class Uzol {
        double hodnota;
        Uzol dalsi;
    }

    private Uzol prvy = null;

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


    public void priemer() {
        Uzol aktualny = prvy;
        while (aktualny != null) {
            if (aktualny.dalsi != null && aktualny.dalsi.dalsi != null) {
                double sucet = aktualny.hodnota + aktualny.dalsi.hodnota + aktualny.dalsi.dalsi.hodnota;
                aktualny.hodnota = sucet / 3;
                aktualny.dalsi = aktualny.dalsi.dalsi.dalsi;
                aktualny = aktualny.dalsi;
            } else if (aktualny.dalsi != null) {
                double sucet = aktualny.hodnota + aktualny.dalsi.hodnota;
                aktualny.hodnota = sucet / 2;
                aktualny.dalsi = aktualny.dalsi.dalsi;
                aktualny = aktualny.dalsi;
            } else {
                aktualny = aktualny.dalsi;
            }

        }
    }

    public static void main(String[] args) {
        SpajanyZoznam3 zoznam = new SpajanyZoznam3();
        zoznam.pridajNaZaciatok(18);
        zoznam.pridajNaZaciatok(17);
        zoznam.pridajNaZaciatok(10);
        zoznam.pridajNaZaciatok(10);
        zoznam.pridajNaZaciatok(10);
        System.out.println(zoznam);
        zoznam.priemer();
        System.out.println(zoznam);
    }
}