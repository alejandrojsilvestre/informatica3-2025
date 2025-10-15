package structs;

/**
 * Nodo para el montículo binario basado en árbol
 * @param <T> Tipo de dato almacenado
 */
public class HeapNode<T extends Comparable<T>> {
    T data;
    HeapNode<T> left;
    HeapNode<T> right;
    HeapNode<T> parent;

    public HeapNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
