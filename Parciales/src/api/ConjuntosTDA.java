package api;

public interface ConjuntosTDA {
	void InicializarConjunto(); //Sin precondiciones
	void Agregar (int x);		//Inicializado
	void Sacar (int x);			//Inicializado
	int Elegir ();				//Inicializado y No Vacio
	boolean ConjuntoVacio();	//Inicializado
	boolean Pertenece(int x);	//Inicializado
	

}