package org.algo.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

/**
 * Task: Group Employees by Department
 * Suppose you have a list of employees. Each employee belongs to a department, has a name, and a salary.
 * <p>
 * 1. Define the Employee Class:
 * <p>
 * public class Employee {
 * private String name;
 * private String department;
 * private double salary;
 * <p>
 * // Constructors, getters, setters, and other methods
 * }
 * Input Sample:
 * <p>
 * List<Employee> employees = Arrays.asList(
 * new Employee("Alice", "IT", 60000),
 * new Employee("Bob", "HR", 50000),
 * new Employee("Charlie", "IT", 65000),
 * new Employee("Daisy", "Finance", 55000),
 * new Employee("Eve", "HR", 52000),
 * new Employee("Frank", "Finance", 57000)
 * );
 * Your Task:
 * Write a method that groups employees by their department and calculates the average salary for each department.
 * The result should be a Map<String, Double>, where the key is the department name and the value is the average salary
 * of that department.
 * <p>
 * Expected Output:
 * For the above input list, the method should return a map:
 * <p>
 * {
 * "IT" -> 62500.0,
 * "HR" -> 51000.0,
 * "Finance" -> 56000.0
 * }
 * Remember to utilize Java Streams, and especially the groupingBy and averagingDouble collectors to solve this task.
 * Once you provide a solution, I'll review it and provide feedback!
 */
public class GroupEmployeesbyDepartment {

    public static void main(String[] args) {
        var employees = Arrays.asList(
                new Employee("Alice", "IT", 60000),
                new Employee("Bob", "HR", 50000),
                new Employee("Charlie", "IT", 65000),
                new Employee("Daisy", "Finance", 55000),
                new Employee("Eve", "HR", 52000),
                new Employee("Frank", "Finance", 57000)
        );

        var result = new GroupEmployeesbyDepartment().solve(employees);
        System.out.println(result);
    }

    public Map<String, Double> solve(List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(
                        Employee::getDepartment,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        averagingDouble(Employee::getSalary)
                ));
    }

    public static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, department, salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
