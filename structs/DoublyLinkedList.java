package structs;

/**
 * Implementación genérica de una Lista Doblemente Enlazada.
 * Mantiene referencias al primer (head) y último (tail) nodo, permitiendo
 * inserciones y eliminaciones eficientes en ambos extremos.
 *
 * @param <T> el tipo de elementos almacenados en la lista
 */
public class DoublyLinkedList<T> {

    private DoublyListNode<T> head;
    private DoublyListNode<T> tail;
    private int size;

    /**
     * Construye una nueva lista doblemente enlazada vacía.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Agrega un elemento al final de la lista (alias de addLast).
     *
     * @param data elemento a agregar
     * @throws IllegalArgumentException si el elemento es null
     */
    public void add(T data) {
        addLast(data);
    }

    /**
     * Agrega un elemento al inicio de la lista.
     *
     * @param data elemento a agregar
     * @throws IllegalArgumentException si el elemento es null
     */
    public void addFirst(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede agregar un elemento null");
        }
        DoublyListNode<T> node = new DoublyListNode<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param data elemento a agregar
     * @throws IllegalArgumentException si el elemento es null
     */
    public void addLast(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede agregar un elemento null");
        }
        DoublyListNode<T> node = new DoublyListNode<>(data);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado.
     *
     * @param data elemento a eliminar
     * @return true si se eliminó, false si no se encontró
     * @throws IllegalArgumentException si el elemento es null
     */
    public boolean remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede eliminar un elemento null");
        }
        if (head == null) return false;

        DoublyListNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Elimina y retorna el primer elemento de la lista.
     *
     * @return el elemento eliminado
     * @throws java.util.NoSuchElementException si la lista está vacía
     */
    public T removeFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException("La lista está vacía");
        }
        T value = head.data;
        unlink(head);
        return value;
    }

    /**
     * Elimina y retorna el último elemento de la lista.
     *
     * @return el elemento eliminado
     * @throws java.util.NoSuchElementException si la lista está vacía
     */
    public T removeLast() {
        if (tail == null) {
            throw new java.util.NoSuchElementException("La lista está vacía");
        }
        T value = tail.data;
        unlink(tail);
        return value;
    }

    /**
     * Verifica si la lista contiene el elemento especificado.
     *
     * @param data elemento a buscar
     * @return true si está presente, false en caso contrario
     * @throws IllegalArgumentException si el elemento es null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede buscar un elemento null");
        }
        DoublyListNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Retorna el número de elementos en la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Indica si la lista está vacía.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Representación en String de la lista, de izquierda a derecha.
     * Formato: [e1, e2, ..., eN]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DoublyListNode<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Desenlaza un nodo arbitrario ajustando punteros y tamaño
    private void unlink(DoublyListNode<T> node) {
        DoublyListNode<T> prev = node.prev;
        DoublyListNode<T> next = node.next;

        if (prev == null) { // era head
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) { // era tail
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        // ayuda al GC
        node.data = null;
        size--;
        if (size == 0) {
            head = tail = null;
        }
    }
}
