package main;

import api.ConjuntoTDA;
import api.RegistroTDA;
import impl.Registro;

public class main {
	
	static class Nodo{
		int info;
		Nodo sig;
	}
	public static void main(String[] args) {
		
		RegistroTDA U = new Registro();
		RegistroTDA V = new Registro();
		
		Nodo A = null;
		
		A=agregarNodo(A,1);
		A=agregarNodo(A,2);
		A=agregarNodo(A,3);
		A=agregarNodo(A,4);
		A=agregarNodo(A,2);
		A=agregarNodo(A,5);
		A=agregarNodo(A,7);
		A=agregarNodo(A,4);
		
		mostrarLista(A);
		System.out.println(" ");
		System.out.println(" ");
		
		Nodo Q = ListarUnicos(A);
		
		mostrarLista(Q);
		System.out.println(" ");
		
		U.InicializarRegistro();
		V.InicializarRegistro();
		
		System.out.println(" ");
		
		U.Contar(1);
		U.Contar(2);
		U.Contar(3);
		U.Contar(2);
		U.Contar(2);
		U.Contar(1);
		
		V.Contar(1);
		V.Contar(1);
		V.Contar(1);
		V.Contar(1);
		V.Contar(1);
		V.Contar(3);
		V.Contar(3);
		V.Contar(5);
		V.Contar(5);
		V.Contar(5);
		
		mostrarRegistro(U);
		
		//U.Descontar(2);
		
		mostrarRegistro(V);
		
		RegistroTDA Com = Combinar(U,V);

		mostrarRegistro(Com);
	
	}
	
	//Orden Cuadratico
	public static void mostrarRegistro(RegistroTDA A) {
		ConjuntoTDA V = A.Valores(); //O(n2)
		int x;
		int c;
		while(!V.ConjuntoVacio()) {
			x=V.Elegir();
			V.Sacar(x);
			c= A.Chequear(x);
			System.out.print(x + " (" + c + ")");
			if(!V.ConjuntoVacio()) {
				System.out.print(" , ");
			}
		}
		System.out.println(" ");
	}
	
	//Orden Cuadratico
	public static RegistroTDA Combinar(RegistroTDA A,RegistroTDA B) {
		RegistroTDA C = new Registro();
		
		C.InicializarRegistro();
		
		ConjuntoTDA ValA = A.Valores(); //O(n2)
		ConjuntoTDA ValB = B.Valores(); //O(n2)
		
		int x;
		int c;
		
		while(!ValA.ConjuntoVacio()){ //O(n)
			x= ValA.Elegir();
			ValA.Sacar(x);
			c = A.Chequear(x);
			
			for(int i =0;i<c;i++) {
				C.Contar(x);
			}
			
		}
		
		while(!ValB.ConjuntoVacio()){
			x= ValB.Elegir();
			ValB.Sacar(x);
			c = B.Chequear(x);
			
			for(int i =0;i<c;i++) {
				C.Contar(x);
			}
			
		}
		
		return C;
		
	}
	
	//Metodo Auxiliar para agregar al final ejercicio 3
	public static Nodo agregarNodo(Nodo L, int x) {
		Nodo nuevo = new Nodo();
		
		nuevo.info = x;
		nuevo.sig = null;
		
		if (L==null) {
			return nuevo;
		}else {
			Nodo aux = L;
			while(aux.sig != null) {
				aux = aux.sig;
			}
			aux.sig = nuevo;
			return L;}
		}
	
	//Otro metodo Auxiliar para mostrar listas
	public static void mostrarLista(Nodo x) {
			System.out.print("[");
			Nodo aux=x;
			while(aux!= null) {
				System.out.print(aux.info);
				aux=aux.sig;
				if(aux!=null) {
					System.out.print(", ");
				}
				
			
		}
			System.out.print("]");
	}

	public static Nodo ListarUnicos(Nodo A) {
		//Primero colocamos los elementos de A en un registro
		Nodo aux = A;
		
		RegistroTDA R = new Registro();
		
		R.InicializarRegistro();
		
		while(aux!=null) {
			R.Contar(aux.info);
			aux = aux.sig;
		}
		
		Nodo nuevo = null;
		
		aux = A;
		
		while(aux !=null) {
			if(R.Chequear(aux.info)==1) {
				nuevo = agregarNodo(nuevo,aux.info);
			}
			
			aux=aux.sig;
		}
		
		return nuevo;
		
	}
}
