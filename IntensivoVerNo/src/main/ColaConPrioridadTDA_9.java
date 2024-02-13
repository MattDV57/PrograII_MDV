package main;

import apis.ColaPrioridadTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;
import impl.ColaPrioridadAO;
import impl.DicMultipleA;

public class ColaConPrioridadTDA_9 {

	public static void main(String[] args) {
		ColaPrioridadTDA ccp1 = new ColaPrioridadAO();
		
		ccp1.inicializarCola();
		
		ccp1.acolarPrioridad(6, 1);
		ccp1.acolarPrioridad(4, 3);
		ccp1.acolarPrioridad(2, 54);
		ccp1.acolarPrioridad(7, 2);
		ccp1.acolarPrioridad(7, 234);
		ccp1.acolarPrioridad(1, 43);
		ccp1.acolarPrioridad(2, 23);
		ccp1.acolarPrioridad(9, 33);
		
		mostrarCola(ccp1);
		
		DiccionarioMultipleTDA dM = generarDicMul(ccp1);
		
		mostrarDic(dM);
		
	}
	
	public static void mostrarCola(ColaPrioridadTDA c1) {
		
		ColaPrioridadTDA cMos = copiarCola(c1);
		
		System.out.println("[");		
		while(!cMos.colaVacia()) {
			System.out.println(cMos.primero() + " - " + cMos.prioridad());	
			cMos.desacolar();

		}
		System.out.print("]");
		
		
	}
	
	public static ColaPrioridadTDA copiarCola (ColaPrioridadTDA cCop) {
		
		ColaPrioridadTDA cAux = new ColaPrioridadAO();
		ColaPrioridadTDA cDes = new ColaPrioridadAO();
		
		cAux.inicializarCola();
		cDes.inicializarCola();
		
		while(!cCop.colaVacia()) {
			cDes.acolarPrioridad(cCop.primero(), cCop.prioridad());
			cCop.desacolar();
		}
		
		while(!cDes.colaVacia()) {
			cCop.acolarPrioridad(cDes.primero(), cDes.prioridad());
			cAux.acolarPrioridad(cDes.primero(), cDes.prioridad());
			cDes.desacolar();
		}
		
		return cAux;
	}

	public static DiccionarioMultipleTDA generarDicMul(ColaPrioridadTDA c2) {
		DiccionarioMultipleTDA dM1 = new DicMultipleA();
		
		dM1.inicializarDiccionario();
		
		while(!c2.colaVacia()) {
			dM1.agregar(c2.primero(), c2.prioridad());
			c2.desacolar();
		};
		
		return dM1;
		
		
	};

	public static void mostrarDic(DiccionarioMultipleTDA dM2) {
		
		ConjuntoTDA claves = dM2.claves();
		
		while(!claves.conjuntoVacio()) {
			
			int aux2 = claves.elegir();
			
			claves.sacar(aux2);
			ConjuntoTDA valores = dM2.recuperar(aux2);
			System.out.println(" ");
			System.out.print(aux2 + " - ");
			
			while(!valores.conjuntoVacio()) {
				int impr = valores.elegir();
				valores.sacar(impr);
				System.out.print(" " + impr + " ");
				
			}
			
			
		}
		
		
	}
}
