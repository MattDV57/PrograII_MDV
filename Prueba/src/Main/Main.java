package Main;

import impl.ColaLD;
import impl.PilaLD;
import api.ColaTDA;
import api.PilaTDA;

public class Main {
    	
	public static void main(String[] args) {
		
		int n1 = 0, n2= 0;
		
		n1= 2;
		n2 = -5;
		
		//sumar(n1,n2);
		System.out.println("");
	//	restar(n1,n2);
		
		PilaTDA pila1 = new PilaLD();
		
		pila1.Apilar(32);
		pila1.Apilar();
		pila1.Apilar(5);
		pila1.Apilar(23);
		pila1.Apilar();
		pila1.Apilar(11);
		pila1.Apilar(56);
		pila1.Apilar(7);

		mostrarPila(pila1);
		
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

	public static void mostrarPila(PilaTDA p1) {
		
		System.out.print("[");
		while(!p1.PilaVacia()) {
			System.out.print(p1.Tope());
			p1.Desapilar();
			if(!p1.PilaVacia()) {
				System.out.print(" - ");
			}
		}
		System.out.print("]");
	}
	
	
}
