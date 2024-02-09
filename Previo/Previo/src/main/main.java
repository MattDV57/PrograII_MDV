package main;

import api.PilaTDA;
import impl.Pila;

public class main {

	public static void main(String[] args) {
		PilaTDA pilauno = new Pila();
		
		pilauno.InicializarPila();
		
		pilauno.Apilar(34);
		pilauno.Apilar(23);
		pilauno.Apilar(3);
		pilauno.Apilar(6);
		pilauno.Apilar(783);
		
		System.out.println("La Pila original es la siguiente: ");
		imprimirPila(pilauno);
		System.out.println("");
		System.out.println("Ejercicio 2_A: ");
		pasarPila(pilauno);
		System.out.println("");
		System.out.println("");
		System.out.println("Ejercicio 2_D: ");
		contarPila(pilauno);
		
		
	}
	
	public static void imprimirPila(PilaTDA pu) {
		PilaTDA copia = copiarPila(pu);
		
		while(!copia.PilaVacia()) {
			System.out.print(copia.Tope()+" ");
			copia.Desapilar();
			
		}
		System.out.println("");
		
	}
	
	public static PilaTDA copiarPila(PilaTDA puno) {
		PilaTDA pilaaux = new Pila();
		PilaTDA piladestino = new Pila();
	
		pilaaux.InicializarPila();
		piladestino.InicializarPila();
		
		while(!puno.PilaVacia()) {
			pilaaux.Apilar(puno.Tope());
			puno.Desapilar();
		}
		
		while(!pilaaux.PilaVacia()) {
			puno.Apilar(pilaaux.Tope());
			piladestino.Apilar(pilaaux.Tope());
			pilaaux.Desapilar();
		}
		
		return piladestino;
	}

	public static void pasarPila(PilaTDA puno2a) {
		PilaTDA copia2a = copiarPila(puno2a);
		PilaTDA copia2afinal = new Pila();
		
		copia2afinal.InicializarPila();
		
		while(!copia2a.PilaVacia()) {
			copia2afinal.Apilar(copia2a.Tope());
			copia2a.Desapilar();
		}
		
		while(!copia2afinal.PilaVacia()) {
			System.out.print(copia2afinal.Tope()+ " ");
			copia2afinal.Desapilar();
		}
	}

	public static void contarPila(PilaTDA puno2d) {
		PilaTDA copia2d = copiarPila(puno2d);
		
		int cont = 0;
		
		while (!copia2d.PilaVacia()) {
			cont++;
			copia2d.Desapilar();
		}
		
		System.out.print(cont);
	}
}
