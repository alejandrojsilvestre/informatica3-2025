package views;

import structs.AVLTree;

public class AVLTreeMenu {
    public static void show() {
        AVLTree<Integer> avl = new AVLTree<>();
        boolean running = true;
        while (running) {
            MenuUtils.limpiarPantalla();
            MenuUtils.mostrarEncabezado("OPERACIONES CON AVLTree");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Buscar por clave");
            System.out.println("3. Eliminar por clave");
            System.out.println("4. Mostrar recorrido in-order");
            System.out.println("5. Mostrar altura del árbol");
            System.out.println("6. Volver al menú principal");
            System.out.println("7. Visualizar árbol");
            int op = MenuUtils.leerEntero("Seleccione una opción (1-7): ");
            switch (op) {
                case 1:
                    Integer keyIns = MenuUtils.leerEntero("Ingrese el dato (int): ");
                    try {
                        avl.insert(keyIns);
                        System.out.println("Nodo insertado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    MenuUtils.pausar();
                    break;
                case 2:
                    int keyBus = MenuUtils.leerEntero("Ingrese el dato a buscar: ");
                    boolean res = avl.search(keyBus);
                    System.out.println(res ? "Dato encontrado." : "Dato no encontrado.");
                    MenuUtils.pausar();
                    break;
                case 3:
                    int keyDel = MenuUtils.leerEntero("Ingrese el dato a eliminar: ");
                    avl.remove(keyDel);
                    System.out.println("Nodo eliminado (si existía).\n");
                    MenuUtils.pausar();
                    break;
                case 4:
                    System.out.println("Recorrido in-order:");
                    System.out.println(avl.inOrder());
                    MenuUtils.pausar();
                    break;
                case 5:
                    System.out.println("Altura del árbol: " + avl.getHeight());
                    MenuUtils.pausar();
                    break;
                case 6:
                    running = false;
                    break;
                case 7:
                    System.out.println("Visualización jerárquica del árbol:");
                    avl.printTree();
                    MenuUtils.pausar();
                    break;
                default:
                    System.out.println("Opción inválida");
                    MenuUtils.pausar();
            }
        }
    }
}
