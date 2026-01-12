package sk.upjs.ondovcik.juraj;

import java.util.*;

public class Event {

    private List<Kid> kids;

    public Event() {
        kids = new ArrayList<>();
    }

    public void add(Kid kid) {
        kids.add(kid);
    }

    public int kidsCount() {
        return kids.size();
    }

    public int numberOfTeenageBoys() {
        //ak je null alebo prazdny zoznam, vrat 0
        if (kids.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Kid kid : kids) {
            if (!kid.isGirl() && kid.getAge() > 12) {
                //+1 ak je chlapec a ma viac ako 12 rokov
                count++;
            }
        }
        return count;
    }

    public Map<String, Integer> numberOfKids() {
        //nova mapa
        Map<String, Integer> map = new HashMap<>();
        //vrati prazdnu mapu ak je zoznam prazdny
        if (kids.isEmpty()) {
            return map;
        }
        //prejde vsetky deti a priradi ich rodicovi v mape
        for (Kid kid : kids) {
            String parent = kid.getParent();
            map.put(parent, map.getOrDefault(parent, 0) + 1); //getOrDefault vrati hodnotu pre dany kluc alebo 0 ak kluc neexistuje
        }

        return map;
    }

    public String youngestKid() {
        //ak je zoznam prazdny, vrat null
        if (kids.isEmpty()) {
            return null;
        }
        //najdi najmladsie dieta
        Kid youngest = kids.get(0);
        for (Kid kid : kids) {
            //porovnaj veky a najdi najmladsie dieta
            if (kid.getAge() < youngest.getAge()) {
                youngest = kid;
            }
        }
        return youngest.getName();
    }

    public int ageRange() {
        //ak je zoznam prazdny, vrat 0
        if (kids.isEmpty()) {
            return 0;
        }

        //zaciname s extremnymi hodnotami
        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;

        //najdi minimalny a maximalny vek
        for (Kid kid : kids) {
            if (kid.getAge() < minAge) {
                minAge = kid.getAge();
            }
            if (kid.getAge() > maxAge) {
                maxAge = kid.getAge();
            }
        }

        return maxAge - minAge;
    }

    public List<String> uniqueNames() {
        //novy set, kedze set ma len unique hodnoty
        Set<String> namesSet = new HashSet<>();
        //pridaj vsetky mena do setu
        for (Kid kid : kids) {
            namesSet.add(kid.getName());
        }
        //vratime ako list
        return new ArrayList<>(namesSet);
    }

    public List<Kid> employeeKids(String employee) {
        //novy list pre deti daneho zamestnanca
        List<Kid> result = new ArrayList<>();
        for (Kid kid : kids) {
            //ak sa rodic zhoduje, pridaj dieta do listu
            if (kid.getParent().equals(employee)) {
                result.add(kid);
            }
        }
        return result;
    }

    public int removeEmployeeFromEvent(String employee) {
        int amount = 0;
        //pouzivame iterator na bezpecne odstranenie prvkov pocas iteracie
        for (Iterator<Kid> iterator = kids.iterator(); iterator.hasNext(); ) {
            Kid kid = iterator.next();
            //ak sa rodic zhoduje, odstran dieta a zvys pocitadlo
            if (kid.getParent().equals(employee)) {
                iterator.remove();
                amount++;
            }
        }

        return amount;
    }

    public boolean hasThisKid(String employee, int age, boolean isGirl) {
        for (Kid kid : kids) {
            //skontroluj ci sa rodic, vek a pohlavie zhoduju
            if (kid.getParent().equals(employee) && kid.getAge() == age && kid.isGirl() == isGirl) {
                return true;
            }
        }
        return false;
    }

    public List<String> employeesWithMultipleKids() {
        Map<String, Integer> countMap = new HashMap<>();
        //spocitaj pocet deti pre kazdeho rodica
        for (Kid kid : kids) {
            String parent = kid.getParent();
            countMap.put(parent, countMap.getOrDefault(parent, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        //pridaj rodicov s viac ako jednym dietatom do vysledneho listu
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public int mostCommonAge() {
        Map<Integer, Integer> ageCountMap = new HashMap<>();
        //spocitaj pocet deti pre kazdy vek
        for (Kid kid : kids) {
            int age = kid.getAge();
            //mapa s udajmi o pocte deti daneho veku, kde vek je kluc a pocet je hodnota
            ageCountMap.put(age, ageCountMap.getOrDefault(age, 0) + 1);
        }

        int mostCommonAge = -1;
        int maxCount = 0;
        //najdi vek s najvacsim poctom deti
        for (Map.Entry<Integer, Integer> entry : ageCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                //aktualizuj maximalny pocet a najcastejsi vek
                maxCount = entry.getValue();
                mostCommonAge = entry.getKey();
            }
        }

        return mostCommonAge;
    }

    public int boysOverAverageAge() {
        if (kids.isEmpty()) {
            return 0;
        }
        //vypocitaj priemerny vek
        int totalAge = 0;
        int amount = 0;
        double averageAge = 0.0;
        for (Kid kid : kids) {
            totalAge += kid.getAge();
        }
        averageAge = (double) totalAge / kids.size();

        //spocitaj chlapcov starsich ako je priemerny vek
        for (Kid kid : kids) {
            if (!kid.isGirl() && kid.getAge() > averageAge) {
                amount++;
            }
        }

        return amount;

    }
}
