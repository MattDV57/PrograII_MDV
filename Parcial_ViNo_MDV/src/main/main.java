package main;

import api.ConjuntoTDA;
import api.RegistroTDA;
import impl.RegistroTA;

public class main {

	public static class Nodo{
		int valor;
		Nodo sig;
	}
	
	public static void main(String[] args) {
		
		Nodo genesis = null;
				
		genesis = agregarNodo(genesis,1);
		genesis = agregarNodo(genesis,2);
		genesis = agregarNodo(genesis,3);
		genesis = agregarNodo(genesis,4);
		genesis = agregarNodo(genesis,2);
		genesis = agregarNodo(genesis,5);
		genesis = agregarNodo(genesis,7);
		genesis = agregarNodo(genesis,4);
		
		RegistroTDA reg = new RegistroTA();
		RegistroTDA regII = new RegistroTA();
		
		reg.InicializarRegistro();
		regII.InicializarRegistro();
		System.out.println(" ");
		System.out.println("Primer Registro ");
		reg.Contar(1);
		reg.Contar(2);
		reg.Contar(1);
		reg.Contar(3);
		reg.Contar(1);
		reg.Contar(2);
		reg.Contar(3);

		
		mostrarRegistro(reg);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Primer Registro modificado ");

		
		reg.Descontar(2);
		
		mostrarRegistro(reg);
		System.out.println(" ");
		regII.Contar(1);
		regII.Contar(1);
		regII.Contar(2);
		regII.Contar(5);
		regII.Contar(5);
		regII.Contar(5);
		System.out.println(" ");
		System.out.println("Segundo Registro");
		mostrarRegistro(regII);
		
		System.out.println(" ");
		
		RegistroTDA zoom = combinarRegs(reg,regII);
		System.out.println(" ");

		System.out.println("Ambos Registros unificados ");
		mostrarRegistro(zoom);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("El Nodo original es");
		mostrarNodo(genesis);
		
		System.out.println(" ");
		System.out.println(" ");

		System.out.println("El Nodo resultado es");
		Nodo Q = resultadoNodo(genesis);

		mostrarNodo(Q);
	}
	
	public static void mostrarRegistro(RegistroTDA rtda){
		
		ConjuntoTDA conjmostrar = rtda.Valores();
		
		int v;
		int c;
		
		while(!conjmostrar.ConjuntoVacio()) {
			v = conjmostrar.Elegir();
			conjmostrar.Sacar(v);
			c = rtda.Chequear(v);
			
			System.out.print(v + "(" + c + ")");
			
			if(!conjmostrar.ConjuntoVacio()){
				System.out.print(", ");
			}
			
			
		}
		
		
	}
	
	public static RegistroTDA combinarRegs(RegistroTDA r1, RegistroTDA r2) {
		RegistroTDA unificadoreg = new RegistroTA();
		
		unificadoreg.InicializarRegistro();
		
		ConjuntoTDA conja = r1.Valores();
		ConjuntoTDA conjb = r2.Valores();
				
		int v;
		int c;
		
		while(!conja.ConjuntoVacio()) {
			v = conja.Elegir();
			conja.Sacar(v);
			c=r1.Chequear(v);
			
			for(int i=0;i<c;i++) {
				unificadoreg.Contar(v);
			}
		}
		
		while(!conjb.ConjuntoVacio()) {
			v = conjb.Elegir();
			conjb.Sacar(v);
			c=r2.Chequear(v);
			
			for(int i=0;i<c;i++) {
				unificadoreg.Contar(v);
			}
		}
		
		return unificadoreg;
	}

	public static Nodo agregarNodo(Nodo L, int x) {
		Nodo nuevo = new Nodo();
		
		nuevo.sig=null;
		nuevo.valor=x;
		
		if(L==null) {
			return nuevo;
		}else {
			Nodo viajero = L;
			while(viajero.sig!= null) {
				viajero = viajero.sig;
			}
			viajero.sig = nuevo;
			return L;
		}
	}
	
	public static void mostrarNodo (Nodo Z) {
		Nodo test = Z;
		
		System.out.print("[");
		while(test!=null) {
			System.out.print(test.valor);
			test=test.sig;
			
			if (test!=null) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
	
	public static Nodo resultadoNodo(Nodo S) {

		Nodo ultimoNod = null;
		Nodo viajero = S;
		
		RegistroTDA numeros = new RegistroTA();
		
		numeros.InicializarRegistro();
		
		while(viajero!=null) {
			numeros.Contar(viajero.valor);
			viajero = viajero.sig;
		}
		
		viajero = S;
		
		while(viajero!=null) {
			if(numeros.Chequear(viajero.valor)==1) {
				ultimoNod = agregarNodo(ultimoNod,viajero.valor);
			}
			viajero = viajero.sig;
		}
		
		return ultimoNod;
		

	}
	
}



