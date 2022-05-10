package main;

import api.ColaTDA;
import api.PilaTDA;
import impl.Cola;
import impl.Pila;

public class main {

	public static void main(String[] args) {
		ColaTDA c = new Cola();
		ColaTDA cola2 = new Cola();
		ColaTDA colaCapi = new Cola();
		ColaTDA colaUlt = new Cola();
		ColaTDA colaUlt2 = new Cola();
		
		c.InicializarCola();
		cola2.InicializarCola();
		colaCapi.InicializarCola();
		colaUlt.InicializarCola();
		colaUlt2.InicializarCola();
		
		c.Acolar(9);
		c.Acolar(3);
		c.Acolar(1);
		c.Acolar(5);
		c.Acolar(0);
		
		cola2.Acolar(89);
		cola2.Acolar(34);
		cola2.Acolar(2);
		cola2.Acolar(3);
		cola2.Acolar(9);
		
		colaCapi.Acolar(1);
		colaCapi.Acolar(2);
		colaCapi.Acolar(3);
		colaCapi.Acolar(2);
		colaCapi.Acolar(1);
		
		colaUlt.Acolar(1);
		colaUlt.Acolar(3);
		colaUlt.Acolar(5);
		colaUlt.Acolar(7);
		colaUlt.Acolar(9);
		colaUlt.Acolar(120);
		
		colaUlt2.Acolar(120);
		colaUlt2.Acolar(9);
		colaUlt2.Acolar(7);
		colaUlt2.Acolar(35);
		colaUlt2.Acolar(3);
		colaUlt2.Acolar(1);
		
		
		
		System.out.println("La Cola 1 y 2  son las siguientes:");
		mostrarCola(c);
		mostrarCola(cola2);
		System.out.println("La Cola copiada es la siguiente:");
		copiarColaTDA2(c);
		System.out.println("Las Colas Invertidas c/Pila son las siguientes:");
		invertirCola(c);
		invertirCola(cola2);
		System.out.println("La Cola Invertida s/Pila es la siguiente:");
		System.out.print ("[");
		recursivCola(c);
		System.out.println ("]");
		chequearFinalColas(c,cola2);
		colaCapicua(colaCapi);
		System.out.println("Punto F:");
		esLaInversa(colaUlt, colaUlt2);
		
		
		
	}
	public static ColaTDA copiarColaTDA (ColaTDA original) {
		ColaTDA aux = new Cola();
		ColaTDA copia = new Cola();
		
		aux.InicializarCola();
		copia.InicializarCola();
		
		while(!original.ColaVacia()) {
			aux.Acolar(original.Primero());
			original.Desacolar();
		}
		
		while(!aux.ColaVacia()) {
			original.Acolar(aux.Primero());
			copia.Acolar(aux.Primero());
			aux.Desacolar();
		}
		
		return copia;
	}
	
	public static ColaTDA copiarColaTDA2 (ColaTDA original) {
		ColaTDA aux2 = new Cola();
		ColaTDA copia2 = new Cola();
		
		aux2.InicializarCola();
		copia2.InicializarCola();
		
		while(!original.ColaVacia()) {
			aux2.Acolar(original.Primero());
			original.Desacolar();
		}
		
		System.out.print("[");
		
		while(!aux2.ColaVacia()) {
			System.out.print(aux2.Primero());
			original.Acolar(aux2.Primero());
			copia2.Acolar(aux2.Primero());
			aux2.Desacolar();
			
			if(!aux2.ColaVacia()) {
				System.out.print(",");
			}
							
		}
		System.out.println("]");	
		return copia2;
	}
	
	public static void mostrarCola(ColaTDA x) {
		ColaTDA copia = copiarColaTDA(x);
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
	
	public static void invertirCola (ColaTDA x) {
		ColaTDA copia3 = copiarColaTDA(x);
		PilaTDA pilaaux = new Pila();
		
		//copia3.InicializarCola();
		pilaaux.InicializarPila();
		
		while(!copia3.ColaVacia()) {
			pilaaux.Apilar(copia3.Primero());
			copia3.Desacolar();
		}
		System.out.print("[");
		while (!pilaaux.PilaVacia()) {
			System.out.print(pilaaux.Tope());
			pilaaux.Desapilar();
			if(!pilaaux.PilaVacia()) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
	
	public static void recursivCola(ColaTDA x) {
		ColaTDA copia4 = copiarColaTDA(x);
		int aux =0;
		
		if (!copia4.ColaVacia()){
			aux= copia4.Primero();
			copia4.Desacolar();
			recursivCola(copia4);
			
		}
		else {
			return;
		}
		System.out.print (aux + ",");
	}
	
	public static void chequearFinalColas(ColaTDA x, ColaTDA x2) {
		ColaTDA copia5 = copiarColaTDA(x);
		ColaTDA copia6 = copiarColaTDA(x2);
		
		PilaTDA pilaaux2 = new Pila();
		PilaTDA pilaaux3 = new Pila();
		
		pilaaux2.InicializarPila();
		pilaaux3.InicializarPila();
		
		while(!copia5.ColaVacia()) {
			pilaaux2.Apilar(copia5.Primero());
			copia5.Desacolar();
		}
		
		while(!copia6.ColaVacia()) {
			pilaaux3.Apilar(copia6.Primero());
			copia6.Desacolar();
		}
		
		System.out.print(pilaaux2.Tope()+ " - ");
		System.out.println(pilaaux3.Tope());
		if(pilaaux2.Tope() == pilaaux3.Tope()) {
			System.out.println("El final de las colas SON iguales");
		}
		else {System.out.println("El final de las colas NO Son iguales");}
		
		
	}

	public static void colaCapicua(ColaTDA x) {
		ColaTDA copia7 = copiarColaTDA(x);
		ColaTDA copia8 = copiarColaTDA(x);
		PilaTDA pilaaux4 = new Pila();
		
		int flag=0;
		
		pilaaux4.InicializarPila();
		
		while(!copia7.ColaVacia()) {
			pilaaux4.Apilar(copia7.Primero());
			copia7.Desacolar();
		}
		
		while (!copia8.ColaVacia() && !pilaaux4.PilaVacia()) {
			if (copia8.Primero()==pilaaux4.Tope()) {
				copia8.Desacolar();
				pilaaux4.Desapilar();
			}else {
				flag=1;
				break;
			}
			
		}
		if (flag==0) {
			System.out.print("la cola es capicua");
		}else {
			System.out.print("la cola NO es capicua");
		}
			
	
		
	}

	public static void esLaInversa(ColaTDA colaUno, ColaTDA colaDos) {
		
		ColaTDA primeracolaaux = copiarColaTDA(colaUno);
		ColaTDA ultimacolaaux = copiarColaTDA(colaDos);
		
		PilaTDA ultimaPilaAux = new Pila();
		
		ultimaPilaAux.InicializarPila();
		
		int superflag = 0;
		
		while (!ultimacolaaux.ColaVacia()) {
			ultimaPilaAux.Apilar(ultimacolaaux.Primero());
			ultimacolaaux.Desacolar();
		}
		
		while (!primeracolaaux.ColaVacia() && !ultimaPilaAux.PilaVacia()) {
			if (primeracolaaux.Primero() == ultimaPilaAux.Tope()) {
				primeracolaaux.Desacolar();
				ultimaPilaAux.Desapilar();
			}
			else {
				superflag = 1;
				break;
			}
		}
		
		if (superflag==0) {
			System.out.print("La Cola C1 ES la inversa de la Cola C2");
		}
		else {
			System.out.print("La Cola C1 NO es la inversa de la Cola C2");
		}
		
	}
}
