package impl;

import api.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {

	class Nodo{
		int	valor;
		Nodo sig;
	}
	
	Nodo primero;
	
	@Override
	public void InicializarConjunto() {
		primero=null;
	}

	@Override
	public void Agregar(int x) {
		
		if(!this.Pertenece(x)) {
			Nodo aux = new Nodo();
			aux.valor = x;
			aux.sig = primero;
			primero = aux;
		}
		
	}

	@Override
	public void Sacar(int x) {
		if(primero!=null) {
			if (primero.valor==x) {
				primero = primero.sig;
			}else {
				Nodo aux = primero;
				while(aux.sig!=null && aux.sig.valor!=x) {
					aux = aux.sig;
				}
				
				if(aux.sig!=null) {
					aux.sig=aux.sig.sig;
				}
			}
		}
	}

	@Override
	public int Elegir() {
		return primero.valor;
	}

	@Override
	public boolean Pertenece(int x) {
		Nodo aux = primero;
		while(aux!=null && aux.valor!=x) {
			aux=aux.sig;
		}
		
		return aux!=null;
	}

	@Override
	public boolean CojuntoVacio() {
		return (primero==null);
	}

}
