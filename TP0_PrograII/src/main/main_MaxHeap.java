package main;

import api.HeapTDA;
import impl.Heap;

public class main_MaxHeap {

	public static void main(String[] args) {
		
		HeapTDA MHeap = new Heap();
		MHeap.InicializarHeap(21);
		
		MHeap.Insertar(5);
		MHeap.Insertar(3);
		MHeap.Insertar(17);
		MHeap.Insertar(10);
		MHeap.Insertar(84);
		MHeap.Insertar(19);
		MHeap.Insertar(6);
		MHeap.Insertar(22);
		MHeap.Insertar(9);
		

		MHeap.mostrarHeap();
		System.out.print(MHeap.Primero());
		

	}
	

	

}
