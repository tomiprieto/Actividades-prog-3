package clase3;

import java.util.ArrayList;
import java.util.List;

/* 
 * Aplica la técnica de divide y vencerás en una lista de clientes
 * con id cliente, nombre y scoring, buscando el cliente con el 
 * scoring máximo
 */
public class Actividad_3_1 {
	
	static class Cliente{
		int id_cliente;
		String nombre;
		int scoring;
		
		public Cliente(int ID, String Nombre, int Score) {
			this.id_cliente = ID;
			this.nombre = Nombre;
			this.scoring = Score;
		}
	
		public int getScoring() {
			return this.scoring; 
		}
		
		public String toString() {
            return "Cliente{id=" + id_cliente + ", nombre='" + nombre + "', scoring=" + scoring + "}";
		}
	}

	public static Cliente maximo(List<Cliente> lista, int i, int f) {
		if (i==f) {
			return lista.get(i);
			
		}
		int mitad = (i+f)/2;
		Cliente izq = maximo(lista, i, mitad);
		Cliente der = maximo(lista,mitad+1,f);
		 return (izq.getScoring() > der.getScoring()) ? izq : der;
	}
	
	
	public static void main(String[] args) {
		List<Cliente> listaCliente = new ArrayList<>();
		
		listaCliente.add(new Cliente(0,"a",10));
		listaCliente.add(new Cliente(1,"b",40));
		listaCliente.add(new Cliente(2,"c",15));
		listaCliente.add(new Cliente(3,"d",20));
		listaCliente.add(new Cliente(5,"e",30));
		listaCliente.add(new Cliente(6,"f",50));
		listaCliente.add(new Cliente(7,"g",5));
		listaCliente.add(new Cliente(8,"h",15));
		
		Cliente maxScoring = maximo(listaCliente,0,listaCliente.size()-1);
		System.out.println(maxScoring);
	}

}
