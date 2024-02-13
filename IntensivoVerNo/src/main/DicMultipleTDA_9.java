package main;

import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;
import impl.DicMultipleA;

public class DicMultipleTDA_9 {

	public static void main(String[] args) {
		
		DiccionarioMultipleTDA dM1 = new DicMultipleA();
		DiccionarioMultipleTDA dM2 = new DicMultipleA();
		
		dM1.inicializarDiccionario();
		dM2.inicializarDiccionario();
		
		dM1.agregar(2, 4);
		dM1.agregar(12, 1);
		dM1.agregar(4, 5);
		dM1.agregar(7, 3);
		dM1.agregar(24, 5);
		dM1.agregar(12, 9);
		
		dM2.agregar(23, 3);
		dM2.agregar(2, 8);
		dM2.agregar(2, 5);
		dM2.agregar(98, 4);
		dM2.agregar(4, 14);
		dM2.agregar(11, 9);
		
		mostrarDiccionario(dM1);
		System.out.println();
		System.out.println("=========");
		System.out.println();
		mostrarDiccionario(dM2);
		System.out.println();
		System.out.println("=========");
		System.out.println();
		unirDiccionarios(dM1,dM2);

	}
	
	public static void mostrarDiccionario(DiccionarioMultipleTDA dM) {
		
		DiccionarioMultipleTDA cop = copiarDiccionario(dM);
		
		ConjuntoTDA claves = cop.claves();
		
		while(!claves.conjuntoVacio()) {
			
			int aux2 = claves.elegir();
			
			claves.sacar(aux2);
			ConjuntoTDA valores = cop.recuperar(aux2);
			System.out.println(" ");
			System.out.print(aux2 + " - ");
			
			while(!valores.conjuntoVacio()) {
				int impr = valores.elegir();
				valores.sacar(impr);
				System.out.print(" " + impr + " ");		
		
			};
		
		};
		
	}
	
	public static DiccionarioMultipleTDA copiarDiccionario(DiccionarioMultipleTDA dM) {
		
		DiccionarioMultipleTDA dMAux = new DicMultipleA();
		DiccionarioMultipleTDA dMDes = new DicMultipleA();
		
		ConjuntoTDA claves = dM.claves();
		
		dMAux.inicializarDiccionario();
		dMDes.inicializarDiccionario();
		
		while(!claves.conjuntoVacio()){
			
			int aux2 = claves.elegir();
			claves.sacar(aux2);
			ConjuntoTDA valores = dM.recuperar(aux2);
			
			while(!valores.conjuntoVacio()) {
				int impr = valores.elegir();
				valores.sacar(impr);
				dMDes.agregar(impr, aux2);
				dM.eliminarValor(impr, aux2);
				
			}
		
			dM.eliminar(aux2);
			
		}
		
		ConjuntoTDA claves2 = dMDes.claves();
	
		while(!claves2.conjuntoVacio()){
			
			int aux3 = claves2.elegir();
			
			claves2.sacar(aux3);
			
			ConjuntoTDA valores2 = dMDes.recuperar(aux3);
			
			while(!valores2.conjuntoVacio()) {
				
				int impr = valores2.elegir();
				valores2.sacar(impr);
				dMAux.agregar(impr, aux3);
				dM.agregar(impr, aux3);
				dMDes.eliminarValor(impr, aux3);
			}
			
			dMDes.eliminar(aux3);
			
			
		}
		
		return dMAux;
	}

	public static void unirDiccionarios(DiccionarioMultipleTDA dMOne, DiccionarioMultipleTDA dMTwo) {
		DiccionarioMultipleTDA cop1 = copiarDiccionario(dMOne);
		DiccionarioMultipleTDA cop2 = copiarDiccionario(dMTwo);
		DiccionarioMultipleTDA dMDes = new DicMultipleA();
				
		dMDes.inicializarDiccionario();
		
		ConjuntoTDA claves1 = cop1.claves();
		ConjuntoTDA claves2 = cop2.claves();
		
		while(!claves1.conjuntoVacio()){
			
			int aux2 = claves1.elegir();
			claves1.sacar(aux2);
			ConjuntoTDA valores = cop1.recuperar(aux2);
			
			while(!valores.conjuntoVacio()) {
				int impr = valores.elegir();
				valores.sacar(impr);
				dMDes.agregar(impr, aux2);
				cop1.eliminarValor(impr, aux2);
				
			}
		
			cop1.eliminar(aux2);
		}
		
		while(!claves2.conjuntoVacio()){
			
			int aux3 = claves2.elegir();
			claves2.sacar(aux3);
			ConjuntoTDA valores2 = cop2.recuperar(aux3);
			
			while(!valores2.conjuntoVacio()) {
				int impr2 = valores2.elegir();
				valores2.sacar(impr2);
				dMDes.agregar(impr2, aux3);
				cop1.eliminarValor(impr2, aux3);
				
			}
		
			cop2.eliminar(aux3);
		}
		
		mostrarDiccionario(dMDes);
	}	
	
}