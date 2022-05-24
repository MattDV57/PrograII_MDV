package impl;

import api.ConjuntoTDA;
import api.RegistroTDA;

public class RegistroTA implements RegistroTDA{

	int[] arreglo;
	int indice;
	
	@Override
	public void InicializarRegistro() {
		arreglo = new int[100];
		indice=0;
	}

	@Override
	public void Contar(int x) {
		arreglo[indice] = x;
		indice++;
	}

	@Override
	public void Descontar(int x) {
		
		int i=0;
		
		while (i<indice && arreglo[i]!=x) {
			i++;
			
		}
		
		if (i<indice) {
			arreglo[i] = arreglo[indice-1];
			indice--;
		}
		
	}

	@Override
	public int Chequear(int x) {
		
		int cont=0;
		
		for(int i=0;i<indice;i++) {
			if(arreglo[i]==x) {
				cont++;
			}
		}
		
		return cont;
	}

	@Override
	public ConjuntoTDA Valores() {
		
		ConjuntoTDA vals = new ConjuntoTA();
		
		vals.InicializarConjunto();
		
		for(int i=0;i<indice;i++) {
			vals.Agregar(arreglo[i]);
		}
		
		return vals;
	}



}
