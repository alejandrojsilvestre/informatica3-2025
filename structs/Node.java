package structs;
/**
 * Nodo de árbol AVL genérico
 * @param <T> Tipo de dato almacenado
 */
public class Node<T extends Comparable<T>> {
    T data;
    int height;
    Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.height = 1;
    }
}
