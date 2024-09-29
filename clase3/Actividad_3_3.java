package clase3;

import java.util.ArrayList;
import java.util.List;

public class Actividad_3_3 {
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

	public static Cliente [] maximos(List<Cliente> lista, int i, int f) {
		if (i==f) {
			return new Cliente[] {lista.get(i), null};
			
		}
		int mitad = (i+f)/2;
		Cliente [] izq = maximos(lista, i, mitad);
		Cliente [] der = maximos(lista, mitad+1, f);
		
		Cliente max1, max2;
		if (izq[0].getScoring() > der[0].getScoring()){
			max1 = izq[0];
			max2 = (izq[1] != null && izq[1].getScoring() > der[0].getScoring()) ? izq[1] : der[0];
		}
		else {
			max1 = der[0];
			max2 = (der[1] != null && der[1].getScoring() > izq[0].getScoring()) ? der[1] : izq[0];
		}
		
		return new Cliente [] {max1, max2};
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
		
		Cliente [] maxClientes = maximos(listaCliente,0,listaCliente.size()-1);
		System.out.println("el cliente con mayor scoring es " + maxClientes[0]);
		System.out.println("el siguiente con mayor scoring es " + maxClientes[1]);
	}


}
