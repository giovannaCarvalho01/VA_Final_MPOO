package model;


public interface ValidadorCPF {
	
	static final String CPF_INVALIDO = "CPF informado � inv�lido";
	
	public abstract boolean validarCPF(String cpf);
	
	
}
