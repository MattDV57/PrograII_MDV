package api;

public interface ColaPrioridadTDA {
	void InicializarCola();
	void AcolarPrioridad(int x, int prioridad);
	void Desacolar();
	int Primero();
	int Prioridad();
	boolean ColaVacia();
	

}
