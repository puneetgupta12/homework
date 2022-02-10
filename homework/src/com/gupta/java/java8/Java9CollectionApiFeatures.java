package com.gupta.java.java8;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9CollectionApiFeatures {
    public static void main(String[] args) {
        //This creates an immutable list - this CANNOT be modified
        List<String> friends = List.of("Tom", "Mat", "Adam");
        friends.forEach(p -> System.out.println(p + ", "));

        //Try modifying the list and it throws UnsupportedOperationException
        try {
            friends.add("Amy");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        //Create a Set
        Set<String> setOfFriends = Set.of("Murali", "Karthik", "Shanamugham");
        setOfFriends.forEach(System.out::println);

        //Create a map
        //1st way - For simple maps
        Map<String, Integer> mapOfFriends = Map.of("Manoj", 35, "Jayesh", 34, "Satish", 32);
        mapOfFriends.forEach((k,v) -> System.out.println(k + "=" + v));

        //2nd way - For complex maps
        Map<String, Integer> ageOfFriends = Map.ofEntries(
                Map.entry("Raphael", 30),
                Map.entry("Olivia", 24),
                Map.entry("Tom", 64)
        );
        System.out.println(ageOfFriends);
    }
}
