package orders;

/**
 * Clase que implementa diferentes algoritmos de ordenamiento.
 */
public class Orders {
    
    /**
     * Ordena un array usando el algoritmo Insertion Sort.
     * Complejidad temporal: O(n²) en promedio y peor caso, O(n) en mejor caso.
     * Complejidad espacial: O(1)
     * 
     * @param <T> tipo de elementos que extienden Comparable
     * @param arr array a ordenar
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Ordena un array usando el algoritmo Shell Sort.
     * Complejidad temporal: O(n log² n) en promedio, O(n²) en peor caso.
     * Complejidad espacial: O(1)
     * 
     * @param <T> tipo de elementos que extienden Comparable
     * @param arr array a ordenar
     */
    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int n = arr.length;
        
        // Iniciar con un gap grande y reducirlo
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Realizar insertion sort para este gap
            for (int i = gap; i < n; i++) {
                T temp = arr[i];
                int j;
                
                for (j = i; j >= gap && arr[j - gap].compareTo(temp) > 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * Ordena un array usando el algoritmo Quick Sort.
     * Complejidad temporal: O(n log n) en promedio, O(n²) en peor caso.
     * Complejidad espacial: O(log n)
     * 
     * @param <T> tipo de elementos que extienden Comparable
     * @param arr array a ordenar
     */
    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // Intercambiar arr[i] y arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Intercambiar arr[i+1] y arr[high] (pivot)
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}
