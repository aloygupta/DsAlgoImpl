package cache.impl;

import cache.Cache;

import java.util.LinkedHashMap;

/**
 * Implements a Least Recently Used Cache.
 */
public class LRUCache<K,V> implements Cache<K,V> {

    private LinkedHashMap<K,V> cache;
    private int capacity;

    // Initialize the LRU cache with positive size capacity.
    public LRUCache(int capacity){
       this.cache = new LinkedHashMap<>(capacity);
       this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        if(!cache.containsKey(key)){
            return null;
        }
        else{
            V value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
            return value;
        }
    }

    @Override
    public void put(K key, V value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            // update key's value and moving it to last
            cache.put(key,value);
        }
        else if(cache.size() == capacity){
            K firstKey = (K) cache.keySet().toArray()[0];
            // key absent. ----remove least recently used key - first key
            cache.remove(firstKey);
            cache.put(key,value);
        }
        else{
            // no key and not full capacity
            cache.put(key,value);
        }
        toString();
    }

    @Override
    public String toString() {
        System.out.println(cache.toString());
        return cache.toString();
    }
}
