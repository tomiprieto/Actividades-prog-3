package clase4;

import java.util.Arrays;

public class actividad_4_1 {
	
	public static boolean hayCambioExacto(int monto, int[] monedas) {
		Arrays.sort(monedas);
		for (int i=monedas.length-1; i>=0;i--) {
			System.out.println(monto + "; " + monedas[i]);
			if (monto >= monedas[i]) {
				monto -= monedas[i];
			}
		}
		return (monto==0);
	}
	
	
	public static void main(String[] args) {
		int [] lista = {50,25,10,10,1};
		System.out.println(hayCambioExacto(70, lista));
		// No es exacto, con una lista de monedas 50,18,10,10 devolveria que no hay cambio
		// de 70 ignorando la combinacion 50+10+10
	}

}
