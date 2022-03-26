package api;

public interface ColasPrioridadTDA {
	void InicializarCola();
	void AcolarPrioridad(int x, int prioridad);
	void Desacolar();
	int Primero();
	int Prioridad();
	boolean ColaVacia();
	

}
