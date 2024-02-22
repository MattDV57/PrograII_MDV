package api;

public interface ConjuntoTDA {
	void 		InicializarConjunto();
	void 		Agregar(int x);
	void		Sacar(int x);
	int			Elegir();
	boolean 	Pertenece(int x);
	boolean		CojuntoVacio();
	
}
