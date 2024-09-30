package clase6;

import java.util.ArrayList;
import java.util.List;

import clase6.Actividad_6_3.Objeto;

public class Actividad_6_4 {
	
	public static void main(String[] args) {
		
		int[] costos = {12,20,15,25};
		int[] ganancias = {150,200,100,300};
		int presupuesto = 35;
		
		
		List<Objeto> L_objetos = new ArrayList<>();
		Objeto [] A_objetos = new Objeto[costos.length];
		
		for (int i=0; i<=costos.length-1;i++) {
			L_objetos.add(new Objeto(i+1, costos[i], ganancias[i]));
			A_objetos[i] = new Objeto(i+1, costos[i], ganancias[i]);
		}
		
		System.out.println("Fuerza Bruta: " + Actividad_6_3.beneficioMax_FuerzaBruta(L_objetos, presupuesto));
		System.out.println("\nGreedy: " + Actividad_6_3.beneficioMax_Greedy(A_objetos, presupuesto));
		System.out.println("\nProgDin: " + Actividad_6_3.beneficioMax_ProgDin(costos, ganancias, presupuesto));
		
	}
}
