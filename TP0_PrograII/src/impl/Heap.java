package impl;

import api.HeapTDA;

//Programa JAVA para implementar Max Heap
public class Heap implements HeapTDA {
    private int[] Heap;
    private int size;
    private int maxsize;
	
    public void InicializarHeap(int maxsize) {
    	
    	//Inicializamos el Max-Heap vacío con un tamaño de capacidad maxima pasado por parámetro.
    	this.maxsize=maxsize;
		this.size=0;
		Heap = new int[this.maxsize+1];
		Heap[0] = Integer.MAX_VALUE;
		
	}
	
    public void Insertar(int x) {
    	
    	/*
    	 * Inserta el elemento en la primer hoja disponible
    	 * Y luego empieza a corroborar si debe hacer intercambios hacia arriba
    	 */
		Heap[++size] = x;
		int current = size;
		
		while(Heap[current] > Heap[Root(current)]) {

			Exchange(current, Root(current));
			current = Root(current);
		}
	}

	public void MostrarHeap() {
		System.out.println("----------------------------------------");
		System.out.println();
		for(int i=1;i<=size/2;i++) {
		
			System.out.println("	 PADRE: " + Heap[i] );
		            
            if(LeftChild(i)<=size) //Chequea que el hijo izquierdo no exceda el limite del arreglo
               System.out.print( " Hijo Izquierdo: " + Heap[LeftChild(i)]);
             
            if(RightChild(i)<=size) //Chequea que el hijo derecho no exceda el limite del arreglo
                System.out.print(" Hijo Derecho: "+ Heap[RightChild(i)]);
             
                System.out.println(); 
                System.out.println();
		}
	
		System.out.println("----------------------------------------");
		System.out.println();
	}
	
	public void Eliminar() {
		
		/*
		 * Captura el valor del tamaño previo a decrementarlo
		 * Luego Eliminar la raíz del Max_Heap y mediante el heapify acomoda al árbol 
		 */
        Heap[0] = Heap[--size];
        MaxHeapify(0);
		
	}
	
	public int Primero() {
		
		/*Devuelve el primer elemento del arreglo
		en el caso del Max_Heap, el mas alto*/
		return (Heap[1]);
	}
	
	public boolean HeapVacio() {
		
		/*Chequeao si el tamaño del arbol es cero
		Lo que significa que esta vacío*/
		return (size==0);
	}
	

//-----------------------MÉTODOS PRIVADOS-----------------------
	
	private void Exchange(int first, int second) {
		
		/*
		 * Intercambia las posiciones del primer valor y el segundo
		 * utilizando una variable auxiliar para dicho intercambio
		 */
		int aux = Heap[first];
		Heap[first]=Heap[second];
		Heap[second] = aux;
	}
		
    private boolean EsHoja(int pos) {
    	
    	//Chequea si la la posición que indicamos pertenece a una hoja o no.
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
	
	private int Root(int pos) {
		
		//Devuelve la raíz del arbol
		return pos/2;
	}
    
    private int LeftChild(int pos) { 
    	
    	//Devuelve el valor del hijo izquierdo
    		return (2 * pos); 
    }
 
    private int RightChild(int pos) {
    	
    	//Devuelve el valor del hijo derecho
    		return (2 * pos)+1; 
    }

    private void MaxHeapify(int pos) {
    	
    	/*
    	 * Este método recursivo acomoda el árbol luego de una eliminación
    	 * Pregunta si es una hoja, en caso de no serlo
    	 * Ejecuta el orden en base a los criterios del Max_Heap
    	 */
        if (EsHoja(pos))
            return;
 
        if (Heap[pos] < Heap[LeftChild(pos)]
            || Heap[pos] < Heap[RightChild(pos)]) {
 
            if (Heap[LeftChild(pos)]
                > Heap[RightChild(pos)]) {
                Exchange(pos, LeftChild(pos));
                MaxHeapify(LeftChild(pos));
            }
            else {
                Exchange(pos, RightChild(pos));
                MaxHeapify(RightChild(pos));
            }
        }
    }
  
}
    
    

	