package structs;
/**
 * Implementación de una cola (Queue) genérica con tamaño fijo usando un array.
 * @param <T> el tipo de elementos almacenados en la cola
 */
public class Queue<T> {
    int front = 0;
    int rear = -1;
    int maxSize;
    int count = 0;
    T[] queueArray;

    /**
     * Crea una cola con el tamaño máximo especificado.
     * @param size el tamaño máximo de la cola
     */
    @SuppressWarnings("unchecked")
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = (T[]) new Object[maxSize];
    }

    /**
     * Inserta un elemento al final de la cola.
     * @param value el valor a insertar
     * @throws IllegalStateException si la cola está llena
     */
    public void enqueue(T value) {
        // Implementación pendiente
    }

    /**
     * Elimina y retorna el elemento al frente de la cola.
     * @return el valor al frente de la cola
     * @throws IllegalStateException si la cola está vacía
     */
    public T dequeue() {
        // Implementación pendiente
        return null;
    }

    /**
     * Retorna el elemento al frente de la cola sin eliminarlo.
     * @return el valor al frente de la cola
     * @throws IllegalStateException si la cola está vacía
     */
    public T front() {
        // Implementación pendiente
        return null;
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        // Implementación pendiente
        return false;
    }

    /**
     * Verifica si la cola está llena.
     * @return true si la cola está llena, false en caso contrario
     */
    public boolean isFull() {
        // Implementación pendiente
        return false;
    }
}
