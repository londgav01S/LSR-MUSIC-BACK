package co.edu.uniquindio.model.estructurasDeDatos.Tree;

/**
 * Clase que representa un nodo en un árbol binario.
 *
 * @param <T> el tipo de dato que contiene el nodo, debe ser comparable
 */
public class TreeNode<T extends Comparable<T>> {
    private T value; // El valor almacenado en el nodo
    private TreeNode<T> left; // Referencia al hijo izquierdo
    private TreeNode<T> right; // Referencia al hijo derecho

    /**
     * Constructor para crear un nuevo nodo con un valor dado.
     *
     * @param value el valor que se almacenará en el nodo
     */
    public TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return el valor almacenado en el nodo
     */
    public T getValue() {
        return value;
    }

    /**
     * Establece el valor almacenado en el nodo.
     *
     * @param value el valor que se establecerá en el nodo
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Obtiene la referencia al hijo izquierdo del nodo.
     *
     * @return la referencia al hijo izquierdo del nodo
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Establece la referencia al hijo izquierdo del nodo.
     *
     * @param left la referencia al nodo que se establecerá como hijo izquierdo
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Obtiene la referencia al hijo derecho del nodo.
     *
     * @return la referencia al hijo derecho del nodo
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Establece la referencia al hijo derecho del nodo.
     *
     * @param right la referencia al nodo que se establecerá como hijo derecho
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Retorna una representación en cadena del nodo, mostrando su valor.
     *
     * @return una cadena que representa el nodo
     */
    @Override
    public String toString() {
        return "TreeNode [value=" + value + "]";
    }
}
