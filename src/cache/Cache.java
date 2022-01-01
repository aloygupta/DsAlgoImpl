package cache;

/**
 * Taking interface signature from here.
 * https://leetcode.com/problems/lru-cache/
 */
public interface Cache<K,V> {

    // Return the value of the key if the key exists, otherwise return -1.
    V get(K key);

    // Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    void put(K key, V value);
}
