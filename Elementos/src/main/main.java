package main;

public class main {

	public static void main(String[] args) {
		Elemento Objeto1 = new Elemento();
		Elemento[] arregloElementos = new Elemento[2];
		
		//Muestro arregloElementos primero
		for(int i=0;i < arregloElementos.length ;i++) {
			arregloElementos[i] = new Elemento();
			mostrarObjeto(arregloElementos[i]);
		}
		
		System.out.println("------------------------------------------");
		
		//Muestro Objeto1 despues
		mostrarObjeto(Objeto1);
		
		Objeto1.valor = 5;
		Objeto1.prioridad = -4;
		
		mostrarObjeto(Objeto1);
		
	}
	
	static class Elemento{
		int valor;
		int prioridad;
		
	}
	
	static void mostrarObjeto(Elemento x) {
		System.out.println("[ Valor = " + x.valor + " / Prioridad = " + x.prioridad + " ]");
	}
}
