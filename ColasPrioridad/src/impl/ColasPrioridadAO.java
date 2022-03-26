package impl;

import api.ColasPrioridadTDA;

public class ColasPrioridadAO implements ColasPrioridadTDA{
	class Elemento{
		int valor;
		int prioridad;
	}
	
	Elemento[] elementos;
	int indice;
	

	public void InicializarCola() {
		elementos = new Elemento[20];
		indice = 0;
	}

	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		
	}

	public void Desacolar() {
		indice--;
	}

	public int Primero() {
		return elementos[indice-1].valor;
		
	}

	public int Prioridad() {
		return elementos[indice-1].prioridad;
	}

	public boolean ColaVacia() {
		return (indice==0);
	}

}
