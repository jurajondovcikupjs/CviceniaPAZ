package sk.upjs.ondovcik.juraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dog {
    private int weight;

    public Dog(int weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog(2);
        Dog dog2 = new Dog(4);
        Dog dog3 = new Dog(2);
        Dog dog4 = new Dog(3);

        Dog[] dogs = {dog1, dog2, dog3, dog4};
        int weightMax = (dog1.weight + dog2.weight + dog3.weight + dog4.weight + 1) / 2;
        boolean[][] matrix = new boolean[dogs.length + 1][weightMax];
        matrix[0][0] = true;

        for (int d = 1; d < matrix.length; d++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[d - 1][j]) {
                    matrix[d][j] = true;
                    if (matrix[d - 1][j] && j + dogs[d-1].weight < weightMax ) {
                        matrix[d][j + dogs[d-1].weight] = true;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        boolean[] pick = new boolean[dogs.length];
        int weight = weightMax - 1;
        for (int d = matrix.length - 1; d >= 0; d--) {
            if (!matrix[d][weight]) {
                pick[d] = true;
                weight -= dogs[d].weight;
            }
        }
        System.out.println(Arrays.toString(pick));

    }
}
