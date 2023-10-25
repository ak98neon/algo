package org.algo.queuestack;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        var list = List.of(
                new Employee("John", 1000),
                new Employee("Jane", 2000),
                new Employee("Ali", 1500)
        );
        PriorityQueue<Employee> pq = new PriorityQueue<>(Comparator.comparing(Employee::getName));

        for (var num : list) {
            pq.add(num);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static class Employee {
        public String name;
        public Integer salary;

        public Employee(String name, Integer salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
