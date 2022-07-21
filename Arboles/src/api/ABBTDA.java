package api;

public interface ABBTDA {
	int Raiz();					//Inicializado y no vacio
	ABBTDA HijoIzq();			//Inicializado y no vacio
	ABBTDA HijoDer();			//Inicializado y no vacio
	boolean ArbolVacio();		//Inicializado
	void InicializarArbol();	//Sin precondiciones
	void AgregarElem(int x);	//Inicializado y no vacio
	void EliminarElem(int x);	//Inicializado y no vacio
}
