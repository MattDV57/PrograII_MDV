package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoLA implements GrafoTDA {
	
	class NodoGrafo{
		int nodo ;
		NodoArista arista;
		NodoGrafo sigNodo;
		}
	
	class NodoArista{
		int etiqueta;
		NodoGrafo nodoDestino;
		NodoArista sigArista;
		}
	
	NodoGrafo origen;

	@Override
	public void InicializarGrafo() {
		origen = null;
		
	}

	@Override
	public void AgregarVertice(int v) {
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = v;
		aux.arista = null;
		aux.sigNodo = origen;
		origen = aux;
		
	}

	@Override
	public void EliminarVertice(int v) {
		if ( origen.nodo == v) {
			origen = origen.sigNodo;
		}
		
		NodoGrafo aux = origen;
		
		while (aux!= null){
		
			this.EliminarAristaNodo(aux , v);
			if (aux.sigNodo!= null && aux.sigNodo.nodo == v) {
				aux.sigNodo = aux.sigNodo.sigNodo;
			}
			aux = aux.sigNodo;
		}
	}

	@Override
	public ConjuntoTDA Vertices() {
		ConjuntoTDA c = new ConjuntoLD();
		
		c.InicializarConjunto ();
		
		NodoGrafo aux = origen;
		while (aux!= null ){
			c. Agregar(aux .nodo );
			aux = aux. sigNodo;
		}
		
		return c;
	}

	@Override
	public void AgregarArista(int v1, int v2, int peso) {
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoGrafo n2 = Vert2Nodo(v2);
		
		NodoArista aux = new NodoArista();
		aux.etiqueta = peso;
		aux. nodoDestino = n2;
		aux.sigArista = n1.arista;
		n1.arista = aux;
		
	}

	@Override
	public void EliminarArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		EliminarAristaNodo(n1 ,v2);
		
	}

	@Override
	public boolean ExisteArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1.arista;
		
		while (aux!= null && aux.nodoDestino.nodo !=v2){
			aux = aux.sigArista;
		}
		//Solo si se encontro la arista buscada , aux no es null
		return aux != null ;
	}

	@Override
	public int PesoArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1. arista;
		
		while (aux.nodoDestino.nodo != v2){
			aux = aux.sigArista;
		}
		//Se encontr´o la arista entre los dos nodos
		return aux .etiqueta;
	}
	
	private NodoGrafo Vert2Nodo( int v){
		NodoGrafo aux = origen;
		while (aux != null && aux.nodo!=v){
			aux = aux.sigNodo;
		}
		return aux ;
	}
	
	private void EliminarAristaNodo( NodoGrafo nodo , int v){
		NodoArista aux = nodo.arista;
		if (aux!= null ) {
		//Si la arista a eliminar es la primera en
		//la lista de nodos adyacentes
			if (aux.nodoDestino.nodo == v){
				nodo.arista = aux.sigArista;
			}
			else {
		
				while (aux.sigArista!= null && aux.sigArista.nodoDestino.nodo!= v){
					aux = aux. sigArista;
				}
		
				if( aux. sigArista!= null ) {
					aux. sigArista = aux . sigArista. sigArista;
				}
			}
		}
	}
}
