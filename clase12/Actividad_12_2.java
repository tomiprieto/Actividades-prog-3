package clase12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Actividad_12_2 {
	
	class Lugar{
		String nombre;
		int precio;
	
		public Lugar(String nombre, int precio) {
			this.nombre = nombre;
			this.precio = precio;
		}
	}
	
	public class Grafo{
		private final Map<String, List<Lugar>> grafo = new HashMap<>();
		
		public void agregarLugar(String nombre) {
			grafo.putIfAbsent(nombre, new ArrayList<>());
		}
		
		public void agregarRuta(String origen, String destino, int precio) {
			grafo.get(origen).add(new Lugar(destino, precio));
		}
		

		
		public int UCS(String inicio, String objetivo) {
			PriorityQueue<Lugar> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(n->n.precio));
			colaPrioridad.add(new Lugar(inicio,0));
			Set<String> visitados = new HashSet<>();
			
			while (!colaPrioridad.isEmpty()) {
				Lugar actual = colaPrioridad.poll();
				
				if (actual.nombre.equals(objetivo)) {
					return actual.precio;
				}
				
				if(visitados.contains(actual.nombre))
					continue;
				
				visitados.add(actual.nombre);
				
				for (Lugar vecino : grafo.getOrDefault(actual.nombre, new ArrayList<>())) {
					if (!visitados.contains(vecino.nombre)) {
						colaPrioridad.add(new Lugar(vecino.nombre, actual.precio + vecino.precio));
					}
				}
			}
			
			return -1;
		}
	}
	
	
	

}
