package Main;

public class Main {
    	
	public static void main(String[] args) {
		
		int n1 = 0, n2= 0;
		
		n1= 2;
		n2 = -5;
		
		sumar(n1,n2);
		System.out.println("");
		restar(n1,n2);
		
	}
	
	public static void sumar (int num1, int num2) {
		
		int resultado=0;
		
		resultado=num1+num2;
		
		System.out.print("La suma es: ");
		System.out.print(resultado);
		
	}
	
	public static void restar (int num1, int num2) {
		
		int resultado=0;
		
		resultado=num1-num2;
		
		System.out.print("La resta es: ");
		System.out.print(resultado);
		
	}
}
