package main;

import api.ConjuntoTDA;
import api.DicMulTDA;
import impl.ConjuntoLD;
import impl.DicMulLD;

public class main {

	public static void main(String[] args) {
		DicMulTDA dM1 = new DicMulLD();
		DicMulTDA dM2 = new DicMulLD();
		
		dM1.InicializarDiccionario();
		dM2.InicializarDiccionario();
		
		dM1.Agregar(2, 4);
		dM1.Agregar(12, 1);
		dM1.Agregar(4, 5);
		dM1.Agregar(7, 3);
		dM1.Agregar(24, 5);
		dM1.Agregar(12, 9);
		
		dM2.Agregar(23, 3);
		dM2.Agregar(2, 8);
		dM2.Agregar(2, 5);
		dM2.Agregar(98, 4);
		dM2.Agregar(4, 14);
		dM2.Agregar(11, 9);
		
		mostrarDiccionario(dM1);
		System.out.println();
		System.out.println("=========");
		System.out.println();
		mostrarDiccionario(dM2);
		System.out.println();
		System.out.println("=========");
		System.out.println();
		

	}
	
	public static void mostrarDiccionario(DicMulTDA dM) {
		
		DicMulTDA cop = copiarDiccionario(dM);
		
		ConjuntoTDA claves = cop.Claves();
		
		while(!claves.CojuntoVacio()) {
			
			int aux2 = claves.Elegir();
			
			claves.Sacar(aux2);
			ConjuntoTDA valores = cop.Recuperar(aux2);
			System.out.println(" ");
			System.out.print(aux2 + " - ");
			
			while(!valores.CojuntoVacio()) {
				int impr = valores.Elegir();
				valores.Sacar(impr);
				System.out.print(" " + impr + " ");		
		
			};
		
		};
		
	}
	
	public static DicMulTDA copiarDiccionario(DicMulTDA dM) {
		
		DicMulTDA dMAux = new DicMulLD();
		DicMulTDA dMDes = new DicMulLD();
		
		ConjuntoTDA claves = dM.Claves();
		
		dMAux.InicializarDiccionario();
		dMDes.InicializarDiccionario();
		
		while(!claves.CojuntoVacio()){
			
			int aux2 = claves.Elegir();
			claves.Sacar(aux2);
			ConjuntoTDA valores = dM.Recuperar(aux2);
			
			while(!valores.CojuntoVacio()) {
				int impr = valores.Elegir();
				valores.Sacar(impr);
				dMDes.Agregar(impr, aux2);
				dM.EliminarValor(impr, aux2);
				
			}
		
			dM.Eliminar(aux2);
			
		}
		
		ConjuntoTDA claves2 = dMDes.Claves();
	
		while(!claves2.CojuntoVacio()){
			
			int aux3 = claves2.Elegir();
			
			claves2.Sacar(aux3);
			
			ConjuntoTDA valores2 = dMDes.Recuperar(aux3);
			
			while(!valores2.CojuntoVacio()) {
				
				int impr = valores2.Elegir();
				valores2.Sacar(impr);
				dMAux.Agregar(impr, aux3);
				dM.Agregar(impr, aux3);
				dMDes.EliminarValor(impr, aux3);
			}
			
			dMDes.Eliminar(aux3);
			
			
		}
		
		return dMAux;

	}

}
