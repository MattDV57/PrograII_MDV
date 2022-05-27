package main;

import api.ObjetosTDA;
import impl.Objetos;

public class main {

	public static void main(String[] args) {
		ObjetosTDA pila = new Objetos();
		ObjetosTDA cola = new Objetos();
		
		pila.InicializarPila();
		cola.InicializarCola();
		
		pila.Apilar(1);
		pila.Apilar(3);
		pila.Apilar(5);
		pila.Apilar(7);
		pila.Apilar(9);
		pila.Apilar(11);
		
		cola.Acolar(2);
		cola.Acolar(4);
		cola.Acolar(6);
		cola.Acolar(8);
		cola.Acolar(10);
		
		System.out.println("Pila");
		mostrarPila(pila);
		System.out.println("");
		System.out.println("Cola");
		mostrarCola(cola);
		
	}
	
	public static void mostrarPila(ObjetosTDA P) {
		ObjetosTDA coPila = copiarPila(P);
		
		System.out.print("[");
		
		while(!coPila.PilaVacia()) {
			System.out.print(coPila.Tope());
			coPila.Desapilar();
			if(!coPila.PilaVacia()) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
	
	public static ObjetosTDA copiarPila (ObjetosTDA PC) {
		ObjetosTDA destino = new Objetos();
		ObjetosTDA aux = new Objetos();
		
		destino.InicializarPila();
		aux.InicializarPila();
		
		while(!PC.PilaVacia()) {
			aux.Apilar(PC.Tope());
			PC.Desapilar();
		}
		
		while(!aux.PilaVacia()) {
			PC.Apilar(aux.Tope());
			destino.Apilar(aux.Tope());
			aux.Desapilar();
		}
		return destino;
	}
	
	public static void mostrarCola(ObjetosTDA Q) {
		ObjetosTDA coCola = copiarCola(Q);
		System.out.print("[");
		
		while(!Q.ColaVacia()) {
			System.out.print(Q.Primero());
			Q.Desacolar();
			if(!Q.ColaVacia()) {
				System.out.print(",");
			}
				
		}
		System.out.print("]");
		
	}
	
	public static ObjetosTDA copiarCola(ObjetosTDA CC) {
		ObjetosTDA destino2 = new Objetos();
		ObjetosTDA aux2 = new Objetos();
		
		destino2.InicializarCola();
		aux2.InicializarCola();
		
		while(!CC.ColaVacia()) {
			aux2.Acolar(CC.Primero());
			CC.Desacolar();
		}
		
		while(!aux2.ColaVacia()) {
			CC.Acolar(aux2.Primero());
			destino2.Acolar(aux2.Primero());
			aux2.Desacolar();
		}
		
		return destino2;
	}
	

	
}
