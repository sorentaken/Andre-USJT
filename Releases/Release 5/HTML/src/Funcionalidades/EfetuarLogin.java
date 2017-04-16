package Funcionalidades;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexaoBanco.UsuarioDAO;
import Entidades.Usuario;
import Usuario.IniciadorAtendente;
import Usuario.IniciadorFuncionario;
import Usuario.IniciadorSindico;

public class EfetuarLogin extends JFrame {
	private Usuario usuario;
	private JLabel lLogin, lSenha , lTipo;
	private JTextField tLogin, tSenha;
	private JButton bEntrar, bCancelar, bLimpar;
	private ResourceBundle bn = null;
	byte[] bMsgCifrada = null;
	byte[] bMsgDecifrada = null;
	byte[] chavemsg = null;
	String chavesms = null;
	String sMsgCifrada = null;
	String sMsgDecifrada = null;
	File fChave = new File("Chave.txt");
	File fCriptografia = new File("Criptografado.txt");
	File cript = new File("SenhaArmazenada.txt");
	byte[] byt = new byte[(int) fChave.length()];
	byte[] bytes = new byte[(int) fCriptografia.length()];
	byte[] by = new byte[(int) cript.length()];

	public EfetuarLogin() {

		setTitle("Login");
		Container c = getContentPane();
		c.setLayout(new GridLayout(0,1));

		JMenu menu = new JMenu("Menu");
		JMenuItem espanhol = new JMenuItem("ESP");
		menu.add(espanhol);
		JMenuItem ingles = new JMenuItem("USA");
		menu.add(ingles);
		JMenuItem portugues = new JMenuItem("Portugues");
		menu.add(portugues);
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(menu);

		
		
		
		
		lLogin = new JLabel("Login");
		tLogin = new JTextField(10);
		lSenha = new JLabel("Senha");
		tSenha = new JTextField(10);

		
		
		
		bEntrar = new JButton("Entrar");
		bCancelar = new JButton("Cancelar");
		bLimpar = new JButton("Limpar");

		c.add(lLogin);
		c.add(tLogin);
		c.add(lSenha);
		c.add(tSenha);
		JLabel vazio = new JLabel("");
		c.add(vazio);
		c.add(bEntrar);
		c.add(bCancelar);
		c.add(bLimpar);

		setSize(250, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
			
				new EfetuarCatraca();
				dispose();

			}
		});
		
		bLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
			
				tLogin.setText("");
				tSenha.setText("");

			}
		});
		
		

		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento)
			{
				boolean resultado = false;
				Usuario usuario = new Usuario(); 
				UsuarioDAO us = new UsuarioDAO();

			    try {
			    	if(tLogin.getText().equals("") && tSenha.getText().equals(""))
			    	{
			    		JOptionPane.showMessageDialog(null, "Dados invalidos");
			    	}
					resultado = us.validarLogin(tLogin.getText() , tSenha.getText());
				} 
			    catch (SQLException e)
			    {
			    	
					e.printStackTrace();
				}
	            if(resultado == true)
	            {
			//Começo do segundo if
			       if(UsuarioLogado.usuarioLogado.getTipo().equals("Funcionario"))
			       {
					new IniciadorFuncionario();
					dispose();
					}
					if(UsuarioLogado.usuarioLogado.getTipo().equals("Atendente"))
					{
					new IniciadorAtendente();
					dispose();
					}
					if(UsuarioLogado.usuarioLogado.getTipo().equals("Sindico"))
					{
					new IniciadorSindico();
					dispose();
					}
					//fim do primeiro if
	            }
			//Fim do segundo if
			}
		});

		portugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex2", new Locale("ex2", "ex2"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				portugues.setText(bn.getString("Portugues"));
				;
				lLogin.setText(bn.getString("Login"));
				lSenha.setText(bn.getString("Senha"));
				bEntrar.setText(bn.getString("Entrar"));
				bCancelar.setText(bn.getString("Cancelar"));
				bLimpar.setText(bn.getString("Limpar"));

			}
		});

		ingles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex", new Locale("ex", "ex"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				lLogin.setText(bn.getString("Login"));
				lSenha.setText(bn.getString("Senha"));
				bEntrar.setText(bn.getString("Entrar"));
				bCancelar.setText(bn.getString("Cancelar"));
				bLimpar.setText(bn.getString("Limpar"));
				portugues.setText(bn.getString("Portugues"));
			}
		});

		espanhol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex1", new Locale("ex1", "ex1"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				lLogin.setText(bn.getString("Login"));
				lSenha.setText(bn.getString("Senha"));
				bEntrar.setText(bn.getString("Entrar"));
				bCancelar.setText(bn.getString("Cancelar"));
				bLimpar.setText(bn.getString("Limpar"));
				portugues.setText(bn.getString("Portugues"));
			}
		});

	}

}
