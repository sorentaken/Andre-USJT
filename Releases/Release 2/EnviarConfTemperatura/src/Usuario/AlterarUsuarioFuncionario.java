package Usuario;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexaoBanco.UsuarioDAO;
import Entidades.Usuario;






public class AlterarUsuarioFuncionario extends JFrame
{
	
	private ResourceBundle bn = null;
	
	public AlterarUsuarioFuncionario()
	{
		setTitle("Alterar Usuario - Funcionario");
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(0,1));
		
		JMenu menu = new JMenu("Menu");
		JMenuItem espanhol = new JMenuItem("ESP");
		menu.add(espanhol);
		JMenuItem ingles = new JMenuItem("USA");
		menu.add(ingles);
		JMenuItem portugues = new JMenuItem("ESP");
		menu.add(portugues);
		JMenuBar bar = new JMenuBar();
	    setJMenuBar(bar);
	    bar.add(menu);
		
	    JLabel lBusca = new JLabel("Busca");
	    JTextField tBusca = new JTextField(10);
		JLabel lNome = new JLabel("Nome");
		JTextField tNome = new JTextField(10);
		JLabel lRG = new JLabel("RG");
		JTextField tRG = new JTextField(10);
		JLabel lCPF= new JLabel("CPF");
		JTextField tCPF = new JTextField(10);
		JLabel lSexo = new JLabel("Sexo");
		JTextField tSexo = new JTextField(10);
		JLabel lEmpresa = new JLabel("Empresa");
		JLabel lConta = new JLabel("Conta");
		JTextField tConta = new JTextField(10);
		JLabel lSenha = new JLabel("Senha");
		JTextField tSenha = new JTextField(10);
		JLabel lHorarioEntrada = new JLabel("Horario Entrada");
		JTextField tHorarioEntrada = new JTextField(10);
		JLabel lHorarioSaida = new JLabel("Horario Saida");
		JTextField tHorarioSaida = new JTextField(10);
		JLabel acesso1 = new JLabel("Acesso:");
		JLabel a1 = new JLabel("Funcionario");
		 JCheckBox livre = new JCheckBox("Acesso Livre");
		 JCheckBox config = new JCheckBox("Enviar Reconfiguração");
		JButton bAlterar = new JButton("Alterar");
		JButton bLimpar = new JButton("Limpar");
		JButton bCancelar = new JButton("Cancelar");

		c.add(lBusca);
		c.add(tBusca);
        c.add(lNome);
		c.add(tNome);
		c.add(lRG);
		c.add(tRG);
		c.add(lCPF);
		c.add(tCPF);
		c.add(lSexo);
		c.add(tSexo);
		c.add(lEmpresa);
		c.add(lConta);
		c.add(tConta);
		c.add(lSenha);
		c.add(tSenha);
		c.add(lHorarioEntrada);
		c.add(tHorarioEntrada);
		c.add(lHorarioSaida);
		c.add(tHorarioSaida);
		c.add(acesso1);
		c.add(a1);
		c.add(config);
		c.add(livre);
		JLabel vazio = new JLabel("");
		c.add(vazio);
		c.add(bAlterar);
		c.add(bLimpar);
		c.add(bCancelar);
		
		
		
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		livre.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	if(livre.isSelected())
		        		{
		        			tHorarioEntrada.setText("Acesso Livre");
		        			tHorarioSaida.setText("Acesso Livre");
		        			tHorarioEntrada.setEditable(false);
		        			tHorarioSaida.setEditable(false);
		        		}
		            	else
		            	{
		            		tHorarioEntrada.setText("");
		        			tHorarioSaida.setText("");
		        			tHorarioEntrada.setEditable(true);
		        			tHorarioSaida.setEditable(true);
		            	}
		            }
		         }
		         );
		
		bCancelar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	tNome.setText("");
		            	tRG.setText("");
		            	tCPF.setText("");
		            	tSexo.setText("");
		            	tConta.setText("");
		            	tSenha.setText("");
		            	tHorarioEntrada.setText("");
		            	tHorarioSaida.setText("");
		            }
		         }
		         );
		
    	
		
		bAlterar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	Usuario usuario = new Usuario(); 
		            	usuario.setNome(tNome.getText());
		            	usuario.setRg(tRG.getText());
		            	usuario.setCpf(tCPF.getText());
		            	usuario.setSexo(tSexo.getText());
		            	usuario.setConta(tConta.getText());
		            	usuario.setSenha(tSenha.getText());
		            	usuario.setHorarioEntrada(tHorarioEntrada.getText());
		            	usuario.setHorarioSaida(tHorarioSaida.getText());
		            	usuario.setTipo(a1.getText());
			            UsuarioDAO usuariod= new UsuarioDAO(); 
			            try {
							usuariod.altera(usuario,tBusca.getText());
						} catch (SQLException e) {
							e.printStackTrace();
						}
			            JOptionPane.showMessageDialog(null, "Usuario "+tNome.getText()+" foi alterada com sucesso !! ");
			            tNome.setText("");
			        	tRG.setText("");
			        	tCPF.setText("");
			        	tSexo.setText("");
			        	tConta.setText("");
			        	tSenha.setText("");
			        	tHorarioEntrada.setText("");
			        	tHorarioSaida.setText("");
		            }
		         }
		         );
		
		portugues.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	bn = ResourceBundle.getBundle("ex2", new Locale("ex2","ex2"));
                     ingles.setText(bn.getString("USA"));    			
		    			espanhol.setText(bn.getString("ESP"));
		    			portugues.setText(bn.getString("Portugues"));
		    			lNome.setText(bn.getString("Nome"));
		    			lSexo.setText(bn.getString("Sexo"));
		    			lEmpresa.setText(bn.getString("Empresa"));
		    			lConta.setText(bn.getString("Conta"));
		    			lSenha.setText(bn.getString("Senha"));
		    			acesso1.setText(bn.getString("Acesso"));
		    			livre.setText(bn.getString("AcessoLivre"));
		    			bAlterar.setText(bn.getString("Alterar"));
		    			bLimpar.setText(bn.getString("Limpar"));
		    			bCancelar.setText(bn.getString("Cancelar"));

		            }
		         }
		         );
		
		bCancelar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new IniciadorAtendente();
		            	dispose();
		            }
		         }
		         );
		
		ingles.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	bn = ResourceBundle.getBundle("ex", new Locale("ex","ex"));
                        ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP"));
		    			lNome.setText(bn.getString("Nome"));
		    			lSexo.setText(bn.getString("Sexo"));
		    			lEmpresa.setText(bn.getString("Empresa"));
		    			lConta.setText(bn.getString("Conta"));
		    			lSenha.setText(bn.getString("Senha"));
		    			acesso1.setText(bn.getString("Acesso"));
		    			livre.setText(bn.getString("AcessoLivre"));
		    			bAlterar.setText(bn.getString("Alterar"));
		    			bLimpar.setText(bn.getString("Limpar"));
		    			bCancelar.setText(bn.getString("Cancelar"));
		    			portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
		
		espanhol.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	bn = ResourceBundle.getBundle("ex1", new Locale("ex1","ex1"));
		            	ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP"));
		    			lNome.setText(bn.getString("Nome"));
		    			lSexo.setText(bn.getString("Sexo"));
		    			lEmpresa.setText(bn.getString("Empresa"));
		    			lConta.setText(bn.getString("Conta"));
		    			lSenha.setText(bn.getString("Senha"));
		    			acesso1.setText(bn.getString("Acesso"));
		    			livre.setText(bn.getString("AcessoLivre"));
		    			bAlterar.setText(bn.getString("Alterar"));
		    			bLimpar.setText(bn.getString("Limpar"));
		    			bCancelar.setText(bn.getString("Cancelar"));
		    			portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
	}
	
}
