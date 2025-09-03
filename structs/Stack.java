package structs;
/**
 * Implementación de una pila (Stack) genérica con tamaño fijo.
 * Proporciona operaciones para apilar, desapilar y consultar el elemento en el tope.
 * @param <T> el tipo de elementos almacenados en la pila
 */
public class Stack<T> {
    int top = -1;
    int maxSize;
    T[] stackArray;

    /**
     * Crea una pila con el tamaño máximo especificado.
     * @param size el tamaño máximo de la pila
     */
    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = (T[]) new Object[maxSize];
    }

    /**
     * Inserta un elemento en el tope de la pila.
     * @param value el valor a insertar
     * @throws IllegalStateException si la pila está llena
     */
    public void push(T value) {
        if (top == maxSize - 1) {
            throw new IllegalStateException("Stack is full");
        } else {
            stackArray[++top] = value;
        }
    }

    /**
     * Elimina y retorna el elemento en el tope de la pila.
     * @return el valor en el tope de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    public T pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return stackArray[top--];
        }
    }

    /**
     * Retorna el elemento en el tope de la pila sin eliminarlo.
     * @return el valor en el tope de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    public T top() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return stackArray[top];
        }
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Verifica si la pila está llena.
     * @return true si la pila está llena, false en caso contrario
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

}
