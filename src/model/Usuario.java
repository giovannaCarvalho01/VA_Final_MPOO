package model;

import java.util.InputMismatchException;

public class Usuario extends Pessoa {

	public String login;
	private String senha;
	
	public Usuario(String nome, String sexo, String cpf, String login, String senha) throws CPFException {
		super(nome, sexo, cpf);
		this.login = login;
		this.senha = senha;
	}

	public boolean validarCPF(String CPF) {
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
		CPF.equals("22222222222") || CPF.equals("33333333333") ||
		CPF.equals("44444444444") || CPF.equals("55555555555") ||
		CPF.equals("66666666666") || CPF.equals("77777777777") ||
		CPF.equals("88888888888") || CPF.equals("99999999999") ||
		(CPF.length() != 11))
		return(false);
		char dig10, dig11;
		int sm, i, r, num, peso;
		try {
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
		num = (int)(CPF.charAt(i) - 48); 
		sm = sm + (num * peso);
		peso = peso - 1;
			}
		r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
		dig10 = '0';
			else dig10 = (char)(r + 48); 
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
		num = (int)(CPF.charAt(i) - 48);
		sm = sm + (num * peso);
		peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
		dig11 = '0';
			else dig11 = (char)(r + 48);
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
		return(true);
			else return(false);
		} catch (InputMismatchException erro) {
		return(false);
		 }
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", nome=" + nome + ", sexo=" + sexo + ", getCpf()="
				+ getCpf() + "]";
	}
	
}
