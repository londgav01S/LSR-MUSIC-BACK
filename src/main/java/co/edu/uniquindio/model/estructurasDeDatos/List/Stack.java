package co.edu.uniquindio.model.estructurasDeDatos.List;

import java.util.NoSuchElementException;

public class Stack<T> {
    private NodeStack pointer;

    private class NodeStack{
        T data;
        NodeStack previous;


        public NodeStack( NodeStack previous,T data) {
            this.data = data;
            this.previous = previous;
        }

    }
    public void push(T element) {
        if (pointer == null)
            pointer = new NodeStack(null, element);
        else
            pointer = new NodeStack(pointer, element);
    }

    public T pop() {
        if (pointer == null)
            throw new NoSuchElementException("");
        T t = pointer.data;
        pointer = pointer.previous;
        return t;
    }

    public boolean isEmpty() {
        return pointer == null;
    }

    public T peek() {
        if (pointer == null)
            throw new NoSuchElementException("");
        return pointer.data;
    }

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

    @Override
    public String toString() {
        return getValuesString();
    }
}
