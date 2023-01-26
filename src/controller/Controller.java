package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import model.Administrador;
import model.AdministradorException;
import model.BaseDados;
import model.CPFException;
import model.PessoaException;
import model.TipoErro;
import model.Usuario;
import view.TelaAplicacao;
import view.TelaMensagem;

public class Controller implements ActionListener {

	KeyHandler keyHandler;
	TelaAplicacao telaAplicacao;
	Administrador admin;
	
	public Controller(TelaAplicacao telaAplicacao) {
		keyHandler = new KeyHandler();
		this.telaAplicacao = telaAplicacao;
		control();
		telaAplicacao.setVisible(true);
	}
	
	public void control() {
		telaAplicacao.getNovoButton().addActionListener(this);
		telaAplicacao.getLoginButton().addActionListener(this);
		telaAplicacao.getAddButton().addActionListener(this);
		telaAplicacao.getRemoveButton().addActionListener(this);
		telaAplicacao.getSairButton().addActionListener(this);
		telaAplicacao.getShowButton().addActionListener(this);
		
		telaAplicacao.getSairButton().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}
		});
		
		telaAplicacao.getSenhaField().addKeyListener(keyHandler);
	}
	
	public void criarUsuario(String sexo) {
		
		String cpf_formatter = telaAplicacao.getCpfField().getText().replace(".", "").replace("-", "");

		try {
			
			if(BaseDados.adicionarPessoa(new Usuario(telaAplicacao.getNomeField().getText(),
					sexo,
					cpf_formatter,
					telaAplicacao.getLoginField().getText(),
					telaAplicacao.getSenhaField().getText()), admin)) {
				TelaMensagem.exibirMensagem("Usuário criado com sucesso!");				
			}
			
		} catch (PessoaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		} catch (AdministradorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		} catch (CPFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateCriar() {
		limpar();
		
		telaAplicacao.getNomeLabel().setVisible(true);
		telaAplicacao.getNomeField().setVisible(true);
		
		telaAplicacao.getCpfLabel().setVisible(true);
		telaAplicacao.getCpfField().setVisible(true);
		
		telaAplicacao.getLoginLabel().setVisible(true);
		telaAplicacao.getLoginField().setVisible(true);
		
		telaAplicacao.getSenhaLabel().setVisible(true);
		telaAplicacao.getSenhaField().setVisible(true);
		
		telaAplicacao.getMascRadioButton().setVisible(true);
		telaAplicacao.getFemRadioButton().setVisible(true);
		
	}
	
	public void limpar() {
		
		telaAplicacao.getNomeField().setText("");
		telaAplicacao.getCpfField().setText("");
		telaAplicacao.getLoginField().setText("");
		telaAplicacao.getSenhaField().setText("");
		
	}
	
	public void updateLogar() {
		limpar();

		telaAplicacao.getNomeLabel().setVisible(false);
		telaAplicacao.getNomeField().setVisible(false);
		
		telaAplicacao.getCpfLabel().setVisible(false);
		telaAplicacao.getCpfField().setVisible(false);
		
		telaAplicacao.getLoginLabel().setVisible(true);
		telaAplicacao.getLoginField().setVisible(true);
		
		telaAplicacao.getSenhaLabel().setVisible(true);
		telaAplicacao.getSenhaField().setVisible(true);
		
		telaAplicacao.getMascRadioButton().setVisible(false);
		telaAplicacao.getFemRadioButton().setVisible(false);
	}

	public void remover(String sexo) {
		
		try {

			String cpf_formatter = telaAplicacao.getSenhaField().getText().replace(".", "").replace("-", "");
	
			BaseDados.removerPessoa(new Usuario(telaAplicacao.getNomeField().getText(),
					sexo,
					cpf_formatter,
					telaAplicacao.getLoginField().getText(),
					telaAplicacao.getSenhaField().getText()), admin);
			
		} catch (PessoaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		} catch (AdministradorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		} catch (CPFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == telaAplicacao.getNovoButton()) {
			
			if (admin == null) {
				TelaMensagem.exibirMensagem("É necessário o Admin logar no sistema!");				
			}
			
			updateCriar();
			
		}
		
		if (e.getSource() == telaAplicacao.getLoginButton()) {
			updateLogar();
		}
		
		if (e.getSource() == telaAplicacao.getAddButton()) {
			
			if (telaAplicacao.getMascRadioButton().isSelected()) {
				criarUsuario("Masculino");
			}
			
			if (telaAplicacao.getFemRadioButton().isSelected()) {
				criarUsuario("Feminino");
			}
		}
		
		if (e.getSource() == telaAplicacao.getRemoveButton()) {
			
			if (admin == null) {
				TelaMensagem.exibirMensagem("É necessário o Admin logar no sistema!");				
			}
			
			if (telaAplicacao.getMascRadioButton().isSelected()) {
				remover("Masculino");
			}
			
			if (telaAplicacao.getFemRadioButton().isSelected()) {
				remover("Feminino");
			}
		}
		
		if (e.getSource() == telaAplicacao.getSairButton()) {
			System.exit(0);
		}
		
		if (e.getSource() == telaAplicacao.getShowButton()) {
			
			if (BaseDados.listNomes().size() != 0) {
				TelaMensagem.exibirMensagem(BaseDados.listNomes().toString());
			}
			
			else {
				TelaMensagem.exibirMensagem("Não existem usuarios");
			}
		}
		
	}

	
private class KeyHandler extends KeyAdapter {
	// VERIFICAR A SENHA
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (telaAplicacao.getSenhaField().getText().length()!=0) {
				if (BaseDados.validarAdmin(telaAplicacao.getLoginField().getText(), telaAplicacao.getSenhaField().getText())) {
					TelaMensagem.exibirMensagem("Bem-vindo!");
					admin = BaseDados.isAdmin(telaAplicacao.getLoginField().getText(), telaAplicacao.getSenhaField().getText());
				}
				
				else if (!BaseDados.validarAdmin(telaAplicacao.getLoginField().getText(), telaAplicacao.getSenhaField().getText())) {
					TelaMensagem.exibirMensagem(TipoErro.ADMINISTRADOR_INVALIDO);
				}
			}
		}
	}
}


}
