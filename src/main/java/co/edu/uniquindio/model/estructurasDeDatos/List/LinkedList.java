package co.edu.uniquindio.model.estructurasDeDatos.List;

import java.util.Comparator;
import java.util.List;

public interface LinkedList<T extends Comparable<T>> extends Iterable<T>{

    void addHead(T element);
    void addTail(T element);
    void add(int index, T element);
    boolean validIndex(int index);
    boolean isEmpty();
    void removeHead();
    void removeTail();
    void remove(int index);
    void remove(T element);
    void sort();
    void print();
    void clean();
    List<T> toList();
    void extend(LinkedList<T> linkedList);
    void sort(Comparator<T> comparator);

    void addAll(DoubleLinkedList<T> songs);
}
