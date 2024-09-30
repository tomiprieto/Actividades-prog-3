package clase5;

public interface RedSocialTDA {
	void inicializarRed();
	void agregarUsuario(int ID, String Nombre);
	ConjuntoTDA following(int ID);
	ConjuntoTDA followers(int ID);
	void follow(int ID_origen, int ID_destino);
	void unfollow(int ID_origen, int ID_destino);

}
