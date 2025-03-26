package Streams;

/**
 * Represents an Employee with basic attributes: name, age, department, and
 * salary.
 */
public class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor to initialize employee attributes
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters for accessing private fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Override toString for better readability
    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", name, department, salary);
    }
}
