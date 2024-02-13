package impl;

import api.PilaTDA;

public class PilaLD implements PilaTDA{

	class Nodo{
		int		valor;
		Nodo	sig;
	}
	
	Nodo primero;
	
	@Override
	public void InicializarPila() {
		primero=null;
	}

	@Override
	public void Apilar(int x) {
		Nodo aux = new Nodo();
		aux.valor=x;
		aux.sig=primero;
		primero=aux;
	}
	
	public void Apilar() {
		System.out.print("Hola");
	}


	@Override
	public void Desapilar() {
		primero=primero.sig;	
	}

	@Override
	public int Tope() {
		return (primero.valor);
	}

	@Override
	public boolean PilaVacia() {
		return (primero==null);
	}

}
