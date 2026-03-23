package sk.upjs.ondovcik.juraj;

public class SpajanyZoznam2 {

    private static class Uzol {
        int hodnota;
        Uzol dalsi;
    }

    private Uzol prvy = null;

    public void pridajNaZaciatok(int hodnota) {
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


    public void commercialTime(int length, int threshold)  {
        Uzol aktualny = prvy;
        int count = aktualny.hodnota;
        while (aktualny != null && aktualny.dalsi != null) {
            count += aktualny.dalsi.hodnota;
            if (count > threshold) {
                Uzol novy = new Uzol();
                novy.hodnota = length;
                novy.dalsi = aktualny.dalsi;
                aktualny.dalsi = novy;
                count = 0;
            }
            aktualny = aktualny.dalsi;
        }
    }

    public static void main(String[] args) {
        SpajanyZoznam2 zoznam = new SpajanyZoznam2();
        zoznam.pridajNaZaciatok(40);
        zoznam.pridajNaZaciatok(15);
        zoznam.pridajNaZaciatok(10);
        zoznam.pridajNaZaciatok(50);
        zoznam.pridajNaZaciatok(20);
        zoznam.pridajNaZaciatok(30);
        System.out.println(zoznam);
        zoznam.commercialTime(3, 50);
        System.out.println(zoznam);
    }
}
