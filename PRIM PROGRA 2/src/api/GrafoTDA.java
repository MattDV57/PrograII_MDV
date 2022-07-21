package api;

public interface GrafoTDA {
	void InicializarGrafo(); 									// Sin Precondiciones
	void AgregarVertice(int vertice); 							// Grafo Inicializado, vertice no existente
	void AgregarArista(int vertice1, int vertice2, int costo); 	// Grafo Inicializado , Vert1 y Vert2 existentes
	void EliminarArista(int vertice1, int vertice2); 			// Grafo Inicializado , Vert1 y Vert2 existentes
	void EliminarVertice(int vertice); 							// Grafo Inicializado, vertice existente
	int PesoArista(int vertice1, int vertice2); 				// Grafo Inicializado , Vert1 y	Vert2 existentes
	boolean ExisteArista(int vertice1, int vertice2); 			// Grafo Inicializado , Vert1 y Vert2 existentes
	ConjuntoTDA2 Adyacentes(int vertice); 						// Grafo Inicializado , [vertice] existente
	ConjuntoTDA2 Vertices(); 									// Grafo Inicializado

}
