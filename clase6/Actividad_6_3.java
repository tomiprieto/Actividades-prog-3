package clase6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Actividad_6_3 {
	
	static class Objeto{
		int id;
		double costo;
		double beneficio;
		double ratio;
	
		public Objeto(int id, double costo, double beneficio) {
			this.id = id;
			this.costo = costo;
			this.beneficio = beneficio;
			this.ratio = beneficio/costo;
		}
	}
	
	public static int beneficioMax_FuerzaBruta(List<Objeto> objetos, int presupuesto) {
		int n = objetos.size();
		int beneficio_max = 0;
		int mejor_combinacion = 0;
		
		//genero todas las combinaciones posibles
		for (int i=0; i<(1<<n); i++) { 	//1<<n: desplazo 1 a la izq n veces para generar 2^n combinaciones
			int beneficioTotal = 0;
			int costoTotal = 0;
			
			// sumo beneficio y costo de los objetos en la combinacion i 
			for (int j=0; j<n; j++) {
				if ((i & (1<<j)) !=0){ // AND bit a bit para ver si el objeto j esta elegido en la combinacion i
					beneficioTotal += objetos.get(j).beneficio;
					costoTotal += objetos.get(j).costo;
				}
			}
			if (costoTotal <= presupuesto && beneficioTotal > beneficio_max) {
				beneficio_max = beneficioTotal;
				mejor_combinacion = i;
			}
		}
		//Traduzco la mejor_combinacion a los objetos elegidos con AND bit a bit
		System.out.println("La mejor combinacion: " );
		for (int j=0; j<n; j++) {
			if((mejor_combinacion & (1<<j)) != 0) {
				System.out.println("\tObjeto: " + objetos.get(j).id + ", costo: " 
						+ objetos.get(j).beneficio + "");
			}
		}
		return beneficio_max;
	}
	
	public static int beneficioMax_Greedy(Objeto[] objetos, int presupuesto) {
		int beneficio_max = 0;
		Arrays.sort(objetos, (a,b) -> Double.compare(b.ratio, a.ratio));
		
		for (Objeto obj : objetos) {
			if (obj.costo <= presupuesto) {
				presupuesto -= obj.costo;
				beneficio_max += obj.beneficio;
			} else {
				break;
			}
		}
		return beneficio_max;
	}
	
	
	
	public static int beneficioMax_ProgDin(int[] costos, int[] beneficios, int presupuesto) {
		int n = costos.length;
		int B = presupuesto;
		
		int [][] dp = new int[n+1][B+1];
		for (int i=1; i<=n; i++) {
			for (int j=0; j<=B; j++) {
				if (costos[i-1]<=j) {
					dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-costos[i-1]] + beneficios[i-1]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][B];
	}
	
	public static void main(String[] args) {
		
		int [] costos = {10,15,20,25};
		int [] beneficios = {100,200,150,300};
		int presupuesto = 40;
		
		/* prueba en la que greedy falla
		int [] costos = {10,20,40};
		int [] beneficios = {60,100,120};
		int presupuesto = 50;
		*/
		
		//creacion de las listas, Greedy usa un arreglo para ordenar los objetos por su ratio
		List<Objeto> L_objetos = new ArrayList<>();
		Objeto [] A_objetos = new Objeto[costos.length];
		
		for (int i=0; i<=costos.length-1;i++) {
			L_objetos.add(new Objeto(i+1, costos[i], beneficios[i]));
			A_objetos[i] = new Objeto(i+1, costos[i], beneficios[i]);
		}
		
		System.out.println("Fuerza Bruta: ");
		System.out.println("Beneficio Maximo: " + beneficioMax_FuerzaBruta(L_objetos, presupuesto));
		
		System.out.println("\nGreedy: " + beneficioMax_Greedy(A_objetos, presupuesto));
		
		System.out.println("\nProgramacion Dinamica: " + beneficioMax_ProgDin(costos, beneficios, presupuesto));
	}
}
