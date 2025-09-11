package views;

import structs.LinkedList;

public class LinkedListMenu {
    private static LinkedList<Integer> linkedList;

    public static void show() {
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            System.out.println(MenuUtils.ANSI_GREEN + "LinkedList creada exitosamente!" + MenuUtils.ANSI_RESET);
        }

        boolean running = true;
        while (running) {
            MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("OPERACIONES CON LINKEDLIST");

            System.out.println(MenuUtils.ANSI_CYAN + "\nOperaciones disponibles:" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " Add     " + MenuUtils.ANSI_BLUE + "[Agregar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " Remove  " + MenuUtils.ANSI_BLUE + "[Eliminar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "3." + MenuUtils.ANSI_RESET + " Contains" + MenuUtils.ANSI_BLUE + "[Buscar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "4." + MenuUtils.ANSI_RESET + " Size    " + MenuUtils.ANSI_BLUE + "[Cantidad de elementos]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "5." + MenuUtils.ANSI_RESET + " isEmpty " + MenuUtils.ANSI_BLUE + "[Verificar si está vacía]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "6." + MenuUtils.ANSI_RESET + " Mostrar lista");
            System.out.println(MenuUtils.ANSI_YELLOW + "7." + MenuUtils.ANSI_RESET + " Ejecutar pruebas");
            System.out.println(MenuUtils.ANSI_YELLOW + "8." + MenuUtils.ANSI_RESET + " Volver al menú principal");

            try {
                int choice = MenuUtils.leerEntero("Seleccione una opción: ");
                switch (choice) {
                    case 1:
                        int valorAdd = MenuUtils.leerEntero("Ingrese valor a agregar: ");
                        linkedList.add(valorAdd);
                        System.out.println("Valor agregado exitosamente");
                        break;
                    case 2:
                        int valorRem = MenuUtils.leerEntero("Ingrese valor a eliminar: ");
                        boolean removed = linkedList.remove(valorRem);
                        System.out.println("Elemento eliminado? " + removed);
                        break;
                    case 3:
                        int valorBus = MenuUtils.leerEntero("Ingrese valor a buscar: ");
                        System.out.println("¿Existe? " + linkedList.contains(valorBus));
                        break;
                    case 4:
                        System.out.println("Tamaño de la lista: " + linkedList.size());
                        break;
                    case 5:
                        System.out.println("¿Está vacía? " + linkedList.isEmpty());
                        break;
                    case 6:
                        System.out.println("Contenido de la lista: " + linkedList);
                        break;
                    case 7:
                        runTests();
                        MenuUtils.pausar();
                        break;
                    case 8:
                        running = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void runTests() {
        MenuUtils.limpiarPantalla();
        MenuUtils.mostrarEncabezado("PRUEBAS DE LINKEDLIST");
        LinkedList<Integer> testList = new LinkedList<>();
        System.out.println(MenuUtils.ANSI_CYAN + "Ejecutando casos de prueba..." + MenuUtils.ANSI_RESET);

        testList.add(10);
        testList.add(20);
        if (testList.size() == 2) {
            System.out.println(MenuUtils.ANSI_GREEN + "add/size OK" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "add/size FAIL" + MenuUtils.ANSI_RESET);
        }

        if (testList.contains(10) && !testList.contains(30)) {
            System.out.println(MenuUtils.ANSI_GREEN + "contains OK" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "contains FAIL" + MenuUtils.ANSI_RESET);
        }

        testList.remove(10);
        if (!testList.contains(10) && testList.size() == 1) {
            System.out.println(MenuUtils.ANSI_GREEN + "remove OK" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "remove FAIL" + MenuUtils.ANSI_RESET);
        }

        testList.remove(20);
        if (testList.isEmpty()) {
            System.out.println(MenuUtils.ANSI_GREEN + "isEmpty OK" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "isEmpty FAIL" + MenuUtils.ANSI_RESET);
        }
    }
}
