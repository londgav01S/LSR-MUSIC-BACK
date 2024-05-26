package co.edu.uniquindio.model.estructurasDeDatos.Tree;

import co.edu.uniquindio.model.estructurasDeDatos.List.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {
    private TreeNode<T> root;

    public BinaryTree() {

    }

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void insert(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        if (root == null) {
            root = new TreeNode<>(value);
        } else {
            insertRecursive(root, value);
        }
    }

    private void insertRecursive(TreeNode<T> node, T value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode<>(value));
            } else {
                insertRecursive(node.getLeft(), value);
            }
        } else if (value.compareTo(node.getValue()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new TreeNode<>(value));
            } else {
                insertRecursive(node.getRight(), value);
            }
        }
    }

    @Override
    public boolean exists(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        return existsRecursive(root, value);
    }

    private boolean existsRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            return existsRecursive(node.getLeft(), value);
        } else if (cmp > 0) {
            return existsRecursive(node.getRight(), value);
        } else {
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }


    @Override
    public T obtener(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        return obtenerRecursive(root, author);
    }

    private T obtenerRecursive(TreeNode<T> node, String author) {
        if (node == null) {
            return null;
        }
        int cmp = author.compareTo(node.getValue().toString());
        if (cmp < 0) {
            return obtenerRecursive(node.getLeft(), author);
        } else if (cmp > 0) {
            return obtenerRecursive(node.getRight(), author);
        } else {
            return node.getValue();
        }
    }

    @Override
    public T find(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        return findRecursive(root, value);
    }

    private T findRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            return findRecursive(node.getLeft(), value);
        } else if (cmp > 0) {
            return findRecursive(node.getRight(), value);
        } else {
            return node.getValue();
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Tree.super.forEach(action);
    }

    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator(root);
    }

    private class BinaryTreeIterator implements Iterator<T> {

        private Stack<TreeNode<T>> stack = new Stack<>();

        public BinaryTreeIterator(TreeNode<T> root) {
            addAllLeft(root);
        }

        private void addAllLeft(TreeNode<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (stack.isEmpty()) throw new NoSuchElementException();
            TreeNode<T> node = stack.pop();
            addAllLeft(node.getRight());
            return node.getValue();
        }
    }
}
