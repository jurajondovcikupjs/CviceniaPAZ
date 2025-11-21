package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

import java.io.File;

public class Launcher {

	public static void main(String[] args) {

		//ClickPane pane = new ClickPane();

        HomeTurtle homeTurtle = new HomeTurtle();
        //System.out.println(smartTurtle.stringToInt("12a3", 0));

        //int[] cisla = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //homeTurtle.spirala(new File("dots.txt"), cisla, 5);


        //System.out.println(homeTurtle.pocetNulVSucine("E:\\PAZ\\CviceniaPAZ\\Cvicenie08\\src\\main\\java\\sk\\upjs\\ondovcik\\juraj\\nuly.txt"));
        System.out.println(homeTurtle.najproduktivnejsiHrac("E:\\PAZ\\CviceniaPAZ\\Cvicenie08\\src\\main\\java\\sk\\upjs\\ondovcik\\juraj\\hraci.txt"));

	}
}
