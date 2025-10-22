import structs.HashTable;

/**
 * TestHashTable.java
 * Programa de prueba para demostrar el funcionamiento de la Tabla Hash
 * Autor: alejandrojsilvestre
 */
public class TestHashTable {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║     PRUEBA DE TABLA HASH - Informática III     ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // Crear una tabla hash con capacidad inicial de 8
        HashTable<String, Integer> tabla = new HashTable<>(8);

        // =====================================================
        // PRUEBA 1: Inserción básica
        // =====================================================
        System.out.println("=== PRUEBA 1: Inserción de elementos ===");
        tabla.put("manzana", 10);
        tabla.put("banana", 5);
        tabla.put("naranja", 8);
        tabla.put("pera", 12);
        tabla.put("uva", 20);
        
        System.out.println("✅ 5 elementos insertados");
        tabla.printTable();

        // =====================================================
        // PRUEBA 2: Búsqueda
        // =====================================================
        System.out.println("\n=== PRUEBA 2: Búsqueda de elementos ===");
        System.out.println("Valor de 'banana': " + tabla.get("banana"));
        System.out.println("Valor de 'uva': " + tabla.get("uva"));
        System.out.println("Valor de 'kiwi' (no existe): " + tabla.get("kiwi"));

        // =====================================================
        // PRUEBA 3: Actualización
        // =====================================================
        System.out.println("\n=== PRUEBA 3: Actualización de valores ===");
        System.out.println("Valor anterior de 'manzana': " + tabla.get("manzana"));
        tabla.put("manzana", 15); // Actualizar
        System.out.println("Valor nuevo de 'manzana': " + tabla.get("manzana"));

        // =====================================================
        // PRUEBA 4: Provocar colisiones y redimensionamiento
        // =====================================================
        System.out.println("\n=== PRUEBA 4: Colisiones y Redimensionamiento ===");
        System.out.println("Insertando más elementos para provocar redimensionamiento...");
        
        tabla.put("sandía", 3);
        tabla.put("melón", 7);
        tabla.put("fresa", 25);
        tabla.put("durazno", 18);
        
        System.out.println("\n✅ Tabla después de redimensionamiento:");
        tabla.printTable();
        tabla.printStatistics();

        // =====================================================
        // PRUEBA 5: Eliminación
        // =====================================================
        System.out.println("\n=== PRUEBA 5: Eliminación de elementos ===");
        Integer eliminado = tabla.remove("banana");
        System.out.println("Elemento eliminado: banana -> " + eliminado);
        
        eliminado = tabla.remove("kiwi");
        System.out.println("Intentando eliminar 'kiwi' (no existe): " + eliminado);
        
        tabla.printTable();

        // =====================================================
        // PRUEBA 6: Verificación de existencia
        // =====================================================
        System.out.println("\n=== PRUEBA 6: Verificación de claves ===");
        System.out.println("¿Existe 'manzana'? " + tabla.containsKey("manzana"));
        System.out.println("¿Existe 'banana'? " + tabla.containsKey("banana"));
        System.out.println("¿Existe 'kiwi'? " + tabla.containsKey("kiwi"));

        // =====================================================
        // PRUEBA 7: Listar todas las claves y valores
        // =====================================================
        System.out.println("\n=== PRUEBA 7: Listar claves y valores ===");
        System.out.println("Claves: " + tabla.keys());
        System.out.println("Valores: " + tabla.values());

        // =====================================================
        // EJEMPLO PRÁCTICO: Conteo de frecuencias
        // =====================================================
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   EJEMPLO PRÁCTICO: Análisis de Frecuencias    ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        
        ejemploFrecuenciaPalabras();

        // =====================================================
        // EJEMPLO PRÁCTICO: Caché de resultados
        // =====================================================
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║     EJEMPLO PRÁCTICO: Caché de Fibonacci       ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        
        ejemploCacheFibonacci();
    }

    /**
     * Ejemplo: Análisis de frecuencia de palabras
     */
    private static void ejemploFrecuenciaPalabras() {
        HashTable<String, Integer> frecuencias = new HashTable<>();
        
        String texto = "java es genial java permite programar java es orientado a objetos";
        System.out.println("\nTexto: " + texto);
        
        String[] palabras = texto.split(" ");
        
        // Contar frecuencias
        for (String palabra : palabras) {
            Integer cuenta = frecuencias.get(palabra);
            if (cuenta == null) {
                frecuencias.put(palabra, 1);
            } else {
                frecuencias.put(palabra, cuenta + 1);
            }
        }
        
        System.out.println("\nFrecuencia de palabras:");
        frecuencias.printTable();
        
        // Encontrar palabra más frecuente
        String palabraMasFrecuente = null;
        int maxFrecuencia = 0;
        
        for (String palabra : frecuencias.keys()) {
            int freq = frecuencias.get(palabra);
            if (freq > maxFrecuencia) {
                maxFrecuencia = freq;
                palabraMasFrecuente = palabra;
            }
        }
        
        System.out.println("\n🏆 Palabra más frecuente: '" + palabraMasFrecuente + 
            "' (aparece " + maxFrecuencia + " veces)");
    }

    /**
     * Ejemplo: Uso de tabla hash como caché para Fibonacci
     */
    private static void ejemploCacheFibonacci() {
        HashTable<Integer, Long> cache = new HashTable<>();
        
        System.out.println("\nCalculando Fibonacci con caché:");
        
        for (int n = 0; n <= 10; n++) {
            long resultado = fibonacciConCache(n, cache);
            System.out.println("fib(" + n + ") = " + resultado);
        }
        
        System.out.println("\n✅ Valores cacheados:");
        System.out.println("Total de valores en caché: " + cache.size());
        cache.printTable();
    }

    /**
     * Calcula Fibonacci usando tabla hash como caché
     */
    private static long fibonacciConCache(int n, HashTable<Integer, Long> cache) {
        // Verificar si ya está en caché
        Long cacheado = cache.get(n);
        if (cacheado != null) {
            return cacheado;
        }
        
        // Casos base
        if (n <= 1) {
            cache.put(n, (long) n);
            return n;
        }
        
        // Calcular y guardar en caché
        long resultado = fibonacciConCache(n - 1, cache) + fibonacciConCache(n - 2, cache);
        cache.put(n, resultado);
        return resultado;
    }
}
