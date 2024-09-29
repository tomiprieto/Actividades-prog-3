package clase3;

import java.util.Arrays;

public class Actividad_3_4 {
	
	public static int[] maximos(int [] lista, int cant, int i, int f) {
		if (i==f) {
			int [] nroYmins = new int[cant];
			nroYmins[0] = lista[i];
			Arrays.fill(nroYmins,1, cant, Integer.MIN_VALUE);
			
			return nroYmins;
		}
		
		int mitad = (i+f)/2;
		int [] izq = maximos(lista, cant, i, mitad);
		int [] der = maximos(lista, cant, mitad+1, f);
		
		return comparar(izq, der, cant);
		
	}
	
	public static int[] comparar(int [] l1, int [] l2, int n) {
		int [] mayores = new int[n];
		int i = 0, j = 0, k = 0;
		
		while (k < n) {
			if (l1[i] > l2[j]) {
				mayores[k] = l1[i];
				i++;
			}
			else {
				mayores[k] = l2[j];
				j++;
			}
			k++;
		}
		return mayores;
	}
	
	public static void main(String[] args) {
		
		//ejemplo
		int[] nros = {50,29,35,28,42,53,65,83,99,34,54,12,51,14,5};
		int [] resultado = maximos(nros, 4, 0, nros.length-1);
		System.out.println("los 4 elementos mas grandes son ");
		for (int a = 0; a<4; a++) {
			System.out.print(resultado[a] + " ");
		}
		
	}

}
