package main;

import apis.PilaTDA;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import impl.PilaTF;
import impl.ColaPI;
import impl.ConjuntoTA;


import java.lang.reflect.ClassFileFormatVersion;

public class PilaTDA_9 {

	public static void main(String[] args) {
		
		PilaTDA pila1 = new PilaTF();
		PilaTDA pila2 = new PilaTF();
		
		pila1.inicializarPila();
		pila2.inicializarPila();
		
		pila1.apilar(2);
		pila1.apilar(3);
		pila1.apilar(6);
		pila1.apilar(4);
		pila1.apilar(2);
		
		pila2.apilar(2);
		pila2.apilar(3);
		pila2.apilar(6);
		pila2.apilar(3);
		pila2.apilar(2);
		System.out.println();
		System.out.print("=== A) Comprobar si una Pila es capicúa ===");
		System.out.println();
		System.out.print("La Pila UNO es la siguiente: ");
		imprimirPila(pila1);
		chequearCapicua(pila1);
		System.out.println();
		System.out.println();
		System.out.print("La Pila DOS es la siguiente: ");
		imprimirPila(pila2);
		chequearCapicua(pila2);
		System.out.println();
		System.out.println();
		System.out.println("-------------------- *** --------------------");
		
		PilaTDA pila3 = new PilaTF();
		
		pila3.inicializarPila();
		
		pila3.apilar(2);
		pila3.apilar(3);
		pila3.apilar(3);
		pila3.apilar(4);
		pila3.apilar(2);
		pila3.apilar(5);
		pila3.apilar(5);
		System.out.println();
		System.out.print("=== B) Eliminar de una Pila P las repeticiones de elementos ===");
		System.out.println();
		System.out.print("La Pila CON repetidos es la siguiente: ");
		imprimirPila(pila3);
		PilaTDA pila4 = eliminarDuplicados(pila3);
		System.out.println();
		System.out.print("La Pila SIN repetidos es la siguiente: ");
		imprimirPila(pila4);
		System.out.println();
		System.out.println();
		System.out.println("-------------------- *** --------------------");
		System.out.println();
		System.out.print("=== C) Repartir una Pila P en dos mitades ===");
		System.out.println();

		PilaTDA pila5 = new PilaTF();
		
		pila5.inicializarPila();
		
		pila5.apilar(12);
		pila5.apilar(35);
		pila5.apilar(32);
		pila5.apilar(46);
		pila5.apilar(22);
		pila5.apilar(26);
		pila5.apilar(53);
		pila5.apilar(6);
		
		System.out.print("La Pila CINCO es la siguiente: ");
		imprimirPila(pila5);
		System.out.println();
		System.out.println();
		repartirPila(pila5);
		System.out.println();
		System.out.println();
		System.out.println("-------------------- *** --------------------");
		System.out.println();
		System.out.print("=== D) Conjunto de elementos que se repiten en una Pila ===");
		System.out.println();
		
		PilaTDA pila6 = new PilaTF();
		
		pila6.inicializarPila();
		
		pila6.apilar(7);
		pila6.apilar(35);
		pila6.apilar(7);
		pila6.apilar(7);
		pila6.apilar(5);
		pila6.apilar(26);
		pila6.apilar(5);
		pila6.apilar(6);
		System.out.print("La Pila SEIS es la siguiente: ");
		imprimirPila(pila6);
		System.out.println();
		System.out.print("El conjunto de elementos repetidos es: ");
		repetidosPila(pila6);
		System.out.println();
		System.out.println();
		System.out.println("-------------------- *** --------------------");
		
	}
	
	public static void imprimirPila(PilaTDA pImp) {
		PilaTDA pilaImp = copiarPila(pImp);
		
		System.out.print("[");
		while(!pilaImp.pilaVacia()) {
			System.out.print(pilaImp.tope());
			pilaImp.desapilar();
			if(!pilaImp.pilaVacia()) {
				System.out.print(" - ");
			}
		}
		
		System.out.print("]");
	
	}
	
	public static PilaTDA copiarPila(PilaTDA pCop) {
		
		PilaTDA pilaAux = new PilaTF();
		PilaTDA pilaDes = new PilaTF();
		
		pilaAux.inicializarPila();
		pilaDes.inicializarPila();
		
		while(!pCop.pilaVacia()) {
			pilaAux.apilar(pCop.tope());
			pCop.desapilar();
		}
		
		while(!pilaAux.pilaVacia()) {
			pCop.apilar(pilaAux.tope());
			pilaDes.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}
		
		return pilaDes;
		
	}
	
	public static void chequearCapicua(PilaTDA pCap) {
		PilaTDA pilaCap = copiarPila(pCap);
		PilaTDA pilaCapDes = new PilaTF();
		
		pilaCapDes.inicializarPila();
		
		int cantPila = contarElementos(pilaCap);
		boolean flag=false;
		while(!pilaCap.pilaVacia()) {
			pilaCapDes.apilar(pilaCap.tope());
			pilaCap.desapilar();
		}
		
		for(int i=0;i<cantPila/2;i++) {
			if(pCap.tope()!=pilaCapDes.tope()) {
				flag=false;
			}else {
				pCap.desapilar();
				pilaCapDes.desapilar();
				flag=true;
			}
		}
		System.out.println();
		if(flag==true) {
			System.out.print("La pila ES es capicua");
		}else {System.out.print("La pila NO ES es capicua");
		}
		
		
	}
	
	public static int contarElementos(PilaTDA pCont) {
		PilaTDA pilaCont = new PilaTF();
		
		pilaCont.inicializarPila();
		
		int cant=0;
		
		while(!pCont.pilaVacia()) {
			pilaCont.apilar(pCont.tope());
			cant++;
			pCont.desapilar();
		}
		
		while(!pilaCont.pilaVacia()) {
			pCont.apilar(pilaCont.tope());
			pilaCont.desapilar();
		}
		
		return cant;
		
	}

	public static PilaTDA eliminarDuplicados(PilaTDA pDup) {
		
		ConjuntoTDA conjuntoAux = new ConjuntoTA();
		PilaTDA pilaAux = new PilaTF();
		
		conjuntoAux.inicializarConjunto();
		pilaAux.inicializarPila();
		
		while(!pDup.pilaVacia()) {
			if(!conjuntoAux.pertenece(pDup.tope())){
				conjuntoAux.agregar(pDup.tope());
				pilaAux.apilar(pDup.tope());
				
			}
			pDup.desapilar();
		}
		
		while(!pilaAux.pilaVacia()) {
			pDup.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}
		
		return pDup;
		
	}

	public static void repartirPila(PilaTDA pRep) {
		
		PilaTDA pRepAux = copiarPila(pRep);
		PilaTDA pRepAux2 = copiarPila(pRep);
		
		PilaTDA cRepAux  = new PilaTF();
		ColaTDA M1  = new ColaPI();
		
		PilaTDA M2  = new PilaTF();
		
		int cant = contarElementos(pRepAux);
		
		M1.inicializarCola();
		M2.inicializarPila();
		cRepAux.inicializarPila();
		
		while(!pRepAux2.pilaVacia()) {
			cRepAux.apilar(pRepAux2.tope());
			pRepAux2.desapilar();
		}
		
		for(int i=0;i<cant/2;i++) {
			M1.acolar(pRepAux.tope());
			M2.apilar(cRepAux.tope());
			pRepAux.desapilar();
			cRepAux.desapilar();
		}
		
		System.out.print("La Pila M1 es la siguiente: ");
		System.out.print("[");
		while(!M1.colaVacia()) {
			System.out.print(M1.primero());
			M1.desacolar();
			if(!M1.colaVacia()) {
				System.out.print(" - ");
			}
		}
		System.out.print("]");
		System.out.println();
		System.out.print("La Pila M2 es la siguiente: ");
		System.out.print("[");
		while(!M2.pilaVacia()) {
			System.out.print(M2.tope());
			M2.desapilar();
			if(!M2.pilaVacia()) {
				System.out.print(" - ");
			}
		}
		System.out.print("]");
		
		
	}
		
	public static void repetidosPila (PilaTDA pRepe) {
		
		ConjuntoTDA conjuntoAux2 = new ConjuntoTA();
		ConjuntoTDA conjuntoFinal = new ConjuntoTA();
		
		PilaTDA pilaAux2 = new PilaTF();
		
		conjuntoAux2.inicializarConjunto();
		conjuntoFinal.inicializarConjunto();
		pilaAux2.inicializarPila();
		
		while(!pRepe.pilaVacia()) {
			if(!conjuntoAux2.pertenece(pRepe.tope())) {
				conjuntoAux2.agregar(pRepe.tope());
			}else {conjuntoFinal.agregar(pRepe.tope());
			}		pRepe.desapilar();
		
		}
			

			System.out.print("[");
			while(!conjuntoFinal.conjuntoVacio()){
				int x = conjuntoFinal.elegir();
				System.out.print(x);
				conjuntoFinal.sacar(x);
				if(!conjuntoFinal.conjuntoVacio()) {
					System.out.print(" - ");
				}
			}
			System.out.print("]");
	
		
		
	
	}
}