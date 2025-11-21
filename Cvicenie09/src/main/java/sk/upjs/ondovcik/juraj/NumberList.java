package sk.upjs.ondovcik.juraj;

import java.util.Arrays;

/**
 * Trieda realizujuca dynamicke pole (zoznam) cisel.
 */
public class NumberList {
    //Hodnotenie: konstruktory a metody bez uvedeneho hodnotania celkom 3 body

    private int[] numbersArray;

    /**
     * Konstruktor zoznamu cisel - vytvori prazdny zoznam
     */
    public NumberList() {
        this.numbersArray = new int[0];
    }

    /**
     * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA pola
     * @param numbers pole, podla ktoreho sa ma inicializovat zoznam cisel
     */
    public NumberList(int[] numbers) {
        this.numbersArray = Arrays.copyOf(numbers, numbers.length);
    }

    /**
     * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA ineho zoznamu
     * @param numberList zoznam, podla ktoreho sa ma inicializovat zoznam cisel
     */
    public NumberList(NumberList numberList) {
        this.numbersArray = Arrays.copyOf(numberList.numbersArray, numberList.numbersArray.length);
    }

    /**
     * Vrati cislo aktualne ulozene na zadanom indexe v zozname
     * @param index index prvku zoznamu, ktoreho hodnotu chceme vratit
     * @return cislo na zadanom indexe v zozname
     */
    public int get(int index) {
        return this.numbersArray[index];
    }

    /**
     * Nastavi hodnotu prvku zoznamu na zadanom (uz existujucom) indexe
     * @param index index prvku
     * @param value nova hodnota pre prvom na zadanom indexe
     */
    public void set(int index, int value) {
        this.numbersArray[index] = value;
    }

    /**
     * Prida na koniec zoznamu novy prvok so zadanou hodnotou
     * @param value hodnota prvku pridaneho na koniec zoznamu
     */
    public void add(int value) {
        // Vytvorime nove pole o velkosti zvacsenej o 1
        int[] newNumbers = new int[this.numbersArray.length + 1];
        // Skopirujeme povodne hodnoty do noveho pola
        for (int i = 0; i < this.numbersArray.length; i++) {
            newNumbers[i] = this.numbersArray[i];
        }
        // Pridame novu hodnotu na koniec pola a aktualizujeme referenciu
        newNumbers[newNumbers.length - 1] = value;
        this.numbersArray = newNumbers;
    }

    /**
     * Vrati aktualny pocet prvkov v zozname cisel
     * @return pocet prvkov v zozname cisel
     */
    public int size() {
        return this.numbersArray.length;
    }

    /**
     * Vyprazdni zoznam
     */
    public void clear() {
        this.numbersArray = new int[0];
    }

    /**
     * Odstrani zo zoznamu prvok na zadanom indexe a vrati hodnotu odstraneneho prvku
     * @param index index odstranovaneho prvku v zozname
     * @return hodnota odstranovaneho prvku v zozname
     */
    public int remove(int index) {
        // Ulozime hodnotu odstranovaneho prvku
        int removedValue = this.numbersArray[index];
        // Vytvorime nove pole o velkosti zmensenej o 1
        int[] newNumbers = new int[this.numbersArray.length - 1];
        // Skopirujeme hodnoty okrem odstranovaneho prvku do noveho pola
        for (int i = 0, j = 0; i < this.numbersArray.length; i++) {
            if (i != index) {
                newNumbers[j++] = this.numbersArray[i];
            }
        }
        // Aktualizujeme referenciu na nove pole
        this.numbersArray = newNumbers;
        return removedValue;
    }

    /**
     * Vrati obsah zoznamu vo forme formatovaneho retazca [prvok1, prvok2, prvok3, prvok4]
     */
    @Override
    public String toString() {
        // Vytvorime retazec reprezentujuci obsah zoznamu
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // Prejdeme vsetky prvky zoznamu a pridame ich do retazca
        for (int i = 0; i < this.numbersArray.length; i++) {
            sb.append(this.numbersArray[i]);
            if (i < this.numbersArray.length - 1) {
                sb.append(", ");
            }
        }
        // Dokoncime retazec a konvertujeme na String
        sb.append("]");
        return sb.toString();
    }
}