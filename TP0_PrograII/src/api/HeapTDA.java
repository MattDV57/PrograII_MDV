package api;

public interface HeapTDA {
	void InicializarHeap(int x);
	void Insertar(int x);
	void Eliminar();
	int Primero();
	boolean HeapVacio();
	void mostrarHeap();
	int leftChild(int pos);
	int rightChild(int pos);
	
		
	
}
