package clase5;

public class GrafoMA implements GrafosTDA {
	
	
	static int n = 100;
	int [][] M;
	int [] Etiqs;
	int cantNodos;
	
	@Override
	public void inicializarGrafo() {
		M = new int[n][n];
		Etiqs = new int[n];
		cantNodos = 0;
	}
	
	private int Vert2Indice(int V) {
		int i = cantNodos-1;
		while(i>=0 && Etiqs[i]!=V)
			i--;
		return i; // devuelve -1 si no lo encontró
	}
	

	@Override
	public void agregarVertice(int V) {
		if (Vert2Indice(V)==-1) { //no existe
			Etiqs[cantNodos] = V; //Etiqs empieza en 0, entonces cantNodos esta afuera de la lista
			for(int i=0; i<=cantNodos; i++) {
				M[cantNodos][i] = 0;
				M[i][cantNodos] = 0;
			}
			cantNodos++;
		}
	}

	@Override
	public void eliminarVertice(int V) {
		int ind = Vert2Indice(V);
		for (int k=0; k<cantNodos; k++)
			M[k][ind] = M[k][cantNodos-1]; //reemplaza la columna por la ultima
		for (int k=0; k<cantNodos; k++)
			M[ind][k] = M[cantNodos-1][k]; //reemplaza la fila por la ultima
		
		Etiqs[ind] = Etiqs[cantNodos-1]; //reemplaza el vertice por el ultimo
		cantNodos--; 					//deja de ser accesible la fila/columna duplicada
	}

	@Override
	public ConjuntoTDA vertices() {
		ConjuntoTDA vertices = new ConjuntoLD();
		vertices.InicializarConjunto();
		for (int i=0; i<cantNodos; i++)
			vertices.Agregar(Etiqs[i]);
		return vertices;
	}

	@Override
	public void agregarArista(int v1, int v2, int peso) {
		int origen = Vert2Indice(v1);
		int destino = Vert2Indice(v2);
		M[origen][destino] = peso;
	}

	@Override
	public void eliminarArista(int v1, int v2) {
		int origen = Vert2Indice(v1);
		int destino = Vert2Indice(v2);
		M[origen][destino] = 0;
	}

	@Override
	public boolean existeArista(int v1, int v2) {
		int origen = Vert2Indice(v1);
		int destino = Vert2Indice(v2);
		return (M[origen][destino] != 0);
	}

	@Override
	public int pesoArista(int v1, int v2) {
		int origen = Vert2Indice(v1);
		int destino = Vert2Indice(v2);
		return M[origen][destino];
	}
	

	public ConjuntoTDA adyacentes(int v) {
		ConjuntoTDA adyacentes = new ConjuntoLD();
		adyacentes.InicializarConjunto();
		
		int indice = Vert2Indice(v);
		
		if (indice!=-1) {
			for (int i=0; i<cantNodos;i++) {
				if (M[indice][i]!=0 || M[i][indice]!=0) {
					adyacentes.Agregar(Etiqs[i]);
				}
			}
		}
		return adyacentes;
	}
	
	public int gradoEntrada(int v) {
		int indice = Vert2Indice(v);
		int gradoEnt = 0;
		
		if (indice != -1) {
			for (int i=0;i<cantNodos;i++) {
				if (M[i][indice] != 0) 
					gradoEnt++;
			}
		}
		return gradoEnt;
	}
	
	public int gradoSalida(int v) {
		int indice = Vert2Indice(v);
		int gradoSal = 0;
		
		if (indice != -1) {
			for (int i=0;i<cantNodos;i++) {
				if (M[indice][i] != 0) 
					gradoSal++;
			}
		}
		return gradoSal;
	}
}
