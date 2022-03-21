package impl;

import api.PilaTDAI;

public class Pila implements PilaTDAI{
	int[] arreglo;
	int indice;

	public void InicializarPila() {
		arreglo = new int[100];
		indice = 0;
	}
	
	public void Apilar(int x) {
		arreglo[indice] = x;
		indice++;
	}
	
	public void Desapilar() {
		indice--;
	}
	
	public int Tope() {
		return arreglo[indice-1];
	}
	
	public boolean PilaVacia() {
		return (indice == 0);
	}
	
}
