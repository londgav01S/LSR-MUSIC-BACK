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

    }

    @Override
    public boolean exists(T value) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T find(T value) {
        return null;
    }



    @Override
    public void forEach(Consumer<? super T> action) {
        Tree.super.forEach(action);
    }

    public Iterator<T> iterator() {
        return new BinaryTreeIterator(root);
    }

    private class BinaryTreeIterator implements Iterator<T> {

        private Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();

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
