package programacion3parcial2;

import java.util.Scanner;

public class NEscritorios {
    
    public static int contadorSoluciones = 0;
    
    public static boolean puedeUbicarEscritorio(int[][] tablero, int fila, int columna) {
        // Revisar anteriores posiciones en la fila
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        return true; // Se puede ubicar el escritorio
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                if(celda == 1){
                    System.out.print("E ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void resolverNEscritorios(int[][] tablero, int columna) {
        int cantidadEscritorios = tablero.length;
        if (columna >= cantidadEscritorios) {
            imprimirTablero(tablero); // Imprimir solución
            contadorSoluciones++;
            return;
        }

        for (int fila = 0; fila < cantidadEscritorios; fila++) {
            if (puedeUbicarEscritorio(tablero, fila, columna)) {
                tablero[fila][columna] = 1; // Ubicar escritorio
                resolverNEscritorios(tablero, columna + 1); // Intentar colocar en la siguiente columna
                tablero[fila][columna] = 0; // Retroceder (backtrack)
            }
        }
    }

    public static void main(String[] args) {
        Scanner scannerCantidadEscritorios = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de escritorios y cantidad de filas y columnas de la oficina:");
        int cantidadEscritorios = scannerCantidadEscritorios.nextInt();
        int[][] tablero = new int[cantidadEscritorios][cantidadEscritorios];
        
        resolverNEscritorios(tablero, 0); // Comenzar desde la primera columna
        System.out.println("La cantidad de soluciones posibles es: " + contadorSoluciones);
    }
}

