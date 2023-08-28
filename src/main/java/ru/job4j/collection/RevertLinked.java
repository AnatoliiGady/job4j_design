package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RevertLinked<T> implements Iterable<T> {
    private Note<T> head;

    public void add(T value) {
        Note<T> node = new Note<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Note<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        if (head != null && head.next != null) {
            Note<T> previous = null;
            Note<T> current = head;
            while (current != null) {
                Note<T> next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Note<T> note = head;

            @Override
            public boolean hasNext() {
                return note != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = note.value;
                note = note.next;
                return value;
            }
        };


    }

    private static class Note<T> {
        T value;
        Note<T> next;

        public Note(T value, Note<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
