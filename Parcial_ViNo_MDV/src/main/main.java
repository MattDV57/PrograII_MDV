package main;

import api.ConjuntoTDA;
import api.RegistroTDA;
import impl.RegistroTA;

public class main {

	public static void main(String[] args) {
		
		RegistroTDA reg = new RegistroTA();
		RegistroTDA regII = new RegistroTA();
		
		reg.InicializarRegistro();
		regII.InicializarRegistro();
		
		reg.Contar(1);
		reg.Contar(2);
		reg.Contar(1);
		reg.Contar(3);
		reg.Contar(1);
		reg.Contar(2);
		reg.Contar(3);
		
		mostrarRegistro(reg);
		System.out.println(" ");
		
		reg.Descontar(2);
		
		mostrarRegistro(reg);
		System.out.println(" ");
		regII.Contar(1);
		regII.Contar(1);
		regII.Contar(2);
		regII.Contar(5);
		regII.Contar(5);
		regII.Contar(5);

		mostrarRegistro(regII);
		
		System.out.println(" ");
		
		RegistroTDA zoom = combinarRegs(reg,regII);
		System.out.println(" ");
		mostrarRegistro(zoom);

	}
	
	public static void mostrarRegistro(RegistroTDA rtda){
		
		ConjuntoTDA A = rtda.Valores();
		
		int x;
		int r;
		
		while(!A.ConjuntoVacio()) {
			x = A.Elegir();
			A.Sacar(x);
			r = rtda.Chequear(x);
			
			System.out.print(x + "(" + r + ")");
			
			if(!A.ConjuntoVacio()) {
				System.out.print(", ");
			}
					
		}			
	}
	
	public static RegistroTDA combinarRegs(RegistroTDA r1, RegistroTDA r2) {
		
		RegistroTDA ultimReg = new RegistroTA();
		
		ultimReg.InicializarRegistro();
		
		ConjuntoTDA conj1 = r1.Valores();
		ConjuntoTDA conj2 = r2.Valores();
		
		int x;
		int r;
		
		while(!conj1.ConjuntoVacio()) {
			x = conj1.Elegir();
			conj1.Sacar(x);
			r = r1.Chequear(x);
			
			for(int i=0;i<r;i++) {
				ultimReg.Contar(x);
			}
			
		}
		
		
		while(!conj2.ConjuntoVacio()) {
			x = conj2.Elegir();
			conj2.Sacar(x);
			r = r2.Chequear(x);
			
			for(int i=0;i<r;i++) {
				ultimReg.Contar(x);
			}
			
		}
		
		return ultimReg;
		
		
	}
}


