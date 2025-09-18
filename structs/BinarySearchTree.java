package structs;

/**
 * Implementación genérica de un Árbol Binario de Búsqueda (BST).
 * Requiere que T implemente Comparable para mantener el orden natural.
 *
 * @param <T> Tipo de elementos almacenados
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private int size;

    /**
     * Crea un BST vacío.
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Inserta un elemento en el BST. Si el elemento ya existe, no se inserta duplicado.
     * @param data elemento a insertar (no puede ser null)
     * @throws IllegalArgumentException si data es null
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede insertar un elemento null");
        }
        int before = size;
        root = insert(root, data);
        // size es incrementado dentro de insert solo si realmente se agrega
        // Verificado con comparación por si la implementación cambiara
        if (size == before) {
            // no-op si era duplicado
        }
    }

    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) {
            size++;
            return new TreeNode<>(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            // duplicado: no insertar
        }
        return node;
    }

    /**
     * Verifica si el elemento está en el árbol.
     * @param data elemento a buscar (no puede ser null)
     * @return true si existe, false en caso contrario
     * @throws IllegalArgumentException si data es null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede buscar un elemento null");
        }
        TreeNode<T> current = root;
        while (current != null) {
            int cmp = data.compareTo(current.data);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return true;
        }
        return false;
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado.
     * @param data elemento a eliminar (no puede ser null)
     * @return true si el elemento existía y fue eliminado, false si no existía
     * @throws IllegalArgumentException si data es null
     */
    public boolean remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se puede eliminar un elemento null");
        }
        int before = size;
        root = delete(root, data);
        return size < before;
    }

    private TreeNode<T> delete(TreeNode<T> node, T data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else {
            // encontrado: manejar casos
            if (node.left == null && node.right == null) {
                size--;
                return null;
            } else if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            } else {
                // dos hijos: reemplazar con sucesor (mínimo en subárbol derecho)
                TreeNode<T> successor = node.right;
                while (successor.left != null) successor = successor.left;
                node.data = successor.data;
                // eliminar sucesor del subárbol derecho (no reducir size dos veces)
                node.right = deleteMin(node.right);
            }
        }
        return node;
    }

    private TreeNode<T> deleteMin(TreeNode<T> node) {
        if (node == null) return null;
        if (node.left == null) {
            // este es el mínimo
            size--; // corresponde a la eliminación real de un nodo
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    /**
     * Retorna el mínimo elemento del árbol.
     * @return mínimo
     * @throws java.util.NoSuchElementException si el árbol está vacío
     */
    public T min() {
        if (root == null) throw new java.util.NoSuchElementException("El árbol está vacío");
        TreeNode<T> current = root;
        while (current.left != null) current = current.left;
        return current.data;
    }

    /**
     * Retorna el máximo elemento del árbol.
     * @return máximo
     * @throws java.util.NoSuchElementException si el árbol está vacío
     */
    public T max() {
        if (root == null) throw new java.util.NoSuchElementException("El árbol está vacío");
        TreeNode<T> current = root;
        while (current.right != null) current = current.right;
        return current.data;
    }

    /**
     * Cantidad de elementos del árbol.
     */
    public int size() { return size; }

    /**
     * Indica si el árbol está vacío.
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Elimina todos los elementos del árbol.
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Representación en-orden del árbol.
     * Formato: [e1, e2, ..., eN]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        inOrder(root, sb);
        if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == ',') {
            // quitar última coma y espacio
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    private void inOrder(TreeNode<T> node, StringBuilder sb) {
        if (node == null) return;
        inOrder(node.left, sb);
        sb.append(node.data).append(", ");
        inOrder(node.right, sb);
    }
}
