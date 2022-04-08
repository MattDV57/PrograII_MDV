package main;

import api.PilaTDA;
import impl.Pila;

public class main {

	public static void main(String[] args) {
		
		PilaTDA stack = new Pila();
		
		stack.InicializarPila();
		
		stack.Apilar(1);
		stack.Apilar(2);
		stack.Apilar(3);
		stack.Apilar(5);
		
		System.out.println("La Pila original es: ");
		mostrarPila(stack);
		
		System.out.println("La Pila invertida es: ");
		invertirPila(stack);
	
		System.out.println("La cantidad de elementos es: ");
		contarElementosPila(stack);
		
		System.out.println("La suma de los elementos es: ");
		sumarElementosPila(stack);
		
		System.out.println("El promedio de los elementos es: ");
		promedioElementos(stack);
		
		
		
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
			PilaTDA destino = new Pila();
			PilaTDA aux = new Pila();
				
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
		
		public static PilaTDA invertirPila(PilaTDA origen2) {
			PilaTDA copia2 = copiarPila(origen2);
			PilaTDA aux2 = new Pila();
			
			aux2.InicializarPila();
			
			while(!copia2.PilaVacia()) {
				aux2.Apilar(copia2.Tope());
				copia2.Desapilar();
				
			}
			
			while(!aux2.PilaVacia()) {
				System.out.print(aux2.Tope() + " ");
				copia2.Apilar(aux2.Tope());
				
				aux2.Desapilar();
				
			}
			System.out.println(" ");			
			return aux2;
		
		}
		
		public static void contarElementosPila (PilaTDA origen3) {
			PilaTDA copia3 = copiarPila(origen3);
			int cont = 0;
			
			while(!copia3.PilaVacia()) {
				cont = cont + 1;
				copia3.Desapilar();
				
			}
			System.out.println(cont);
		}

		public static void sumarElementosPila (PilaTDA origen4) {
			PilaTDA copia4 = copiarPila(origen4);
			int suma = 0;
			
			while(!copia4.PilaVacia()) {
				suma = suma + copia4.Tope();
				copia4.Desapilar();
			}
			
			System.out.println(suma);
		}
		
		public static void promedioElementos(PilaTDA origen5) {
			
			PilaTDA copia5 = copiarPila(origen5);
			
			int cont2 = 0;
			int suma2 = 0;
			double promedio = 0;
			
			while(!copia5.PilaVacia()) {
				suma2 = suma2 + copia5.Tope();
				cont2 = cont2 + 1;
				copia5.Desapilar();
			}
			
			System.out.println((double)suma2/cont2);
			
		}
		
	}

