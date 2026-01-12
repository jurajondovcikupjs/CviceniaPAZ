package sk.upjs.ondovcik.juraj;

public class Ship {

    private String name;
    private String departure;
    private String lastMessage;
    private String mission;
    private boolean armed;
    private String arrival;
    private int sailorCount;
    public static String NO_INFO = "N/A";

    public Ship(String name, String departure, String lastMessage, String mission, boolean armed, String arrival, int sailorCount) {
        this.name = name;
        this.departure = departure;
        this.lastMessage = lastMessage;
        this.mission = mission;
        this.armed = armed;
        this.arrival = arrival;
        this.sailorCount = sailorCount;
    }

    public Ship(String name, String departure, String lastMessage, String mission, boolean armed, int sailorCount) {
        this.name = name;
        this.departure = departure;
        this.lastMessage = lastMessage;
        this.mission = mission;
        this.armed = armed;
        this.sailorCount = sailorCount;
    }

    public String getName() {
        return name;
    }

    public String getDeparture() {
        return departure;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getMission() {
        return mission;
    }

    public boolean isArmed() {
        return armed;
    }

    public String getArrival() {
        return arrival;
    }

    public int getSailorCount() {
        return sailorCount;
    }

    public static Ship fromString(String input) {
        String[] parts = input.split(";");
        String name = parts[0];
        String departure = parts[1];
        String lastMessage = parts[2];
        String mission = parts[3];
        boolean armed = Boolean.parseBoolean(parts[4]);
        if (parts.length > 6) {
            String arrival = parts[5];
            int sailorCount = Integer.parseInt(parts[6]);
            return new Ship(name, departure, lastMessage, mission, armed, arrival, sailorCount);
        } else {
            int sailorCount = Integer.parseInt(parts[5]);
            return new Ship(name, departure, lastMessage, mission, armed, sailorCount);
        }
    }

    public String toString() {
        if (arrival != null) {
            return name + ";" + departure + ";" + lastMessage + ";" + mission + ";" + armed + ";" + arrival + ";" + sailorCount;
        } else {
            return name + ";" + departure + ";" + lastMessage + ";" + mission + ";" + armed + ";" + sailorCount;
        }
    }

    public int monthsAway() {
        String[] dep = departure.split("/");
        String[] arr = arrival.split("\\.");


        return (Integer.parseInt(arr[1]) - Integer.parseInt(dep[0])) + (12 * (Integer.parseInt(arr[2]) - Integer.parseInt(dep[1])));
    }
}
