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
	//	combinarAmbos(d1,d2);

		Nodo x1 = new Nodo();
		Nodo x2 = new Nodo();
		Nodo x3 = new Nodo();
		Nodo x4 = new Nodo();
		Nodo x5 = new Nodo();
		Nodo x6 = new Nodo();
		Nodo x7 = new Nodo();
		Nodo x8 = new Nodo();
		
		x1.valor = 1;
		x2.valor = 3;
		x3.valor = 3;
		x4.valor = 1;
		x5.valor = 5;
		x6.valor = 7;
		x7.valor = 7;
		x8.valor = 3;
		
		x1.sig = x2;
		x2.sig = x3;
		x3.sig = x4;
		x4.sig = x5;
		x5.sig = x6;
		x6.sig = x7;
		x7.sig = x8;
		x8.sig = null;
		
		mostrarListaEnlazada(x1);
		reducirListaEnlazada(x1);
		
		
				
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
			System.out.print(sinRepeticiones.Tope() + ",");
			sinRepeticiones.Desapilar();
		}
		System.out.print("]");
	}
	
	public static void combinarAmbos(DiccionarioSimpleTDA duno, DiccionarioSimpleTDA ddos) {
		ConjuntosTDA conjuno = duno.Claves();
		ConjuntosTDA condos = ddos.Claves();
		
		DiccionarioSimpleTDA dicFinal = new DicSimpleA();
		
		dicFinal.InicializarDiccionario();
		
		while (!conjuno.ConjuntoVacio()&&!condos.ConjuntoVacio()) {
			int keyuno = conjuno.Elegir();
			int keydos = condos.Elegir();
			
			if (keyuno!=keydos) {
				dicFinal.Agregar(duno.Recuperar(keyuno), keyuno);
				System.out.print(ddos.Recuperar(keyuno) + keyuno);
				dicFinal.Agregar(ddos.Recuperar(keydos), keydos);
				System.out.print(ddos.Recuperar(keydos) + keydos);
			}
			
			else {
				if (duno.Recuperar(keyuno) > ddos.Recuperar(keydos)) {
					dicFinal.Agregar(ddos.Recuperar(keydos), keydos);
					System.out.print(ddos.Recuperar(keydos) + keydos);
				}
				else {
					dicFinal.Agregar(duno.Recuperar(keyuno), keyuno);
					System.out.print(ddos.Recuperar(keyuno) + keyuno);
				}
			}
			
			conjuno.Sacar(keyuno);
			condos.Sacar(keydos);
			
		}
		
		ConjuntosTDA confinal = dicFinal.Claves();
		
	
		while(!confinal.ConjuntoVacio()) {
			int keyfinal = confinal.Elegir();
			System.out.print(dicFinal.Recuperar(keyfinal));
			confinal.Sacar(keyfinal);
		
		}
		

		
		return;
		
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
		
		
	
	