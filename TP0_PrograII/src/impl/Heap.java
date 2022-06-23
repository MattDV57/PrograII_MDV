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

	public int Primero() {
		return (Heap[1]);
	}
	
	public boolean HeapVacio() {
		return (size==0);
	}
	
	public void mostrarHeap() {
		for(int i=1;i<=size;i++) {
		
			System.out.print("PADRE: "+  Heap[i] +  " IZQUIERDO: " + Heap[2*i] +" DERECHO: " + Heap[2*i + 1]);
			System.out.println();
			System.out.println("------------");
			
		}
		System.out.println();
	}
	
}
    
    

	