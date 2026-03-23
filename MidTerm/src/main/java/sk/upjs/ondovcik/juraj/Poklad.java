package sk.upjs.ondovcik.juraj;

import java.util.*;

public class Poklad {

    public String[] strany = {"S", "E", "N", "W"};
    public List<String> path = new ArrayList<>();
    private StringBuilder vysledok = new StringBuilder();

    public List<String> cesty(int k, int x, int y) {
        List<String> allPaths = new ArrayList<>();
        path.clear();
        generuj(0, k, new StringBuilder(), allPaths);
        for (String cesta : allPaths) {
            int x1 = 0, y1 = 0;
            for (int i = 0; i < cesta.length(); i++) {
                switch (cesta.charAt(i)) {
                    case 'S': y1--; break;
                    case 'E': x1++; break;
                    case 'N': y1++; break;
                    case 'W': x1--; break;
                }
            }
            if (x1 == x && y1 == y)
                path.add(cesta);
        }
        return path;
    }

    private void generuj(int kolkoUzBolo, int k, StringBuilder sb, List<String> allPaths) {
        if (kolkoUzBolo == k) {
            allPaths.add(sb.toString());
            return;
        }
        for (String s : strany) {
            sb.append(s);
            generuj(kolkoUzBolo + 1, k, sb, allPaths);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        Poklad poklad = new Poklad();
        List<String> cesty = poklad.cesty(2, 0, 0);
        System.out.println(cesty);
    }

}