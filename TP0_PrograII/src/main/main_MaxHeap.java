package main;

import api.HeapTDA;
import impl.Heap;

public class main_MaxHeap {

	public static void main(String[] args) {
		
		// ------------- HEAP 1 -------------
		
		//Creamos un objeto nuevo de tipo Heap		
		HeapTDA MHeap = new Heap();
		
		/*Lo inicializamos para poder empezar a utilizarlo
		La cantidad de elementos la pasaremos por parámetro*/
		MHeap.InicializarHeap(21);
		
		//Mediante el metodo "Insertar", agregamos elementos al Heap
		MHeap.Insertar(5);
		MHeap.Insertar(3);
		MHeap.Insertar(17);
		MHeap.Insertar(10);
		MHeap.Insertar(84);
		MHeap.Insertar(19);
		MHeap.Insertar(6);
		MHeap.Insertar(22);
		MHeap.Insertar(9);
		
		//Lo mostramos por pantalla
		MHeap.MostrarHeap();
		
		/*Imprimimos el primer elemento.
		En el caso del MaxHeap, la raíz (elemento de mayor valor)*/
		System.out.println("- El elemento de mayor valor es: " + MHeap.Primero());
		
		//Eliminamos un elemento y lo volvemos a mostrar
		System.out.println("- Procedemos a eliminar la raíz");
		MHeap.Eliminar();
		MHeap.MostrarHeap();
		
		/*Imprimimos el primer elemento.
		En el caso del MaxHeap, la raíz (elemento de mayor valor)*/
		System.out.println("- El elemento de mayor valor es: " + MHeap.Primero());

		
		
		// ------------- HEAP 2 -------------
		
		HeapTDA MHeapEmpty = new Heap();
		
		MHeapEmpty.InicializarHeap(4);
		MHeapEmpty.Insertar(9);
		
		EsVacio(MHeapEmpty);
		
		MHeapEmpty.Eliminar();
		
		EsVacio(MHeapEmpty);
	}
	
	public static void EsVacio(HeapTDA X) {
		if(X.HeapVacio()) {
			
			System.out.print("- El Heap está vacío");
		
		}else{
			
			System.out.println("- El Heap NO Esta vacio");
		}
	}
	

	

}
