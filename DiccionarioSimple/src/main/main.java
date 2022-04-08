package main;

import impl.ConjuntoTA;
import impl.DicSimpleA;
import api.DiccionarioSimpleTDA;
import api.ConjuntoTDA;

public class main {

	public static void main(String[] args) {
		DicSimpleA dic = new DicSimpleA();
		
		dic.InicializarDiccionario();
		
		dic.Agregar(1, 5);
		dic.Agregar(2, 7);
		dic.Agregar(3, 3);
		dic.MostrarDiccionario();
		dic.Eliminar(3);
		dic.MostrarDiccionario();
		dic.Agregar(3, 1);
		dic.MostrarDiccionario();
		dic.Agregar(3, 3);
		dic.MostrarDiccionario();
		
		

	}
	


}
