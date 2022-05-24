package impl;

import api.ColaTDA;

public class Cola implements ColaTDA {

	int a[];
	int indice;
	
	@Override
	public void InicializarCola() {
		a = new int[100];
		indice=0;
		
	}

	@Override
	public void Acolar(int x) {
		
		for(int i=indice;i>0;i--) {
			a[i] = a[i-1];
		}
		
		a[0]=x;
		
		indice++;
		
	}

	@Override
	public void Desacolar() {
		indice--;
		
	}

	@Override
	public int Primero() {
		return a[indice-1];
	}

	@Override
	public boolean ColaVacia() {
		return (indice==0);
	}

}
