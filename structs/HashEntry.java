package structs;

/**
 * HashEntry.java
 * Representa una entrada (clave-valor) en la tabla hash
 * Autor: alejandrojsilvestre
 * @param <K> Tipo de la clave
 * @param <V> Tipo del valor
 */
public class HashEntry<K, V> {
    K key;
    V value;
    HashEntry<K, V> next; // Para manejar colisiones con encadenamiento

    /**
     * Constructor de una entrada hash
     * @param key Clave única
     * @param value Valor asociado a la clave
     */
    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
