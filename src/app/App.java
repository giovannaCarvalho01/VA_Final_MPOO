package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Controller;
import model.Acesso;
import model.Administrador;
import model.AdministradorException;
import model.BaseDados;
import model.CPFException;
import model.Logo;
import model.Pessoa;
import model.PessoaException;
import model.Usuario;
import view.TelaAplicacao;
import view.TelaMensagem;

public class App extends Thread {

	public static void main(String[] args) {

		BaseDados.inicializarBase();
				
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			
			new Acesso("E03A00B06eZ",(Administrador) BaseDados.isAdmin("admin", "admin"));
			
			Administrador admin2;
			try {
				admin2 = new Administrador("Maria Silva", "feminino", "94811699955", "maria", "mAriA");
				BaseDados.adicionarPessoa(admin2, BaseDados.isAdmin("admin", "admin"));
				new Acesso("E14A11B19eZ", (Administrador) BaseDados.isAdmin("maria", "mAriA"));
				
			} catch (PessoaException e) {
				e.printStackTrace();
			} catch (AdministradorException e) {
				e.printStackTrace();
			}
			} catch (CPFException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		try {
			
			Usuario usuario = new Usuario("Joao Silva", "masculino", "58408406299", "joaoSilva", "joaoSilva");
			
			try {					
				BaseDados.adicionarPessoa((Pessoa)usuario, BaseDados.isAdmin("admin", "admin"));
				
			} catch (PessoaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AdministradorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (CPFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	try {
		
		Usuario usuario2 = new Usuario("Joao Silva", "masculino", "58408406299", "joaoSilva", "joaoSilva");
		
		try {					
			BaseDados.adicionarPessoa((Pessoa)usuario2, BaseDados.isAdmin("admin", "admin"));
		} catch (PessoaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdministradorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (CPFException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		Usuario usuario3;
		try {
			usuario3 = new Usuario("Jose Santos", "masculino", "12345678900", "joseSantos", "joseSantos");
			try {					
				BaseDados.adicionarPessoa((Pessoa)usuario3, BaseDados.isAdmin("admin", "admin"));
			} catch (PessoaException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (AdministradorException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		} catch (CPFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 TelaAplicacao tela =  new TelaAplicacao(new Logo().getLogoImageIcon());
		 
		 new Controller(tela);
		 
		 System.out.println(BaseDados.listPessoas());
		 
		 App app = new App();
		 
		 app.start();
		 
	}

	@Override
	public void run() {
		// EXIBIR OS NOMES DOS USUARIOS EM UM JOPTIONPANE
		
		try {
			sleep(60000);
			
			if (BaseDados.listNomes().size() != 0) {
				TelaMensagem.exibirMensagem(BaseDados.listNomes().toString());
			}
			
			else {
				TelaMensagem.exibirMensagem("Não existem usuarios");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	// CRIAR AS TELAS AQUI E NÃO NO CONTROLADOR
}
