package api;

public interface PilaTDA {

		void InicializarPila(); 	// Sin precondiciones
		void Apilar(int x); 		// Pila Inicializada
		void ApilarReverse(int x); 	// Pila Inicializada
		void Desapilar(); 			// Pila inicializada y no vacia
		int Tope();					// Pila inicializada y no vacia
		boolean PilaVacia();
}
