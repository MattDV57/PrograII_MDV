package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadTA implements ColaPrioridadTDA{
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
		
		for (;j >0 && elementos[j-1].prioridad >= prioridad; j--) {
			elementos[j] = elementos[j-1];
						
		}
		elementos[j] = new Elemento();
		elementos[j].valor = x;
		elementos[j].prioridad = prioridad;
		indice++;
	}

	public void Desacolar() {
		elementos[indice-1] = null;
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
