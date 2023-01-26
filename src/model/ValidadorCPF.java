package model;


public interface ValidadorCPF {
	
	static final String CPF_INVALIDO = "CPF informado é inválido";
	
	public abstract boolean validarCPF(String cpf);
	
	
}
