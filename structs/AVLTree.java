package structs;
import java.util.ArrayList;
import java.util.List;

/**
 * AVLTree.java
 * Implementación genérica de un árbol AVL (Auto-Balanced Binary Search Tree)
 * Autor: alejandrojsilvestre
 * @param <T> Tipo de dato almacenado
 */
public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;

    /**
     * Inserta un dato en el árbol AVL
     * @param data Dato a insertar (no puede ser nulo)
     * @throws IllegalArgumentException si data es nulo
     */
    public void insert(T data) {
        if (data == null) throw new IllegalArgumentException("El dato no puede ser nulo");
        root = insert(root, data);
    }

    /**
     * Busca un dato en el árbol AVL
     * @param data Dato a buscar
     * @return true si existe, false si no
     */
    public boolean search(T data) {
        return search(root, data) != null;
    }

    /**
     * Elimina un dato en el árbol AVL
     * @param data Dato a eliminar
     */
    public void remove(T data) {
        root = remove(root, data);
    }

    /**
     * Devuelve una lista con el recorrido in-order del árbol AVL
     * @return Lista de datos en orden
     */
    public List<T> inOrder() {
        List<T> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    /**
     * Devuelve la altura del árbol AVL
     * @return Altura del árbol
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * Imprime el árbol AVL en formato jerárquico para inspección visual
     */
    public void printTree() {
        printTree(root, "", true);
    }

    // Métodos privados

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) return new Node<>(data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            return node; // No se permiten duplicados
        }
        updateHeight(node);
        return balance(node);
    }

    private Node<T> search(Node<T> node, T data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return node;
        if (cmp < 0) return search(node.left, data);
        return search(node.right, data);
    }

    private void inOrder(Node<T> node, List<T> result) {
        if (node != null) {
            inOrder(node.left, result);
            result.add(node.data);
            inOrder(node.right, result);
        }
    }

    private int getHeight(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getBalance(Node<T> node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node<T> balance(Node<T> node) {
        int balance = getBalance(node);
        // Rotación izquierda
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }
        // Rotación derecha
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        // Rotación doble izquierda-derecha
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // Rotación doble derecha-izquierda
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateLeft(Node<T> y) {
        Node<T> x = y.right;
        Node<T> T2 = x.left;
        x.left = y;
        y.right = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;
        x.right = y;
        y.left = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<T> remove(Node<T> node, T data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, data);
        } else if (cmp > 0) {
            node.right = remove(node.right, data);
        } else {
            // Nodo encontrado
            if (node.left == null || node.right == null) {
                Node<T> temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    // Sin hijos
                    return null;
                } else {
                    // Un hijo
                    node = temp;
                }
            } else {
                // Dos hijos: buscar sucesor in-order
                Node<T> successor = minValueNode(node.right);
                node.data = successor.data;
                node.right = remove(node.right, successor.data);
            }
        }
        updateHeight(node);
        return balance(node);
    }

    private Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private void printTree(Node<T> node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data + " (h=" + node.height + ")");
            printTree(node.left, prefix + (isTail ? "    " : "│   "), false);
            printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    // Clase interna para nodos del árbol
    private static class Node<T> {
        T data;
        Node<T> left, right;
        int height;

        Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }
}
