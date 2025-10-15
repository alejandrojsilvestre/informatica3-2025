package views;

import structs.BinaryHeap;
import structs.BinaryHeapTree;

public class BinaryHeapMenu {
    public static void show() {
        BinaryHeap<Integer> heapArray = null;
        BinaryHeapTree<Integer> heapTree = null;
        boolean useTree = false;
        boolean running = true;
        
        while (running) {
            MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("OPERACIONES CON MONTÍCULO BINARIO (BINARY HEAP)");
            
            if (heapArray == null && heapTree == null) {
                System.out.println("Seleccione la implementación:");
                System.out.println("1. Implementación con Array (más eficiente)");
                System.out.println("2. Implementación con Árbol de Nodos");
                System.out.println("3. Volver al menú principal");
                int implChoice = MenuUtils.leerEntero("Seleccione implementación (1-3): ");
                
                if (implChoice == 3) {
                    running = false;
                    continue;
                } else if (implChoice != 1 && implChoice != 2) {
                    System.out.println("Opción inválida");
                    MenuUtils.pausar();
                    continue;
                }
                
                useTree = (implChoice == 2);
                
                System.out.println("\n1. Crear Max Heap");
                System.out.println("2. Crear Min Heap");
                int op = MenuUtils.leerEntero("Seleccione tipo (1-2): ");
                
                switch (op) {
                    case 1:
                        if (useTree) {
                            heapTree = new BinaryHeapTree<>(true);
                            System.out.println("Max Heap (árbol) creado exitosamente.");
                        } else {
                            heapArray = new BinaryHeap<>(true);
                            System.out.println("Max Heap (array) creado exitosamente.");
                        }
                        MenuUtils.pausar();
                        break;
                    case 2:
                        if (useTree) {
                            heapTree = new BinaryHeapTree<>(false);
                            System.out.println("Min Heap (árbol) creado exitosamente.");
                        } else {
                            heapArray = new BinaryHeap<>(false);
                            System.out.println("Min Heap (array) creado exitosamente.");
                        }
                        MenuUtils.pausar();
                        break;
                    default:
                        System.out.println("Opción inválida");
                        MenuUtils.pausar();
                }
            } else {
                System.out.println("Implementación: " + (useTree ? "Árbol de Nodos" : "Array"));
                System.out.println("1. Insertar elemento");
                System.out.println("2. Extraer raíz");
                System.out.println("3. Ver raíz (peek)");
                System.out.println("4. Mostrar todos los elementos");
                System.out.println("5. Visualizar montículo");
                System.out.println("6. Tamaño del montículo");
                System.out.println("7. Verificar si está vacío");
                System.out.println("8. Generar montículo con n elementos aleatorios");
                System.out.println("9. Reiniciar montículo");
                System.out.println("10. Volver al menú principal");
                int op = MenuUtils.leerEntero("Seleccione una opción (1-10): ");
                
                switch (op) {
                    case 1:
                        int dato = MenuUtils.leerEntero("Ingrese el dato a insertar: ");
                        try {
                            if (useTree) {
                                heapTree.insert(dato);
                            } else {
                                heapArray.insert(dato);
                            }
                            System.out.println("Elemento insertado correctamente.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        MenuUtils.pausar();
                        break;
                    case 2:
                        try {
                            int extraido = useTree ? heapTree.extract() : heapArray.extract();
                            System.out.println("Elemento extraído: " + extraido);
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        MenuUtils.pausar();
                        break;
                    case 3:
                        try {
                            int raiz = useTree ? heapTree.peek() : heapArray.peek();
                            System.out.println("Raíz del montículo: " + raiz);
                        } catch (IllegalStateException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        MenuUtils.pausar();
                        break;
                    case 4:
                        System.out.println("Elementos del montículo:");
                        if (useTree) {
                            System.out.println(heapTree.getElements());
                        } else {
                            System.out.println(heapArray.getElements());
                        }
                        MenuUtils.pausar();
                        break;
                    case 5:
                        System.out.println("Visualización jerárquica del montículo:");
                        if (useTree) {
                            heapTree.printHeap();
                        } else {
                            heapArray.printHeap();
                        }
                        MenuUtils.pausar();
                        break;
                    case 6:
                        int size = useTree ? heapTree.size() : heapArray.size();
                        System.out.println("Tamaño del montículo: " + size);
                        MenuUtils.pausar();
                        break;
                    case 7:
                        boolean empty = useTree ? heapTree.isEmpty() : heapArray.isEmpty();
                        System.out.println(empty ? "El montículo está vacío" : "El montículo no está vacío");
                        MenuUtils.pausar();
                        break;
                    case 8:
                        int n = MenuUtils.leerEntero("¿Cuántos elementos aleatorios desea generar?: ");
                        if (n <= 0) {
                            System.out.println("El número debe ser mayor a 0");
                        } else {
                            int rangoMin = MenuUtils.leerEntero("Valor mínimo del rango: ");
                            int rangoMax = MenuUtils.leerEntero("Valor máximo del rango: ");
                            if (rangoMin >= rangoMax) {
                                System.out.println("El rango es inválido");
                            } else {
                                System.out.println("Generando " + n + " elementos aleatorios...");
                                for (int i = 0; i < n; i++) {
                                    int aleatorio = rangoMin + (int)(Math.random() * (rangoMax - rangoMin + 1));
                                    if (useTree) {
                                        heapTree.insert(aleatorio);
                                    } else {
                                        heapArray.insert(aleatorio);
                                    }
                                }
                                System.out.println("Montículo generado exitosamente con " + n + " elementos.");
                            }
                        }
                        MenuUtils.pausar();
                        break;
                    case 9:
                        heapArray = null;
                        heapTree = null;
                        System.out.println("Montículo reiniciado.");
                        MenuUtils.pausar();
                        break;
                    case 10:
                        running = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        MenuUtils.pausar();
                }
            }
        }
    }
}
