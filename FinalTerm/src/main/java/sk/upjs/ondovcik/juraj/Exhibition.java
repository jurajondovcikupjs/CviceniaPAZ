package sk.upjs.ondovcik.juraj;

import java.util.Arrays;

public class Exhibition {

    private String name;
    private int dayStart;
    private int dayEnd;
    private int visitors;

    public Exhibition(String name, int dayStart, int dayEnd, int visitors) {
        this.name = name;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.visitors = visitors;
    }

    public String getName() {
        return name;
    }

    public int getDayStart() {
        return dayStart;
    }

    public int getDayEnd() {
        return dayEnd;
    }

    public int getVisitors() {
        return visitors;
    }

    public static void main(String[] args) {
        Exhibition e1 = new Exhibition("Filmový festival v Cannes", 100, 107, 60_000);
        Exhibition e2 = new Exhibition("Festival vedy a techniky", 101, 105, 30_000);
        Exhibition e3 = new Exhibition("Festival vedy a techniky", 106, 108, 40_000);
        Exhibition e4 = new Exhibition("Deň otvorených dverí UPJŠ", 45, 45, 1_000);

        Exhibition[] exhibitions = new Exhibition[]{e1, e2, e3, e4};
        Arrays.sort(exhibitions, new ExhibitionComparator());

        int[] d = new int[exhibitions.length + 1];
        d[0] = 0;

        for (int e = 1; e <= exhibitions.length; e++) {
            Exhibition currentExhibition = exhibitions[e - 1];

            int visitorsWithoutCurrent = d[e - 1];

            int k = 0;
            for (int j = e - 2; j >= 0;j--) {
                if (exhibitions[j].getDayEnd() < currentExhibition.getDayStart()) {
                    k = j + 1;
                    break;
                }
            }
            int visitorsWithCurrent = currentExhibition.getVisitors() + d[k];
            d[e] = Math.max(visitorsWithCurrent, visitorsWithoutCurrent);
        }
        System.out.println(d[exhibitions.length]);

    }
}
