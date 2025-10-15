package structs;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryHeap.java
 * Implementación genérica de un Montículo Binario (Binary Heap)
 * Autor: alejandrojsilvestre
 * @param <T> Tipo de dato almacenado (debe ser Comparable)
 */
public class BinaryHeap<T extends Comparable<T>> {
    private List<T> heap;
    private boolean isMaxHeap;

    /**
     * Constructor para crear un montículo binario
     * @param isMaxHeap true para Max Heap, false para Min Heap
     */
    public BinaryHeap(boolean isMaxHeap) {
        this.heap = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }

    /**
     * Inserta un elemento en el montículo
     * @param data Dato a insertar
     * @throws IllegalArgumentException si el dato es nulo
     */
    public void insert(T data) {
        if (data == null) throw new IllegalArgumentException("El dato no puede ser nulo");
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    /**
     * Extrae y retorna el elemento raíz del montículo
     * @return Elemento raíz (máximo en Max Heap, mínimo en Min Heap)
     * @throws IllegalStateException si el montículo está vacío
     */
    public T extract() {
        if (isEmpty()) throw new IllegalStateException("El montículo está vacío");
        T root = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return root;
    }

    /**
     * Retorna el elemento raíz sin eliminarlo
     * @return Elemento raíz
     * @throws IllegalStateException si el montículo está vacío
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("El montículo está vacío");
        return heap.get(0);
    }

    /**
     * Verifica si el montículo está vacío
     * @return true si está vacío, false en caso contrario
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Retorna el tamaño del montículo
     * @return Cantidad de elementos
     */
    public int size() {
        return heap.size();
    }

    /**
     * Retorna una lista con todos los elementos del montículo
     * @return Lista de elementos
     */
    public List<T> getElements() {
        return new ArrayList<>(heap);
    }

    /**
     * Imprime el montículo en formato de árbol
     */
    public void printHeap() {
        if (isEmpty()) {
            System.out.println("El montículo está vacío");
            return;
        }
        printHeap(0, "", true);
    }

    // Métodos privados

    private void heapifyUp(int index) {
        if (index == 0) return;
        int parentIndex = (index - 1) / 2;
        if (compare(heap.get(index), heap.get(parentIndex))) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int target = index;

        if (leftChild < heap.size() && compare(heap.get(leftChild), heap.get(target))) {
            target = leftChild;
        }
        if (rightChild < heap.size() && compare(heap.get(rightChild), heap.get(target))) {
            target = rightChild;
        }
        if (target != index) {
            swap(index, target);
            heapifyDown(target);
        }
    }

    private boolean compare(T child, T parent) {
        int cmp = child.compareTo(parent);
        return isMaxHeap ? cmp > 0 : cmp < 0;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void printHeap(int index, String prefix, boolean isTail) {
        if (index < heap.size()) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + heap.get(index));
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if (leftChild < heap.size()) {
                printHeap(leftChild, prefix + (isTail ? "    " : "│   "), rightChild >= heap.size());
            }
            if (rightChild < heap.size()) {
                printHeap(rightChild, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
}
