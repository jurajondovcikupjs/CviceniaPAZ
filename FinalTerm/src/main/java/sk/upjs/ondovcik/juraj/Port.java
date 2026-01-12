package sk.upjs.ondovcik.juraj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Port {
    ArrayList<Ship> zoznamLodi = new ArrayList<Ship>();

    public void addShip(Ship ship) {
        zoznamLodi.add(ship);
    }

    public static Port loadShips(String fileName) {
        Port p = new Port();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                p.addShip(Ship.fromString(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void saveShips(String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            for (Ship ship : zoznamLodi) {
                if (ship.getArrival() == null) {
                    pw.println(ship.getName() + ";" + ship.getDeparture() + ";" + ship.getLastMessage() + ";" + ship.getMission() + ";" + ship.isArmed() + ";" + ship.getSailorCount());
                } else {
                    pw.println(ship.getName() + ";" + ship.getDeparture() + ";" + ship.getLastMessage() + ";" + ship.getMission() + ";" + ship.isArmed() + ";" + ship.getArrival() + ";" + ship.getSailorCount());
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String s = "";
        for (Ship ship : zoznamLodi) {
            s = s.concat(ship.toString());
            s = s.concat("\n");
        }
        return s;
    }

    public int arrivedShips() {
        int count = 0;
        for (Ship ship : zoznamLodi) {
            if (ship.getArrival() != null) {
                count++;
            }
        }
        return count;
    }

    public int sailorsAway() {
        int total = 0;
        for (Ship ship : zoznamLodi) {
            if (ship.getArrival() == null) {
                total += ship.getSailorCount();
            }
        }
        return total;
    }

    public Map<String, Integer> sailorsPerMission() {
        Map<String, Integer> missionSailors = new HashMap<>();
        for (Ship ship : zoznamLodi) {
            missionSailors.put(ship.getMission(), missionSailors.getOrDefault(ship.getMission(), 0) + ship.getSailorCount());
        }
        return missionSailors;
    }



}
