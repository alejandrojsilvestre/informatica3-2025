package views;

import java.util.Scanner;
import java.util.InputMismatchException;
import structs.Stack;
import structs.Queue;
import orders.Orders;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Integer> stack;
    private static Queue<Integer> queue;
    
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
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Operaciones con Stack");
            System.out.println("2. Operaciones con Queue");
            System.out.println("3. Pruebas de Ordenamiento");
            System.out.println("4. Salir");
            
            int choice = leerEntero("Seleccione una opción: ");
            
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
            int size = leerEntero("Ingrese el tamaño del Stack: ");
            stack = new Stack<>(size);
        }
        
        boolean stackMenuRunning = true;
        while (stackMenuRunning) {
            System.out.println("\n=== Operaciones Stack ===");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Verificar si está vacía");
            System.out.println("5. Verificar si está llena");
            System.out.println("6. Crear nuevo Stack");
            System.out.println("7. Volver al menú principal");
            
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
            int size = leerEntero("Ingrese el tamaño de la Queue: ");
            queue = new Queue<>(size);
        }
        
        boolean queueMenuRunning = true;
        while (queueMenuRunning) {
            System.out.println("\n=== Operaciones Queue ===");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Front");
            System.out.println("4. Verificar si está vacía");
            System.out.println("5. Verificar si está llena");
            System.out.println("6. Crear nueva Queue");
            System.out.println("7. Volver al menú principal");
            
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
    
    private static void sortingMenu() {
        System.out.println("\n=== Pruebas de Ordenamiento ===");
        int size = leerEntero("Ingrese el tamaño del array a ordenar: ");
        
        Integer[] arr = new Integer[size];
        System.out.println("Ingrese los " + size + " números:");
        for (int i = 0; i < size; i++) {
            arr[i] = leerEntero("Número " + (i+1) + ": ");
        }
        
        System.out.println("\nSeleccione el método de ordenamiento:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Shell Sort");
        System.out.println("3. Quick Sort");
        
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
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
