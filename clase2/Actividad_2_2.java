package clase2;

public class Actividad_2_2 {
	
	//Codigo del repo de la materia
	
	public class BusquedaBinaria {

	    // Método para realizar la búsqueda binaria
	    public static int busquedaBinaria(int[] arreglo, int objetivo) {
	        int izquierda = 0;
	        int derecha = arreglo.length - 1;

	        while (izquierda <= derecha) {
	            int medio = izquierda + (derecha - izquierda) / 2;

	            // Verificar si el objetivo está en el medio
	            if (arreglo[medio] == objetivo) {
	                return medio; // Retorna el índice del objetivo
	            }

	            // Si el objetivo es mayor, ignorar la mitad izquierda
	            if (arreglo[medio] < objetivo) {
	                izquierda = medio + 1;
	            } 
	            // Si el objetivo es menor, ignorar la mitad derecha
	            else {
	                derecha = medio - 1;
	            }
	        }

	        // Si no se encuentra el objetivo, retorna -1
	        return -1;
	    }
	}
	
	
	/* 		ACTIVIDAD 2.2
	 * 
	 * 		Utilizar la implementación de la búsqueda binaria del repo de la materia
	 * 		para buscar un elemento en un array ordenado
	 */
	
	public static void main(String[] args) {
		
		// Prueba de la busqueda binaria
		
		int[] A = {3,9,16,20,24,29,35,45,59,61,62,70,77,102,140};
		int objetivo = 71;
		
		int pos = BusquedaBinaria.busquedaBinaria(A,objetivo);
		
		if (pos != -1) {
			System.out.println("El valor " + objetivo + " se encuentra en la posicion " + pos);
			System.out.println("A["+pos+"] = " + A[pos]);
		}
		else
			System.out.println("No se encuentra el valor " + objetivo + " en el arreglo");
		
	}
	    
}
