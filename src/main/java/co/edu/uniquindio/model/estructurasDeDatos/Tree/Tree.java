package co.edu.uniquindio.model.estructurasDeDatos.Tree;

public interface Tree <T> extends Iterable<T> {

    void insert(T value);
    boolean exists(T value);
    boolean isEmpty();
    T find(T value);
    int size();

    T obtener(String author);
}
