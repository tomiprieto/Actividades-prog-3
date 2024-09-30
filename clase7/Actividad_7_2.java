package clase7;

public class Actividad_7_2 {
	
	// vuelvo a definir INF para que el armado de la matriz en el ejemplo sea mas prolijo
	
	/* modifique la clase FloydWarshall para que la funcion devuelva una matriz y tambien que
	   no se considere M[i][k] + M[k][j] si alguno es INF ya que al poder sumar negativos
	   pueden obtenerse resultados como 99997
	*/
	
	final static int INF = 99999;
	
	// 	Si en el grafo existen ciclos negativos, 
	//  estos se observaran en la diagonal de la matriz
	
	public static void hayCiclosNegativos(int[][] fw) {
		for (int i=0; i<= fw.length-1; i++) {
			if (fw[i][i] < 0) {
				System.out.println("\nHay ciclos negativos");
			return;
			}
		}
		System.out.println("\nNo hay ciclos negativos");
		
	}
	
	public static int[] pesoMinimoDesde(int[][] fw, int origen) {
		return fw[origen];
	}
	
	
	public static void main(String[] args) {
		
		
		 int graph[][] = { 
                 {0, 1, INF, INF}, 
                 {INF, 0, -1, INF}, 
                 {INF, INF, 0, -1}, 
                 {INF, -1, INF, 0} 
             };
		
		int V = graph.length;
		
		FloydWarshall fw = new FloydWarshall();
		
		int [][]dist = fw.floydWarshall(graph, V);
		
		hayCiclosNegativos(dist);
		
		int sedePrincipal = 0;  //este valor se puede cambiar 
		
		int [] tiempoDesdeSedePrincipal = pesoMinimoDesde(dist, sedePrincipal);
		
		System.out.println("\nLos tiempos minimos de entrega desde la sede Principal son:");
		for (int i=0; i<=tiempoDesdeSedePrincipal.length-1; i++) {
			System.out.println("\thacia sede " + i + ": " + tiempoDesdeSedePrincipal[i]);
		}
	}

}
