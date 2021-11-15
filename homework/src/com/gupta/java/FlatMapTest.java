package com.gupta.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapTest {
    public static void main(String[] args) {
        //Create couple of orders
        Customer first = new Customer();
        first.setName("tom");
        first.addOrders(new Order(12345L, "Bike"));
        first.addOrders(new Order(2345L, "Grocery"));

        Customer second = new Customer();
        second.setName("mary");
        second.addOrders(new Order(12945L, "White Bike"));
        second.addOrders(new Order(2375L, "Meat"));

        List<Customer> customers = Arrays.asList(first, second);

        //Iterate without flatMap
        customers.stream().forEach(c -> c.getOrders().stream().forEach(o -> System.out.println(o.getOrderNumber())));

        //Iterate with flatMap
        customers.stream().flatMap(c -> c.getOrders().stream()).forEach(o -> System.out.println(o.getOrderNumber()));
    }

    private static class Customer {
        private String name;
        private List<Order> orders = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

        public Customer addOrders(Order order) {
            orders.add(order);
            return this;
        }
    }

    private static class Order {
        private Long orderNumber;
        private String orderDescription;

        public Order(Long orderNumber, String orderDescription) {
            this.orderNumber = orderNumber;
            this.orderDescription = orderDescription;
        }

        public Long getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(Long orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getOrderDescription() {
            return orderDescription;
        }

        public void setOrderDescription(String orderDescription) {
            this.orderDescription = orderDescription;
        }
    }
}
