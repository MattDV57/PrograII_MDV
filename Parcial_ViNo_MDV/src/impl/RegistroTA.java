package impl;

import api.ConjuntoTDA;
import api.RegistroTDA;

public class RegistroTA implements RegistroTDA {

	int[] arr;
	int indice;
	
	@Override
	public void InicializarRegistro() {
		arr = new int[100];
		indice = 0;
		
	}

	@Override
	public void Contar(int x) {
		arr[indice] = x;
		indice++;
	}

	@Override
	public void Descontar(int x) {
		
		int i=0;
		
		while(i<indice && arr[i]!=x) {
			i++;
			
		}
		
		if (i<indice) {
			arr[i] = arr[indice-1];
			indice--;
			
		}
		
	}

	@Override
	public int Chequear(int x) {
		
		int cant=0;
		
		for(int i=0;i<indice;i++) {
			if (arr[i]==x) {
				cant++;
			}
		}
		return cant;
	}

	@Override
	public ConjuntoTDA Valores() {
		
		ConjuntoTDA conj = new ConjuntoTA();
		
		conj.InicializarConjunto();
		
		for(int i=0;i<indice;i++) {
			
			conj.Agregar(arr[i]);
		
		}		
		return conj;
	}

}
