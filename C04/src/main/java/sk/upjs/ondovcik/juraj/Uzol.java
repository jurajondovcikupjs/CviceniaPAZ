package sk.upjs.ondovcik.juraj;

import java.util.Set;

public class Uzol {
    private int hodnota;
    private Uzol lavy;
    private Uzol pravy;

    public Uzol(int hodnota, Uzol lavy, Uzol pravy) {
        this.hodnota = hodnota;
        this.lavy = lavy;
        this.pravy = pravy;
    }

    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lavy != null)
            sb.append("(" + lavy.toString() + ") ");

        sb.append(hodnota);

        if (pravy != null)
            sb.append(" (" + pravy.toString() + ")");

        return sb.toString();
    }

    public boolean jeVyvazeny() {
        int lavyPocet = pocetUzlov(lavy);
        int pravyPocet = pocetUzlov(pravy);
        if (Math.abs(lavyPocet - pravyPocet) > 1) {
            return false;
        }
        boolean lavyVyvazeny = (lavy == null) || lavy.jeVyvazeny();
        boolean pravyVyvazeny = (pravy == null) || pravy.jeVyvazeny();
        return lavyVyvazeny && pravyVyvazeny;
    }

    private int pocetUzlov(Uzol uzol) {
        if (uzol == null) {
            return 0;
        }
        return 1 + pocetUzlov(uzol.lavy) + pocetUzlov(uzol.pravy);
    }

    public static Uzol vytvorBVS(Set<Integer> hodnoty) {
        if (hodnoty == null || hodnoty.isEmpty()) {
            return null;
        }
        // Preveď hodnoty do zoradeného poľa
        int[] pole = hodnoty.stream().sorted().mapToInt(Integer::intValue).toArray();
        return vytvorBVSZoZoradenehoPola(pole, 0, pole.length - 1);
    }

    private static Uzol vytvorBVSZoZoradenehoPola(int[] pole, int lavy, int pravy) {
        if (lavy > pravy) {
            return null;
        }
        int stred = lavy + (pravy - lavy) / 2;
        Uzol lavyPodstrom = vytvorBVSZoZoradenehoPola(pole, lavy, stred - 1);
        Uzol pravyPodstrom = vytvorBVSZoZoradenehoPola(pole, stred + 1, pravy);
        return new Uzol(pole[stred], lavyPodstrom, pravyPodstrom);
    }
}