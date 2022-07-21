package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class Grafo implements GrafoTDA {
	
	static int n=100;
	int[][] MAdy;
	int [] Etiqs;
	int cantNodos;
	
	@Override
	public void InicializarGrafo() {
		MAdy = new int [n][n];
		Etiqs = new int [n];
		cantNodos = 0;
		
	}

	@Override
	public void AgregarVertice(int v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarVertice(int v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AgregarArista(int v1, int v2, int peso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConjuntoTDA Vertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ExisteArista(int v1, int v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int PesoArista(int v1, int v2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
