package com.gupta.java.personal.datastructures;

import java.util.Comparator;

public class CustomHashMapWithChaining<K,V> {

    private int size = 16;
    private SortedList[] map;

    public int getHashCode(K k) {
        return k.hashCode() % size;
    }

    public CustomHashMapWithChaining() {
        map = new SortedList[size];
        for (int i = 0; i < size; i++) {
            map[i] = new SortedList();
        }
    }

    public void put(K k, V v) {
        int index = getHashCode(k);
        Entry<K,V> entry = new Entry<>(k,v, null);
        map[index].put(entry);
    }

    public void display() {
        for (SortedList s : map) {
            s.display();
        }
    }

    public class Entry<K,V> {
        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K,V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    public class CustomComparator<V extends Comparable<V>> implements Comparator<V> {

        @Override
        public int compare(V o1, V o2) {
            return o1.compareTo(o2);
        }
    }

    public class SortedList<K,V extends Comparable> {
        private Entry<K,V> first;

        public SortedList() {
            first = null;
        }

        public void put(Entry<K,V> entry) {
            K key = entry.getKey();
            V value = entry.getValue();
            Entry<K,V> previous = null;
            Entry<K,V> current = first;

            while (current != null
                    && new CustomComparator().compare(value, current.getValue()) > 0) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                first = entry;
            } else {
                previous.next = entry;
                entry.next = current;
            }
        }

        public void display() {
            while (first != null) {
                System.out.println(first.getKey() + " = " + first.getValue());
                first = first.next;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMapWithChaining test = new CustomHashMapWithChaining<Integer, Integer>();
        test.put(1, 100);
        test.put(3, 200);
        test.put(3, 300);
        test.display();

        CustomHashMapWithChaining test1 = new CustomHashMapWithChaining<String, String>();
        test1.put("hello", "world");
        test1.put("bye", "universe");
        test1.put("hello", "world100");
        test1.display();
    }
}
