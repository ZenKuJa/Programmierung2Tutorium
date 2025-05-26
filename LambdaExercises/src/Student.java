package src;

public class Student {
    private String name;
    private int age;
    private String gender;
    private double grade;
    private String major;

    public Student(String name, int age, String gender, double grade, String major) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.major = major;
    }

    // Getter
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public double getGrade() { return grade; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + gender + ") - " + major + ", Grade: " + grade;
    }
}

