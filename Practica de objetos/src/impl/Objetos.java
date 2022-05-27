package impl;

import api.ObjetosTDA;

public class Objetos implements ObjetosTDA {

	int[] arreglo;
	int indice;
	
	@Override
	public int Tope() {
		return arreglo[indice-1];
	}

	@Override
	public int Primero() {
		
		return (arreglo[indice-1]);
	}

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
	public boolean PilaVacia() {
		
		return (indice == 0);
	}

	@Override
	public boolean ColaVacia() {
		
		return (indice==0);
	}

	@Override
	public void InicializarPila() {
		arreglo = new int[50];
		indice=0;
		
	}

	@Override
	public void Acolar(int x) {
		for(int i=indice;i>0;i--) {
			arreglo[i] = arreglo[i-1];
		}
		arreglo[0] = x;
		indice++;
		
	}

	@Override
	public void Desacolar() {
		indice--;
		
	}

	@Override
	public void InicializarCola() {
		arreglo = new int[50];
		indice=0;
		
	}

}
