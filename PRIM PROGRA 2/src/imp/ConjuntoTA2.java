package imp;

import api.ConjuntoTDA2;

public class ConjuntoTA2 implements ConjuntoTDA2  {
	int [] a;
	int cant;
	
	
	public void inicializarConjunto() {
			a = new int[10];
			cant= 0;
	}

	
	public void agregar(int elemento) {
		if(!this.pertenece(elemento)) {
			a[cant] =  elemento;
			cant++;
		}
			
	}

	
	public void sacar(int elemento) {
		int i = 0;
		while(i< cant && a[i]!= elemento)
			i++;
		if(i< cant) {
			a[i] = a[cant - 1];
			cant--;
		}
	}

	
	public boolean conjuntoVacio() {
		
		return (cant==0);
	}

	
	public boolean pertenece(int elemento) {
		int i = 0;
		while(i < cant &&a[i] != elemento)
			i++;
		return (i<cant);
	}

	
	public  int elegir() {
		return a[cant-1];
	}

	


}
