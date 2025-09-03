package structs;
/**
 * Implementación de una cola (Queue) genérica con tamaño fijo usando un array.
 * @param <T> el tipo de elementos almacenados en la cola
 */
public class Queue<T> {
    private static final int DEFAULT_SIZE = 10;
    
    private int front = 0;
    private int rear = -1;
    private int maxSize;
    private int count = 0;
    private T[] queueArray;

    /**
     * Crea una cola con el tamaño máximo especificado. Si el tamaño es nulo o menor o igual a 0, se usa el valor por defecto (10).
     * @param size el tamaño máximo de la cola
     */
    @SuppressWarnings("unchecked")
    public Queue(int size) {
        if (size <= 0) {
            this.maxSize = DEFAULT_SIZE;
        } else {
            this.maxSize = size;
        }
        this.queueArray = (T[]) new Object[maxSize];
    }

    /**
     * Inserta un elemento al final de la cola.
     * @param value el valor a insertar
     * @throws IllegalStateException si la cola está llena
     */
    public void enqueue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        count++;
    }

    /**
     * Elimina y retorna el elemento al frente de la cola.
     * @return el valor al frente de la cola
     * @throws IllegalStateException si la cola está vacía
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = queueArray[front];
        front = (front + 1) % maxSize;
        count--;
        return value;
    }

    /**
     * Retorna el elemento al frente de la cola sin eliminarlo.
     * @return el valor al frente de la cola
     * @throws IllegalStateException si la cola está vacía
     */
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueArray[front];
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Verifica si la cola está llena.
     * @return true si la cola está llena, false en caso contrario
     */
    public boolean isFull() {
        return count == maxSize;
    }
}
