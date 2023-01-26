package model;

import com.Validador;

public class Acesso {

	String chaveAcesso;
	
	public Acesso(Administrador administrador) {
		
	}

	public Acesso(String chaveAcesso, Administrador administrador) {

		if (Validador.validarChave(chaveAcesso)) {
			administrador.acesso.chaveAcesso = chaveAcesso;			
		}
		
		
	}

	@Override
	public String toString() {
		return "Acesso [chaveAcesso=" + chaveAcesso + "]";
	}
	
}
