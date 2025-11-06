package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextTurtle extends Turtle {

    public double average(String filename) {
        File file = new  File(filename);
        try {
            int amount = 0;
            int sum = 0;
            Scanner sc = new Scanner(file);
            while (sc.hasNextInt()) {
                sum += sc.nextInt();
                amount++;
            }
            return (double)sum/amount;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return 0;
    }

    public int countLines(String filename) {
        File file = new  File(filename);
        try {
            int amount = 0;
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                amount++;
                sc.nextLine();
            }
            return amount;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return 0;
    }
}
