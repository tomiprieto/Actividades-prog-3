package clase1;

import java.util.ArrayList;
import java.util.List;

/*
 * Un sistema de facturacion recibe una lista de comprobantes
 * facturas electronicas, con id de factura, id de cliente, e importe y
 * una lista de clientes con id cliente, y nombre de cliente, realizar
 * un codigo de java que genera otra lista, con id cliente, suma de los
 * importes de las facturas
 */

public class Actividad_1_1b {
	
	public static class Factura{
		int id_factura;
		int id_cliente;
		int importe;
		
		public Factura(int ID_FACTURA, int ID_CLIENTE, int IMPORTE) {
			this.id_factura = ID_FACTURA;
			this.id_cliente = ID_CLIENTE;
			this.importe = IMPORTE;
		}
	}
	
	public static class Cliente{
		int id_cliente;
		String nombre;
		
		public Cliente(int ID_CLIENTE, String NOMBRE) {
			this.id_cliente = ID_CLIENTE;
			this.nombre = NOMBRE;
		}
	}
	
	public static class Total{
		int id_cliente;
		int suma;
		
		public Total(int ID_CLIENTE, int SUMA) {
			this.id_cliente = ID_CLIENTE;
			this.suma = SUMA;
		}
		
		public String toString() {
			return "Id_Cliente: " + id_cliente + "; total: " + suma;
		}
	}
	
	public static List<Total> sumaImportes(List<Cliente> Clientes, List<Factura> Facturas){
		
		List<Total> ImportesTotales = new ArrayList<>();
		
		for (int i=0; i<= Clientes.size()-1; i++) {
			int id = Clientes.get(i).id_cliente;
			int suma_importes = 0;
			
			for(int j=0; j<= Facturas.size()-1;j++) {
				if (Facturas.get(j).id_cliente == id) {
					suma_importes += Facturas.get(j).importe;
				}
			}
			
			Total t = new Total(id, suma_importes);
			ImportesTotales.add(t);
		}
		
		return ImportesTotales;
	}
	
	public static void main(String[] args) {
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente(1,"Juan"));
		clientes.add(new Cliente(2,"Pedro"));
		clientes.add(new Cliente(3,"Marcos"));
		clientes.add(new Cliente(4,"Carlos"));
		
		List<Factura> facturas = new ArrayList<>();
		facturas.add(new Factura(1, 1, 1200));
		facturas.add(new Factura(2, 1, 500));
		facturas.add(new Factura(3, 2, 300));
		facturas.add(new Factura(4, 4, 1600));
		facturas.add(new Factura(5, 3, 2200));
		facturas.add(new Factura(6, 4, 1200));
		facturas.add(new Factura(7, 1, 4200));
		facturas.add(new Factura(8, 2, 1100));
		facturas.add(new Factura(9, 2, 1700));
		facturas.add(new Factura(10, 4, 200));
		
		List<Total> totales = sumaImportes(clientes, facturas);
		
		for (Total total : totales) {
			System.out.println(total);
		}
	}
}
