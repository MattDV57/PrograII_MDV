package main;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.DicMultipleA;

public class main {

	public static void main(String[] args) {

		DiccionarioMultipleTDA Dic = new DicMultipleA();
		Dic.InicializarDiccionario();
		
		Dic.Agregar(5, 1);
		Dic.Agregar(2, 0);
		Dic.Agregar(3, 2);
		Dic.Agregar(1, 8);
		Dic.Agregar(8, 8);
		Dic.Agregar(5, 2);
		Dic.Agregar(2, 3);
		Dic.Agregar(3, 3);
		Dic.Agregar(8, 7);
		Dic.Agregar(2, 1);
		Dic.Agregar(3, 1);
		Dic.Agregar(3, 5);
		
		mostrarDiccionario(Dic);
		
		System.out.println("-");
		
		Dic.Eliminar(8);
		Dic.EliminarValor(5, 2);
		
		mostrarDiccionario(Dic);
		
		Dic.EliminarValor(5, 1);
		
		System.out.println("-");
		
		mostrarDiccionario(Dic);
		
	}
	
	public static void mostrarDiccionario(DiccionarioMultipleTDA A) {
		ConjuntoTDA claves = A.Claves();
		
		while(!claves.ConjuntoVacio()) {
			int key = claves.Elegir();
			System.out.print(key + "");
			claves.Sacar(key);
			ConjuntoTDA values = A.Recuperar(key);
			System.out.print(" - ");
			System.out.print("{");
			while(!values.ConjuntoVacio()) {
				int v = values.Elegir();
				System.out.print(v);
				values.Sacar(v);
				
				if (!values.ConjuntoVacio()) {
					System.out.print(" , ");
				}
			}
			
			System.out.println("}");
		}
		
		
	}

}
