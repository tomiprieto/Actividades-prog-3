package clase1;

public class Actividad1_1 {
	
	public static int maximo(int[] a) {
		int max = a[0];
		for (int i=0; i<=a.length-1; i++) {
			if (a[i]>max) 
				max = a[i];
			}
		return max;
		}
	public static void main(String[] args) {
		int[] arreglo = {2,5,7,3,3};
		System.out.println(maximo(arreglo));		
	}
}
