package sk.upjs.ondovcik.juraj;


public class Launcher {

	public static void main(String[] args) {
		Cards c = new Cards();
		//c.solve(new int[][]{{19,40}, {23,40}, {17,24}, {18,24}, {71,96}}, 175);
		System.out.println(c.solve(new int[][]{{19,40}, {23,40}, {17,24}, {18,24}, {71,96}}, 175));
		//System.out.println(c.solve(new int[][]{{0,1}, {3,7}}, 4));

	}
}