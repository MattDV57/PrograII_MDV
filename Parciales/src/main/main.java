package main;

import api.PilaTDA;
import api.ColaTDA;
import api.DiccionarioSimpleTDA;
import api.ConjuntosTDA;
import impl.Cola;
import impl.Pila;
import main.main.Nodo;
import impl.ConjuntoTA;
import impl.DicSimpleA;
import impl.ConjuntoLD;

public class main {

	static class Nodo {
		
		int valor;
		Nodo sig;
	}
	public static void main(String[] args) {
		ColaTDA c = new Cola();
		c.InicializarCola();
		
		c.Acolar(1);
		c.Acolar(2);
		c.Acolar(2);
		c.Acolar(2);
		c.Acolar(3);
		c.Acolar(1);
		c.Acolar(3);
		c.Acolar(5);
		c.Acolar(3);
		c.Acolar(3);
		c.Acolar(2);
		
		mostrarCola(c);
		eliminarConsecutivas(c);
		
		DiccionarioSimpleTDA d1 = new DicSimpleA();
		DiccionarioSimpleTDA d2 = new DicSimpleA();
		
		d1.InicializarDiccionario();
		d2.InicializarDiccionario();
		
		d1.Agregar(3, 3);
		d1.Agregar(2, 8);
		d1.Agregar(4, 7);
		
		d2.Agregar(3, 3);
		d2.Agregar(1, 5);
		d2.Agregar(7, 9);
		d2.Agregar(2, 9);
		
		
		System.out.println(" ");
		System.out.println(" ");
		combinarAmbos(d1,d2);
		
		Nodo Inicio = null;
		
		Inicio = agregarNodos(Inicio,1);
		Inicio = agregarNodos(Inicio,3);
		Inicio = agregarNodos(Inicio,3);
		Inicio = agregarNodos(Inicio,1);
		Inicio = agregarNodos(Inicio,5);
		Inicio = agregarNodos(Inicio,7);
		Inicio = agregarNodos(Inicio,7);
		Inicio = agregarNodos(Inicio,3);
		System.out.println(" ");
		System.out.println(" ");
		mostrarListaEnlazada(Inicio);

		reducirListaEnlazada(Inicio);
	}

	public static void mostrarCola(ColaTDA x) {
		ColaTDA copia = copiarCola(x);

		System.out.print("[");
		while(!copia.ColaVacia()) {
			System.out.print(copia.Primero());
			copia.Desacolar();
			if(!copia.ColaVacia()) {
				System.out.print(",");
			}
					
		}
		System.out.println("]");
	}
		
	public static ColaTDA copiarCola(ColaTDA cola) {
		ColaTDA aux = new Cola();
		ColaTDA destino = new Cola();
		
		aux.InicializarCola();
		destino.InicializarCola();
		
		while(!cola.ColaVacia()) {
			destino.Acolar(cola.Primero());
			cola.Desacolar();
		}
		
		while(!destino.ColaVacia()) {
			cola.Acolar(destino.Primero());
			aux.Acolar(destino.Primero());
			destino.Desacolar();
			
		}
		
		return aux;
		
	}
	
	public static void eliminarConsecutivas(ColaTDA principal) {
		
		ColaTDA ultima = copiarCola(principal);
		PilaTDA sinRep = new Pila();
		PilaTDA sinRepeticiones = new Pila();
		
		sinRep.InicializarPila();
		sinRepeticiones.InicializarPila();
		
		sinRep.Apilar(ultima.Primero());
		ultima.Desacolar();
		
		while (!ultima.ColaVacia()) {
			
			if (ultima.Primero()!=sinRep.Tope()) {
				sinRep.Apilar(ultima.Primero());
				//ultima.Desacolar();
			}
		
			ultima.Desacolar();

		}
		
		while(!sinRep.PilaVacia()) {
			sinRepeticiones.Apilar(sinRep.Tope());
			sinRep.Desapilar();
		}
		
		System.out.print("[");
		
		while (!sinRepeticiones.PilaVacia()) {
			System.out.print(sinRepeticiones.Tope());
			sinRepeticiones.Desapilar();
			if(!sinRepeticiones.PilaVacia()) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
	
	public static void combinarAmbos(DiccionarioSimpleTDA duno, DiccionarioSimpleTDA ddos) {
		
		ConjuntosTDA conjuno = duno.Claves();
		ConjuntosTDA condos = ddos.Claves();
		
		DiccionarioSimpleTDA dicFinal = new DicSimpleA();
		
		dicFinal.InicializarDiccionario();
		
		int v1;
		int v2;
		
		while(!conjuno.ConjuntoVacio()) {
			v1 = conjuno.Elegir();
			conjuno.Sacar(v1);
			
			if(condos.Pertenece(v1)) {
				if (ddos.Recuperar(v1) < duno.Recuperar(v1)) {
					dicFinal.Agregar(v1, ddos.Recuperar(v1));
				}else {
					dicFinal.Agregar(v1, duno.Recuperar(v1));
				}
			}else {
				dicFinal.Agregar(v1, duno.Recuperar(v1));
			}

		}
		
		while(!condos.ConjuntoVacio()) {
			v2 = condos.Elegir();
			condos.Sacar(v2);
			
			if(!conjuno.Pertenece(v2)) {
				dicFinal.Agregar(v2, ddos.Recuperar(v2));
		
			}
		
		}
		
		ConjuntosTDA conjFinal = dicFinal.Claves();
		
		int cf;
		System.out.print("[" );
		while(!conjFinal.ConjuntoVacio()) {
			cf = conjFinal.Elegir();
			conjFinal.Sacar(cf);
			System.out.print(cf + "-" + dicFinal.Recuperar(cf));
			if(!conjFinal.ConjuntoVacio()) {
				System.out.print(", " );
			}
		}
		
		System.out.print("]" );
		
		
		return;
		
	}
	
	public static Nodo agregarNodos(Nodo L, int x) {
		
		Nodo nuevo = new Nodo();
		
		nuevo.sig=null;
		nuevo.valor=x;
		
		if(L==null) {
			
			return nuevo;
		
		}else {
		
			Nodo viajero = L;
			
			while(viajero.sig!=null) {
			
				viajero = viajero.sig;
				
			}
			viajero.sig=nuevo;
			return L;
		}
	}
		
	public static void mostrarListaEnlazada(Nodo A) {
		Nodo viajero=A;
		System.out.print("[");
		
		while(viajero!=null) {
			System.out.print(viajero.valor);
			viajero = viajero.sig;
			
			if(viajero!= null) {
				System.out.print(" , ");
				
			}
					
		}
		System.out.println("]");
		System.out.println("");
	}
	
	public static void reducirListaEnlazada(Nodo listx) {
		Nodo viajero2 = listx;
		Nodo ultimo = new Nodo();
		
		ConjuntosTDA conjuntos = new ConjuntoTA();
		
		conjuntos.InicializarConjunto();
		
		System.out.print("[");
		
		while(viajero2!=null) {
			if (!conjuntos.Pertenece(viajero2.valor)){
				conjuntos.Agregar(viajero2.valor);
				ultimo.valor = viajero2.valor;
				ultimo = viajero2;
				System.out.print(viajero2.valor);
				
			}
			
			viajero2 = viajero2.sig;
			
			
			
		}
		
		System.out.print("]");
		return;
		
	}
	
}
		
		
	
	