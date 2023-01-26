package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class TelaAplicacao extends JFrame {

	JButton novoButton, LoginButton, addButton, removeButton, showButton, sairButton;
	JRadioButton mascRadioButton, femRadioButton;
	JLabel loginLabel, senhaLabel, nomeLabel, cpfLabel, logoLabel;
	JTextField loginField, nomeField, cpfField;
	JPasswordField senhaField;
	JPanel panel;
	
	public TelaAplicacao(ImageIcon logo) {
		setSize(300,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(10,2));
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
				 Color.BLUE));
		
		novoButton = new JButton("Novo");
		LoginButton = new JButton("Login");
		addButton = new JButton("Add");
		removeButton = new JButton("remove");
		showButton = new JButton("Show");
		sairButton = new JButton("Sair");
		
		logoLabel = new JLabel(logo);

		add(logoLabel, BorderLayout.NORTH);
	
		JSeparator js = new JSeparator();
		
		js.setOrientation(SwingConstants.HORIZONTAL);


		add(js, BorderLayout.CENTER);
		
		nomeLabel = new JLabel("Nome: ");
		nomeField = new JTextField();
		
		try {
			cpfLabel = new JLabel("CPF: ");
			cpfField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			cpfField.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		loginLabel = new JLabel("login: ");
		loginField = new JTextField(10);
		
		senhaLabel = new JLabel("Senha: ");
		senhaField = new JPasswordField(10);
				
		mascRadioButton = new JRadioButton("Masc", true);
		femRadioButton = new JRadioButton("Fem");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(mascRadioButton);
		buttonGroup.add(femRadioButton);

		getContentPane().add(novoButton);
		getContentPane().add(LoginButton);
		
		getContentPane().add(nomeLabel).setVisible(false);
		getContentPane().add(nomeField).setVisible(false);

		getContentPane().add(cpfLabel).setVisible(false);
		getContentPane().add(cpfField).setVisible(false);

		getContentPane().add(loginLabel).setVisible(false);
		getContentPane().add(loginField).setVisible(false);

		getContentPane().add(senhaLabel).setVisible(false);
		getContentPane().add(senhaField).setVisible(false);
		
		getContentPane().add(mascRadioButton).setVisible(false);
		getContentPane().add(femRadioButton).setVisible(false);
		
		getContentPane().add(addButton);
		getContentPane().add(removeButton);
		getContentPane().add(showButton);
		getContentPane().add(sairButton);
		
		
		//add(this, BorderLayout.SOUTH);
		
		setVisible(false);
	}

	public JButton getNovoButton() {
		return novoButton;
	}

	public JButton getLoginButton() {
		return LoginButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public JButton getShowButton() {
		return showButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}

	public JRadioButton getMascRadioButton() {
		return mascRadioButton;
	}

	public JRadioButton getFemRadioButton() {
		return femRadioButton;
	}

	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public JLabel getSenhaLabel() {
		return senhaLabel;
	}

	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	public JLabel getCpfLabel() {
		return cpfLabel;
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}


	public JTextField getLoginField() {
		return loginField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}


	public JPasswordField getSenhaField() {
		return senhaField;
	}

	public JPanel getPanel() {
		return panel;
	}
	
	
	
}
