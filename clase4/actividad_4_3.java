package clase4;

import java.util.ArrayList;
import java.util.Arrays;

public class actividad_4_3 {
	
	static class Mercancia{
		int id;
		double valor, peso, ratio;
		
		Mercancia(int id, double valor, double peso){
			this.id = id;
			this.valor = valor;
			this.peso = peso;
			this.ratio = valor/peso;
		}
		
		@Override
	    public String toString() {
	        return "{id: " + id + "; valor: " + valor + "; peso: " + peso + "; ratio: " + ratio + "}";
	    }
	}
	
	public static double cargaCamion(double capacidad, Mercancia[] mercancias){
		
		ArrayList<Mercancia> Carga = new ArrayList<>();
		
		Arrays.sort(mercancias, (a,b) -> Double.compare(b.ratio, a.ratio));
		
		double valorTotal = 0.0;
		Mercancia ultima = null;
		double fraccion = 0.0;
		
		for (Mercancia m : mercancias) {
			if (capacidad == 0)
				break;
			
			if (m.peso <= capacidad) {
				capacidad -= m.peso;
				valorTotal += m.valor;
				Carga.add(m);	
			}
			else {
				fraccion = capacidad/m.peso;
				ultima = m;
				valorTotal += m.valor*fraccion;
				capacidad = 0;
				
				
			}
		}
		
		System.out.println("Las mercancias cargadas son:");
		for (Mercancia cargada : Carga) {
			System.out.println("\t" + cargada);
		}
		
		if (ultima!=null) {
			System.out.println("y " + fraccion + " partes de \n\t" + ultima);
		}
		
		return valorTotal;
	}
	
	public static void main(String[] args) {
		
		Mercancia[] mercancias = {
				new Mercancia(1,320.00,40.0),
				new Mercancia(2,540.00,60.0),
				new Mercancia(3,80.00,20.0),
				new Mercancia(4,360.00,40.0),
				new Mercancia(5,1600.00,40.0),
				new Mercancia(6,280.00,10.0)};
		
		double ValorTotalMax = cargaCamion(159.0 ,mercancias);
		
		System.out.print("\nEl máximo valor total que se puede cargar es: $" + ValorTotalMax);
		
	}
}
