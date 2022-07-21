package imp;

import api.ConjuntoTDA2;
import api.GrafoTDA;

public class GrafoTA implements GrafoTDA{
	static int n = 100;
	int [][] MAdy ;
	int [] Etiqs;
	int cantNodos;
	
	
	
	public void InicializarGrafo() {
		MAdy = new int [n][n];
		Etiqs= new int [n];
		cantNodos= 0;
		
	}
	
	public void AgregarVertice(int vertice) {
		Etiqs[cantNodos] = vertice;
		for (int i= 0; i <= cantNodos; i++) {
			MAdy[cantNodos][i] = 0;
			MAdy[i][cantNodos] = 0;
			
		}
		cantNodos++;
	}
	private int Vert2Indice(int v) {
		int i= cantNodos -1;
		while(i >=0 && Etiqs[i]!= v)
			i --;
	return i;
	}
	
	public void AgregarArista(int vertice1, int vertice2, int costo) {
		int o = Vert2Indice(vertice1);
		int d = Vert2Indice(vertice2);
		MAdy[o][d]= costo;
		MAdy[d][o] = costo;
	}
	

	
	public int PesoArista(int vertice1, int vertice2) {
		int o = Vert2Indice( vertice1);
		int d = Vert2Indice (vertice2);
		return MAdy[o][d];
	}
	

	
	
	public void EliminarArista(int vertice1, int vertice2) {
		int o = Vert2Indice(vertice1);
		int d= Vert2Indice(vertice2);
		MAdy [o][d]= 0;
		MAdy [d][o]= 0;	
	}
	
	public void EliminarVertice(int vertice) {
		int	 ind = Vert2Indice(vertice);
		for (int k=0; k < cantNodos; k++)
			MAdy[k][ind] = MAdy[k][cantNodos-1];
		for(int k=0; k< cantNodos; k++)
			MAdy[ind][k] = MAdy[cantNodos -1][k];
		Etiqs[ind]= Etiqs[cantNodos -1];
		cantNodos --;
		
	}
	
	public boolean ExisteArista(int vertice1, int vertice2) {
		int o = Vert2Indice(vertice1) ;
		int d = Vert2Indice(vertice2) ;
		
	return MAdy [o][d]!= 0;
	}
	
	public ConjuntoTDA2 Vertices(){
		ConjuntoTDA2 Vert = new ConjuntoTA2();
		Vert.inicializarConjunto();
		for(int i= 0; i< cantNodos; i++) {
			Vert.agregar(Etiqs[i]);
		}
	return Vert;
	}
	
	public ConjuntoTDA2 Adyacentes(int vertice){
		ConjuntoTDA2 adya = new ConjuntoTA2();
		adya.inicializarConjunto();
		int vertice1= Vert2Indice(vertice);	
		for (int i = 0; i <10 ; i++) {
			int ind= MAdy[vertice1][i];
			if(ind!=0) {
			adya.agregar(Etiqs[i]);	
			}
		}	
		return adya;
	}
		
	

}
