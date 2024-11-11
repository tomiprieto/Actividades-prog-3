package clase10;

public class Actividad_10_1 {

    public static int contadorSoluciones = 0;
    
    public static boolean puedeUbicar(int[][] tablero, int fila, int columna) {
        // Revisar anteriores posiciones en la fila
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }

        // Revisar anteriores posiciones diagonal arriba
        for (int j = fila, k = columna; j >= 0 && k >= 0; j--, k--) {
            if (tablero[j][k] == 1) {
                return false;
            }
        }

        // Revisar anteriores posiciones diagonal abajo
        for (int m = fila, n = columna; n >= 0 && m < tablero.length; m++, n--) {
            if (tablero[m][n] == 1) {
                return false;
            }
        }

        return true; // Se puede ubicar la reina
    }
    
    public static void resolverNReinas(int[][] tablero, int columna) {
        int cantidadReinas = tablero.length;
        if (columna >= cantidadReinas) {
            imprimirTablero(tablero); // Imprimir solución
            contadorSoluciones++;
            return;
        }

        for (int fila = 0; fila < cantidadReinas; fila++) {
            if (puedeUbicar(tablero, fila, columna)) {
                tablero[fila][columna] = 1; // Ubicar reina
                resolverNReinas(tablero, columna + 1); // Intentar colocar en la siguiente columna
                tablero[fila][columna] = 0; // Retroceder (backtrack)
            }
        }
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                if(celda == 1){
                    System.out.print("R ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
        
    	int cantidadReinas = 4;
    	int[][] tablero = new int[cantidadReinas][cantidadReinas];

        resolverNReinas(tablero, 0); // Comenzar desde la primera columna
        System.out.println("La cantidad de soluciones posibles es: " + contadorSoluciones);
    }
}


