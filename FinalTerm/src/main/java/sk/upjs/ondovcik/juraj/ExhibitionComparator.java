package sk.upjs.ondovcik.juraj;

import java.util.Comparator;

public class ExhibitionComparator implements Comparator<Exhibition> {
    @Override
    public int compare(Exhibition e1, Exhibition e2) {
        return Integer.compare(e1.getDayEnd(), e2.getDayEnd());
    }
}
