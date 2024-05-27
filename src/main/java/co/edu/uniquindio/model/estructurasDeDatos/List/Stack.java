package co.edu.uniquindio.model.estructurasDeDatos.List;

import java.util.NoSuchElementException;

/**
 * Implementación de una pila (stack) genérica.
 *
 * @param <T> el tipo de elementos que contendrá la pila
 */
public class Stack<T> {
    private NodeStack pointer; // El nodo superior de la pila

    // Clase interna que representa un nodo en la pila
    private class NodeStack {
        T data; // El dato almacenado en el nodo
        NodeStack previous; // El nodo anterior en la pila

        // Constructor para crear un nuevo nodo con un dato y una referencia al nodo anterior
        public NodeStack(NodeStack previous, T data) {
            this.data = data;
            this.previous = previous;
        }
    }

    /**
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param element el elemento que se va a agregar a la pila
     */
    public void push(T element) {
        if (pointer == null)
            pointer = new NodeStack(null, element);
        else
            pointer = new NodeStack(pointer, element);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return el elemento en la parte superior de la pila
     * @throws NoSuchElementException si la pila está vacía
     */
    public T pop() {
        if (pointer == null)
            throw new NoSuchElementException("La pila está vacía");
        T t = pointer.data;
        pointer = pointer.previous;
        return t;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario
     */
    public boolean isEmpty() {
        return pointer == null;
    }

    /**
     * Obtiene pero no elimina el elemento en la parte superior de la pila.
     *
     * @return el elemento en la parte superior de la pila
     * @throws NoSuchElementException si la pila está vacía
     */
    public T peek() {
        if (pointer == null)
            throw new NoSuchElementException("La pila está vacía");
        return pointer.data;
    }

    // Método privado para obtener una representación en cadena de los elementos de la pila
    private synchronized String getValuesString() {
        StringBuilder sb = new StringBuilder("[");
        Stack<T> newStack = new Stack<T>();
        while (!this.isEmpty())
            newStack.push(this.pop());
        while (!newStack.isEmpty()) {
            T value = newStack.pop();
            sb.append(value.toString());
            if (!newStack.isEmpty())
                sb.append(", ");
            this.push(value);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Retorna una representación en cadena de la pila.
     *
     * @return una cadena que representa la pila
     */
    @Override
    public String toString() {
        return getValuesString();
    }
}
