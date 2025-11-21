package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        FrequencyTable ft = new FrequencyTable();

        try (Scanner sc = new Scanner(new File("subor.txt"))) {
            while (sc.hasNext())
                ft.addOccurrence(sc.next());
        } catch (FileNotFoundException e) {
            System.err.println("Subor neexistuje.");
        }

        System.out.println("Pocet roznych precitanych slov: " + ft.getWordCount());

        // Vypis po slovach
        String[] words = ft.getWords();
        System.out.println("Vyskyty slov: ");
        for (int i = 0; i < words.length; i++)
            System.out.println(words[i] + ": " + ft.getNumberOfOccurrences(words[i]));

        // test "hacknutia" objektu
        for (int i = 0; i < words.length; i++) {
            words[i] = "???";
        }

        // Vypis cez toString
        System.out.println("Vyskyty slov inak: " + ft.toString());
    }

}