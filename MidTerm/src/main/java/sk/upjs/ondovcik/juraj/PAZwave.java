package sk.upjs.ondovcik.juraj;

import java.util.Arrays;

public class PAZwave {

    public int validAddressVersionX(String number, int x) {
        return countValid(number, 0, x);
    }

    private int countValid(String s, int index, int partsLeft) {
        if (partsLeft == 0 && index == s.length()) return 1; // Valid complete address
        if (partsLeft == 0 || index == s.length()) return 0; // Invalid address
        int count = 0;
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            if ((part.length() > 1 && part.startsWith("0")) || Integer.parseInt(part) > 255) continue;
            count += countValid(s, index + len, partsLeft - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        PAZwave paz = new PAZwave();
        System.out.println(paz.validAddressVersionX("11111", 3));
    }

}
