package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class SmartTurtle extends Turtle {

    public long power(int n, int k) {
        if (k == 0) {
            return 1;
        } else {
            for (int i = 1; i < k; i++) {
                n = n * n;
            }
            return n;
        }
    }


}
