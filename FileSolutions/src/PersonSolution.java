package src;

public class PersonSolution {
    private String name;
    private int age;

    public PersonSolution(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

