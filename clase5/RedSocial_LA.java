package clase5;


public class RedSocial_LA implements RedSocialTDA {
	
	class Usuario{
		int id;
		String nombre;
	}
	
	class NodoGrafo{
		Usuario user;
		NodoArista arista;
		NodoGrafo sigNodo;
	}
	
	class NodoArista{
		NodoGrafo nodoDestino;
		NodoArista sigArista;
	}
	
	NodoGrafo origen;

	@Override
	public void inicializarRed() {
		origen = null;

	}

	@Override
	public void agregarUsuario(int ID, String Nombre) {
		Usuario u = new Usuario();
		u.id = ID;
		u.nombre = Nombre;
		
		// verificar que el ID no se encuentre en la red
		NodoGrafo pivote = origen;
		while(pivote.user.id != ID && pivote!=null) {
			pivote =  pivote.sigNodo;
		}
		if (pivote==null) {
			NodoGrafo ng = new NodoGrafo();
			ng.user = u;
			ng.arista = null;
			ng.sigNodo = origen;
			origen = ng;
		}
	}
	
	private NodoGrafo Vert2Nodo(int ID) {
		NodoGrafo aux = origen;
		while (aux!=null && aux.user.id !=ID) //recorre hasta encontrarlo
			aux = aux.sigNodo;
		return aux; // me devuelve el nodo o null si no existe
	}

	@Override
	public void follow(int ID_origen, int ID_destino) {
		NodoGrafo ori = Vert2Nodo(ID_origen);
		NodoGrafo des = Vert2Nodo(ID_destino);
		
		NodoArista aux = new NodoArista();
		aux.nodoDestino = des; //apunta a n2
		aux.sigArista = ori.arista; // se pone al principio de las aristas de n1
		ori.arista = aux;
		

	}

	@Override
	public void unfollow(int ID_origen, int ID_destino) {
		NodoGrafo n_ori = Vert2Nodo(ID_origen); //obtengo el nodo para luego ver sus aristas
		if (n_ori != null && n_ori.arista != null) {
			NodoArista aux = n_ori.arista;
			if (aux.nodoDestino.user.id == ID_destino) { //si el destino es el primer nodo,
				n_ori.arista = aux.sigArista; 
			}
			else {
				while(aux.sigArista != null && aux.sigArista.nodoDestino.user.id != ID_destino) {
					aux = aux.sigArista; // sino se recorre la lista de aristas hasta encontrarlo
				}
				if (aux.sigArista != null) {
					aux.sigArista = aux.sigArista.sigArista;
				}
			}
		}

		
		

	}
	@Override
	public ConjuntoTDA following(int ID) {
		ConjuntoTDA cFollowing = new ConjuntoLD();
		cFollowing.InicializarConjunto();
		
		// recorro las aristas salientes del usuario y agrego los usuarios que este sigue al conjunto
		NodoGrafo ng = Vert2Nodo(ID);
		if (ng != null && ng.arista != null) {
			NodoArista aux = ng.arista;
			while(aux != null) {
				cFollowing.Agregar(aux.nodoDestino.user.id);
				aux = aux.sigArista;
			}
		}
		
		return cFollowing;
	}

	private boolean isFollowing(NodoGrafo N_origen, int ID_destino) {
		if (N_origen != null) {
			NodoArista aux = N_origen.arista;
			while (aux != null) {
				if (aux.nodoDestino.user.id == ID_destino)
					return true;
				aux = aux.sigArista;
			}
		}
		return false;
	}
	
	public ConjuntoTDA followers(int ID) {
		ConjuntoTDA cFollowers = new ConjuntoLD();
		cFollowers.InicializarConjunto();
		
		//recorro todos los usuarios y si 
		NodoGrafo pivote = origen;
		while(pivote!=null) {
			if (isFollowing(pivote, ID)) {
				cFollowers.Agregar(pivote.user.id);
			}
			pivote = pivote.sigNodo;
		}
		return cFollowers;
		
		
	}



}
