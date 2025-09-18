package views;

import structs.BinarySearchTree;

public class BinarySearchTreeMenu {
    private static BinarySearchTree<Integer> bst;

    public static void show() {
        if (bst == null) {
            bst = new BinarySearchTree<>();
            System.out.println(MenuUtils.ANSI_GREEN + "BinarySearchTree creado exitosamente!" + MenuUtils.ANSI_RESET);
        }

        boolean running = true;
        while (running) {
            MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("OPERACIONES CON BINARY SEARCH TREE");

            System.out.println(MenuUtils.ANSI_CYAN + "\nOperaciones disponibles:" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " add         " + MenuUtils.ANSI_BLUE + "[Insertar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " remove      " + MenuUtils.ANSI_BLUE + "[Eliminar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "3." + MenuUtils.ANSI_RESET + " contains    " + MenuUtils.ANSI_BLUE + "[Buscar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "4." + MenuUtils.ANSI_RESET + " min         " + MenuUtils.ANSI_BLUE + "[Mínimo]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "5." + MenuUtils.ANSI_RESET + " max         " + MenuUtils.ANSI_BLUE + "[Máximo]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "6." + MenuUtils.ANSI_RESET + " size        " + MenuUtils.ANSI_BLUE + "[Cantidad de elementos]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "7." + MenuUtils.ANSI_RESET + " isEmpty     " + MenuUtils.ANSI_BLUE + "[¿Está vacío?]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "8." + MenuUtils.ANSI_RESET + " clear       " + MenuUtils.ANSI_BLUE + "[Vaciar árbol]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "9." + MenuUtils.ANSI_RESET + " Mostrar árbol (in-order)");
            System.out.println(MenuUtils.ANSI_YELLOW + "10." + MenuUtils.ANSI_RESET + " Ejecutar pruebas");
            System.out.println(MenuUtils.ANSI_YELLOW + "11." + MenuUtils.ANSI_RESET + " Volver al menú principal");

            try {
                int choice = MenuUtils.leerEntero("Seleccione una opción: ");
                switch (choice) {
                    case 1:
                        int vAdd = MenuUtils.leerEntero("Ingrese valor a insertar: ");
                        bst.add(vAdd);
                        System.out.println("Valor insertado (si no era duplicado)");
                        break;
                    case 2:
                        int vRem = MenuUtils.leerEntero("Ingrese valor a eliminar: ");
                        System.out.println("Elemento eliminado? " + bst.remove(vRem));
                        break;
                    case 3:
                        int vBus = MenuUtils.leerEntero("Ingrese valor a buscar: ");
                        System.out.println("¿Existe? " + bst.contains(vBus));
                        break;
                    case 4:
                        try {
                            System.out.println("Mínimo: " + bst.min());
                        } catch (java.util.NoSuchElementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("Máximo: " + bst.max());
                        } catch (java.util.NoSuchElementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("Tamaño: " + bst.size());
                        break;
                    case 7:
                        System.out.println("¿Está vacío? " + bst.isEmpty());
                        break;
                    case 8:
                        bst.clear();
                        System.out.println("Árbol vaciado");
                        break;
                    case 9:
                        System.out.println("Contenido (in-order): " + bst);
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
        MenuUtils.mostrarEncabezado("PRUEBAS DE BINARY SEARCH TREE");
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        System.out.println(MenuUtils.ANSI_CYAN + "Ejecutando casos de prueba..." + MenuUtils.ANSI_RESET);

        // Inserciones
        t.add(50); t.add(30); t.add(70); t.add(20); t.add(40); t.add(60); t.add(80);
        boolean okInsert = t.toString().equals("[20, 30, 40, 50, 60, 70, 80]") && t.size() == 7;
        System.out.println((okInsert ? MenuUtils.ANSI_GREEN : MenuUtils.ANSI_RED) + "add/size/toString " + (okInsert ? "OK" : "FAIL") + MenuUtils.ANSI_RESET);

        // Búsquedas
        boolean okContains = t.contains(20) && t.contains(50) && t.contains(80) && !t.contains(100);
        System.out.println((okContains ? MenuUtils.ANSI_GREEN : MenuUtils.ANSI_RED) + "contains " + (okContains ? "OK" : "FAIL") + MenuUtils.ANSI_RESET);

        // Min/Max
        boolean okMinMax = (t.min() == 20) && (t.max() == 80);
        System.out.println((okMinMax ? MenuUtils.ANSI_GREEN : MenuUtils.ANSI_RED) + "min/max " + (okMinMax ? "OK" : "FAIL") + MenuUtils.ANSI_RESET);

        // Eliminación raíz con dos hijos
        boolean removed50 = t.remove(50);
        boolean structureOK = t.toString().equals("[20, 30, 40, 60, 70, 80]") && removed50;
        System.out.println((structureOK ? MenuUtils.ANSI_GREEN : MenuUtils.ANSI_RED) + "remove (raíz con 2 hijos) " + (structureOK ? "OK" : "FAIL") + MenuUtils.ANSI_RESET);

        // Clear
        t.clear();
        boolean okClear = t.isEmpty();
        System.out.println((okClear ? MenuUtils.ANSI_GREEN : MenuUtils.ANSI_RED) + "clear/isEmpty " + (okClear ? "OK" : "FAIL") + MenuUtils.ANSI_RESET);
    }
}
