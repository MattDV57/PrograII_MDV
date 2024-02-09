package api;

public interface ListaTDA {

		void 	Inicializar();			// Sin precondiciones
		void 	Agregar(int x);			// Siempre que la lista este inicializada
		void 	Eliminar(int x);		// Siempre que la lista este inicializada y no vacia
		int 	Recuperar(int indice);	// Siempre que la lista este inicializada y el elemento exista
		int 	Len();					// Siempre que la lista este inicializada
		boolean Existe(int x);			// Siempre que la lista este inicializada  y no vacia
			
}
