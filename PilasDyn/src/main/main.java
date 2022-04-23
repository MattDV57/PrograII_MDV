package main;

import api.PilaTDA;
import impl.PilaLD;

public class main {

	public static void main(String[] args) {	
		PilaTDA stack = new PilaLD();
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
			
		}
		
		public static void mostrarPila (PilaTDA X) {
			PilaTDA copia = copiarPila(X);
			
			while(!copia.PilaVacia()) {
				System.out.print(copia.Tope()+ " ");
				copia.Desapilar();
			}
			
			System.out.println(" ");
		}
		
		public static PilaTDA copiarPila(PilaTDA origen) {
			PilaTDA destino = new PilaLD();
			PilaTDA aux = new PilaLD();
			
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


