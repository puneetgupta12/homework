package com.gupta.java.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare2Lists {
    public static void main(String[] args) {
        List<Employee> list1 = Arrays.asList(
                new Employee("tom", 28, "ASSOC"),
                new Employee("mary", 45, "VP")
        );

        List<Employee> list2 = Arrays.asList(
                new Employee("tom", 28, "ASSOC"),
                new Employee("anna", 55, "ED")
        );

        //Another approach
        List<Employee> diff = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (!list1.get(i).equals(list2.get(j))) {
                    diff.add(list1.get(i));
                    diff.add(list2.get(j));
                } else {
                    break;
                }
            }
        }

        diff.stream().forEach(d -> System.out.println(d.getName()));

        //Method 1: Start
//        Set<Employee> list1Lookup = list1.stream().collect(Collectors.toSet());
//
//        Set<Employee> list2Lookup = list2.stream().collect(Collectors.toSet());
//
//        List<Employee> matched = list2.stream()
//                .filter(emp -> list1Lookup.contains(emp)).collect(Collectors.toList());
//
//        List<Employee> unmatched = list2.stream()
//                .filter(emp -> !list1Lookup.contains(emp)).collect(Collectors.toList());
//
//        list1.stream().filter(emp -> !list2Lookup.contains(emp)).
//                collect(Collectors.toCollection(() -> unmatched));
//
//        System.out.println("Matched List: ");
//        matched.forEach(e -> System.out.println(e.getName()));
//
//        System.out.println("Unmatched List: ");
//        unmatched.forEach(e -> System.out.println(e.getName()));
//        //Method 1: End
//
//        //Method 2: Start
//        Map<String, Employee> list1Map = list1.stream()
//                .collect(Collectors.toMap(Employee::getName, Function.identity()));
//
//        Map<String, Employee> list2Map = list2.stream()
//                .collect(Collectors.toMap(Employee::getName, Function.identity()));
//
//        List<Employee> matched2 = list2.stream()
//                .filter(emp -> list1Map.containsKey(emp.getName())).collect(Collectors.toList());
//
//        List<Employee> unmatched2 = list1.stream()
//                .filter(emp -> !list2Map.containsKey(emp.getName())).collect(Collectors.toList());
//
//        list2.stream().filter(emp -> !list1Map.containsKey(emp.getName()))
//                .collect(Collectors.toCollection(() -> unmatched2));
//
//        System.out.println("Matched2 List: ");
//        matched.forEach(e -> System.out.println(e.getName()));
//
//        System.out.println("Unmatched2 List: ");
//        unmatched.forEach(e -> System.out.println(e.getName()));
        //Method 2: End
    }

    private static class Employee {
        private String name;
        private int age;
        private String designation;

        public Employee(String name, int age, String designation) {
            this.name = name;
            this.age = age;
            this.designation = designation;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(designation, employee.designation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, designation);
        }
    }
}
