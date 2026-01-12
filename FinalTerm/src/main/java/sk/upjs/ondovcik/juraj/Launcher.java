package sk.upjs.ondovcik.juraj;

public class Launcher {

	public static void main(String[] args) {

		Port p = new Port();
		p.addShip(new Ship("Name 1", "09/1519", "Leaving", "Sail", false, "1.10.1520", 45));
		p.addShip(new Ship("Name 2", "05/1412", "Leaving", "Sail", true, 45));
		p.addShip(new Ship("Name 2", "05/1412", "Leaving", "Watch", true, 45));
		//p.addShip(Ship.fromString("Name 1;19/1519;Leaving;Sail;false;45"));
		//System.out.println(p.zoznamLodi);

		//Port p = Port.loadShips("lode.txt");
		//System.out.println(p.toString());
		//System.out.println(p.zoznamLodi.get(0).monthsAway());
		//System.out.println("Arrived ships: " + p.arrivedShips());
		//System.out.println("Saylors away: " + p.sailorsAway());
		//System.out.println(Math.round(1.492262 * 100.0) / 100.0);
		//System.out.println(p.sailorsPerMission());

	}
}