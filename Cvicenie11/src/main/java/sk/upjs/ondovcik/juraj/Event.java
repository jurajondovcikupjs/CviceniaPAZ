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
        if (kids.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Kid kid : kids) {
            if (!kid.isGirl() && kid.getAge() > 12) {
                count++;
            }
        }
        return count;
    }

    public Map<String, Integer> numberOfKids() {
        Map<String, Integer> map = new HashMap<>();

        if (kids.isEmpty()) {
            return map;
        }

        for (Kid kid : kids) {
            String parent = kid.getParent();
            map.put(parent, map.getOrDefault(parent, 0) + 1);
        }

        return map;
    }

    public String youngestKid() {
        if (kids.isEmpty()) {
            return null;
        }

        Kid youngest = kids.get(0);
        for (Kid kid : kids) {
            if (kid.getAge() < youngest.getAge()) {
                youngest = kid;
            }
        }
        return youngest.getName();
    }

    public int ageRange() {
        if (kids.isEmpty()) {
            return 0;
        }

        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;

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
        Set<String> namesSet = new HashSet<>();
        for (Kid kid : kids) {
            namesSet.add(kid.getName());
        }
        return new ArrayList<>(namesSet);
    }

    public List<Kid> employeeKids(String employee) {
        List<Kid> result = new ArrayList<>();
        for (Kid kid : kids) {
            if (kid.getParent().equals(employee)) {
                result.add(kid);
            }
        }
        return result;
    }

    public int removeEmployeeFromEvent(String employee) {
        int amount = 0;
        for (Iterator<Kid> iterator = kids.iterator(); iterator.hasNext(); ) {
            Kid kid = iterator.next();
            if (kid.getParent().equals(employee)) {
                iterator.remove();
                amount++;
            }
        }

        return amount;
    }

    public boolean hasThisKid(String employee, int age, boolean isGirl) {
        for (Kid kid : kids) {
            if (kid.getParent().equals(employee) && kid.getAge() == age && kid.isGirl() == isGirl) {
                return true;
            }
        }
        return false;
    }

    public List<String> employeesWithMultipleKids() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Kid kid : kids) {
            String parent = kid.getParent();
            countMap.put(parent, countMap.getOrDefault(parent, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public int mostCommonAge() {
        Map<Integer, Integer> ageCountMap = new HashMap<>();
        for (Kid kid : kids) {
            int age = kid.getAge();
            ageCountMap.put(age, ageCountMap.getOrDefault(age, 0) + 1);
        }

        int mostCommonAge = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : ageCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
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

        int totalAge = 0;
        int amount = 0;
        double averageAge = 0.0;
        for (Kid kid : kids) {
            totalAge += kid.getAge();
        }
        averageAge = (double) totalAge / kids.size();

        for (Kid kid : kids) {
            if (!kid.isGirl() && kid.getAge() > averageAge) {
                amount++;
            }
        }

        return amount;

    }
}
