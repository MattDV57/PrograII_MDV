package impl;

import api.PilaTDA;

public class Pila implements PilaTDA{
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
	
	public void ApilarReverse(int x) {
		indice++;
		
		for (int i =0; i < indice;i++) {
			arreglo[i]=arreglo[i+1];
			//arreglo[indice] = x;
		}
		arreglo[0]=x;
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
