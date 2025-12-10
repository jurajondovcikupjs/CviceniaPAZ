package sk.upjs.ondovcik.juraj;

import java.util.Objects;

public class Kid {

    private String name;
    private int age;
    private boolean isGirl;
    private String parent;

    public Kid(String name, int age, boolean isGirl, String parent) {
        this.name = name;
        this.age = age;
        this.isGirl = isGirl;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public String getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Kid kid = (Kid) o;
        return age == kid.age && isGirl == kid.isGirl && Objects.equals(name, kid.name) && Objects.equals(parent, kid.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isGirl, parent);
    }
}