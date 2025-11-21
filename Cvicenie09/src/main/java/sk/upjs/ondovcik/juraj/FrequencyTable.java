package sk.upjs.ondovcik.juraj;

public class FrequencyTable {

    String[][] frequencyTableWords;

    // ??? Konstruktor + clear + getWordCount: 2 body

    /**
     * Konstruktor: vytvori prazdnu frekvencnu tabulku
     */
    public FrequencyTable() {
        this.frequencyTableWords = new String[0][0];
    }

    /**
     * Vyprazdni obsah tabulky (vratene vlozenych slov)
     */
    public void clear() {
        this.frequencyTableWords = new String[0][0];
    }

    /**
     * Vrati pocet vyskytov slova. V pripade, ze sa slovo v tabulke nenachadza,
     * vrati 0
     *
     * @param word
     *            retazec, ktoreho pocet vyskytov chceme zistit
     * @return pocet vyskytov zadaneho slova (retazca)
     */
    public int getNumberOfOccurrences(String word) {
        int count = 0;
        // Hladame slovo v tabulke
        for (int i = 0; i < this.frequencyTableWords.length; i++) {
            // Ak sme nasli hladane slovo, vratime jeho pocet vyskytov
            if (this.frequencyTableWords[i][0].equals(word)) {
                return Integer.parseInt(this.frequencyTableWords[i][1]);
            }
        }
        // Ak sme slovo nenasli, vratime 0
        return 0;
    }

    /**
     * Poznaci novy vyskyt slova vo frekvencnej tabulke (zvysi pocitadlo
     * priradene danemu slovu o 1). Ak take slovo sa v tabulke nenachadza,
     * nastavi pocet jeho vyskytov na 1
     *
     * @param word
     *            slovo, ktoreho vyskyt chceme poznacit vo frekvencnej tabulke
     */
    public void addOccurrence(String word) {
        // Hladame slovo v tabulke
        for (int i = 0; i < this.frequencyTableWords.length; i++) {
            // Ak sme nasli hladane slovo, zvysime jeho pocet vyskytov o 1
            if (this.frequencyTableWords[i][0].equals(word)) {
                // Zvysime pocet vyskytov o 1
                int currentCount = Integer.parseInt(this.frequencyTableWords[i][1]); //Ono je to vlastne String konvertovany na int, pripocitany o 1 a potom znovu konvertovany na String
                currentCount++;
                this.frequencyTableWords[i][1] = Integer.toString(currentCount);
                return;
            }
        }
        // Ak sme nasli nove slovo, pridame ho do tabulky
        String[][] newFrequencyTable = new String[this.frequencyTableWords.length + 1][2];
        // Skopirujeme existujuce polozky do novej tabulky
        for (int i = 0; i < this.frequencyTableWords.length; i++) {
            newFrequencyTable[i][0] = this.frequencyTableWords[i][0];
            newFrequencyTable[i][1] = this.frequencyTableWords[i][1];
        }
        // Pridame nove slovo s poctom vyskytov 1
        newFrequencyTable[newFrequencyTable.length - 1][0] = word;
        newFrequencyTable[newFrequencyTable.length - 1][1] = "1";
        this.frequencyTableWords = newFrequencyTable;
    }

    /**
     * Vrati pocet slov vo frekvencnej tabulke (vsetky maju nenulovy pocet vyskytov)
     * @return pocet slov vo frekvencnej tabulke
     */
    public int getWordCount() {
        return this.frequencyTableWords.length;
    }

    /**
     * Vrati slova vo frekvencnej tabulke v novovytvorenom poli retazcov
     * @return referencia na novovytvorene pole retazcov so slovami v tabulke
     */
    public String[] getWords() {
        // Vytvorime nove pole retazcov pre slova
        String[] words = new String[this.frequencyTableWords.length];
        // Skopirujeme slova z frekvencnej tabulky do noveho pola a vratime pole
        for (int i = 0; i < this.frequencyTableWords.length; i++) {
            words[i] = this.frequencyTableWords[i][0];
        }
        return words;
    }


    /**
     * Vrati obsah frekvencnej tabulky ako retazec vo formate
     * [slovo1=pocetVyskytov1, slovo2=pocetVyskytov2]
     */
    public String toString() {
        // Vytvorime retazec reprezentujuci obsah frekvencnej tabulky
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // Prejdeme vsetky polozky tabulky a pridame ich do retazca
        for (int i = 0; i < this.frequencyTableWords.length; i++) {
            sb.append(this.frequencyTableWords[i][0]);
            sb.append("=");
            sb.append(this.frequencyTableWords[i][1]);
            if (i < this.frequencyTableWords.length - 1) {
                sb.append(", ");
            }
        }
        // Dokoncime retazec a konvertujeme na String
        sb.append("]");
        return sb.toString();
    }
}
