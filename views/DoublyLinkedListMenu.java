package views;

import structs.DoublyLinkedList;

public class DoublyLinkedListMenu {
    private static DoublyLinkedList<Integer> list;

    public static void show() {
        if (list == null) {
            list = new DoublyLinkedList<>();
            System.out.println(MenuUtils.ANSI_GREEN + "DoublyLinkedList creada exitosamente!" + MenuUtils.ANSI_RESET);
        }

        boolean running = true;
        while (running) {
            // MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("OPERACIONES CON DOUBLY LINKED LIST");

            System.out.println(MenuUtils.ANSI_CYAN + "\nOperaciones disponibles:" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " addFirst     " + MenuUtils.ANSI_BLUE + "[Agregar al inicio]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " addLast      " + MenuUtils.ANSI_BLUE + "[Agregar al final]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "3." + MenuUtils.ANSI_RESET + " removeFirst  " + MenuUtils.ANSI_BLUE + "[Eliminar primero]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "4." + MenuUtils.ANSI_RESET + " removeLast   " + MenuUtils.ANSI_BLUE + "[Eliminar último]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "5." + MenuUtils.ANSI_RESET + " remove(value)" + MenuUtils.ANSI_BLUE + "[Eliminar por valor]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "6." + MenuUtils.ANSI_RESET + " contains     " + MenuUtils.ANSI_BLUE + "[Buscar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "7." + MenuUtils.ANSI_RESET + " size         " + MenuUtils.ANSI_BLUE + "[Cantidad de elementos]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "8." + MenuUtils.ANSI_RESET + " isEmpty      " + MenuUtils.ANSI_BLUE + "[Verificar si está vacía]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "9." + MenuUtils.ANSI_RESET + " Mostrar lista");
            System.out.println(MenuUtils.ANSI_YELLOW + "10." + MenuUtils.ANSI_RESET + " Ejecutar pruebas");
            System.out.println(MenuUtils.ANSI_YELLOW + "11." + MenuUtils.ANSI_RESET + " Volver al menú principal");

            try {
                int choice = MenuUtils.leerEntero("Seleccione una opción: ");
                switch (choice) {
                    case 1:
                        int vAF = MenuUtils.leerEntero("Ingrese valor para addFirst: ");
                        list.addFirst(vAF);
                        System.out.println("Valor agregado al inicio");
                        break;
                    case 2:
                        int vAL = MenuUtils.leerEntero("Ingrese valor para addLast: ");
                        list.addLast(vAL);
                        System.out.println("Valor agregado al final");
                        break;
                    case 3:
                        try {
                            int removedFirst = list.removeFirst();
                            System.out.println("Eliminado primero: " + removedFirst);
                        } catch (java.util.NoSuchElementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            int removedLast = list.removeLast();
                            System.out.println("Eliminado último: " + removedLast);
                        } catch (java.util.NoSuchElementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 5:
                        int vRem = MenuUtils.leerEntero("Ingrese valor a eliminar: ");
                        System.out.println("Elemento eliminado? " + list.remove(vRem));
                        break;
                    case 6:
                        int vBus = MenuUtils.leerEntero("Ingrese valor a buscar: ");
                        System.out.println("¿Existe? " + list.contains(vBus));
                        break;
                    case 7:
                        System.out.println("Tamaño de la lista: " + list.size());
                        break;
                    case 8:
                        System.out.println("¿Está vacía? " + list.isEmpty());
                        break;
                    case 9:
                        System.out.println("Contenido de la lista: " + list);
                        break;
                    case 10:
                        runTests();
                        MenuUtils.pausar();
                        break;
                    case 11:
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
        MenuUtils.mostrarEncabezado("PRUEBAS DE DOUBLY LINKED LIST");
        DoublyLinkedList<Integer> test = new DoublyLinkedList<>();
        System.out.println(MenuUtils.ANSI_CYAN + "Ejecutando casos de prueba..." + MenuUtils.ANSI_RESET);

        test.addFirst(20);
        test.addLast(30);
        test.addFirst(10); // [10,20,30]
        if (test.size() == 3 && test.toString().equals("[10, 20, 30]")) {
            System.out.println(MenuUtils.ANSI_GREEN + "addFirst/addLast/size/toString OK" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "addFirst/addLast/size/toString FAIL" + MenuUtils.ANSI_RESET);
        }

        int rf = test.removeFirst(); // 10 => [20,30]
        int rl = test.removeLast();  // 30 => [20]
        if (rf == 10 && rl == 30 && test.size() == 1 && test.contains(20)) {
            System.out.println(MenuUtils.ANSI_GREEN + "removeFirst/removeLast/contains OK" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "removeFirst/removeLast/contains FAIL" + MenuUtils.ANSI_RESET);
        }

        boolean rem = test.remove(20); // []
        if (rem && test.isEmpty()) {
            System.out.println(MenuUtils.ANSI_GREEN + "remove(value)/isEmpty OK" + MenuUtils.ANSI_RESET);
        } else {
            System.out.println(MenuUtils.ANSI_RED + "remove(value)/isEmpty FAIL" + MenuUtils.ANSI_RESET);
        }
    }
}
