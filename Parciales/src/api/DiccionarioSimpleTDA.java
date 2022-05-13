package api;

public interface DiccionarioSimpleTDA {
	void InicializarDiccionario();			//Sin precondiciones
	void Agregar(int clave, int valor);		//Inicializado
	void Eliminar (int clave);				//Inicializado
	int Recuperar (int clave);				//Inicializado y Clave Existe
	ConjuntosTDA Claves();					//Inicializado
	
	
}
