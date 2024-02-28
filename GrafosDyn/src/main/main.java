package main;

import api.ConjuntoTDA;
import api.GrafoTDA;
import impl.ConjuntoLD;
import impl.GrafoLA;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int mayorCosto(GrafoTDA g, int v) {
		int max=-1;
		ConjuntoTDA vertices=g.Vertices();
		if (vertices.Pertenece(v)) {
			vertices.Sacar(v);
			boolean primeraVez=true;
			while(!vertices.ConjuntoVacio()) {
				int vertice_destino=vertices.Elegir();
				if(g.ExisteArista(v,vertice_destino))
					if (primeraVez) {
						max=g.PesoArista(v,vertice_destino);
						primeraVez=false;
					}
					else
						if (max < g.PesoArista(v,vertice_destino))
							max=g.PesoArista(v,vertice_destino);					
				vertices.Sacar(vertice_destino);					
				}
		}			
		return max;
	}
	
	
	public static int mayorCosto1(GrafoTDA g, int v) {
		int max=-1;
		ConjuntoTDA vertices=g.Vertices();
		if (vertices.Pertenece(v)) {
			vertices.Sacar(v);			
			while(!vertices.ConjuntoVacio()) {
				int vertice_destino=vertices.Elegir();
				if(g.ExisteArista(v,vertice_destino))				
					if (max < g.PesoArista(v,vertice_destino))
						max=g.PesoArista(v,vertice_destino);					
				vertices.Sacar(vertice_destino);					
				}
		}			
		return max;
	}
	public static ConjuntoTDA conjuntoPredecesor(GrafoTDA g, int v) {
		ConjuntoTDA conjResultante=new ConjuntoLD();
		conjResultante.InicializarConjunto();
		ConjuntoTDA vertices=g.Vertices();
		if (vertices.Pertenece(v)) {
			vertices.Sacar(v);			
			while(!vertices.ConjuntoVacio()) {
				int vertice_origen=vertices.Elegir();
				if(g.ExisteArista(vertice_origen,v))				
					conjResultante.Agregar(vertice_origen);		
				vertices.Sacar(vertice_origen);					
				}
		}			
		return conjResultante;
	}
	
	public static ConjuntoTDA dobleAdyacente(GrafoTDA g, int v) {
		ConjuntoTDA conjResultante=new ConjuntoLD();
		conjResultante.InicializarConjunto();
		ConjuntoTDA ws;
		ConjuntoTDA xs=g.Vertices();
		if (xs.Pertenece(v)) {
			xs.Sacar(v);			
			while(!xs.ConjuntoVacio()) {//Candidatos a x
				int x =xs.Elegir();
				if(g.ExisteArista(v,x)) {	
					ws=g.Vertices();			    
				    ws.Sacar(v);
					while(!ws.ConjuntoVacio()) {//Candidatos a w
						int w=ws.Elegir();
						if (g.ExisteArista(x, w))// Por cada x debo verificar que exista un w
							conjResultante.Agregar(w);
						ws.Sacar(w);
					}	
				}	
				xs.Sacar(x);					
				}
		}			
		return conjResultante;
	}
	
	public static ConjuntoTDA aislados(GrafoTDA g) {
		ConjuntoTDA conjResultante=new ConjuntoLD();
		conjResultante.InicializarConjunto();		
		ConjuntoTDA vertices=g.Vertices();
		while(!vertices.ConjuntoVacio()) {//Candidatos a aislado
			int v=vertices.Elegir();
			boolean aislado=true;
			ConjuntoTDA otros=g.Vertices();
			otros.Sacar(v);
			while(!otros.ConjuntoVacio() && aislado) {//Candidatos a w
				int otro=otros.Elegir();
				if (g.ExisteArista(v, otro) || g.ExisteArista(otro, v ))// Por cada v debo verificar que sea aislado
					aislado=false;
				otros.Sacar(otro);
			}	
			if (aislado)
				conjResultante.Agregar(v);
			
			vertices.Sacar(v);					
		}
				
		return conjResultante;
	}
}
