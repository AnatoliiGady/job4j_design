package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private int hash(int hashCode) {
        return (hashCode) ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & table.length - 1;
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity <<= 1;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> entry : oldTable) {
            if (entry != null) {
                int i = getIndex(entry.key);
                table[i] = new MapEntry<>(entry.key, entry.value);
            }
        }
    }

    private int getIndex(K key) {
        return key == null ? 0 : indexFor(hash(key.hashCode()));
    }


    @Override
    public boolean put(K key, V value) {
        if ((double) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        int index = getIndex(key);
        boolean result = table[index] == null;
        if (result) {
            table[index] = new MapEntry<>(key, value);
            modCount++;
            count++;
        }
        return result;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return isValid(key) ? table[index].value : null;
    }


    @Override
    public boolean remove(K key) {
        int index = getIndex(key);
        boolean rsl = isValid(key);
        if (rsl) {
            table[index] = null;
            modCount++;
            count--;
        }
        return rsl;
    }

    private boolean isValid(K key) {
        int index = getIndex(key);
        return (key != null && table[index] != null
                && table[index].key != null
                && table[index].key.hashCode() == key.hashCode())
                || table[index] != null && Objects.equals(table[index].key, key);
    }


    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
