package com.gupta.java.hackerrank.sapient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomCache<K, V> {
    Map<K,V> cache;

    public CustomCache() {
        this.cache = new HashMap<>();
    }

    public void put(K key, V value){
        //TODO implement this method
        if (cache.containsKey(key)) {
            //Replace the key
            cache.remove(key);
            cache.put(key, value);
        } else {
            if (cache.size() == 0) {
                cache.put(key, value);
                return;
            }

            Class<?> keyClass = key.getClass();
            Class<?> valueClass = value.getClass();

            //Otherwise, we will get ConcurrentModificationException
            Iterator<Map.Entry<K,V>> itr = cache.entrySet().iterator();

            if (itr.hasNext()) {
                Map.Entry<K,V> entry = itr.next();

                Class<?> cacheKeyClass = entry.getKey().getClass();
                Class<?> cacheValueClass = entry.getValue().getClass();

                if (valueClass.equals(cacheValueClass)
                        || valueClass.isInstance(cacheValueClass)
                            || valueClass.isAssignableFrom(cacheValueClass)
                                || (!valueClass.getSuperclass().getName().contains("Object") && valueClass.getSuperclass().isAssignableFrom(cacheValueClass))) {
                    cache.put(key, value);
                } else {
                    if (keyClass.equals(cacheKeyClass)
                            || keyClass.isInstance(cacheKeyClass)
                            || keyClass.isAssignableFrom(cacheKeyClass)) {
                        //Don't add, since for same key type different values can not be added
                        if (cacheValueClass.getName().contains("Integer")) {
                            throw new IllegalArgumentException("Object of class [class " + valueClass.getName() + "] not allowable for this Key Type [class " + cacheKeyClass.getName() + "]." +
                                    " Allowed types are [class java.lang.Integer] or it sub and super types");
                        } else {
                            throw new IllegalArgumentException("Object of class [class " + valueClass.getName() + "] not allowable for this Key Type [class " + cacheKeyClass.getName() + "]." +
                                    " Allowed types are [class " + cacheValueClass.getSuperclass().getName() + "] or it sub and super types");
                        }
                    } else {
                        cache.put(key, value);
                    }
                }
            }
        }
    }

    public boolean remove(K key){
        //TODO implement this method
        if (cache.containsKey(key)) {
            cache.remove(key);
            return true;
        }

        return false;
    }


    public V get(K key){
        //TODO implement this method
        return cache.get(key);
    }
}