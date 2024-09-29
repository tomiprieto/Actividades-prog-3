package clase2;

public class Actividad_2_1 {
	
	/* 		ACTIVIDAD 2.1
	 * 
	 * 		Implementa el método getHeight en la clase BinarySearchTree
	 * 		para calcular la altura de un Árbol Binario de Busqueda utilizando
	 * 		la técnica "Dividir y Vencerás"
	 */
	
    public static int getHeight(TreeNode root) {
    	
    	int leftHeight, rightHeight;
    	
    	if (root==null) {
    		return 0; //altura de arboles vacios es 0
    	}
    	else {
    		leftHeight = getHeight(root.left);
    		rightHeight = getHeight(root.right);
    		return Math.max(leftHeight,rightHeight) + 1;
    	}
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(1);
        
        System.out.println("La altura del árbol es " + getHeight(root));
        System.out.println("La altura del subárbol izquierdo es " + getHeight(root.left));
        System.out.println("La altura del subárbol derecho es " + getHeight(root.right));
    }
}
