package programacion3parcial2;

import java.util.Scanner;

public class NComputadorasImpresoras {
    
    public static int contadorSoluciones = 0;

    public static boolean puedeUbicarComputadora(int[][] tablero, int fila, int columna) {
        // Revisar si ya hay un objeto en esa posición
        if (tablero[fila][columna] != 0) {
            return false;
        }
        
        // Revisar anteriores posiciones en la fila
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        return true; // Se puede ubicar una computadora
    }

    public static boolean puedeUbicarImpresora(int[][] tablero, int fila, int columna) {
        // Revisar si ya hay un objeto en esa posición
        if (tablero[fila][columna] != 0) {
            return false;
        }
        
        // Revisar anteriores posiciones en la fila
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == 2) {
                return false;
            }
        }
        return true; // Se puede ubicar una impresora
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                switch (celda) {
                    case 1:
                        System.out.print("C "); // Computadora
                        break;
                    case 2:
                        System.out.print("I "); // Impresora
                        break;
                    default:
                        System.out.print(". "); // Espacio vacío
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void resolverNObjetos(int[][] tablero, int columna, int cantidadComputadoras, int cantidadImpresoras, int computadorasColocadas, int impresorasColocadas) {
        int cantidadFilas = tablero.length;

        // Si se colocaron todas las computadoras e impresoras, imprimir solución
        if (computadorasColocadas == cantidadComputadoras && impresorasColocadas == cantidadImpresoras) {
            imprimirTablero(tablero);
            contadorSoluciones++;
            return;
        }

        // Intentar colocar computadoras
        if (computadorasColocadas < cantidadComputadoras) {
            for (int fila = 0; fila < cantidadFilas; fila++) {
                if (puedeUbicarComputadora(tablero, fila, columna)) {
                    tablero[fila][columna] = 1; // Ubicar computadora
                    resolverNObjetos(tablero, columna + 1, cantidadComputadoras, cantidadImpresoras, computadorasColocadas + 1, impresorasColocadas);
                    tablero[fila][columna] = 0; // Retroceder
                }
            }
        }

        // Intentar colocar impresoras
        if (impresorasColocadas < cantidadImpresoras) {
            for (int fila = 0; fila < cantidadFilas; fila++) {
                if (puedeUbicarImpresora(tablero, fila, columna)) {
                    tablero[fila][columna] = 2; // Ubicar impresora
                    resolverNObjetos(tablero, columna + 1, cantidadComputadoras, cantidadImpresoras, computadorasColocadas, impresorasColocadas + 1);
                    tablero[fila][columna] = 0; // Retroceder
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de computadoras e impresoras:");
        int cantidadObjetos = scanner.nextInt();
        int cantidadComputadoras = cantidadObjetos/2;
        int cantidadImpresoras = cantidadObjetos/2;

        int[][] tablero = new int[cantidadObjetos][cantidadObjetos];
        resolverNObjetos(tablero, 0, cantidadComputadoras, cantidadImpresoras, 0, 0); // Comenzar desde la primera columna
        System.out.println("La cantidad de soluciones posibles es: " + contadorSoluciones);
    }
}

