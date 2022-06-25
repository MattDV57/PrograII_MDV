package impl;

import api.ConjuntoTDA;
import api.DicSimpleTDA;

public class ConjuntoLD implements DicSimpleTDA{
	
	class NodoClave{
		int clave;
		int valor;
		NodoClave sigClave;
	}
	
	NodoClave origen;
	
	public void InicializarDiccionario (){
		origen = null ;
	}
	
	public void Agregar( int clave , int valor){
		
		NodoClave nc = Clave2NodoClave( clave);
		
		if (nc == null ) {
			nc = new NodoClave();
			nc. clave = clave;
			nc. sigClave = origen;
			origen = nc;
		}
		
		nc. valor = valor;
		}
		
	private NodoClave Clave2NodoClave( int clave){
		
		NodoClave aux = origen;
		
		while (aux!= null && aux.clave!= clave){
			aux = aux.sigClave;
		}
		return aux ;
		}
	
	public void Eliminar( int clave) {
		if (origen!= null) {
		
			if (origen.clave == clave) {
				origen = origen. sigClave;
			}
			else {
		
				NodoClave aux = origen;
		
				while (aux.sigClave != null && aux.sigClave.clave!= clave){
					aux = aux. sigClave;
				}
				if (aux. sigClave!= null ) {
					aux. sigClave= aux. sigClave. sigClave;
				}
			}
		}
	}
		
	public int Recuperar( int clave){
		
		NodoClave n = Clave2NodoClave( clave);
		
		return n. valor;
	}
		
	public static ConjuntoTDA Claves(){
		
		ConjuntoTDA c = new ConjuntoLD();
		
		c. InicializarConjunto ();
		
		NodoClave aux = origen;
		
		for ( int i =0; i< cant ; i ++){
			c. Agregar( elementos[i]. clave);
		
		}
		return c;
	}
}
