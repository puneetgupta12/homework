package com.gupta.java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareWeight {

    public static void main(String[] args) {
        List<Apple> list1 = Arrays.asList(
                new Apple("red", 2, 3.5),
                new Apple("green", 4, 3.5),
                new Apple("red", 3, 3.5)
        );

        List<Apple> list2 = Arrays.asList(
                new Apple("red", 2.5, 3.5),
                new Apple("green", 4.53, 3.52),
                new Apple("red", 3.46, 3.53),
                new Apple("green", 4.53, 3.55)
        );

        list1.sort(Comparator.comparing(Apple::getWeight));
        list1.forEach(a -> System.out.println(a.getWeight()));

        list2.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getPrice));
        list2.forEach(a -> System.out.println(a.getWeight() + " - " + a.getPrice()));
    }

    private static class Apple {
        private String color;
        private double weight;
        private double price;

        public Apple(String color, double weight, double price) {
            this.color = color;
            this.weight = weight;
            this.price = price;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
