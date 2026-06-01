package sk.upjs.ondovcik.juraj;

import java.util.Comparator;

public class DreamComparator implements Comparator<Dreams> {


    @Override
    public int compare(Dreams o1, Dreams o2) {
        return Integer.compare(o1.getEnd(), o2.getEnd());
    }
}
