package sk.upjs.ondovcik.juraj;

import java.util.Arrays;

public class Cards {

    public void vypis2Dpole(boolean[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                System.out.print(pole[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void vypis2DpoleInt(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                System.out.print(pole[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public boolean solve(int[][] cards, int number) {
        boolean[][] dp = new boolean[cards.length + 1][number + 1];
        //vypis2Dpole(dp);
        //vypis2DpoleInt(cards);

        dp[0][0] = true;
        for (int i = 1; i <= cards.length; i++) { //riadky
            int cardA = cards[i-1][0];
            int cardB = cards[i-1][1];
            for (int j = 0; j <= number; j++) { //stlpce
                if (dp[i-1][j]) {
                    if (j + cardA <= number) {
                        dp[i][j + cardA] = true;
                    }
                    if (j + cardB <= number) {
                        dp[i][j + cardB] = true;
                    }

                }
            }
        }
        //vypis2Dpole(dp);

        return dp[cards.length][number];
    }

}