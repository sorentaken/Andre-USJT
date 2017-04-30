package Funcionalidades;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entidades.Usuario;

public class EfetuarCatraca extends JFrame {
	private Usuario usuario;
	private JLabel  lSenha , lTipo;
	private JTextField tSenha;
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

	public EfetuarCatraca() {

		setTitle("Catraca");
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

		
		
		String[] ac = {"Funcionario" ,"Atendente" ,"Sindico"}; 
		
		lTipo = new JLabel("Tipo");
		JComboBox tipo = new JComboBox(ac);
		lSenha = new JLabel("Senha");
		tSenha = new JTextField(10);

		bEntrar = new JButton("Entrar");
		bCancelar = new JButton("Cancelar");
		bLimpar = new JButton("Limpar");

		c.add(lTipo);
		c.add(tipo);
		c.add(lSenha);
		c.add(tSenha);
		JLabel vazio = new JLabel("");
		c.add(vazio);
		c.add(bEntrar);
		c.add(bLimpar);

		setSize(250, 250);
		setLocationRelativeTo(null);
		setVisible(true);

		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento)
			{
				
				String b = (String) tipo.getSelectedItem();
				
			
				FileReaderTeste fr = new FileReaderTeste();
				boolean cond = false;
				ArrayList<Usuario> usuarios = fr.leArquivo("Senhas.txt");
				Usuario user = new Usuario();
				user.setTipo(b);
				user.setSenha(tSenha.getText());
					
					if(user.contaValido(usuarios, user) == null)
					{
						cond = false;
					}else{
						cond = true;
					};
					
				if(cond == true)
				{
					new EfetuarLogin();
					dispose();
				}					
				
			else{
					JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos");
					tSenha.setText("");
					
				}

			}
		});
		
		
		bLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
			
				
				tSenha.setText("");

			}
		});

		portugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex2", new Locale("ex2", "ex2"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				portugues.setText(bn.getString("Portugues"));
				;
				lSenha.setText(bn.getString("Senha"));
				bEntrar.setText(bn.getString("Entrar"));
				bLimpar.setText(bn.getString("Limpar"));

			}
		});

		ingles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex", new Locale("ex", "ex"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				lSenha.setText(bn.getString("Senha"));
				bEntrar.setText(bn.getString("Entrar"));
				bLimpar.setText(bn.getString("Limpar"));
				portugues.setText(bn.getString("Portugues"));
			}
		});

		espanhol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex1", new Locale("ex1", "ex1"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				lSenha.setText(bn.getString("Senha"));
				bEntrar.setText(bn.getString("Entrar"));
				bLimpar.setText(bn.getString("Limpar"));
				portugues.setText(bn.getString("Portugues"));
			}
		});

	}

}
