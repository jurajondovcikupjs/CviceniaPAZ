package sk.upjs.ondovcik.juraj;

import java.util.Arrays;

public class Dreams {

    private int start;
    private int length;
    private int reward;
    private int end;

    public Dreams(int start, int length, int reward) {
        this.start = start;
        this.length = length;
        this.reward = reward;
        this.end = start + length - 1;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public int getReward() {
        return reward;
    }

    public int getEnd() {
        return end;
    }

    public static void main(String[] args) {
        int n = 4;
        Dreams[] dreams = new Dreams[n];
        dreams[0] = new Dreams(19, 5, 10_000); // VS (19-23)
        dreams[1] = new Dreams(24, 1, 4_000);  // SVET (24-24)
        dreams[2] = new Dreams(22, 2, 2_000);  // CIMBAL (22-23)
        dreams[3] = new Dreams(20, 2, 6_000);  // START-UP (20-21)

        // Predpokladám, že DreamComparator radí podľa (.end) vzostupne
        Arrays.sort(dreams, new DreamComparator());

        // DP pole veľkosti n + 1
        int[] d = new int[n + 1];
        d[0] = 0; // Pre 0 snov je zisk 0

        // i reprezentuje POČET snov, ktoré máme k dispozícii (1 až n)
        for (int i = 1; i <= n; i++) {
            // Aktuálny sen, ktorý zvažujeme, je v poli dreams na indexe (i - 1)
            Dreams currentDream = dreams[i - 1];

            // 1. MOŽNOSŤ: Sen 'currentDream' NEROBÍME
            int ziskBezSna = d[i - 1];

            // 2. MOŽNOSŤ: Sen 'currentDream' ROBÍME
            int k = 0; // Index v DP poli pre posledný nekonfliktný stav

            // Hľadáme v poli 'dreams' od predchádzajúceho (i-2) smerom na začiatok (0)
            for (int j = i - 2; j >= 0; j--) {
                // Ak sen j skončil skôr, ako aktuálny sen začína
                if (dreams[j].getEnd() < currentDream.getStart()) {
                    // V DP poli 'd' zodpovedá snovi j stav na indexe j + 1
                    k = j + 1;
                    break;
                }
            }

            int ziskSoSnom = currentDream.getReward() + d[k];

            // Uložíme maximum do DP poľa
            d[i] = Math.max(ziskBezSna, ziskSoSnom);
        }

        // Výsledný maximálny zisk je na úplnom konci poľa d
        System.out.println("DP pole stavov: " + Arrays.toString(d));
        System.out.println("Max zisk: " + d[n]);
    }



}
