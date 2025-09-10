package structs;

/**
 * Implementación genérica de una Lista Enlazada Simple.
 * Esta estructura de datos mantiene una colección de elementos ordenados
 * donde cada elemento tiene una referencia al siguiente.
 *
 * @param <T> el tipo de elementos almacenados en la lista
 */
public class LinkedList<T> {

    private ListNode<T> head;
    private int size;

    /**
     * Construye una nueva lista enlazada vacía.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Agrega un nuevo elemento al final de la lista.
     *
     * @param data el elemento a agregar
     * @throws IllegalArgumentException si el elemento es null
     */
    public void add(T data) {

        if (data == null) {
            throw new IllegalArgumentException("No se puede agregar un elemento null");
        }
        ListNode<T> newNode = new ListNode<T>(data);
    
        if (head == null) {
            head = newNode;
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
        size++;
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado de la lista.
     *
     * @param data el elemento a eliminar
     * @return true si el elemento fue encontrado y eliminado, false en caso contrario
     * @throws IllegalArgumentException si el elemento es null
     */
    public boolean remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede eliminar un elemento null");
        }
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        ListNode<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Verifica si un elemento específico está presente en la lista.
     *
     * @param data el elemento a buscar
     * @return true si el elemento está presente, false en caso contrario
     * @throws IllegalArgumentException si el elemento es null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede buscar un elemento null");
        }
        ListNode<T> current = head;
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
     *
     * @return el número de elementos en la lista
     */
    public int size() {
        return size;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false en caso contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna una representación en String de la lista.
     * El formato es: [elemento1, elemento2, ..., elementoN]
     *
     * @return una representación en String de la lista
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode<T> current = head;
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
}
