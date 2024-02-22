package impl;

import api.ConjuntoTDA;
import api.DicMulTDA;

public class DicMulLD implements DicMulTDA {

	class NodoClave{
		int clave;
		NodoValor valores;
		NodoClave sig;
	}
	
	class NodoValor{
		int		valor;
		NodoValor	sig;
	}
	
	NodoClave origen;
		
	@Override
	public void InicializarDiccionario() {
		origen = null;		
	}

	@Override
	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		
		if(nc==null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.sig = origen;
			origen = nc;
		}
		
		NodoValor aux = nc.valores;
		while(aux!=null && aux.valor!=valor) {
			aux=aux.sig;
		}
		
		if(aux==null) {
			NodoValor nv = new NodoValor();
			nv.valor = valor;
			nv.sig = nc.valores;
			nc.valores = nv;
		}
	}

	@Override
	public void Eliminar(int clave) {
		if(origen!=null) {
			if(origen.clave==clave) {
				origen = origen.sig;
			}else {
				NodoClave aux = origen;
				while(aux.sig!=null && aux.sig.clave!=clave) {
					aux=aux.sig;
				}
				if(aux.sig!=null) {
					aux.sig=aux.sig.sig;
				}
			}
		}
	}

	@Override
	public void EliminarValor(int clave, int valor) {
		if(origen!=null) {
			if(origen.clave==clave) {
				EliminarValorEnNodo(origen,valor);
				if(origen.valores==null) {
					origen = origen.sig;
				}
			}else {
				NodoClave aux = origen;
				while(aux.sig!=null && aux.sig.clave!=clave) {
					aux=aux.sig;
				}
				if(aux.sig!=null) {
					EliminarValorEnNodo(aux.sig,valor);
					if(aux.sig.valores==null) {
						aux.sig=aux.sig.sig;
					}
				}
			}
		}
		
	}

	@Override
	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		
		NodoClave aux = origen;
		
		while(aux!=null) {
			c.Agregar(aux.clave);
			aux=aux.sig;
		}
		
		return c;
	}

	@Override
	public ConjuntoTDA Recuperar(int clave) {
		NodoClave n = Clave2NodoClave(clave);		
		
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		
		if(n!=null) {
			NodoValor aux = n.valores;
			while(aux!=null) {
				c.Agregar(aux.valor);
				aux=aux.sig;
			}
		}
		return c;
	}
	
	private NodoClave Clave2NodoClave(int cl) {
		NodoClave aux = origen;
		while(aux!=null && aux.clave!=cl) {
			aux=aux.sig;
		}
		
		return aux;
	}
	
	
	private void EliminarValorEnNodo(NodoClave nodo, int valor) {
		if(nodo.valores!=null) {
			if(nodo.valores.valor==valor) {
				nodo.valores = nodo.valores.sig;
			}else {
				NodoValor aux = nodo.valores;
				while(aux.sig!=null && aux.sig.valor!=valor) {
					aux=aux.sig;
				}
				if(aux.sig!=null) {
					aux.sig = aux.sig.sig;
				}
			}
		}
	}

}
