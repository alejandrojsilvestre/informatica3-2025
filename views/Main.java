package views;

import java.util.Scanner;
import java.util.InputMismatchException;
import structs.Stack;
import structs.Queue;
import orders.Orders;

public class Main {
    // Códigos de color ANSI
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    
    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Integer> stack;
    private static Queue<Integer> queue;
    
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private static void mostrarEncabezado(String titulo) {
        String linea = "=".repeat(50);
        System.out.println(ANSI_BLUE + linea + ANSI_RESET);
        System.out.println(ANSI_CYAN + " " + titulo + ANSI_RESET);
        System.out.println(ANSI_BLUE + linea + ANSI_RESET);
    }
    
    private static void pausar() {
        System.out.println(ANSI_YELLOW + "\nPresione ENTER para continuar..." + ANSI_RESET);
        scanner.nextLine();
        if (scanner.hasNextLine()) scanner.nextLine();
    }
    
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = scanner.nextInt();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
    }
    
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            limpiarPantalla();
            mostrarEncabezado("ESTRUCTURAS DE DATOS Y ALGORITMOS - IUA 2025");
            
            System.out.println(ANSI_CYAN + "\nOpciones disponibles:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1." + ANSI_RESET + " Operaciones con Stack " + 
                             ANSI_BLUE + "[Pila LIFO]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2." + ANSI_RESET + " Operaciones con Queue " + 
                             ANSI_BLUE + "[Cola FIFO]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "3." + ANSI_RESET + " Pruebas de Ordenamiento " + 
                             ANSI_BLUE + "[Sorting]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "4." + ANSI_RESET + " Salir");
            
            int choice = leerEntero(ANSI_CYAN + "\nSeleccione una opción (1-4): " + ANSI_RESET);
            
            switch (choice) {
                case 1:
                    stackMenu();
                    break;
                case 2:
                    queueMenu();
                    break;
                case 3:
                    sortingMenu();
                    break;
                case 4:
                    running = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        scanner.close();
    }
    
    private static void stackMenu() {
        if (stack == null) {
            int size = leerEntero(ANSI_CYAN + "Ingrese el tamaño del Stack: " + ANSI_RESET);
            stack = new Stack<>(size);
            System.out.println(ANSI_GREEN + "Stack creado exitosamente!" + ANSI_RESET);
        }
        
        boolean stackMenuRunning = true;
        while (stackMenuRunning) {
            limpiarPantalla();
            mostrarEncabezado("OPERACIONES CON STACK (PILA)");
            
            System.out.println(ANSI_CYAN + "\nOperaciones disponibles:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1." + ANSI_RESET + " Push    " + ANSI_BLUE + "[Agregar elemento]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2." + ANSI_RESET + " Pop     " + ANSI_BLUE + "[Quitar elemento del tope]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "3." + ANSI_RESET + " Top     " + ANSI_BLUE + "[Ver elemento del tope]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "4." + ANSI_RESET + " isEmpty " + ANSI_BLUE + "[Verificar si está vacía]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "5." + ANSI_RESET + " isFull  " + ANSI_BLUE + "[Verificar si está llena]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "6." + ANSI_RESET + " Crear nuevo Stack");
            System.out.println(ANSI_YELLOW + "7." + ANSI_RESET + " Volver al menú principal");
            
            try {
                int choice = leerEntero("Seleccione una opción: ");
                switch (choice) {
                    case 1:
                        int valor = leerEntero("Ingrese valor a push: ");
                        stack.push(valor);
                        System.out.println("Valor agregado exitosamente");
                        break;
                    case 2:
                        System.out.println("Valor extraído: " + stack.pop());
                        break;
                    case 3:
                        System.out.println("Valor en el tope: " + stack.top());
                        break;
                    case 4:
                        System.out.println("¿Está vacía? " + stack.isEmpty());
                        break;
                    case 5:
                        System.out.println("¿Está llena? " + stack.isFull());
                        break;
                    case 6:
                        int nuevoTamaño = leerEntero("Ingrese nuevo tamaño: ");
                        stack = new Stack<>(nuevoTamaño);
                        System.out.println("Nuevo Stack creado");
                        break;
                    case 7:
                        stackMenuRunning = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private static void queueMenu() {
        if (queue == null) {
            int size = leerEntero(ANSI_CYAN + "Ingrese el tamaño de la Queue: " + ANSI_RESET);
            queue = new Queue<>(size);
            System.out.println(ANSI_GREEN + "Queue creada exitosamente!" + ANSI_RESET);
        }
        
        boolean queueMenuRunning = true;
        while (queueMenuRunning) {
            limpiarPantalla();
            mostrarEncabezado("OPERACIONES CON QUEUE (COLA)");
            
            System.out.println(ANSI_CYAN + "\nOperaciones disponibles:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1." + ANSI_RESET + " Enqueue " + ANSI_BLUE + "[Agregar elemento]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2." + ANSI_RESET + " Dequeue " + ANSI_BLUE + "[Quitar elemento del frente]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "3." + ANSI_RESET + " Front   " + ANSI_BLUE + "[Ver elemento del frente]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "4." + ANSI_RESET + " isEmpty " + ANSI_BLUE + "[Verificar si está vacía]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "5." + ANSI_RESET + " isFull  " + ANSI_BLUE + "[Verificar si está llena]" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "6." + ANSI_RESET + " Crear nueva Queue");
            System.out.println(ANSI_YELLOW + "7." + ANSI_RESET + " Volver al menú principal");
            
            try {
                int choice = leerEntero("Seleccione una opción: ");
                switch (choice) {
                    case 1:
                        int valor = leerEntero("Ingrese valor a enqueue: ");
                        queue.enqueue(valor);
                        System.out.println("Valor agregado exitosamente");
                        break;
                    case 2:
                        System.out.println("Valor extraído: " + queue.dequeue());
                        break;
                    case 3:
                        System.out.println("Valor al frente: " + queue.front());
                        break;
                    case 4:
                        System.out.println("¿Está vacía? " + queue.isEmpty());
                        break;
                    case 5:
                        System.out.println("¿Está llena? " + queue.isFull());
                        break;
                    case 6:
                        int nuevoTamaño = leerEntero("Ingrese nuevo tamaño: ");
                        queue = new Queue<>(nuevoTamaño);
                        System.out.println("Nueva Queue creada");
                        break;
                    case 7:
                        queueMenuRunning = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private static Integer[] generarArrayAleatorio(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100); // Números aleatorios entre 0 y 99
        }
        return arr;
    }

    private static void sortingMenu() {
        limpiarPantalla();
        mostrarEncabezado("PRUEBAS DE ORDENAMIENTO");
        
        int size = leerEntero(ANSI_CYAN + "\nIngrese el tamaño del array a ordenar: " + ANSI_RESET);
        
        System.out.println(ANSI_CYAN + "\n¿Cómo desea ingresar los datos?" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "1." + ANSI_RESET + " Ingresar manualmente");
        System.out.println(ANSI_YELLOW + "2." + ANSI_RESET + " Generar números aleatorios");
        
        Integer[] arr = new Integer[size];
        int opcion = leerEntero(ANSI_CYAN + "\nSeleccione una opción (1-2): " + ANSI_RESET);
        
        if (opcion == 1) {
            System.out.println(ANSI_CYAN + "\nIngrese los " + size + " números:" + ANSI_RESET);
            for (int i = 0; i < size; i++) {
                arr[i] = leerEntero(ANSI_YELLOW + "Número " + (i+1) + ": " + ANSI_RESET);
            }
        } else if (opcion == 2) {
            arr = generarArrayAleatorio(size);
            System.out.println(ANSI_GREEN + "\nArray generado exitosamente!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Opción inválida. Generando números aleatorios por defecto..." + ANSI_RESET);
            arr = generarArrayAleatorio(size);
        }
        
        System.out.println(ANSI_CYAN + "\nMétodos de ordenamiento disponibles:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "1." + ANSI_RESET + " Insertion Sort " + 
                         ANSI_BLUE + "[O(n²) - Mejor para arrays pequeños]" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "2." + ANSI_RESET + " Shell Sort    " + 
                         ANSI_BLUE + "[O(n log² n) - Mejora del Insertion Sort]" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3." + ANSI_RESET + " Quick Sort    " + 
                         ANSI_BLUE + "[O(n log n) - Más eficiente en promedio]" + ANSI_RESET);
        
        int choice = leerEntero("Seleccione el método (1-3): ");
        System.out.println("\nArray original:");
        printArray(arr);
        
        switch (choice) {
            case 1:
                Orders.insertionSort(arr);
                break;
            case 2:
                Orders.shellSort(arr);
                break;
            case 3:
                Orders.quickSort(arr);
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }
        
        System.out.println("\nArray ordenado:");
        printArray(arr);
    }
    
    private static void printArray(Integer[] arr) {
        System.out.print(ANSI_CYAN + "[ " + ANSI_RESET);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(ANSI_YELLOW + arr[i] + ANSI_RESET);
            if (i < arr.length - 1) {
                System.out.print(ANSI_CYAN + ", " + ANSI_RESET);
            }
        }
        System.out.println(ANSI_CYAN + " ]" + ANSI_RESET);
    }
}
