package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class HomeTurtle extends Turtle {

    public String toEmailAddress(String name) {

        //novy String a email do lowercase
        String email = new String("");
        name = name.toLowerCase();
        //prechadzam kazdy znak mena a ak je to medzera pridam bodku
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                email += '.';
            } else {
                email += name.charAt(i);
            }
        }
        //a uz len domenu
        email = email.concat("@upjs.sk");
        return email;
    }

    public int countAcronyms(String r) {
        r =r.concat("."); //pridam na koniec nejaky znak ktory nie je velke pismeno
        int pocet = 0; // pocet
        String acronyms = new String(""); //aktualna skratka

        //prechadzam retazec
        for (int i = 0; i < r.length(); i++) {
            char znak = r.charAt(i);
            // ak je velke pismeno pridam do skratky
            if (Character.isUpperCase(znak)) {
                acronyms = acronyms + znak;
            } else {
                //ak nie tak skontrolujem ci je skratka dostatocne dlha a resetujem skratku
                if (acronyms.length() >= 2) {
                    pocet++;
                }
                acronyms = "";
            }
        }
        return pocet;
    }

    public String replaceNumbers(String s, String replacement) {
        String result = new String("");

        //prechadzam retazec a ak je znak cislo pridam z retazca replacement na rovnakej pozicii
        for (int i = 0; i < s.length(); i++) {
            char znak = s.charAt(i);
            if (Character.isDigit(znak)) {
                result = result + replacement.charAt(i);
            } else {
                result = result + znak;
            }
        }
        return result;
    }

    public String sanitize(String s) {

        //vytvorim novy retazec a premennu pre posledny znak
        String result = new String("");
        char lastChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            //porovnam ci je aktualny znak rovnaky ako posledny pridany znak, ak ano pokracujem dalej, ak nie pridam do vysledneho retazca
            char znak = s.charAt(i);
            if (Character.toLowerCase(znak) == Character.toLowerCase(lastChar)) {
                continue;
            } else {
                result = result + znak;
            }

            //nastavim posledny znak na aktualny znak
            lastChar = znak;
        }
        return result;
    }

}
