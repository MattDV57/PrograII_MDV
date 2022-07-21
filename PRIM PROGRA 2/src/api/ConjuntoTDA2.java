package api;

public interface ConjuntoTDA2{
	void inicializarConjunto();
	
	void agregar(int elemento);
	
	void sacar(int elemento);

	boolean conjuntoVacio();
	
	boolean pertenece(int elemento);
	
	int elegir();
	
}
