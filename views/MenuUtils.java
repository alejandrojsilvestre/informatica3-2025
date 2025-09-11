package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUtils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static Scanner scanner = new Scanner(System.in);

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mostrarEncabezado(String titulo) {
        String linea = "=".repeat(50);
        System.out.println(ANSI_BLUE + linea + ANSI_RESET);
        System.out.println(ANSI_CYAN + " " + titulo + ANSI_RESET);
        System.out.println(ANSI_BLUE + linea + ANSI_RESET);
    }

    public static void pausar() {
        System.out.println(ANSI_YELLOW + "\nPresione ENTER para continuar..." + ANSI_RESET);
        scanner.nextLine();
        if (scanner.hasNextLine()) scanner.nextLine();
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine();
            }
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
