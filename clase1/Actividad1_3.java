package clase1;

public class Actividad1_3 {
	
	public static int sumaRecursiva(int n, int suma) {
		if (n<=0) {
			return 0;
		} else {
			suma = n + sumaRecursiva(n-1, suma);
		}
		return suma;
	}
	
	public static void main(String[] args) {
		System.out.println(sumaRecursiva(100,0));
	}

}
