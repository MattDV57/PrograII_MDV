package api;

public interface DiccionarioMultipleTDA {
	
	void			InicializarDiccionario();				//Sin Precondiciones
	void			Agregar(int clave, int valor);			//Diccionario Inicializado
	void			Eliminar(int clave);					//Diccionario Inicializado
	void			EliminarValor(int clave, int valor);	//Diccionario Inicializado
	ConjuntoTDA		Recuperar(int clave);					//Diccionario Inicializado
	ConjuntoTDA		Claves();								//Diccionario Inicializado

}
