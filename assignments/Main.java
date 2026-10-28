// ---------- Exercise 1 ----------
class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public double getAnnualSalary() { return monthlySalary * 12; }
}

// ---------- Assignment 1 ----------
interface Displayable {
    void display();
}

abstract class Student implements Displayable {
    private String name;
    private String registrationNumber;

    public Student(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    public String getName() { return name; }
    public String getRegistrationNumber() { return registrationNumber; }

    public abstract double calculateFinalScore();

    @Override
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Reg No: " + registrationNumber);
        System.out.printf("Final Score: %.2f%n", calculateFinalScore());
    }
}

class CourseworkStudent extends Student {
    private double assignmentMark, testMark, examMark;

    public CourseworkStudent(String name, String regNo,
                             double assignmentMark, double testMark, double examMark) {
        super(name, regNo);
        this.assignmentMark = assignmentMark;
        this.testMark = testMark;
        this.examMark = examMark;
    }

    @Override
    public double calculateFinalScore() {
        return assignmentMark * 0.2 + testMark * 0.2 + examMark * 0.6;
    }
}

class ExamOnlyStudent extends Student {
    private double examMark;

    public ExamOnlyStudent(String name, String regNo, double examMark) {
        super(name, regNo);
        this.examMark = examMark;
    }

    @Override
    public double calculateFinalScore() { return examMark; }
}

// ---------- The only public class ----------
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 1 ===");
        FullTimeEmployee emp = new FullTimeEmployee("IAN", 101, 1_500_000);
        System.out.println(emp.getName() + " earns " + emp.getMonthlySalary()
                + " per month (" + emp.getAnnualSalary() + " per year)");

        System.out.println("\n=== Assignment 1 ===");
        Student[] students = {
            new CourseworkStudent("John", "2024/BSE/0852", 80, 70, 65),
            new ExamOnlyStudent("Briffin", "2024/BSE/0024", 72)
        };

        for (Student s : students) {
            s.display();
            System.out.println("-----");
        }
    }
}
