package api;

public interface DicSimpleTDA {
	void InicializarDiccionario();			//Sin precondiciones
	void Agregar(int clave, int valor);		//Inicializado
	void Eliminar (int clave);				//Inicializado
	int Recuperar (int clave);				//Inicializado y Clave Existe
	ConjuntoTDA Claves();					//Inicializado
}
