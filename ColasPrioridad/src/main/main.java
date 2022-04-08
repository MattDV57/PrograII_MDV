package main;

import api.ColasPrioridadTDA;
import impl.ColasPrioridadAO;

public class main {

	public static void main(String[] args) {
		ColasPrioridadTDA u = new ColasPrioridadAO();
		
		u.InicializarCola();
		u.AcolarPrioridad(0, 0);
		u.AcolarPrioridad(0, 0);
		u.AcolarPrioridad(0, 0);
		u.AcolarPrioridad(0, 0);
		mostrarColaPrioridad(u);

	}

	public static ColasPrioridadTDA copiarCola (ColasPrioridadTDA original) {
		ColasPrioridadTDA aux = new ColasPrioridadAO();
		ColasPrioridadTDA copia = new ColasPrioridadAO();
		
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
		ColasPrioridadTDA copia = copiarCola(x);
		System.out.print("[");
		while(!copia.ColaVacia()) {
			System.out.print("pepito");
		}
		
	}
}
