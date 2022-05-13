package impl;

import api.ColaTDA;

public class Cola implements ColaTDA {
	int[] a;
	int indice;
	
	public void InicializarCola() {
		a = new int[111];
		indice = 0;		
	}
	
	public void Acolar(int x) {
		for (int i = indice;i>0;i--) {
			a[i]=a[i-1];}
		a[0] = x;
		
		indice++;
		
	}
	
	public void Desacolar() {
		indice--;
	}
	
	public int Primero() {
		return a[indice-1];
	}
	
	public boolean ColaVacia() {
		return(indice==0);
	}
}
