package views;

import orders.Orders;

public class SortingMenu {
    private static Integer[] generarArrayAleatorio(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    private static void printArray(Integer[] arr) {
        System.out.print(MenuUtils.ANSI_CYAN + "[ " + MenuUtils.ANSI_RESET);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(MenuUtils.ANSI_YELLOW + arr[i] + MenuUtils.ANSI_RESET);
            if (i < arr.length - 1) {
                System.out.print(MenuUtils.ANSI_CYAN + ", " + MenuUtils.ANSI_RESET);
            }
        }
        System.out.println(MenuUtils.ANSI_CYAN + " ]" + MenuUtils.ANSI_RESET);
    }

    public static void show() {
        MenuUtils.limpiarPantalla();
        MenuUtils.mostrarEncabezado("PRUEBAS DE ORDENAMIENTO");

        int size = MenuUtils.leerEntero(MenuUtils.ANSI_CYAN + "\nIngrese el tamaño del array a ordenar: " + MenuUtils.ANSI_RESET);

        System.out.println(MenuUtils.ANSI_CYAN + "\n¿Cómo desea ingresar los datos?" + MenuUtils.ANSI_RESET);
        System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " Ingresar manualmente");
        System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " Generar números aleatorios");

        Integer[] arr = new Integer[size];
        int opcion = MenuUtils.leerEntero(MenuUtils.ANSI_CYAN + "\nSeleccione una opción (1-2): " + MenuUtils.ANSI_RESET);

        if (opcion == 1) {
            System.out.println(MenuUtils.ANSI_CYAN + "\nIngrese los " + size + " números:" + MenuUtils.ANSI_RESET);
            for (int i = 0; i < size; i++) {
                arr[i] = MenuUtils.leerEntero(MenuUtils.ANSI_YELLOW + "Número " + (i+1) + ": " + MenuUtils.ANSI_RESET);
            }
        } else if (opcion == 2) {
            arr = generarArrayAleatorio(size);
            System.out.println(MenuUtils.ANSI_GREEN + "\nArray generado exitosamente!" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "Opción inválida. Generando números aleatorios por defecto..." + MenuUtils.ANSI_RESET);
            arr = generarArrayAleatorio(size);
        }

        System.out.println(MenuUtils.ANSI_CYAN + "\nMétodos de ordenamiento disponibles:" + MenuUtils.ANSI_RESET);
        System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " Insertion Sort " + MenuUtils.ANSI_BLUE + "[O(n²) - Mejor para arrays pequeños]" + MenuUtils.ANSI_RESET);
        System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " Shell Sort    " + MenuUtils.ANSI_BLUE + "[O(n log² n) - Mejora del Insertion Sort]" + MenuUtils.ANSI_RESET);
        System.out.println(MenuUtils.ANSI_YELLOW + "3." + MenuUtils.ANSI_RESET + " Quick Sort    " + MenuUtils.ANSI_BLUE + "[O(n log n) - Más eficiente en promedio]" + MenuUtils.ANSI_RESET);

        int choice = MenuUtils.leerEntero("Seleccione el método (1-3): ");
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
        MenuUtils.pausar();
    }
}
