package views;

import structs.Stack;

public class StackMenu {
    private static Stack<Integer> stack;

    public static void show() {
        if (stack == null) {
            int size = MenuUtils.leerEntero(MenuUtils.ANSI_CYAN + "Ingrese el tamaño del Stack: " + MenuUtils.ANSI_RESET);
            stack = new Stack<>(size);
            System.out.println(MenuUtils.ANSI_GREEN + "Stack creado exitosamente!" + MenuUtils.ANSI_RESET);
        }

        boolean running = true;
        while (running) {
            MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("OPERACIONES CON STACK (PILA)");

            System.out.println(MenuUtils.ANSI_CYAN + "\nOperaciones disponibles:" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " Push    " + MenuUtils.ANSI_BLUE + "[Agregar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " Pop     " + MenuUtils.ANSI_BLUE + "[Quitar elemento del tope]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "3." + MenuUtils.ANSI_RESET + " Top     " + MenuUtils.ANSI_BLUE + "[Ver elemento del tope]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "4." + MenuUtils.ANSI_RESET + " isEmpty " + MenuUtils.ANSI_BLUE + "[Verificar si está vacía]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "5." + MenuUtils.ANSI_RESET + " isFull  " + MenuUtils.ANSI_BLUE + "[Verificar si está llena]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "6." + MenuUtils.ANSI_RESET + " Crear nuevo Stack");
            System.out.println(MenuUtils.ANSI_YELLOW + "7." + MenuUtils.ANSI_RESET + " Volver al menú principal");

            try {
                int choice = MenuUtils.leerEntero("Seleccione una opción: ");
                switch (choice) {
                    case 1:
                        int valor = MenuUtils.leerEntero("Ingrese valor a push: ");
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
                        int nuevoTamaño = MenuUtils.leerEntero("Ingrese nuevo tamaño: ");
                        stack = new Stack<>(nuevoTamaño);
                        System.out.println("Nuevo Stack creado");
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
            MenuUtils.pausar();
        }
    }
}
