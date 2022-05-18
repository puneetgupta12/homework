package com.gupta.java.personal.datastructures;

import java.util.Objects;

public class CustomHashMap<K,V> {
    private Entry<K,V> [] map;
    private int size;

    public CustomHashMap(int size) {
        this.size = size;
        this.map = new Entry[size];
    }

    public int getHashCode(K k) {
        return k.hashCode() % size;
    }

    public void put(K k, V v) {
        int index = getHashCode(k);
        Entry newEntry = new Entry(k, v, null);

        if (map[index] == null) {
            map[index] = newEntry;
        } else {
            Entry<K,V> previous = null;
            Entry<K,V> current = map[index];

            while (current != null) {

                if (current.getKey().equals(k)) {
                    current.setValue(v);
                    break;
                }

                previous = current;
                current = current.next;
            }

            if (previous == null) {
                current = newEntry;
            } else {
                previous.next = newEntry;
                newEntry.next = current;
            }
        }
    }

    public V get(K k) {
        int index = getHashCode(k);

        if (map[index] != null) {
            return map[index].getValue();
        }

        return null;
    }

    public void delete(K k) {
        int index = getHashCode(k);
        map[index].setValue(null);
        map[index].setKey(null);
        map[index] = null;
    }

    public void display() {
        for (Entry<K,V> e : map) {
            while (e != null) {
                System.out.println(e.getKey() + " = " + e.getValue());
                e = e.getNext();
            }
        }
    }

    public class Entry<K,V> {
        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next) {
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

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>(16);

        customHashMap.put(1, "hello");
        customHashMap.put(3, "world");
        System.out.println(customHashMap.get(3));
        customHashMap.put(5, "universe");
        customHashMap.put(3, "changed world");
        System.out.println(customHashMap.get(3));
        customHashMap.delete(1);
        System.out.println(customHashMap.get(1));

        customHashMap.display();
    }
}
