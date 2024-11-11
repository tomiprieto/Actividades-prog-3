package clase11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Actividad_11_3 {
	
	static class Almacen{
		int id;
		String nombre;
		
		public Almacen(int id, String nombre) {
			this.id = id;
			this.nombre = nombre;
		}
		
		public String toString() {
			return "Almacen " + id + ":" + nombre;
		}
	}
	
	static class Grafo{
		private List<Almacen> almacenes;
		private List<List<Almacen>> redDistribucion;
		
		public Grafo() {
			almacenes = new ArrayList<>();
			redDistribucion = new ArrayList<>();
		}
		
		public void agregarAlmacen(Almacen almacen) {
			almacenes.add(almacen);
			redDistribucion.add(new LinkedList<>());
		}
		
		public void agregarRuta(Almacen A, Almacen B) {
			int indice_A = almacenes.indexOf(A);
			int indice_B = almacenes.indexOf(B);
			
			if (indice_A != -1 && indice_B != -1) {
				redDistribucion.get(indice_A).add(B);
				redDistribucion.get(indice_B).add(A);
			}
		}
		
		public void imprimirRed() {
			for (int i=0; i<almacenes.size(); i++) {
				System.out.print(almacenes.get(i) + "  => { ");
				for (Almacen vecino : redDistribucion.get(i)) {
					System.out.print(vecino + "  ");
				}
				System.out.print("}\n");
			}
		}
		
		public int distancia_BFS(Almacen inicio, Almacen destino) {
			Queue<Almacen> cola = new LinkedList<>();
			Set<Almacen> visitados = new HashSet<>();
			Map<Almacen, Integer> distancia = new HashMap<>();
			
			cola.add(inicio);
			visitados.add(inicio);
			distancia.put(inicio, 0);
			
			while (!cola.isEmpty()) {
				Almacen aux = cola.poll();
				int distActual = distancia.get(aux);
		
				
				if (aux.equals(destino)) {
					return distActual;
				}
				
				int indice = almacenes.indexOf(aux);
				for (Almacen vecino : redDistribucion.get(indice)) {
					if (!visitados.contains(vecino)) {
						visitados.add(vecino);
						cola.add(vecino);
						distancia.put(vecino, distActual +1);
					}
				}
			}
			
			return -1; // no hay camino entre los almacenes
		}
		
		
		public void DFS_rutas(Almacen almacen, List<Almacen> rutaActual, Set<Almacen> visitados) {
			visitados.add(almacen);
			rutaActual.add(almacen);
			System.out.println("Ruta: " + rutaActual);
			
			int indice = almacenes.indexOf(almacen);
			for (Almacen vecino : redDistribucion.get(indice)) {
				if (!visitados.contains(vecino)) {
				DFS_rutas(vecino, new ArrayList<>(rutaActual), visitados);
				}
			}
			
			visitados.remove(almacen);
		}
	}
	
	public static void main(String[] args) {
		
		Grafo red = new Grafo();
		
		Almacen a = new Almacen(1,"a");
		Almacen b = new Almacen(2,"b");
		Almacen c = new Almacen(3,"c");
		Almacen d = new Almacen(4,"d");
		Almacen e = new Almacen(5,"e");
		Almacen f = new Almacen(6,"f");
		Almacen g = new Almacen(7,"g");
		Almacen h = new Almacen(8,"h");
		
		red.agregarAlmacen(a);
		red.agregarAlmacen(b);
		red.agregarAlmacen(c);
		red.agregarAlmacen(d);
		red.agregarAlmacen(e);
		red.agregarAlmacen(f);
		red.agregarAlmacen(g);
		red.agregarAlmacen(h);
		
		red.agregarRuta(a, b);
		red.agregarRuta(a, c);
		red.agregarRuta(a, d);
		red.agregarRuta(b, e);
		red.agregarRuta(e, f);
		red.agregarRuta(e, g);
		red.agregarRuta(c, d);
		red.agregarRuta(f, h);
		
		System.out.println("Red Completa: ");
		red.imprimirRed();
		
		System.out.println("\nDistancia entre almacenes mediante BFS");
		System.out.println("a -> a: " + red.distancia_BFS(a, a));
		System.out.println("a -> b: " + red.distancia_BFS(a, b));
		System.out.println("a -> g: " + red.distancia_BFS(a, g));	
		System.out.println("d -> h: " + red.distancia_BFS(d, h));
		System.out.println("c -> h: " + red.distancia_BFS(c, h));
		
		Set<Almacen> visitados = new HashSet<>();
		List<Almacen> rutaActual = new ArrayList<>();
		
		System.out.println("\nRutas desde b hacia los demas almacenes mediante DFS");
		red.DFS_rutas(b, rutaActual, visitados);
		

	}
	

}
