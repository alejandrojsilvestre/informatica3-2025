package structs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BinaryHeapTree.java
 * Implementación de un Montículo Binario usando estructura de árbol con nodos
 * Autor: alejandrojsilvestre
 * @param <T> Tipo de dato almacenado (debe ser Comparable)
 */
public class BinaryHeapTree<T extends Comparable<T>> {
    private HeapNode<T> root;
    private int size;
    private boolean isMaxHeap;

    /**
     * Constructor para crear un montículo binario basado en árbol
     * @param isMaxHeap true para Max Heap, false para Min Heap
     */
    public BinaryHeapTree(boolean isMaxHeap) {
        this.root = null;
        this.size = 0;
        this.isMaxHeap = isMaxHeap;
    }

    /**
     * Inserta un elemento en el montículo
     * @param data Dato a insertar
     * @throws IllegalArgumentException si el dato es nulo
     */
    public void insert(T data) {
        if (data == null) throw new IllegalArgumentException("El dato no puede ser nulo");
        HeapNode<T> newNode = new HeapNode<>(data);
        
        if (root == null) {
            root = newNode;
        } else {
            // Encontrar la posición correcta para insertar (nivel order)
            HeapNode<T> parent = findInsertPosition();
            newNode.parent = parent;
            if (parent.left == null) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            // Aplicar heapify up
            heapifyUp(newNode);
        }
        size++;
    }

    /**
     * Extrae y retorna el elemento raíz del montículo
     * @return Elemento raíz (máximo en Max Heap, mínimo en Min Heap)
     * @throws IllegalStateException si el montículo está vacío
     */
    public T extract() {
        if (isEmpty()) throw new IllegalStateException("El montículo está vacío");
        
        T rootData = root.data;
        
        if (size == 1) {
            root = null;
        } else {
            // Encontrar el último nodo
            HeapNode<T> lastNode = findLastNode();
            
            // Reemplazar raíz con el último nodo
            root.data = lastNode.data;
            
            // Eliminar el último nodo
            if (lastNode.parent.right == lastNode) {
                lastNode.parent.right = null;
            } else {
                lastNode.parent.left = null;
            }
            
            // Aplicar heapify down
            heapifyDown(root);
        }
        size--;
        return rootData;
    }

    /**
     * Retorna el elemento raíz sin eliminarlo
     * @return Elemento raíz
     * @throws IllegalStateException si el montículo está vacío
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("El montículo está vacío");
        return root.data;
    }

    /**
     * Verifica si el montículo está vacío
     * @return true si está vacío, false en caso contrario
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Retorna el tamaño del montículo
     * @return Cantidad de elementos
     */
    public int size() {
        return size;
    }

    /**
     * Retorna una lista con todos los elementos del montículo (level order)
     * @return Lista de elementos
     */
    public List<T> getElements() {
        List<T> elements = new ArrayList<>();
        if (root == null) return elements;
        
        Queue<HeapNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            HeapNode<T> node = queue.poll();
            elements.add(node.data);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        return elements;
    }

    /**
     * Imprime el montículo en formato de árbol
     */
    public void printHeap() {
        if (isEmpty()) {
            System.out.println("El montículo está vacío");
            return;
        }
        printHeap(root, "", true);
    }

    // Métodos privados

    /**
     * Encuentra la posición donde debe insertarse el siguiente nodo (level order)
     */
    private HeapNode<T> findInsertPosition() {
        Queue<HeapNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            HeapNode<T> node = queue.poll();
            if (node.left == null || node.right == null) {
                return node;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return null;
    }

    /**
     * Encuentra el último nodo del montículo (level order)
     */
    private HeapNode<T> findLastNode() {
        Queue<HeapNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        HeapNode<T> lastNode = null;
        
        while (!queue.isEmpty()) {
            lastNode = queue.poll();
            if (lastNode.left != null) queue.offer(lastNode.left);
            if (lastNode.right != null) queue.offer(lastNode.right);
        }
        
        return lastNode;
    }

    /**
     * Aplica heapify hacia arriba desde un nodo
     */
    private void heapifyUp(HeapNode<T> node) {
        while (node.parent != null && compare(node.data, node.parent.data)) {
            // Intercambiar datos con el padre
            T temp = node.data;
            node.data = node.parent.data;
            node.parent.data = temp;
            node = node.parent;
        }
    }

    /**
     * Aplica heapify hacia abajo desde un nodo
     */
    private void heapifyDown(HeapNode<T> node) {
        while (true) {
            HeapNode<T> target = node;
            
            if (node.left != null && compare(node.left.data, target.data)) {
                target = node.left;
            }
            if (node.right != null && compare(node.right.data, target.data)) {
                target = node.right;
            }
            
            if (target == node) break;
            
            // Intercambiar datos
            T temp = node.data;
            node.data = target.data;
            target.data = temp;
            node = target;
        }
    }

    /**
     * Compara dos elementos según el tipo de heap
     */
    private boolean compare(T child, T parent) {
        int cmp = child.compareTo(parent);
        return isMaxHeap ? cmp > 0 : cmp < 0;
    }

    /**
     * Imprime el árbol en formato jerárquico
     */
    private void printHeap(HeapNode<T> node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);
            if (node.left != null) {
                printHeap(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
            }
            if (node.right != null) {
                printHeap(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
}
