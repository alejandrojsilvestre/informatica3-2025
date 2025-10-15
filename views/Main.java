package views;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("ESTRUCTURAS DE DATOS Y ALGORITMOS - IUA 2025");

            System.out.println(MenuUtils.ANSI_CYAN + "\nOpciones disponibles:" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " Operaciones con Stack " + MenuUtils.ANSI_BLUE + "[Pila LIFO]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " Operaciones con Queue " + MenuUtils.ANSI_BLUE + "[Cola FIFO]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "3." + MenuUtils.ANSI_RESET + " Operaciones con LinkedList " + MenuUtils.ANSI_BLUE + "[Lista Enlazada]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "4." + MenuUtils.ANSI_RESET + " Pruebas de Ordenamiento " + MenuUtils.ANSI_BLUE + "[Sorting]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "5." + MenuUtils.ANSI_RESET + " Operaciones con AVLTree " + MenuUtils.ANSI_BLUE + "[Árbol AVL]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "6." + MenuUtils.ANSI_RESET + " Operaciones con BinaryHeap " + MenuUtils.ANSI_BLUE + "[Montículo Binario]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "7." + MenuUtils.ANSI_RESET + " Salir");

            int choice = MenuUtils.leerEntero(MenuUtils.ANSI_CYAN + "\nSeleccione una opción (1-7): " + MenuUtils.ANSI_RESET);

            switch (choice) {
                case 1:
                    StackMenu.show();
                    break;
                case 2:
                    QueueMenu.show();
                    break;
                case 3:
                    LinkedListMenu.show();
                    break;
                case 4:
                    SortingMenu.show();
                    break;
                case 5:
                    AVLTreeMenu.show();
                    break;
                case 6:
                    BinaryHeapMenu.show();
                    break;
                case 7:
                    running = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    MenuUtils.pausar();
            }
        }
        MenuUtils.getScanner().close();
    }
}
