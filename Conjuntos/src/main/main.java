package main;

import api.ConjuntoTDA;
import impl.ConjuntoTA;

public class main {

	public static void main(String[] args) {
		ConjuntoTDA Menge = new ConjuntoTA();
		
		Menge.InicializarConjunto();
		Menge.Agregar(1);
		Menge.Agregar(3);
		Menge.Agregar(5);

		mostrarConjunto(Menge);
		Menge.Sacar(1);

		mostrarConjunto(Menge);
		Menge.Sacar(3);
		Menge.Sacar(5);

		mostrarConjunto(Menge);
	}
	
	public static ConjuntoTDA copiarConjunto(ConjuntoTDA original) {
		ConjuntoTDA aux = new ConjuntoTA();
		ConjuntoTDA copia = new ConjuntoTA();
		
		aux.InicializarConjunto();
		copia.InicializarConjunto();
		
		while(!original.ConjuntoVacio()) {
			int x = original.Elegir();
			aux.Agregar(x);
			original.Sacar(x);
		}
		
		while(!aux.ConjuntoVacio()){
			int x = aux.Elegir();
			original.Agregar(x);
			copia.Agregar(x);
			aux.Sacar(x);
		}
		
		return copia;

	}
	
	public static void mostrarConjunto(ConjuntoTDA a) {
		ConjuntoTDA copia = copiarConjunto(a);
		System.out.print("{");
		while(!copia.ConjuntoVacio()){
			int x = copia.Elegir();
			System.out.print(x);
			copia.Sacar(x);
			
			if(!copia.ConjuntoVacio()) {
				System.out.print(" , ");
			}
		
		}
		System.out.println("}");
		
	}
	
}
