package main;

import api.ColaTDA;
import impl.Cola;

public class main {
	
	
	public static void main(String[] args) {
		ColaTDA c = new Cola();
		c.InicializarCola();
		
		mostrarCola(c);
		
		c.Acolar(8);
		c.Acolar(11);
		c.Acolar(-2);
		c.Acolar(-2);
		c.Acolar(8);
		
		mostrarCola(c);
		
		c.Acolar(5);
		c.Acolar(90);
		c.Acolar(5);
		c.Acolar(34);
		c.Acolar(90);
		c.Acolar(95);
		c.Acolar(9);
		c.Acolar(340);
		c.Acolar(94);
		c.Acolar(50);
		c.Acolar(93);
		c.Acolar(234);
		
		mostrarCola(c);
		
		c.Desacolar();
		
		mostrarCola(c);
		
		c.MultiDesacolar(4);
		
		mostrarCola(c);
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
}
