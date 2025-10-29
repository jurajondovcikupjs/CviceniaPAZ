package sk.upjs.ondovcik.juraj;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {

        //Korytnackovo korytnackovo = new Korytnackovo();
        //korytnackovo.nahodneFarby();
        //korytnackovo.posunITu(4, 100);
        //System.out.println(korytnackovo.sFarbouVon(4));
        //korytnackovo.krok();

        //MSPaint g = new MSPaint();

        KorytnaciSvet2 ks = new KorytnaciSvet2();
        ObjectInspector oi = new ObjectInspector(ks);
        oi.inspect(ks);
		
	}
}
