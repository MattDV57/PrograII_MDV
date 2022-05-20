package impl;

import api.ConjuntoTDA;
import api.RegistroTDA;

public class Registro implements RegistroTDA {
	
	int[] a;
	int cant;
	
	
	@Override
	public void InicializarRegistro() {
		a = new int[50];
		cant = 0;
	}

	@Override
	public void Contar(int x) {
		a[cant] = x;
		cant++;
	}

	@Override
	public void Descontar(int x) {
		int i = 0;
		
		while(i<cant && a[i]!=x ) {
			i++;
		}
		
		if(i<cant) {
			a[i] = a[cant-1];
			cant--;
		}
	}

	@Override
	public int Chequear(int x) {
		int cont = 0;
		
		for (int i=0; i<cant;i++) {
			
			if(a[i]==x) {
				
				cont++;
			}
		}
		return cont;
	}

	@Override
	public ConjuntoTDA Valores() {
		
		ConjuntoTDA c = new  ConjuntoTA();
		
		c.InicializarConjunto();
		
		for(int i=0; i<cant;i++) {
			
			c.Agregar(a[i]);
		}
		
		return c;
	}

}
