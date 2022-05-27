package main;

public class main {

	public static class Nodo{
		int info;
		Nodo sig;
	}
	
	public static void main(String[] args) {
		
		Nodo origen1=null;
		Nodo origen2=null;
		Nodo origen3=null;
		Nodo origen4=null;
		
		origen1 = agregarNodo(origen1,5);
		origen1 = agregarNodo(origen1,0);
		origen1 = agregarNodo(origen1,2);
		origen1 = agregarNodo(origen1,7);
		
		origen2 = agregarNodo(origen2,6);
		origen2 = agregarNodo(origen2,2);
		origen2 = agregarNodo(origen2,4);
		
		origen3 = agregarNodo(origen3,2);
		origen3 = agregarNodo(origen3,4);
		origen3 = agregarNodo(origen3,6);

		origen4 = agregarNodo(origen4,1);
		origen4 = agregarNodo(origen4,3);
		origen4 = agregarNodo(origen4,5);
		origen4 = agregarNodo(origen4,7);

		System.out.println("Nodo 1:");
		mostrarNodos(origen1);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Nodo 2:");
		mostrarNodos(origen2);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Nodo 3:");
		mostrarNodos(origen3);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Nodo 4:");
		mostrarNodos(origen4);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("---------------");
		
		Nodo ultimodelos = unirNodos(origen1, origen2);
	
		mostrarNodos(ultimodelos);
		System.out.println(" ");
		System.out.println("---------------");
		Nodo ultimodelos2 = unirNodos(origen3, origen4);
		
		mostrarNodos(ultimodelos2);
		System.out.println(" ");
		System.out.println("---------------");
	}
	
	public static Nodo agregarNodo(Nodo L, int x) {
		
		Nodo nuevo = new Nodo();
		
		nuevo.info = x;
		nuevo.sig = null;
		
		if (L==null) {
			return nuevo;
		}else {
			Nodo viajero = L;
			while(viajero.sig!=null) {
				viajero = viajero.sig;
			}
			
			viajero.sig=nuevo;
			return L;
		}
		
	}

	public static void mostrarNodos(Nodo S) {
		
		Nodo recorre = S;
		System.out.print("[");
		while (recorre!=null) {
			System.out.print(recorre.info);
			recorre = recorre.sig;
			if(recorre!=null) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		
	}
	
	public static Nodo unirNodos(Nodo P,Nodo Q) {
		Nodo viaj1 = P;
		Nodo viaj2 = Q;
		
		Nodo ultimo = null;
		
		while(viaj1!=null) {
			if(viaj1.info!=0) {
				ultimo = agregarNodo(ultimo, viaj1.info);
				viaj1=viaj1.sig;
			}else {
				
				ultimo = agregarNodo(ultimo, viaj1.info);
				ultimo = agregarNodo(ultimo, viaj2.info);
				viaj2 = viaj2.sig;
				
				while(viaj2!=null) {
					ultimo = agregarNodo(ultimo, viaj2.info);
					viaj2 = viaj2.sig;
				}
				viaj1 = viaj1.sig;
			}
		}
		
		while(viaj2!=null) {
			ultimo = agregarNodo(ultimo, viaj2.info);
			viaj2=viaj2.sig;}
		
		return ultimo;
		
	}
}


