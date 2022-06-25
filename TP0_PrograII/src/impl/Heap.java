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
		Heap[++size] = x;
		int current = size;
		
		while(Heap[current] > Heap[Root(current)]) {

			Exchange(current, Root(current));
			current = Root(current);
		}
	}
	
	private void Exchange(int first, int second) {
		int aux = Heap[first];
		Heap[first]=Heap[second];
		Heap[second] = aux;
	}
	
	private int Root(int pos) {
		return pos/2;
	}
	@Override
	public void Eliminar() {
		// TODO Auto-generated method stub
		
	}
	
    // Method 1
    // Returning position of parent
    private int parent(int pos) { return (pos - 1) / 2; }
 
    // Method 2
    // Returning left children
    public int leftChild(int pos) { 
    		return (2 * pos); 
    }
 
    // Method 3
    // Returning right children
    public int rightChild(int pos){
    		return (2 * pos)+1; 
    }

	public int Primero() {
		return (Heap[1]);
	}
	
	public boolean HeapVacio() {
		return (size==0);
	}
	
	public void mostrarHeap() {
		for(int i=1;i<=size/2;i++) {
		
			//System.out.print("PADRE: "+  Heap[i] +  " IZQUIERDO: " + Heap[2*i] +" DERECHO: " + Heap[2*i + 1]);
			//System.out.println();
			//System.out.println("------------");
			System.out.print("PADRE: " + Heap[i] );
            
            if(leftChild(i)<size) //if the child is out of the bound of the array
               System.out.print( " Hijo Izquierdo: " + Heap[leftChild(i)]);
             
            if(rightChild(i)<size) //if the right child index must not be out of the index of the array
                System.out.print(" Hijo Derecho: "+ Heap[rightChild(i)]);
             
                System.out.println(); //for new line
		}
		System.out.println();
	}
	
}
    
    

	