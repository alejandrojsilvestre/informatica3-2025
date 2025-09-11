package views;

import structs.Queue;

public class QueueMenu {
    private static Queue<Integer> queue;

    public static void show() {
        if (queue == null) {
            int size = MenuUtils.leerEntero(MenuUtils.ANSI_CYAN + "Ingrese el tamaño de la Queue: " + MenuUtils.ANSI_RESET);
            queue = new Queue<>(size);
            System.out.println(MenuUtils.ANSI_GREEN + "Queue creada exitosamente!" + MenuUtils.ANSI_RESET);
        }

        boolean running = true;
        while (running) {
            MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("OPERACIONES CON QUEUE (COLA)");

            System.out.println(MenuUtils.ANSI_CYAN + "\nOperaciones disponibles:" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "1." + MenuUtils.ANSI_RESET + " Enqueue " + MenuUtils.ANSI_BLUE + "[Agregar elemento]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "2." + MenuUtils.ANSI_RESET + " Dequeue " + MenuUtils.ANSI_BLUE + "[Quitar elemento del frente]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "3." + MenuUtils.ANSI_RESET + " Front   " + MenuUtils.ANSI_BLUE + "[Ver elemento del frente]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "4." + MenuUtils.ANSI_RESET + " isEmpty " + MenuUtils.ANSI_BLUE + "[Verificar si está vacía]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "5." + MenuUtils.ANSI_RESET + " isFull  " + MenuUtils.ANSI_BLUE + "[Verificar si está llena]" + MenuUtils.ANSI_RESET);
            System.out.println(MenuUtils.ANSI_YELLOW + "6." + MenuUtils.ANSI_RESET + " Crear nueva Queue");
            System.out.println(MenuUtils.ANSI_YELLOW + "7." + MenuUtils.ANSI_RESET + " Volver al menú principal");

            try {
                int choice = MenuUtils.leerEntero("Seleccione una opción: ");
                switch (choice) {
                    case 1:
                        int valor = MenuUtils.leerEntero("Ingrese valor a enqueue: ");
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
                        int nuevoTamaño = MenuUtils.leerEntero("Ingrese nuevo tamaño: ");
                        queue = new Queue<>(nuevoTamaño);
                        System.out.println("Nueva Queue creada");
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
