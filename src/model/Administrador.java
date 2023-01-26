package model;

public class Administrador extends Usuario{

	Acesso acesso;
	
	public Administrador(String nome, String sexo, String cpf, String login, String senha) throws CPFException {
		super(nome, sexo, cpf, login, senha);
		this.acesso = new Acesso(this);
	}

	@Override
	public String toString() {
		return "Administrador [acesso=" + acesso + ", login=" + login + ", nome=" + nome + ", sexo=" + sexo
				+ ", getSenha()=" + getSenha() + ", getCpf()=" + getCpf() + "]";
	}

}
