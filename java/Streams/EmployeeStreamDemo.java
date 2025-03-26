package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Demonstrates the usage of Function Interface and Streams in Java.
 * Performs various operations on a dataset of Employee objects.
 */
public class EmployeeStreamDemo {

        public static void main(String[] args) {

                // Step 1: Create Dataset - List of Employees
                List<Employee> employees = Arrays.asList(
                                new Employee("Alice", 28, "HR", 50000),
                                new Employee("Bob", 35, "IT", 70000),
                                new Employee("Charlie", 32, "Finance", 65000),
                                new Employee("David", 25, "IT", 48000),
                                new Employee("Eve", 45, "HR", 78000),
                                new Employee("Frank", 38, "Finance", 73000));

                // Step 2: Define Function to Concatenate Name and Department
                /**
                 * Function to transform Employee object into a concatenated string.
                 * Format: "Name - Department"
                 */
                Function<Employee, String> nameDeptFunction = emp -> emp.getName() + " - " + emp.getDepartment();

                // Step 3: Create New Collection of Concatenated Strings Using Streams
                List<String> nameDeptList = employees.stream()
                                .map(nameDeptFunction) // Apply Function
                                .collect(Collectors.toList());

                System.out.println("▶ Concatenated Name - Department List:");
                nameDeptList.forEach(System.out::println);

                // Step 4: Calculate the Average Salary Using Streams
                double averageSalary = employees.stream()
                                .mapToDouble(Employee::getSalary) // Extract salary
                                .average()
                                .orElse(0.0); // Default if no employees

                System.out.printf("\n▶ Average Salary: $%.2f\n", averageSalary);

                // Step 5: Filter Employees with Age > 30
                List<Employee> filteredEmployees = employees.stream()
                                .filter(emp -> emp.getAge() > 30) // Age filter
                                .collect(Collectors.toList());

                System.out.println("\n▶ Employees with Age > 30:");
                filteredEmployees.forEach(System.out::println);

                // Step 6: Bonus Feature - Top 3 Highest Salaries
                System.out.println("\n▶ Top 3 Highest Paid Employees:");
                employees.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // Sort by salary
                                                                                                    // descending
                                .limit(3) // Top 3
                                .forEach(System.out::println);
        }
}
