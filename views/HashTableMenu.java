package views;

import structs.HashTable;
import java.util.List;
import java.util.Scanner;

/**
 * HashTableMenu.java
 * Menú interactivo para probar la implementación de Tabla Hash
 * Autor: alejandrojsilvestre
 */
public class HashTableMenu {
    private HashTable<String, Integer> tabla;
    private Scanner scanner;

    public HashTableMenu() {
        this.tabla = new HashTable<>();
        this.scanner = MenuUtils.getScanner();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║      TABLA HASH - Menú Principal       ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1.  Insertar/Actualizar elemento");
            System.out.println("2.  Buscar elemento");
            System.out.println("3.  Eliminar elemento");
            System.out.println("4.  Verificar si existe clave");
            System.out.println("5.  Mostrar todas las claves");
            System.out.println("6.  Mostrar todos los valores");
            System.out.println("7.  Mostrar tabla completa");
            System.out.println("8.  Mostrar estadísticas");
            System.out.println("9.  Limpiar tabla");
            System.out.println("10. Ejemplo con estudiantes");
            System.out.println("11. Ejemplo con conteo de palabras");
            System.out.println("0.  Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            opcion = MenuUtils.leerEntero("");
            System.out.println();

            switch (opcion) {
                case 1: insertarElemento(); break;
                case 2: buscarElemento(); break;
                case 3: eliminarElemento(); break;
                case 4: verificarClave(); break;
                case 5: mostrarClaves(); break;
                case 6: mostrarValores(); break;
                case 7: mostrarTabla(); break;
                case 8: mostrarEstadisticas(); break;
                case 9: limpiarTabla(); break;
                case 10: ejemploEstudiantes(); break;
                case 11: ejemploConteoPalabras(); break;
                case 0: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("❌ Opción inválida");
            }
        } while (opcion != 0);
    }

    private void insertarElemento() {
        System.out.print("Ingrese la clave (String): ");
        String clave = scanner.next();
        int valor = MenuUtils.leerEntero("Ingrese el valor (Integer): ");
        
        tabla.put(clave, valor);
        System.out.println("✅ Elemento insertado correctamente");
        System.out.println("   Factor de carga actual: " + 
            String.format("%.2f", tabla.getLoadFactor()));
    }

    private void buscarElemento() {
        System.out.print("Ingrese la clave a buscar: ");
        String clave = scanner.next();
        
        Integer valor = tabla.get(clave);
        if (valor != null) {
            System.out.println("✅ Clave encontrada: " + clave + " -> " + valor);
        } else {
            System.out.println("❌ Clave no encontrada");
        }
    }

    private void eliminarElemento() {
        System.out.print("Ingrese la clave a eliminar: ");
        String clave = scanner.next();
        
        Integer valorEliminado = tabla.remove(clave);
        if (valorEliminado != null) {
            System.out.println("✅ Elemento eliminado: " + clave + " -> " + valorEliminado);
        } else {
            System.out.println("❌ Clave no encontrada");
        }
    }

    private void verificarClave() {
        System.out.print("Ingrese la clave a verificar: ");
        String clave = scanner.next();
        
        if (tabla.containsKey(clave)) {
            System.out.println("✅ La clave '" + clave + "' existe en la tabla");
        } else {
            System.out.println("❌ La clave '" + clave + "' NO existe en la tabla");
        }
    }

    private void mostrarClaves() {
        if (tabla.isEmpty()) {
            System.out.println("❌ La tabla está vacía");
            return;
        }
        
        List<String> claves = tabla.keys();
        System.out.println("=== Todas las Claves ===");
        for (String clave : claves) {
            System.out.println("  - " + clave);
        }
        System.out.println("Total: " + claves.size() + " claves");
    }

    private void mostrarValores() {
        if (tabla.isEmpty()) {
            System.out.println("❌ La tabla está vacía");
            return;
        }
        
        List<Integer> valores = tabla.values();
        System.out.println("=== Todos los Valores ===");
        for (Integer valor : valores) {
            System.out.println("  - " + valor);
        }
        System.out.println("Total: " + valores.size() + " valores");
    }

    private void mostrarTabla() {
        if (tabla.isEmpty()) {
            System.out.println("❌ La tabla está vacía");
            return;
        }
        
        tabla.printTable();
    }

    private void mostrarEstadisticas() {
        tabla.printStatistics();
    }

    private void limpiarTabla() {
        System.out.print("¿Está seguro de limpiar toda la tabla? (s/n): ");
        String confirmacion = scanner.next();
        
        if (confirmacion.equalsIgnoreCase("s")) {
            tabla.clear();
            System.out.println("✅ Tabla limpiada correctamente");
        } else {
            System.out.println("❌ Operación cancelada");
        }
    }

    private void ejemploEstudiantes() {
        System.out.println("=== Ejemplo: Registro de Estudiantes ===");
        System.out.println("Guardando notas de estudiantes...\n");
        
        HashTable<String, Integer> notas = new HashTable<>();
        
        // Insertar estudiantes con sus notas
        notas.put("Juan", 85);
        notas.put("María", 92);
        notas.put("Pedro", 78);
        notas.put("Ana", 95);
        notas.put("Luis", 88);
        
        System.out.println("✅ Notas registradas:");
        notas.printTable();
        
        // Buscar nota de un estudiante
        System.out.println("\n🔍 Buscando nota de María: " + notas.get("María"));
        
        // Actualizar nota
        System.out.println("📝 Actualizando nota de Pedro a 82...");
        notas.put("Pedro", 82);
        System.out.println("✅ Nota actualizada: " + notas.get("Pedro"));
        
        // Mostrar estadísticas
        System.out.println();
        notas.printStatistics();
    }

    private void ejemploConteoPalabras() {
        System.out.println("=== Ejemplo: Conteo de Palabras ===");
        System.out.println("Analizando frecuencia de palabras...\n");
        
        HashTable<String, Integer> frecuencia = new HashTable<>();
        
        // Texto de ejemplo
        String texto = "el gato y el perro juegan en el parque el gato sube al arbol";
        String[] palabras = texto.split(" ");
        
        // Contar frecuencia de cada palabra
        for (String palabra : palabras) {
            Integer cuenta = frecuencia.get(palabra);
            if (cuenta == null) {
                frecuencia.put(palabra, 1);
            } else {
                frecuencia.put(palabra, cuenta + 1);
            }
        }
        
        System.out.println("Texto analizado: \"" + texto + "\"");
        System.out.println("\n✅ Frecuencia de palabras:");
        frecuencia.printTable();
        
        // Mostrar la palabra más frecuente
        String palabraMasFrecuente = null;
        int maxFrecuencia = 0;
        
        for (String palabra : frecuencia.keys()) {
            int freq = frecuencia.get(palabra);
            if (freq > maxFrecuencia) {
                maxFrecuencia = freq;
                palabraMasFrecuente = palabra;
            }
        }
        
        System.out.println("\n🏆 Palabra más frecuente: '" + palabraMasFrecuente + 
            "' (aparece " + maxFrecuencia + " veces)");
    }
}
