package main;

import api.PilaTDAI;
import impl.Pila;

public class main {

	public static void main(String[] args) {
		
		PilaTDAI stack = new Pila();
		stack.InicializarPila();
		stack.Apilar(1);
		stack.Apilar(2);
		stack.Apilar(3);
		mostrarPila(stack);
		stack.Apilar(5);
		mostrarPila(stack);
		stack.Desapilar();
		stack.Desapilar();
		mostrarPila(stack);
		
		PilaTDAI stackRev = new Pila();
		stackRev.InicializarPila();
		stackRev.ApilarReverse(1);
		stackRev.ApilarReverse(7);
		stackRev.ApilarReverse(4);
		stackRev.ApilarReverse(2);
		stackRev.ApilarReverse(5);
		stackRev.ApilarReverse(4);
		mostrarPila(stackRev);
		
	}
	
	public static void mostrarPila (PilaTDAI X) {
		PilaTDAI copia = copiarPila(X);
		
		while(!copia.PilaVacia()) {
			System.out.print(copia.Tope()+ " ");
			copia.Desapilar();
		}
		
		System.out.println(" ");
	}
	
	public static PilaTDAI copiarPila(PilaTDAI origen) {
		PilaTDAI destino = new Pila();
		PilaTDAI aux = new Pila();
		
		destino.InicializarPila();
		aux.InicializarPila();
		
		while(!origen.PilaVacia()) {
			aux.Apilar(origen.Tope());
			origen.Desapilar();
		}
		
		while(!aux.PilaVacia()) {
			origen.Apilar(aux.Tope());
			destino.Apilar(aux.Tope());
			aux.Desapilar();
		}
		
		return destino;
	}

}
