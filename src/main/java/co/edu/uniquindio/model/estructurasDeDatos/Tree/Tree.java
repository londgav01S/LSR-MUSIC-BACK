package co.edu.uniquindio.model.estructurasDeDatos.Tree;

/**
 * Interfaz que define las operaciones básicas que debe proporcionar una estructura de datos tipo árbol.
 *
 * @param <T> el tipo de elemento que contendrá el árbol
 */
public interface Tree<T> extends Iterable<T> {

    /**
     * Inserta un nuevo valor en el árbol.
     *
     * @param value el valor que se va a insertar en el árbol
     */
    void insert(T value);

    /**
     * Verifica si un valor dado existe en el árbol.
     *
     * @param value el valor que se busca en el árbol
     * @return true si el valor existe en el árbol, false de lo contrario
     */
    boolean exists(T value);

    /**
     * Verifica si el árbol está vacío.
     *
     * @return true si el árbol está vacío, false de lo contrario
     */
    boolean isEmpty();

    /**
     * Busca un valor dado en el árbol y lo devuelve si se encuentra.
     *
     * @param value el valor que se busca en el árbol
     * @return el valor encontrado en el árbol, o null si no se encuentra
     */
    T find(T value);

    /**
     * Obtiene un elemento del árbol según un criterio específico, por ejemplo, el nombre del autor.
     *
     * @param author el autor del elemento que se desea obtener
     * @return el elemento encontrado en el árbol, o null si no se encuentra
     */
    T obtener(String author);

    /**
     * Retorna un iterador sobre los elementos del árbol.
     *
     * @return un iterador sobre los elementos del árbol
     */
    @Override
    java.util.Iterator<T> iterator();


    int size();
}
