package model;

import java.util.ArrayList;

public class BaseDados {

	private static ArrayList<Pessoa> pessoas;
	
	public static void inicializarBase() {
		pessoas = new ArrayList<Pessoa>();
		
		try {
			
			Administrador admin = new Administrador("Giovanna", "feminino", "08102349476", "admin", "admin");
			pessoas.add(admin);
		} catch (CPFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Pessoa buscarPessoa(String cpf) {
		for (Pessoa p : pessoas) {
			if (p.getCpf().equals(cpf)) {
				return p;
			}
		}
		
		return null;
	}
	
	private static void uploadBase() {
		
	}
	
	public static boolean isPessoa(Pessoa pessoa) {
		if (buscarPessoa(pessoa.getCpf()) != null) {
			return true;
		}
		
		return false;
	}
	
	public static Administrador isAdmin(String login, String senha) {
		
		for (Pessoa p : pessoas) {
			if (((Administrador) p).login.equals(login) && ((Administrador) p).getSenha().equals(senha)) {
				return (Administrador) p;
			}
		}
		
		return null;
	}
	
	public static boolean validarAdmin(String login, String senha) {
		
		if (isAdmin(login, senha) != null) {
			return true;
		}
		
		return false;
	}
	
	public static boolean adicionarPessoa(Pessoa pessoa, Administrador administrador) throws PessoaException, AdministradorException {
		
		if (administrador == null || !validarAdmin(administrador.login, administrador.getSenha())) {
			throw new AdministradorException(TipoErro.ADMINISTRADOR_INVALIDO);
		}
		
		if (pessoa == null){
			throw new PessoaException(TipoErro.NULL_USUARIO);
		}
		
		if (validarAdmin(administrador.login, administrador.getSenha())) {
			if (!isPessoa(pessoa)) {
				pessoas.add(pessoa);
				return true;
			}
			
			throw new PessoaException(TipoErro.EXISTE_USUARIO);
		}
		
		return false;
	}
	
	public static boolean removerPessoa(Pessoa pessoa, Administrador administrador) throws PessoaException, AdministradorException {
		
		if (administrador == null || !validarAdmin(administrador.login, administrador.getSenha())) {
			throw new AdministradorException(TipoErro.ADMINISTRADOR_INVALIDO);
		}
		
		if (pessoa == null){
			throw new PessoaException(TipoErro.NULL_USUARIO);
		}
		
		if (validarAdmin(administrador.login, administrador.getSenha())) {
			System.out.println(validarAdmin(administrador.login, administrador.getSenha()));
			if (isPessoa(pessoa)) {
				pessoas.remove(pessoa);
				return true;
			}
			
			throw new PessoaException(TipoErro.NAO_EXISTE_USUARIO);
		}
		
		return false;
	}

	public static ArrayList<String> listNomes() {
		ArrayList<String> lista = new ArrayList<String>();
		
		for (Pessoa p : pessoas) {
			lista.add(p.nome.toString());
		}
		
		return lista;
	}

	public static ArrayList<Pessoa> listPessoas() {
		return pessoas;
	}
	
}
