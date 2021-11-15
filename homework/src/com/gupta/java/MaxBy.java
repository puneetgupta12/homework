package com.gupta.java;

import java.util.*;
import java.util.stream.Collectors;

public class MaxBy {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Cersei", 23, "King", "Lannister"),
                new Employee("Jamie", 18, "Prince", "Lannister"),
                new Employee("Tyrion", 45, "Soldier", "Lannister"),
                new Employee("Robb", 27, "King", "Stark"),
                new Employee("Sansa", 31, "Princess", "Stark"),
                new Employee("Arya", 15, "Girl", "Stark"),
                new Employee("Jon Snow", 29, "Boy", "Stark")
        );

        //Max Age
        Optional<Employee> maxAgedEmp = employees.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println(maxAgedEmp.get().getName() + ":" + maxAgedEmp.get().getAge());

        //Max Age - method 2 to just get the age
        OptionalInt maxAgedEmp2 = employees.stream().mapToInt(Employee::getAge).max();
        System.out.println(maxAgedEmp2.getAsInt());

        //Max Age - method 3
        Optional<Employee> maxAgedEmp3 = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println(maxAgedEmp3.get().getName() + ":" + maxAgedEmp3.get().getAge());

        //Groupby age
        Map<String, Optional<Employee>> groupedByMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));

        groupedByMap.forEach((k,v) -> System.out.println(k + ":" + v.get().getAge()));

//        Result should be:
//        Lannister:45
//        Stark:31
    }

    private static class Employee {
        private String name;
        private int age;
        private String designation;
        private String department;

        public Employee(String name, int age, String designation, String department) {
            this.name = name;
            this.age = age;
            this.designation = designation;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }
    }
}
