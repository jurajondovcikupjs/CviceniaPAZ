package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class StringTurtle extends Turtle {

    public int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public boolean isPalindrome(String s) {
        String s1 = s;
        String s2 = "";

        for (int i = s1.length() - 1; i >= 0; i-- ) {
            s2 = s2 + s1.charAt(i);
        }

        if (s1.toLowerCase().equals(s2.toLowerCase())) {
            return true;
        } else  {
            return false;
        }
    }

    public boolean containsDoubleSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (s.charAt(i + 1) == ' ') {
                    return true;
                }
            }
        }
        return false;
    }
}
