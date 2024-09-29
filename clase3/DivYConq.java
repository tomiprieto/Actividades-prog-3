package clase3;

public class DivYConq {
	
	public static int maximo_DyC(int [] lista, int i, int f) {
		if (i==f-1) {
			return lista[i];
		}
		else {
			int mitad = (i+f)/2;
			int izq = maximo_DyC(lista, i, mitad);
			int der = maximo_DyC(lista,mitad,f);
			return Math.max(izq, der);
			}
		
	}
	
	public static void main(String[] args) {
		
		int [] lista = {2,53,43,56,34,87,12,34,98,45};
		
		System.out.println(maximo_DyC(lista, 0, lista.length));
	}

}
