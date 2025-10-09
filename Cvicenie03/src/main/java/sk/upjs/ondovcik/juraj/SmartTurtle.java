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

    public long factorial(int n) {
        long nfactorial = 1;
        while (n > 0) {
            nfactorial = n * nfactorial;
            n--;
        }
        return nfactorial;
    }

    public int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n % 2 == 0) {
            return true;
        }
        return true;
    }

    public boolean containsDigit(byte c, int n) {
        while (n > 0) {
            if (n % 10 == c) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }


}
