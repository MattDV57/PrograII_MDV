package main;

import api.ColaPrioridadTDA;
import impl.ColaPrioridadTA;

public class main {

	public static void main(String[] args) {
		ColaPrioridadTDA cola1 = new ColaPrioridadTA();
		ColaPrioridadTDA cola2 = new ColaPrioridadTA();
		
		cola1.InicializarCola();
		cola2.InicializarCola();
		
		cola1.AcolarPrioridad(0, 9);
		cola1.AcolarPrioridad(4, 8);
		cola1.AcolarPrioridad(6, 7);

		
		cola2.AcolarPrioridad(5, 4);
		cola2.AcolarPrioridad(65, 1);
		cola2.AcolarPrioridad(12, 8);
		cola2.AcolarPrioridad(34, 7);
				
		System.out.println("La Cola original Valor - Prioridad es: ");
		mostrarCola(cola1);
		System.out.println("");
		mostrarCola(cola2);
		System.out.println("");
		unirColas(cola1,cola2);
		
	}
		
		public static ColaPrioridadTDA copiarCola(ColaPrioridadTDA original) {
			ColaPrioridadTDA aux = new ColaPrioridadTA();
			ColaPrioridadTDA copia = new ColaPrioridadTA();
			
			aux.InicializarCola();
			copia.InicializarCola();
			
			while(!original.ColaVacia()) {
				aux.AcolarPrioridad(original.Primero(), original.Prioridad());
				original.Desacolar();
			}
			
			while (!aux.ColaVacia()) {
				original.AcolarPrioridad(aux.Primero(), aux.Prioridad());
				copia.AcolarPrioridad(aux.Primero(), aux.Prioridad());
				aux.Desacolar();
			}
			
			return copia;
			
		}
		public static void mostrarCola(ColaPrioridadTDA x) {
			ColaPrioridadTDA copia2 = copiarCola(x);
			
			while(!copia2.ColaVacia()) {
				System.out.print("[");
				System.out.print(copia2.Primero() + " - " + copia2.Prioridad() + " ");
				copia2.Desacolar();
				System.out.print("]");
			}
		}
		
		public static void unirColas(ColaPrioridadTDA uno, ColaPrioridadTDA dos) {
			ColaPrioridadTDA copiaUno = copiarCola(uno);
			ColaPrioridadTDA copiaDos = copiarCola(dos);
			ColaPrioridadTDA ultima = new ColaPrioridadTA();
			
			ultima.InicializarCola();
			
			
			while(!copiaUno.ColaVacia() && !copiaDos.ColaVacia()) {
				if (copiaUno.Prioridad()==copiaDos.Prioridad()) {
					ultima.AcolarPrioridad(copiaDos.Primero(), copiaDos.Prioridad());
					ultima.AcolarPrioridad(copiaUno.Primero(), copiaUno.Prioridad());
								
				}else {
					ultima.AcolarPrioridad(copiaUno.Primero(), copiaUno.Prioridad());
					ultima.AcolarPrioridad(copiaDos.Primero(), copiaDos.Prioridad());
					
				
				}
				copiaUno.Desacolar();
				copiaDos.Desacolar();

			}
			
			System.out.println(" ");
			
			while(!ultima.ColaVacia()) {
				System.out.print("[" + ultima.Primero() + " - " + ultima.Prioridad() + "]");
				ultima.Desacolar();
			}
			
		}

}
