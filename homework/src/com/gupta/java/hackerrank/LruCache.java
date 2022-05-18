package com.gupta.java.hackerrank;

import java.util.*;

public class LruCache<K,V> {
    Map<K,V> cache;
    final int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cache = Collections.synchronizedMap(new LinkedHashMap<K,V>(capacity));
    }

    public Optional<V> get(K k) {
        if (!cache.containsKey(k)) {
            return Optional.empty();
        }

        V val = cache.get(k);
        cache.remove(k);
        cache.put(k, val);
        return Optional.ofNullable(val);
    }

    public void put(K k, V v) {
        if (cache.size() == capacity) {
            Optional<K> key = cache.keySet().stream().findFirst();

            if (key.isPresent()) {
                cache.remove(key.get());
            }
        }

        cache.put(k, v);
    }

    public void display() {
        cache.entrySet().stream().forEach(c -> System.out.println(c.getKey() + "=" + c.getValue()));
    }

    public static void main(String[] args) {
        LruCache<Integer, String> lruCache1 = new LruCache<>(5);

        lruCache1.put(1, "apple");
        lruCache1.put(2, "banana");
        lruCache1.put(3, "cashew");
        lruCache1.put(4, "door");
        lruCache1.put(5, "elephant");
        lruCache1.display();

        System.out.println("------");
        lruCache1.get(3);
        lruCache1.put(6, "hyena");
        lruCache1.put(7, "panther");
        lruCache1.display();

        System.out.println("------");
        lruCache1.get(5);
        lruCache1.put(8, "tiger");
        lruCache1.put(9, "lion");
        lruCache1.display();

        System.out.println("------");
        LruCache<Integer, List<String>> lruCache2 = new LruCache<>(4);
        lruCache2.put(1, Arrays.asList("a1", "b1", "c"));
        lruCache2.put(2, Arrays.asList("a2", "b2", "c2"));
        lruCache2.put(3, Arrays.asList("a3", "b3", "c3"));
        lruCache2.put(4, Arrays.asList("a4", "b4", "c4"));
        lruCache2.display();

        System.out.println("------");
        lruCache2.get(3);
        lruCache2.display();

        System.out.println("------");
        lruCache2.get(4);
        lruCache2.display();
    }
}
