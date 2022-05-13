package api;

public interface ColaTDA {

	void InicializarCola(); //Sin Precondiciones
	void Acolar(int x); 	//Cola Inicializada
	void Desacolar();		//Inicializada y No Vacia
	int Primero();			//Inicializada y No Vacia
	boolean ColaVacia();	//Cola Inicializada
	
}
