package co.edu.uniquindio.model.estructurasDeDatos.List;

import java.util.*;

/**
 * Implementación de una lista simple enlazada genérica.
 *
 * @param <T> el tipo de elementos que contendrá la lista
 */
public class SimpleList<T extends Comparable<T>> implements LinkedList<T> {
    private Node<T> head; // El nodo inicial de la lista
    private int size; // El tamaño de la lista

    /**
     * Constructor predeterminado que inicializa una lista vacía.
     */
    public SimpleList() {
        size = 0;
    }

    /**
     * Constructor que inicializa una lista con un nodo específico como cabeza.
     *
     * @param head el nodo inicial de la lista
     */
    public SimpleList(Node<T> head) {
        this.head = head;
        this.size = 0;
    }

    // Clase interna que representa un nodo en la lista
    private class Node<T> {
        T element; // El elemento almacenado en el nodo
        Node<T> next; // El siguiente nodo en la lista

        // Constructor para crear un nuevo nodo con un elemento
        public Node(T element) {
            this.element = element;
        }
    }

    // Clase interna que implementa el iterador para la lista
    private class SimpleListIterator implements Iterator<T> {
        private Node<T> node; // El nodo actual del iterador

        // Constructor para crear un iterador con un nodo específico
        SimpleListIterator(Node<T> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T value = node.element;
            node = node.next;
            return value;
        }

    }


    /**
     * Retorna un iterador sobre los elementos de la lista.
     *
     * @return un iterador sobre los elementos de la lista
     */
    @Override
    public Iterator<T> iterator() {
        return new SimpleListIterator(head);
    }

    /**
     * Agrega un nuevo elemento al inicio de la lista.
     *
     * @param element el elemento que se va a agregar
     */
    @Override
    public void addHead(T element) {
        var node = new Node<>(element);
        if (!isEmpty()) node.next = head;
        head = node;
        size++;
    }

    /**
     * Agrega un nuevo elemento al final de la lista.
     *
     * @param element el elemento que se va a agregar
     */
    @Override
    public void addTail(T element) {
        var node = new Node<>(element);
        if (isEmpty()) head = node;
        else {
            var current = head;
            while (current.next != null) current = current.next;
            current = node;
        }
        size++;
    }

    /**
     * Agrega un nuevo elemento en una posición específica de la lista.
     *
     * @param index   la posición en la que se va a agregar el elemento
     * @param element el elemento que se va a agregar
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista
     */
    @Override
    public void add(int index, T element) {
        if (!validIndex(index)) throw new IndexOutOfBoundsException();
        var node = new Node<>(element);
        if (isEmpty() || index == 0) {
            node.next = head;
            head = node;
        } else {
            int currentPos = 0;
            var current = head;
            while (currentPos != index - 1) {
                current = current.next;
                currentPos++;
            }
            node.next = current.next;
            current.next = node;
        }
        size++;
    }

    /**
     * Verifica si un índice dado es válido para la lista.
     *
     * @param index el índice a verificar
     * @return true si el índice es válido, false de lo contrario
     */
    @Override
    public boolean validIndex(int index) {
        return size > index;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false de lo contrario
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Elimina el primer elemento de la lista.
     *
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public void removeHead() {
        if (isEmpty()) throw new NoSuchElementException();
        head = head.next;
        size--;
    }

    /**
     * Elimina el último elemento de la lista.
     *
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public void removeTail() {
        if (isEmpty()) throw new NoSuchElementException();
        if (head.next == null) head = null;
        else {
            var current = head;
            Node<T> previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
        }
        size--;
    }

    /**
     * Elimina el elemento en una posición específica de la lista.
     *
     * @param index la posición del elemento a eliminar
     * @throws NoSuchElementException si la lista está vacía
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista
     */
    @Override
    public void remove(int index) {
        if (isEmpty()) throw new NoSuchElementException();
        if (!validIndex(index)) throw new IndexOutOfBoundsException();
        if (index == 0) head = null;
        else {
            int currentPos = 0;
            var current = head;
            while (currentPos != index - 1) {
                current = current.next;
                currentPos++;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Elimina la primera ocurrencia de un elemento de la lista.
     *
     * @param element el elemento a eliminar
     * @throws NoSuchElementException si la lista está vacía o el elemento no está presente
     */
    @Override
    public void remove(T element) {
        if (isEmpty()) throw new NoSuchElementException();
        if (head.element.equals(element)) head = head.next;
        else {
            var current = head;
            Node<T> previous = null;
            while (!current.element.equals(element)) {
                if (current.next == null) throw new NoSuchElementException();
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        size--;
    }

    /**
     * Ordena los elementos de la lista en orden ascendente.
     */
    @Override
    public void sort() {
        if (isEmpty() || size == 1) return;
        head = quickSort(head);
    }


    /**
     * Implementación del algoritmo de ordenación rápida (QuickSort) para una lista enlazada.
     *
     * @param node el nodo que representa el inicio de la lista a ordenar
     * @return el nodo que representa el inicio de la lista ordenada
     */
    private Node<T> quickSort(Node<T> node) {
        if (node == null || node.next == null) return node;

        Node<T> pivot = node;
        Node<T> lessHead = null;
        Node<T> greaterHead = null;
        Node<T> equalHead = pivot;
        Node<T> current = node.next;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            if (current.element.compareTo(pivot.element) < 0) {
                current.next = lessHead;
                lessHead = current;
            } else if (current.element.compareTo(pivot.element) > 0) {
                current.next = greaterHead;
                greaterHead = current;
            } else {
                current.next = equalHead;
                equalHead = current;
            }
            current = next;
        }

        // Recursivamente ordenar las sublistas
        lessHead = quickSort(lessHead);
        greaterHead = quickSort(greaterHead);

        // Unir las sublistas ordenadas
        if (lessHead != null) {
            Node<T> temp = lessHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = equalHead;
        } else {
            lessHead = equalHead;
        }
        equalHead.next = greaterHead;

        return lessHead;
    }

    /**
     * Imprime los elementos de la lista enlazada.
     */
    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.element);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Elimina todos los elementos de la lista y la deja vacía.
     */
    @Override
    public void clean() {
        head = null;
        size = 0;
    }

    /**
     * Convierte la lista enlazada a una lista estándar de Java.
     *
     * @return una lista estándar de Java que contiene los elementos de la lista enlazada
     */
    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        for (T t : this) list.add(t);
        return list;
    }

    /**
     * Extiende la lista enlazada actual agregando todos los elementos de otra lista enlazada.
     *
     * @param linkedList la lista enlazada cuyos elementos se agregarán a la lista actual
     */
    @Override
    public void extend(LinkedList<T> linkedList) {
        for (T t : linkedList) addTail(t);
    }

    /**
     * Ordena los elementos de la lista enlazada utilizando un comparador dado.
     * Se implementa el algoritmo de ordenación de selección (selection sort).
     *
     * @param comparator el comparador que define el orden de los elementos
     */
    @Override
    public void sort(Comparator<T> comparator) {
        if (head == null || head.next == null) return;

        Node<T> current = head;
        while (current != null) {
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

    /**
     * No implementado. Agrega todos los elementos de una lista doblemente enlazada a esta lista.
     *
     * @param songs la lista doblemente enlazada cuyos elementos se agregarán a esta lista
     */
    @Override
    public void addAll(DoubleLinkedList<T> songs) {

    }

}
