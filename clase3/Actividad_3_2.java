package clase3;

public class Actividad_3_2 {
	
	public static int[] maximos(int [] lista, int i, int f) {
		
		if (i==f) {
			return new int[] {lista[i], Integer.MIN_VALUE};
		}
		
		int mitad  = (i+f)/2;
		int [] izq = maximos(lista, i, mitad);
		int [] der = maximos(lista, mitad+1, f);
		
		
		//comparacion entre tuplas izquierda y derecha
		
		/* las tuplas siempre tendran el max como primer elemento,
		 * se elige el maximo entre los primeros de las 2 tuplas y se compara el 
		 * segundo elem de la elegida con el primero de la otra tupla para determinar
		 * el max2
		 */
		
		int max1, max2;
		if (izq[0] > der[0]) {
			max1 = izq[0];
			max2 = Math.max(izq[1], der[0]);
		}
		else {
			max1 = der[0];
			max2 = Math.max(der[1], izq[0]);
		}
		
		return new int[] {max1,max2};
	}
	
	public static void main(String[] args) {
		int [] lista = {1,5,2,6,9,4,5,8,4};
		int [] dos_maximos = maximos(lista,0,lista.length-1);
		System.out.println("los maximos son " + dos_maximos[0] + " y " + dos_maximos[1]);
	}

}
