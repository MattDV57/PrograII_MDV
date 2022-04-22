package main;

import api.ColaTDA;
import api.PilaTDA;
import impl.Cola;
import impl.Pila;

public class main {

	public static void main(String[] args) {
		ColaTDA c = new Cola();
		c.InicializarCola();
		
		c.Acolar(9);
		c.Acolar(3);
		c.Acolar(1);
		c.Acolar(5);
		c.Acolar(0);
		
		System.out.println("La Cola original es la siguiente:");
		mostrarCola(c);
		System.out.println("La Cola copiada es la siguiente:");
		copiarColaTDA2(c);
		
		invertirCola(c);
	}
	public static ColaTDA copiarColaTDA (ColaTDA original) {
		ColaTDA aux = new Cola();
		ColaTDA copia = new Cola();
		
		aux.InicializarCola();
		copia.InicializarCola();
		
		while(!original.ColaVacia()) {
			aux.Acolar(original.Primero());
			original.Desacolar();
		}
		
		while(!aux.ColaVacia()) {
			original.Acolar(aux.Primero());
			copia.Acolar(aux.Primero());
			aux.Desacolar();
		}
		
		return copia;
	}
	
	public static ColaTDA copiarColaTDA2 (ColaTDA original) {
		ColaTDA aux2 = new Cola();
		ColaTDA copia2 = new Cola();
		
		aux2.InicializarCola();
		copia2.InicializarCola();
		
		while(!original.ColaVacia()) {
			aux2.Acolar(original.Primero());
			original.Desacolar();
		}
		
		System.out.print("[");
		
		while(!aux2.ColaVacia()) {
			System.out.print(aux2.Primero());
			original.Acolar(aux2.Primero());
			copia2.Acolar(aux2.Primero());
			aux2.Desacolar();
			
			if(!aux2.ColaVacia()) {
				System.out.print(",");
			}
							
		}
		System.out.println("]");	
		return copia2;
	}
	
	public static void mostrarCola(ColaTDA x) {
		ColaTDA copia = copiarColaTDA(x);
		System.out.print("[");
		while(!copia.ColaVacia()) {
			System.out.print(copia.Primero());
			copia.Desacolar();
			if(!copia.ColaVacia()) {
				System.out.print(",");
			}
					
		}
		System.out.println("]");
	}
	
	public static void invertirCola (ColaTDA x) {
		ColaTDA copia3 = copiarColaTDA(x);
		PilaTDA pilaaux = new Pila();
		
		//copia3.InicializarCola();
		pilaaux.InicializarPila();
		
		while(!copia3.ColaVacia()) {
			pilaaux.Apilar(copia3.Primero());
			copia3.Desacolar();
		}
		
		while (!pilaaux.PilaVacia()) {
			System.out.print(pilaaux.Tope());
			pilaaux.Desapilar();
		}
		
	}

}
