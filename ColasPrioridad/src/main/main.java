package main;

import api.ColasPrioridadTDA;
import impl.ColasPrioridadAO;

public class main {

	public static void main(String[] args) {
		ColasPrioridadTDA u = new ColasPrioridadAO();
		
		u.InicializarCola();
		u.AcolarPrioridad(0, 0);
		u.AcolarPrioridad(5, 3);
		u.AcolarPrioridad(1, 4);
		u.AcolarPrioridad(4, 7);
		mostrarColaPrioridad(u);

	}

	public static ColasPrioridadTDA copiarCola (ColasPrioridadTDA original) {
		ColasPrioridadTDA aux = new ColasPrioridadAO();
		ColasPrioridadTDA copia = new ColasPrioridadAO();
		
		aux.InicializarCola();
		copia.InicializarCola();
		
		while(!original.ColaVacia()) {
			aux.AcolarPrioridad(original.Primero(),original.Prioridad());
			original.Desacolar();
			
		}
		
		while(!aux.ColaVacia()) {
			original.AcolarPrioridad(aux.Primero(),aux.Prioridad());
			copia.AcolarPrioridad(aux.Primero(),aux.Prioridad());
			aux.Desacolar();
			
		}
		return copia;
	}
	
	public static void mostrarColaPrioridad(ColasPrioridadTDA x) {
		ColasPrioridadTDA copia2 = copiarCola(x);
		
		System.out.print("[");

		while(!copia2.ColaVacia()) {
			System.out.print("pepito");
			copia2.Desacolar();
		}
		
	}
}
