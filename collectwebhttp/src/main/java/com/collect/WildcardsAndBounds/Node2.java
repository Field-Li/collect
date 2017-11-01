package com.collect.WildcardsAndBounds;

/**
 * Created by lifana on 2017/7/17.
 */
public class Node2<T  extends Comparable<T>> {
    private T data;
    private Node2<T> next;

    public Node2(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node2<T> getNext() {
        return next;
    }

    public void setNext(Node2<T> next) {
        this.next = next;
    }
}
