package clase5;

public class ConjuntoLD implements ConjuntoTDA {

	class Nodo{
		int valor;
		Nodo sig;
	}
	
	Nodo origen;
	
	@Override
	public void InicializarConjunto() {
		origen = null;

	}

	@Override
	public void Agregar(int x) {
		if(!this.Pertenece(x)) {
			Nodo nuevo = new Nodo();
			nuevo.valor = x;
			nuevo.sig = origen;
			origen = nuevo;
		}
	}

	@Override
	public void Sacar(int x) {
		if (origen != null) {
			if (origen.valor == x) {
				origen = origen.sig;
			} else {
				Nodo viajero = origen;
				while (viajero.sig != null && viajero.sig.valor != x) {
					viajero = viajero.sig;
				}
				if (viajero.sig != null) {
					viajero.sig = viajero.sig.sig;
				}
				
			}
		}

	}

	@Override
	public boolean Pertenece(int x) {
		
		return false;
	}

	@Override
	public int Elegir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean ConjuntoVacio() {
		// TODO Auto-generated method stub
		return false;
	}

}
