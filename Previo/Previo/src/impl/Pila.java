package impl;

import api.PilaTDA;

public class Pila implements PilaTDA {
	
	int [] arreglo;
	int indice;
		
	@Override
	public void Apilar(int x) {
		arreglo[indice]=x;
		indice++;
	}

	@Override
	public void Desapilar() {
		indice--;
	}

	@Override
	public void InicializarPila() {
		indice = 0;
		arreglo = new int [6];
		
	}

	@Override
	public int Tope() {
		return arreglo[indice-1];
	}

	@Override
	public boolean PilaVacia() {
		return (indice==0);
	}

}
