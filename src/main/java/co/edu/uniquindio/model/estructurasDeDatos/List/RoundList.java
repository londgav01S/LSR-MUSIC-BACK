package co.edu.uniquindio.model.estructurasDeDatos.List;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class RoundList <T extends Comparable<T>> implements LinkedList<T> {


    private Node<T> head;
    private int size;

    public void addAll(List<T> songs) {
    }

    private class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
        }
    }

    public RoundList() {
        size = 0;
    }

    private class RoundListIterator implements Iterator<T> {

        private Node<T> current;
        private int count;

        RoundListIterator(Node<T> start) {
            this.current = start;
            this.count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T value = current.element;
            current = current.next;
            count++;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundListIterator(head);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        LinkedList.super.forEach(action);
    }

    @Override
    public void addHead(T element) {
        var node = new Node<>(element);
        if (isEmpty()) node.next = node;
        else {
            node.next = head;
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = node;
        }
        head = node;
        size++;
    }

    @Override
    public void addTail(T element) {
        var node = new Node<>(element);
        if (isEmpty()) node.next = node;
        else {
            node.next = head;
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addHead(element);
        else if (index == size) addTail(element);
        else {
            var node = new Node<>(element);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    @Override
    public boolean validIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;

    }

    @Override
    public void removeHead() {

    }

    @Override
    public void removeTail() {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(T element) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void print() {

    }

    @Override
    public void clean() {

    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public void extend(LinkedList<T> linkedList) {

    }

    @Override
    public void sort(Comparator<T> comparator) {

    }

    @Override
    public void addAll(DoubleLinkedList<T> songs) {

    }


}
