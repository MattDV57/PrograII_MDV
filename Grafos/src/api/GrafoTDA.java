package api;

public interface GrafoTDA {
	void InicializarGrafo();						//Sin precondiciones
	void AgregarVertice(int v);						//Inicializado y no exista el Nodo
	void EliminarVertice(int v);					//Inicializado y exista el Nodo
	void AgregarArista(int v1, int v2, int peso);	//Inicializado y No exista Arista
	void EliminarArista(int v1, int v2);			//Inicializado y existan los Nodos
	ConjuntoTDA Vertices();							//Inicializado	
	boolean ExisteArista(int v1, int v2);			//Inicializado y exista Arista
	int PesoArista(int v1, int v2);					//Inicializado
	
}
