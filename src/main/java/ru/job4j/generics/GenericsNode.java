package ru.job4j.generics;

public class GenericsNode<T> {
    private T data;
    private GenericsNode<T> next;

    public GenericsNode(T data, GenericsNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
