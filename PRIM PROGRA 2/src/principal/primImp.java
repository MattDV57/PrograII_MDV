package principal;

import api.GrafoTDA;
import imp.ConjuntoTA2;
import imp.GrafoTA;
import api.ConjuntoTDA2;



public class primImp {
	
	public static GrafoTDA prim ( GrafoTDA g) {
		int vertice , aux_vertice , mejor_vertice ,mejor_distancia;
		
		GrafoTDA resultado = new GrafoTA ();
		resultado.InicializarGrafo();
		
		ConjuntoTDA2 vertices =g.Vertices();
		
		vertice = vertices.elegir();
		vertices.sacar (vertice);
		resultado.AgregarVertice(vertice);
		while (!vertices.conjuntoVacio() ) {
			aux_vertice = vertices.elegir();
			vertices.sacar (aux_vertice);
			resultado.AgregarVertice(aux_vertice);
			if ( g.ExisteArista(aux_vertice,vertice) ) {
			resultado.AgregarArista (aux_vertice ,vertice, g.PesoArista (aux_vertice,vertice ) ) ;
			}
		}
		ConjuntoTDA2  pendientes = g.Vertices () ;
		pendientes.sacar(vertice) ;
		ConjuntoTDA2  aux_pendientes = new ConjuntoTA2 ();
		aux_pendientes.inicializarConjunto();
		
		while(!pendientes.conjuntoVacio () ) {
			mejor_distancia = 0;
			mejor_vertice = 0;
		
			while(! pendientes.conjuntoVacio () ) {
			aux_vertice = pendientes.elegir () ;
			pendientes.sacar (aux_vertice ) ;
			aux_pendientes.agregar (aux_vertice ) ;
				if ((!resultado.Adyacentes(aux_vertice ).conjuntoVacio() ) && (mejor_distancia == 0 ||(mejor_distancia > resultado.PesoArista(aux_vertice,resultado.Adyacentes(aux_vertice ).elegir() ) ) ) ) {
				mejor_distancia = resultado.PesoArista(aux_vertice,resultado.Adyacentes(aux_vertice ).elegir());
				mejor_vertice = aux_vertice ;
				}
			}

			vertice = mejor_vertice;
			aux_pendientes .sacar(vertice) ;
			while(!aux_pendientes.conjuntoVacio () ) {
				aux_vertice = aux_pendientes.elegir ();
				aux_pendientes.sacar(aux_vertice);
				pendientes.agregar ( aux_vertice );
			
				if(g.ExisteArista (aux_vertice,vertice)) {
						if(resultado.Adyacentes(aux_vertice ).conjuntoVacio () ) {
							resultado.AgregarArista( aux_vertice ,vertice,g.PesoArista ( aux_vertice ,vertice));
						}else {
							if (resultado.PesoArista ( aux_vertice ,resultado.Adyacentes( aux_vertice).elegir() ) > g.PesoArista(aux_vertice ,vertice ) ) {
								resultado.EliminarArista ( aux_vertice ,resultado.Adyacentes ( aux_vertice ).elegir());
								resultado.AgregarArista ( aux_vertice ,vertice, g.PesoArista(aux_vertice ,vertice));
							}
						}
				}
			}
		}
		return resultado;
	}



	
	static void  mostrargrafo (GrafoTDA A) {
		ConjuntoTDA2 vertices = A.Vertices();
		while(!vertices.conjuntoVacio()) {
			ConjuntoTDA2 vertices2= A.Vertices();
			int origen = vertices.elegir();
			vertices.sacar(origen);	
			while(!vertices2.conjuntoVacio()) {
				int destino = vertices2.elegir();
				vertices2.sacar(destino);
				if(A.ExisteArista(origen, destino) == true) {
					System.out.print("vertice: "+ origen + " ----> arista: " + A.PesoArista(origen, destino) + " <---- vertice: " + destino );
					System.out.println();
				
					A.EliminarArista(origen, destino);
				}
			}
			
			
		}
	
	}
	
	


	public static void main(String[] args) {
		GrafoTDA grafo = new GrafoTA();
		grafo.InicializarGrafo();
		/*
		 * ---- EJEMPLO 1----
		 * grafo.AgregarVertice(0);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(7);
		grafo.AgregarVertice(12);
		grafo.AgregarVertice(22);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(10);
		grafo.AgregarVertice(15);
		grafo.AgregarArista(0, 2, 4);
		grafo.AgregarArista(2, 12, 2);
		grafo.AgregarArista(2, 1, 5);
		grafo.AgregarArista(1, 12, 8);
		grafo.AgregarArista(1, 22, 1);
		grafo.AgregarArista(4, 12, 1);
		grafo.AgregarArista(12, 7, 3);
		grafo.AgregarArista(12, 10, 7);
		grafo.AgregarArista(12, 22, 4);
		grafo.AgregarArista(22, 15, 12);
		grafo.AgregarArista(22, 10, 6);
		grafo.AgregarArista(7, 10, 10);
		grafo.AgregarArista(7, 4, 2);
		grafo.AgregarArista(10, 15, 7);
		*/
		
		//--- EJEMPLO 2
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarArista(1, 2, 1);
		grafo.AgregarArista(1, 3, 2);
		grafo.AgregarArista(1, 4, 6);
		grafo.AgregarArista(2, 1, 1);
		grafo.AgregarArista(2, 3, 3);
		grafo.AgregarArista(2, 4, 4);
		grafo.AgregarArista(3, 1, 2);
		grafo.AgregarArista(3, 2, 3);
		grafo.AgregarArista(3, 4, 5);
		grafo.AgregarArista(4, 1, 6);
		grafo.AgregarArista(4, 2, 4);
		grafo.AgregarArista(4, 3, 5);
		
		GrafoTDA grafo2= prim(grafo);
		mostrargrafo(grafo2);
		
		
	
		
	}
	
	
}


