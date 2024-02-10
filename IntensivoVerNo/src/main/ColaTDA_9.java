package main;

import apis.ColaTDA;
import apis.ConjuntoTDA;
import impl.ColaPU;
import impl.ConjuntoTA;

public class ColaTDA_9 {

	public static void main(String[] args) {
		ColaTDA cola1 = new ColaPU();
		
		cola1.inicializarCola();
		
		cola1.acolar(3);
		cola1.acolar(5);
		cola1.acolar(5);
		cola1.acolar(6);
		cola1.acolar(23);
		cola1.acolar(23);
		cola1.acolar(1);
		cola1.acolar(70);
		cola1.acolar(70);
		
		System.out.println();
		System.out.print("=== A) Eliminar de una Cola las repeticiones de elementos ===");
		System.out.println();
		System.out.print("La Cola UNO es la siguiente: ");
		System.out.println();
		mostrarCola(cola1);
		System.out.println();
		eliminarRepetidos(cola1);
		System.out.println();
		System.out.println();
		System.out.println("-------------------- *** --------------------");

		System.out.print("=== B) Repartir una Cola C en dos mitades M1 y M2 ===");
		System.out.println();
		ColaTDA cola2 = new ColaPU();
		
		cola2.inicializarCola();
		
		cola2.acolar(23);
		cola2.acolar(56);
		cola2.acolar(23);
		cola2.acolar(28);
		cola2.acolar(12);
		cola2.acolar(23);
		System.out.println();
		mostrarCola(cola2);
		System.out.println();
		separarCola(cola2);
		System.out.println();
		System.out.println();
		System.out.println("-------------------- *** --------------------");
		System.out.print("=== C) Generar el conjunto de elementos que se repiten en una Cola ===");
		System.out.println();
		
		ColaTDA cola3 = new ColaPU();
		
		cola3.inicializarCola();
		
		cola3.acolar(23);
		cola3.acolar(23);
		cola3.acolar(28);
		cola3.acolar(12);
		cola3.acolar(12);
		cola3.acolar(24);
		System.out.println();
		mostrarCola(cola3);
		System.out.println();
		conjuntoRepetidos(cola3);
		
		
	}
	
	public static void mostrarCola(ColaTDA c1) {
		
		ColaTDA cMos = copiarCola(c1);
		
		System.out.print("[");
		while(!cMos.colaVacia()) {
			System.out.print(cMos.primero());
			cMos.desacolar();
			if(!cMos.colaVacia()) {
				System.out.print(" - ");
			}
		}
		System.out.print("]");
		
	}
	
	public static ColaTDA copiarCola(ColaTDA cTC) {
		ColaTDA colaDes = new ColaPU();
		ColaTDA colaAux = new ColaPU();
		
		colaDes.inicializarCola();
		colaAux.inicializarCola();
		
		while(!cTC.colaVacia()) {
			colaDes.acolar(cTC.primero());
			cTC.desacolar();
		}
		
		while(!colaDes.colaVacia()) {
			cTC.acolar(colaDes.primero());
			colaAux.acolar(colaDes.primero());
			colaDes.desacolar();
		}
		
		return colaAux;		
	}
	
	public static void eliminarRepetidos (ColaTDA c1) {
		
		ColaTDA colaRep = new ColaPU();
		ConjuntoTDA conjRep = new ConjuntoTA();
		
		colaRep.inicializarCola();
		conjRep.inicializarConjunto();
		
		while(!c1.colaVacia()) {
			int aux = c1.primero();
			if(!conjRep.pertenece(aux)) {
				conjRep.agregar(aux);
				colaRep.acolar(aux);
			}
			c1.desacolar();
		}
		
		while(!colaRep.colaVacia()) {
			c1.acolar(colaRep.primero());
			colaRep.desacolar();
		}
		
		mostrarCola(c1);
		
	}

	public static void separarCola(ColaTDA c2) {
		
		int cSep = contarElementos(c2); 
	
		ColaTDA M1 = new ColaPU();
		ColaTDA M2 = new ColaPU();
		
		M1.inicializarCola();
		M2.inicializarCola();
		
		for(int i=0;i<cSep/2;i++) {
			M1.acolar(c2.primero());
			c2.desacolar();
		}
		
		while(!c2.colaVacia()) {
			M2.acolar(c2.primero());
			c2.desacolar();
		}
		
		mostrarCola(M1);
		System.out.println();
		mostrarCola(M2);
		
		
	}
	
	public static int contarElementos(ColaTDA c2) {
		
		ColaTDA colaAux2 = new ColaPU();
		
		colaAux2.inicializarCola();
		
		int cant=0;
		
		while(!c2.colaVacia()) {
			colaAux2.acolar(c2.primero());
			cant++;
			c2.desacolar();
		}
		
		while(!colaAux2.colaVacia()) {
			c2.acolar(colaAux2.primero());
			colaAux2.desacolar();
		}
		
		return cant;
		
	}

	public static void	conjuntoRepetidos(ColaTDA c3) {
		ColaTDA colaRep2 = new ColaPU();
		ConjuntoTDA conjRepAux = new ConjuntoTA();
		ConjuntoTDA conjRepDes = new ConjuntoTA();
		
		colaRep2.inicializarCola();
		conjRepAux.inicializarConjunto();
		conjRepDes.inicializarConjunto();
		
		while(!c3.colaVacia()) {
			int aux3 = c3.primero();
			if(!conjRepAux.pertenece(aux3)) {
				conjRepAux.agregar(aux3);
			}else{
				colaRep2.acolar(aux3);
			}
			c3.desacolar();
		};
	
		mostrarCola(colaRep2);
		
	};
	
}
