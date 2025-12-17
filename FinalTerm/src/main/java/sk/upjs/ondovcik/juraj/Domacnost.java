package sk.upjs.ondovcik.juraj;

import java.util.Scanner;

public class Domacnost {
    private String meno;
    private String adresa;
    private int pocetObyvatelov;
    private double rocnaSpotreba;
    private boolean kanalizacia;
    private double kapacitaZumpy;
    private int pocetVyvozov;

    public Domacnost(String meno, String adresa, int pocetObyvatelov, double rocnaSpotreba) {
        this.meno = meno;
        this.adresa = adresa;
        this.pocetObyvatelov = pocetObyvatelov;
        this.rocnaSpotreba = rocnaSpotreba;
    }

    public Domacnost(String meno, String adresa, int pocetObyvatelov, double rocnaSpotreba, double kapacitaZumpy, int pocetVyvozov) {
        this.meno = meno;
        this.adresa = adresa;
        this.pocetObyvatelov = pocetObyvatelov;
        this.rocnaSpotreba = rocnaSpotreba;
        this.kapacitaZumpy = kapacitaZumpy;
        this.pocetVyvozov = pocetVyvozov;
    }


    public String getMeno() {
        return meno;
    }

    public int getPocetVyvozov() {
        return pocetVyvozov;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getPocetObyvatelov() {
        return pocetObyvatelov;
    }

    public double getRocnaSpotreba() {
        return rocnaSpotreba;
    }

    public boolean isKanalizacia() {
        return kanalizacia;
    }

    public double getKapacitaZumpy() {
        return kapacitaZumpy;
    }

    public static Domacnost zoStringu(String popis) {
        try {
            Scanner sc = new Scanner(popis);
            sc.useDelimiter("\t");
            String meno = sc.next();
            String adresa = sc.next();
            int pocetObyvatelov = sc.nextInt();
            double rocnaSpotreba = sc.nextDouble();
            if (sc.hasNext()) {
                double kapacitaZumpy = sc.nextDouble();
                int  pocetVyvozov = sc.nextInt();
                return new Domacnost(meno, adresa, pocetObyvatelov, rocnaSpotreba, kapacitaZumpy, pocetVyvozov);
            } else {
                return new Domacnost(meno, adresa, pocetObyvatelov, rocnaSpotreba);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String toString() {
        return meno+"\t"+adresa;
    }

}
