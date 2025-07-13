package com.gupta.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveFromList {
    public static void main(String[] args) {
        //Lets create list old-fashioned way, since Arrays.asList() creates an immutable list
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("James", "AB2345", 987.45));
        transactions.add(new Transaction("Jeremy", "367FGH", 1003.45));
        transactions.add(new Transaction("Sudhir", "347AHDH", 8976.50));
        transactions.add(new Transaction("Debashis", "O8934789", 1200.67));

        //This throws ConcurrentModificationException
        try {
            for (Transaction tx : transactions) {
                if (Character.isDigit(tx.getReferenceCode().charAt(0))) {
                    transactions.remove(tx);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Try removeIf for the above - remove if 1st character is not a digit
        transactions.removeIf(tx -> Character.isDigit(tx.getReferenceCode().charAt(0)));
        transactions.stream().map(t -> t.getCustomerName()).forEach(System.out::println);

        //Different method to remove
        Iterator<Transaction> itr = transactions.iterator();

        while (itr.hasNext()) {
            Transaction tx = itr.next();
            if (Character.isDigit(tx.getReferenceCode().charAt(0))) {
                itr.remove();
            }
        }

        transactions.forEach(t -> System.out.println(t.getCustomerName()));
    }

    private static class Transaction {
        private String customerName;
        private String referenceCode;
        private double amount;

        public Transaction(String customerName, String referenceCode, double amount) {
            this.customerName = customerName;
            this.referenceCode = referenceCode;
            this.amount = amount;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getReferenceCode() {
            return referenceCode;
        }

        public void setReferenceCode(String referenceCode) {
            this.referenceCode = referenceCode;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
