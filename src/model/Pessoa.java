package model;

public abstract class Pessoa implements ValidadorCPF {

	public String nome;
	protected String sexo;
	private String cpf;
		
	public Pessoa(String nome, String sexo, String cpf) throws CPFException {

		if (validarCPF(cpf)) {
			this.nome = nome;
			this.sexo = sexo;
			this.cpf = cpf;
		}
		
		else {
			throw new CPFException(CPF_INVALIDO);			
		}
	}
	

	public String getSexo() {
		return sexo;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + "]";
	}

}
