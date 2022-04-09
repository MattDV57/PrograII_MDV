package main;

public class main {

	static class Nodo {
		
		int valor;
		Nodo sig;
	}
	
	public static void main(String[] args) {
		
		//Nodo x1 = new Nodo();
		//Nodo x2 = new Nodo();
		//Nodo x3 = new Nodo();
				
		//x1.valor=4;
		//x1.sig=x2;
		//x2.valor=7;
		//x2.sig=x3;
		//x3.valor=8;
		//x3.sig=null;
		
		Nodo origen = null;
		mostrarListaEnlazada(origen);
		//mostrarListaEnlazada(x1);
		origen = agregarInicio(7,origen);
		origen = agregarInicio(2,origen);
		origen = agregarInicio(9,origen);
		mostrarListaEnlazada(origen);
		//x1 = agregarInicio(7,x1);
		
		//mostrarListaEnlazada(x1);
		
		origen = agregarFinal(9, origen);
		origen = agregarFinal(7, origen);
		origen = agregarFinal(2,origen);
		
		mostrarListaEnlazada(origen);
			
	}
	
	public static void mostrarListaEnlazada(Nodo A) {
		Nodo viajero=A;
		System.out.print("[");
		
		while(viajero!=null) {
			System.out.print(viajero.valor);
			viajero = viajero.sig;
			
			if(viajero!= null) {
				System.out.print(" , ");
				
			}
					
		}
		System.out.println("]");
		System.out.println("");
	}
	
	static Nodo agregarInicio(int x,Nodo origen) {
		Nodo nuevo = new Nodo();
		nuevo.valor = x;
		nuevo.sig = origen;
		
		return nuevo;
	}

	static Nodo agregarFinal(int x,Nodo origen) {
		Nodo nuevo = new Nodo();
		nuevo.sig = null;
		nuevo.valor=x;
		
		if (origen == null) {
			return nuevo;
		}
		else {
			Nodo viajero = origen;
			while(viajero.sig != null) {
				viajero = viajero.sig;
			}
			viajero.sig=nuevo;
			
		}
		return nuevo;
	
	}
}
