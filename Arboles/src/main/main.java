package main;

import api.ABBTDA;
import api.ConjuntoTDA;
import impl.ABB;
import impl.ConjuntoTA;

public class main {

	public static void main(String[] args) {
		ABBTDA Arbol1 = new ABB();
		ABBTDA Arbol2 = new ABB();
		
		Arbol1.InicializarArbol();
		Arbol2.InicializarArbol();
		
		Arbol1.AgregarElem(20);
		Arbol1.AgregarElem(10);
		Arbol1.AgregarElem(1);
		Arbol1.AgregarElem(18);
		Arbol1.AgregarElem(14);
		Arbol1.AgregarElem(12);
		Arbol1.AgregarElem(15);
		Arbol1.AgregarElem(35);
		Arbol1.AgregarElem(26);
		Arbol1.AgregarElem(23);
		Arbol1.AgregarElem(30);
		Arbol1.AgregarElem(40);
		
		Arbol2.AgregarElem(20);
		Arbol2.AgregarElem(10);
		Arbol2.AgregarElem(1);
		Arbol2.AgregarElem(18);
		//Arbol2.AgregarElem(14);
		Arbol2.AgregarElem(12);
		Arbol2.AgregarElem(15);
		Arbol2.AgregarElem(35);
		Arbol2.AgregarElem(26);
		Arbol2.AgregarElem(23);
		Arbol2.AgregarElem(30);
		Arbol2.AgregarElem(40);
		
		
		System.out.print("PreOrder - ");
		preOrder(Arbol1);
		System.out.println();
		System.out.print("InOrder - ");
		inOrder(Arbol1);
		System.out.println();
		System.out.print("PostOrder - ");
		postOrder(Arbol1);
		System.out.println();
		System.out.println();
		System.out.println("Buscamos Elementos en el Arbol:");
		System.out.print(" - ");
		buscarElemento(14,Arbol1);
		System.out.print(" - ");
		buscarElemento(266,Arbol1);
		System.out.println();
		int profundidad = calcularProfundidad(Arbol1,23);
		System.out.println("Calculamos la profundidad del Arbol dado un valor:");
		System.out.print(" - ");
		System.out.println(profundidad);
		System.out.println();
		System.out.println("Calculamos la cantidad de nodos del Arbol:");
		System.out.print(" - ");
		int contados = contar(Arbol1);
		System.out.print(contados);
		System.out.println();
		System.out.println();
		System.out.println("Calculamos la suma de nodos del Arbol:");
		System.out.print(" - ");
		int sumados = sumar(Arbol1);
		System.out.print(sumados);
		System.out.println();
		System.out.println();
		menorMenorElemento(Arbol1);
		ConjuntoTDA paresolo = nodosPares(Arbol1);
		System.out.println();
		System.out.println("Los elementos pares del arbol son: ");
		mostrarConjunto(paresolo);
		System.out.println();
		System.out.println();

		System.out.println("Las Hojas del Arbol son: ");
		soloHojas(Arbol1);
		System.out.println();
		System.out.println();
		System.out.println("Chequeo de hojas");
		esHoja(15,Arbol1);
		System.out.println();
		esHoja(26,Arbol1);
		System.out.println();
		System.out.println();
		System.out.println("Los dos arboles tienen la misma forma? ");
		boolean confirm = mismaForma(Arbol1, Arbol2);
		System.out.print(confirm);

	}
	
	public static void preOrder(ABBTDA x) {
		if(!x.ArbolVacio()) {
			System.out.print(x.Raiz()+" ");
			preOrder(x.HijoIzq());
			preOrder(x.HijoDer());
		}
	}

	public static void inOrder(ABBTDA x) {
		if(!x.ArbolVacio()) {
			inOrder(x.HijoIzq());
			System.out.print(x.Raiz()+" ");
			inOrder(x.HijoDer());
		}		
	}
	
	public static void postOrder(ABBTDA x) {
		if(!x.ArbolVacio()) {
			postOrder(x.HijoIzq());
			postOrder(x.HijoDer());
			System.out.print(x.Raiz()+" ");
		}
	}
	
	public static int contar(ABBTDA x) {
		if(x.ArbolVacio()) {
			return 0;
		}else {
			return (1 + contar(x.HijoIzq()) + contar(x.HijoDer()));
		}
	}

	public static int sumar(ABBTDA x) {
		if(x.ArbolVacio()) {
			return 0;
		}else {
			return(x.Raiz() + sumar(x.HijoIzq()) + sumar(x.HijoDer()));
		}
		
	}
	
	public static int calcularProfundidad(ABBTDA x, int n) {
		if (x.ArbolVacio()) {
			return 0;
		}else if (x.Raiz()==n) {
			return 0;
		}else if (x.Raiz()>n) {
			return (1 + calcularProfundidad(x.HijoIzq(),n)); 
		}else {
			return (1 + calcularProfundidad(x.HijoDer(),n));
		}
		
	}
	
	public  boolean existeElemento(ABBTDA x, int n) {
		if(x.ArbolVacio()) {
			return false;
		}else if(x.Raiz()==n) {
			return true;
		}else if(x.Raiz() > n) {
			return this.existeElemento(x.HijoIzq(),n);
		}else {
			return this.existeElemento(x.HijoDer(),n);
		}
	}
	
	public static ConjuntoTDA nodosPares(ABBTDA x) {
		
		ConjuntoTDA pares = new ConjuntoTA();
		pares.InicializarConjunto();
		
		if(!x.ArbolVacio()) {
			if (x.Raiz()%2==0) {
				pares.Agregar(x.Raiz());
			}
			
			ConjuntoTDA xI = nodosPares(x.HijoIzq());
			ConjuntoTDA xD = nodosPares(x.HijoDer());
			
			while (!xI.ConjuntoVacio()) {
				int c = xI.Elegir();
				pares.Agregar(c);
				xI.Sacar(c);
			}
			while (!xD.ConjuntoVacio()) {
				int c = xD.Elegir();
				pares.Agregar(c);
				xD.Sacar(c);
			}
		}
		return pares;
	}
	
	public static void mostrarConjunto(ConjuntoTDA x) {
		while(!x.ConjuntoVacio()) {
			int h = x.Elegir();
			System.out.print(h);
			x.Sacar(h);
			if (!x.ConjuntoVacio()){
				System.out.print(", ");
			}
		}
	}
	
	public static void buscarElemento(int b,ABBTDA x) {
			if(x.ArbolVacio()) {
				System.out.println( b + " NO se encuentra en el arbol");
			}
			else if (x.Raiz()==b) {
			System.out.println(b + " Se encuentra en el arbol");
				
			}else if(x.Raiz()>b) {
				buscarElemento(b, x.HijoIzq());
			
			}else if (x.Raiz()<b) {
				buscarElemento(b, x.HijoDer());
			
			}else {
				System.out.println(b + " NO se encuentra en el arbol");
			
			}
		
		
	}
	
	public static void menorMenorElemento(ABBTDA x) {
		if(!x.ArbolVacio()) {
			if(!x.HijoIzq().ArbolVacio()) {
				menorMenorElemento(x.HijoIzq());
			}else {
				System.out.println("El menor elemento del Arbol es: ");
				System.out.println(x.Raiz());
			}
			
		}
		
		
	}
	
	public static void soloHojas(ABBTDA x) {
		if(!x.ArbolVacio()) {
			if(!x.HijoIzq().ArbolVacio()){
				soloHojas(x.HijoIzq());
				soloHojas(x.HijoDer());
									
			}else {
				System.out.print(x.Raiz() + " ");
				
			}
		}
	}
	
	public static void esHoja(int b,ABBTDA x) {
		if(!x.ArbolVacio()) {
			if(x.Raiz()==b) {
				if(x.HijoDer().ArbolVacio()) {
					System.out.print(b + " Es una Hoja");
				}else {
					System.out.print(b + " NO Es una Hoja");
				}
				
			}else {
				esHoja(b,x.HijoIzq());
				esHoja(b,x.HijoDer());
			}
		}
	}
	
	public static boolean mismaForma(ABBTDA x, ABBTDA y) {
		if(x.ArbolVacio()&&y.ArbolVacio()) {
			return true;
		}
		return !x.ArbolVacio() && !y.ArbolVacio() && mismaForma(x.HijoDer(),y.HijoDer()) && mismaForma(x.HijoIzq(), y.HijoIzq());
	}

}

