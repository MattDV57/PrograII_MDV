package api;

public interface RegistroTDA {
	void InicializarRegistro();
	void Contar(int x);
	void Descontar(int x);
	int Chequear(int x);
	ConjuntoTDA Valores();
}
