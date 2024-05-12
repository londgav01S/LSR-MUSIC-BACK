package co.edu.uniquindio.model.estructurasDeDatos.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DoubleLinkedList <T extends Comparable<T>> implements LinkedList<T>{
    private Node<T> head;
    private int size;

    private class Node<T>{
        T element;
        Node<T> next;
        Node<T> prev;

        Node(T element){
            this.element = element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public void addHead(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addHead'");
    }

    @Override
    public void addTail(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTail'");
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean validIndex(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validIndex'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void removeHead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeHead'");
    }

    @Override
    public void removeTail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTail'");
    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }

    @Override
    public void clean() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clean'");
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        for (T t : this) list.add(t);
        return list;
    }

    @Override
    public void extend(LinkedList<T> linkedList) {
        for (T t : linkedList) addTail(t);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        if (head == null || head.next == null) return;

        Node<T> current = head;
        while (current.next != null) {
            Node<T> min = current;
            Node<T> innerCurrent = current.next;
            while (innerCurrent != null) {
                if (comparator.compare(innerCurrent.element, min.element) < 0) {
                    min = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            T temp = current.element;
            current.element = min.element;
            min.element = temp;
            current = current.next;
        }
    }
}
