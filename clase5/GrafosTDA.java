package clase5;

public interface GrafosTDA {
	void inicializarGrafo();
	void agregarVertice(int V);
	void eliminarVertice(int V);
	ConjuntoTDA vertices();
	void agregarArista(int v1, int v2, int peso);
	void eliminarArista(int v1, int v2);
	boolean existeArista(int v1, int v2);
	int pesoArista(int v1, int v2);
	
	
	
	

}
