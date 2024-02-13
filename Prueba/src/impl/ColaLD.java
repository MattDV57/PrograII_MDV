package impl;

import api.ColaTDA;

public class ColaLD implements ColaTDA {

	class Nodo{
		int 	valor;
		Nodo 	sig;
	}
	
	Nodo primero;
	Nodo ultimo;
	
	@Override
	public void InicializarCola() {
		primero=null;
		ultimo=null;
		
	}

	@Override
	public void Acolar(int x) {
		Nodo aux = new Nodo();
		aux.valor = x;
		aux.sig = null;
		
		//Si la cola no esta vacia
		if(ultimo!=null) {
			ultimo.sig=null;
			ultimo = aux;
		}
		
		//Si la cola esta vacia
		if(primero==null) {
			primero=ultimo;
		}
		
	}

	@Override
	public void Desacolar() {
		primero = primero.sig;
		
		if(primero==null) {
			ultimo=null;
		}
		
	}

	@Override
	public boolean ColaVacia() {
		return (ultimo==null);
	}

	@Override
	public int Primero() {
		return (primero.valor);
	}

}
