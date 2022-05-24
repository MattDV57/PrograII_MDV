package main;

import api.PilaTDA;
import impl.Pila;
import api.ConjuntoTDA;
import impl.ConjuntoTA;

public class main {

	public static void main(String[] args) {
		
		PilaTDA firstStack = new Pila();
		PilaTDA secondStack = new Pila();
		firstStack.InicializarPila();
		secondStack.InicializarPila();
		
		firstStack.Apilar(1);
		firstStack.Apilar(4);
		firstStack.Apilar(2);
		firstStack.Apilar(5);
		firstStack.Apilar(2);
		firstStack.Apilar(2);
		firstStack.Apilar(3);
		firstStack.Apilar(6);
		firstStack.Apilar(6);
		firstStack.Apilar(2);
		
		secondStack.Apilar(2);
		secondStack.Apilar(7);
		secondStack.Apilar(0);
		secondStack.Apilar(7);
		secondStack.Apilar(2);
		
		System.out.println("La pila original es:");		
		mostrarPila(firstStack);
		System.out.println("");	
		System.out.println("------------------------------------");	
	
		chequearPilaCapicua(firstStack);
		chequearPilaCapicua(secondStack);
		
		System.out.println("------------------------------------");	
		
		System.out.println("La pila sin duplicados es:");
		eliminarDuplicados(firstStack);
		
		System.out.println("------------------------------------");	
		
		contarElementos(firstStack);
		separarElementos(firstStack);
		System.out.println("------------------------------------");	
		System.out.println("Los elementos que se repiten en la pila son:");
		chequearConjunto(firstStack);
	}
	
	public static void mostrarPila(PilaTDA original) {
		PilaTDA copia = copiarPila(original);

		System.out.print("[");
		
		while(!copia.PilaVacia()) {
			System.out.print(copia.Tope());
			copia.Desapilar();
			if(!copia.PilaVacia()) {
				System.out.print(", ");
			}
		}
		
		System.out.print("]");
	}

	public static PilaTDA copiarPila(PilaTDA x){
		PilaTDA aux = new Pila();
		PilaTDA destino = new Pila();
		
		aux.InicializarPila();
		destino.InicializarPila();
		
		while(!x.PilaVacia()) {
			aux.Apilar(x.Tope());
			x.Desapilar();
		}
		
		while(!aux.PilaVacia()) {
			x.Apilar(aux.Tope());
			destino.Apilar(aux.Tope());
			aux.Desapilar();
		}
		
		return destino;
	}

	public static void chequearPilaCapicua(PilaTDA capiOriginal) {
		PilaTDA copiaCapiOriginal = copiarPila(capiOriginal);
		PilaTDA copiaCapiOriginalReversa = copiarPila(capiOriginal);
		
		PilaTDA capicuaAux = new Pila();
		
		capicuaAux.InicializarPila();
		
		while(!copiaCapiOriginalReversa.PilaVacia()) {
			capicuaAux.Apilar(copiaCapiOriginalReversa.Tope());
			copiaCapiOriginalReversa.Desapilar();
		}
		
		boolean confirmation = true;
		
		while(!copiaCapiOriginal.PilaVacia() && !capicuaAux.PilaVacia()) {
			if(copiaCapiOriginal.Tope()!=capicuaAux.Tope()) {
				confirmation = false;
				break;
			}else {
				copiaCapiOriginal.Desapilar();
				capicuaAux.Desapilar();
			}
				
		}
		
		if(confirmation) {
			System.out.println("La Pila es Capicua");
		}
		else {
			System.out.println("La Pila NO es capicua");
		}
		
	}

	public static void eliminarDuplicados(PilaTDA duplOriginal) {
		PilaTDA copiaOriginal = copiarPila(duplOriginal);
		PilaTDA aux = new Pila();
			
		aux.InicializarPila();
		
		aux.Apilar(copiaOriginal.Tope());
		
		copiaOriginal.Desapilar();
		
		while(!copiaOriginal.PilaVacia()) {
			if(copiaOriginal.Tope()!=aux.Tope()) {
				aux.Apilar(copiaOriginal.Tope());
				copiaOriginal.Desapilar();
				
			}else {
				copiaOriginal.Desapilar();
			}
		}
		
		while(!aux.PilaVacia()) {
			copiaOriginal.Apilar(aux.Tope());
			aux.Desapilar();
		}
		
		System.out.print("[");
		
		while(!copiaOriginal.PilaVacia()) {
			System.out.print(copiaOriginal.Tope());
			copiaOriginal.Desapilar();
			if(!copiaOriginal.PilaVacia()) {
				System.out.print(", ");
			}
		}
		
		System.out.println("]");
	}

	public static int contarElementos(PilaTDA contOriginal) {
		PilaTDA conteo = copiarPila(contOriginal);
		
		int total=0;
		
		while(!conteo.PilaVacia()) {
			total+=1;
			conteo.Desapilar();
		}
		
		//System.out.println(total);	
		
		return total;
	}
	
	public static void separarElementos(PilaTDA separarOriginal) {
		PilaTDA copSepOriginal = copiarPila(separarOriginal);
		PilaTDA M1 = new Pila();
		PilaTDA M2 = new Pila();
		
		M1.InicializarPila();
		M2.InicializarPila();
		
		int contSep = contarElementos(separarOriginal);
		
		int mitad1 = contSep/2;
		
		int cont = 0;
		int cont2 = 0;
		while(!copSepOriginal.PilaVacia() && cont<mitad1) {
			M1.Apilar(copSepOriginal.Tope());
			copSepOriginal.Desapilar();
			cont+=1;
		}
		
		while(!copSepOriginal.PilaVacia() && cont2<mitad1) {
			M2.Apilar(copSepOriginal.Tope());
			copSepOriginal.Desapilar();
			cont2+=1;
		}
		
		System.out.print("M1 = [");
		
		while(!M1.PilaVacia()) {
			System.out.print(M1.Tope());
			M1.Desapilar();
			if(!M1.PilaVacia()) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.print("M2 = [");
		
		while(!M2.PilaVacia()) {
			System.out.print(M2.Tope());
			M2.Desapilar();
			if(!M2.PilaVacia()) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
	}

	public static void chequearConjunto(PilaTDA contarOriginal) {
		PilaTDA cOriginal = copiarPila(contarOriginal);
		PilaTDA caux = new Pila();
		
		caux.InicializarPila();
		
		ConjuntoTDA conjuntoRep = new ConjuntoTA();
		ConjuntoTDA conjuntoRep2 = new ConjuntoTA();
		
		conjuntoRep.InicializarConjunto();
		conjuntoRep2.InicializarConjunto();
		
		caux.Apilar(cOriginal.Tope());
		conjuntoRep.Agregar(cOriginal.Tope());
		cOriginal.Desapilar();
		
		while(!cOriginal.PilaVacia()) {
			int valor = cOriginal.Tope();
			if(!conjuntoRep.Pertenece(valor)){
				conjuntoRep.Agregar(valor);
				cOriginal.Desapilar();
			}else {
				conjuntoRep2.Agregar(valor);
				cOriginal.Desapilar();
			}			
		}
		System.out.print("[");
		while(!conjuntoRep2.ConjuntoVacio()) {
			int valor2 = conjuntoRep2.Elegir();
			System.out.print(valor2);
			conjuntoRep2.Sacar(valor2);
			if(!conjuntoRep2.ConjuntoVacio() ){
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
			
		}
	}


