package clase11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Actividad_11_4 {
	
	static class Usuario{
		int id;
		String nombre;
		
		public Usuario(int id, String nombre) {
			this.id = id;
			this.nombre = nombre;
		}
		
		int getId() {
			return this.id;
		}
		
		public String toString() {
			return  nombre + " (id: " + id + ")";
		}
	}
	
	static class Grafo{
		private List<Usuario> usuarios;
		private List<List<Usuario>> redSocial;
		
		public Grafo() {
			usuarios = new ArrayList<>();
			redSocial = new ArrayList<>();
		}
		
		public boolean agregarUsuario(Usuario nuevo) {
			
			int id = nuevo.getId();
			
			// Asegurar ID unico, usar un HashSet para "usuarios" optimizaria este paso
			for (Usuario usuario : usuarios) {
				if (usuario.getId() == id) {
					System.out.println("Ya existe ese ID");
					return false;
				}
			}
			usuarios.add(nuevo);
			redSocial.add(new LinkedList<>());
			return true;
		}
		
		public void conectarUsuarios(Usuario user_A, Usuario user_B) {
			int indice_A = usuarios.indexOf(user_A);
			int indice_B = usuarios.indexOf(user_B);
			
			if (indice_A != -1 && indice_B != -1) {
				redSocial.get(indice_A).add(user_B);
				redSocial.get(indice_B).add(user_A);
			}
		}
		
		public void DFS(Usuario usuario, Set<Usuario> visitados) {
			visitados.add(usuario);
			
			int indice = usuarios.indexOf(usuario);
			for (Usuario vecino : redSocial.get(indice)) {
				if (!visitados.contains(vecino)) {
					DFS(vecino, visitados);
				}
			}
			
		}
		
		public void alcanzables(Usuario usuario) {
			Set<Usuario> visitados = new HashSet<>();	
			DFS(usuario, visitados);

			System.out.println("Los usuarios alcanzables por " + usuario + " son:");
			System.out.println(visitados);
			
		}
		
		public void BFS(Usuario inicio) {
			Queue<Usuario> cola = new LinkedList<>();
			Set<Usuario> visitados = new HashSet<>();
			
			cola.add(inicio);
			visitados.add(inicio);
			
			while(!cola.isEmpty()) {
				Usuario actual = cola.poll();
				System.out.println(actual);
				
				int indice = usuarios.indexOf(actual);
				for (Usuario vecino : redSocial.get(indice)) {
					if(!visitados.contains(vecino)) {
						visitados.add(vecino);
						cola.add(vecino);
						
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Grafo red = new Grafo();
		
		Usuario u_1 = new Usuario(1,"a");
		Usuario u_2 = new Usuario(2,"b");
		Usuario u_3 = new Usuario(3,"c");
		Usuario u_4 = new Usuario(4,"d");
		Usuario u_5 = new Usuario(5,"e");
		Usuario u_6 = new Usuario(6,"f");
		Usuario u_7 = new Usuario(7,"g");
		Usuario u_8 = new Usuario(8,"h");
		
		
		red.agregarUsuario(u_1);
		red.agregarUsuario(u_2);
		red.agregarUsuario(u_3);
		red.agregarUsuario(u_4);
		red.agregarUsuario(u_5);
		red.agregarUsuario(u_6);
		red.agregarUsuario(u_7);
		red.agregarUsuario(u_8);
		
		red.conectarUsuarios(u_1,u_2);
		red.conectarUsuarios(u_1,u_3);
		red.conectarUsuarios(u_3,u_4);
		red.conectarUsuarios(u_5,u_6);
		red.conectarUsuarios(u_6,u_7);
		red.conectarUsuarios(u_3,u_8);
		
		red.alcanzables(u_2);
		
		System.out.println("\nBFS desde: " + u_5);
		red.BFS(u_5);
		
		
		
		
		
		
	}

}
