package api;

public interface ColaTD {
	void InicializarCola();
	void Acolar( int x);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
}
