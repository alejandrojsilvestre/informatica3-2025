package structs;

import java.util.ArrayList;
import java.util.List;

/**
 * HashTable.java
 * Implementación propia de una Tabla Hash con encadenamiento
 * Características:
 * - Usa función hash para mapear claves a índices
 * - Maneja colisiones con encadenamiento (listas enlazadas)
 * - Se redimensiona automáticamente cuando el factor de carga es alto
 * Autor: alejandrojsilvestre
 * @param <K> Tipo de la clave
 * @param <V> Tipo del valor
 */
public class HashTable<K, V> {
    private HashEntry<K, V>[] table;
    private int capacity; // Tamaño del array
    private int size;     // Cantidad de elementos
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    /**
     * Constructor por defecto con capacidad inicial de 16
     */
    @SuppressWarnings("unchecked")
    public HashTable() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new HashEntry[capacity];
        this.size = 0;
    }

    /**
     * Constructor con capacidad inicial especificada
     * @param initialCapacity Capacidad inicial del array interno
     */
    @SuppressWarnings("unchecked")
    public HashTable(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        this.capacity = initialCapacity;
        this.table = new HashEntry[capacity];
        this.size = 0;
    }

    /**
     * Función hash para calcular el índice a partir de una clave
     * @param key Clave a hashear
     * @return Índice en el array (0 a capacity-1)
     */
    private int hash(K key) {
        if (key == null) return 0;
        // Usa el hashCode de Java y aplica módulo para que esté en rango
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Inserta o actualiza un par clave-valor en la tabla
     * @param key Clave única
     * @param value Valor asociado
     * @throws IllegalArgumentException si la clave es nula
     */
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }

        // Verificar si necesitamos redimensionar
        if (getLoadFactor() >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int index = hash(key);
        HashEntry<K, V> entry = table[index];

        // Si la posición está vacía, insertar directamente
        if (entry == null) {
            table[index] = new HashEntry<>(key, value);
            size++;
            return;
        }

        // Si hay colisión, recorrer la lista enlazada
        HashEntry<K, V> prev = null;
        while (entry != null) {
            // Si la clave ya existe, actualizar el valor
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            prev = entry;
            entry = entry.next;
        }

        // Si llegamos aquí, la clave no existía: agregar al final
        prev.next = new HashEntry<>(key, value);
        size++;
    }

    /**
     * Obtiene el valor asociado a una clave
     * @param key Clave a buscar
     * @return Valor asociado, o null si no existe
     */
    public V get(K key) {
        if (key == null) return null;

        int index = hash(key);
        HashEntry<K, V> entry = table[index];

        // Buscar en la lista enlazada
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }

        return null; // No encontrado
    }

    /**
     * Elimina un par clave-valor de la tabla
     * @param key Clave a eliminar
     * @return Valor eliminado, o null si no existía
     */
    public V remove(K key) {
        if (key == null) return null;

        int index = hash(key);
        HashEntry<K, V> entry = table[index];
        HashEntry<K, V> prev = null;

        // Buscar el elemento en la lista enlazada
        while (entry != null) {
            if (entry.key.equals(key)) {
                V removedValue = entry.value;

                // Si es el primer elemento de la lista
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }

                size--;
                return removedValue;
            }
            prev = entry;
            entry = entry.next;
        }

        return null; // No encontrado
    }

    /**
     * Verifica si la tabla contiene una clave
     * @param key Clave a buscar
     * @return true si existe, false en caso contrario
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Verifica si la tabla está vacía
     * @return true si no tiene elementos, false en caso contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna la cantidad de elementos en la tabla
     * @return Número de pares clave-valor
     */
    public int size() {
        return size;
    }

    /**
     * Retorna la capacidad actual del array interno
     * @return Capacidad
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Calcula el factor de carga actual
     * @return Ratio entre size y capacity
     */
    public double getLoadFactor() {
        return (double) size / capacity;
    }

    /**
     * Limpia toda la tabla
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        table = new HashEntry[capacity];
        size = 0;
    }

    /**
     * Retorna una lista con todas las claves
     * @return Lista de claves
     */
    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            HashEntry<K, V> entry = table[i];
            while (entry != null) {
                keyList.add(entry.key);
                entry = entry.next;
            }
        }
        return keyList;
    }

    /**
     * Retorna una lista con todos los valores
     * @return Lista de valores
     */
    public List<V> values() {
        List<V> valueList = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            HashEntry<K, V> entry = table[i];
            while (entry != null) {
                valueList.add(entry.value);
                entry = entry.next;
            }
        }
        return valueList;
    }

    /**
     * Redimensiona la tabla cuando el factor de carga es alto
     * Duplica la capacidad y rehashea todos los elementos
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        HashEntry<K, V>[] oldTable = table;

        // Duplicar capacidad
        capacity = capacity * 2;
        table = new HashEntry[capacity];
        size = 0;

        // Reinsertar todos los elementos
        for (int i = 0; i < oldCapacity; i++) {
            HashEntry<K, V> entry = oldTable[i];
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    /**
     * Imprime la tabla hash mostrando las colisiones
     */
    public void printTable() {
        System.out.println("=== Tabla Hash ===");
        System.out.println("Tamaño: " + size + " | Capacidad: " + capacity);
        System.out.println("Factor de carga: " + String.format("%.2f", getLoadFactor()));
        System.out.println();

        for (int i = 0; i < capacity; i++) {
            HashEntry<K, V> entry = table[i];
            if (entry != null) {
                System.out.print("[" + i + "] -> ");
                while (entry != null) {
                    System.out.print("{" + entry.key + ": " + entry.value + "}");
                    entry = entry.next;
                    if (entry != null) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Imprime estadísticas sobre la distribución de elementos
     */
    public void printStatistics() {
        int usedBuckets = 0;
        int maxChainLength = 0;
        int totalChainLength = 0;

        for (int i = 0; i < capacity; i++) {
            HashEntry<K, V> entry = table[i];
            if (entry != null) {
                usedBuckets++;
                int chainLength = 0;
                while (entry != null) {
                    chainLength++;
                    entry = entry.next;
                }
                totalChainLength += chainLength;
                maxChainLength = Math.max(maxChainLength, chainLength);
            }
        }

        System.out.println("=== Estadísticas de la Tabla Hash ===");
        System.out.println("Elementos: " + size);
        System.out.println("Capacidad: " + capacity);
        System.out.println("Buckets usados: " + usedBuckets + "/" + capacity);
        System.out.println("Factor de carga: " + String.format("%.2f", getLoadFactor()));
        System.out.println("Longitud máxima de cadena: " + maxChainLength);
        if (usedBuckets > 0) {
            System.out.println("Longitud promedio de cadena: " + 
                String.format("%.2f", (double) totalChainLength / usedBuckets));
        }
    }
}
