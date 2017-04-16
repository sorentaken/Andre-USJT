package Empresa;

	import java.awt.Container;
	import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import ConexaoBanco.EmpresaDAO;
import Entidades.Empresa;
import Usuario.IniciadorAtendente;
import Usuario.IniciadorFuncionario;

	public class ExcluirEmpresaAtendente extends JFrame
	{
		
		private ResourceBundle bn = null;
		
		
		public ExcluirEmpresaAtendente()
		{
			
			setTitle("Excluir Empresa - Atendente");
			
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
			
			JLabel lNome = new JLabel("Nome");
			JTextField tNome = new JTextField(10);
			JLabel lCNPJ = new JLabel("CNPJ");
			JTextField tCNPJ = new JTextField(10);
			JLabel lRazaoSocial = new JLabel("Razao Social");
			JTextField tRazaoSocial = new JTextField(10);
			JButton bExcluir= new JButton("Excluir");
			JButton bLimpar= new JButton("Limpar");
			JButton bCancelar= new JButton("Cancelar");
			
			c.add(lNome);
			c.add(tNome);
			JLabel vazio = new JLabel("");
			c.add(vazio);
			c.add(bExcluir);
			c.add(bLimpar);
			c.add(bCancelar);
			
			
			
			
			setSize(300,200);
			setLocationRelativeTo(null);
			setVisible(true);
			
			
			bExcluir.addActionListener(
			         new ActionListener()
			         {
			            public void actionPerformed( ActionEvent evento )
			            {
			            	Empresa empresa = new Empresa(); 
			            	empresa.setNomeEmpresa(tNome.getText());
			            	EmpresaDAO empresad = new EmpresaDAO();
				            empresad.excluir(empresa);
				            JOptionPane.showMessageDialog(null, "Empresa "+tNome.getText()+" foi Excluida com sucesso !! ");
				            tNome.setText("");
			            }
			            
			         }
			         );
			
			bLimpar.addActionListener(
			         new ActionListener()
			         {
			            public void actionPerformed( ActionEvent evento )
			            {
			            	tNome.setText("");
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
			
			
			portugues.addActionListener(
			         new ActionListener()
			         {
			            public void actionPerformed( ActionEvent evento )
			            {
			            	bn = ResourceBundle.getBundle("ex2", new Locale("ex2","ex2"));
	                      ingles.setText(bn.getString("USA"));    			
			    			espanhol.setText(bn.getString("ESP"));
			    			portugues.setText(bn.getString("Portugues"));
			    			setTitle(bn.getString("ExcluirEmpresa"));
			            	lNome.setText(bn.getString("Nome"));
			    			lRazaoSocial.setText(bn.getString("RazaoSocial"));
	                        ingles.setText(bn.getString("USA"));
			    			espanhol.setText(bn.getString("ESP"));
			    			bExcluir.setText(bn.getString("Excluir"));
			    			bLimpar.setText(bn.getString("Limpar"));
			    			bCancelar.setText(bn.getString("Cancelar"));

			            }
			         }
			         );
			
			ingles.addActionListener(
			         new ActionListener()
			         {
			            public void actionPerformed( ActionEvent evento )
			            {
			            	bn = ResourceBundle.getBundle("ex", new Locale("ex","ex"));
			            	portugues.setText(bn.getString("Portugues"));
			            	setTitle(bn.getString("ExcluirEmpresa"));
			            	lNome.setText(bn.getString("Nome"));
			    			lRazaoSocial.setText(bn.getString("RazaoSocial"));
	                        ingles.setText(bn.getString("USA"));
			    			espanhol.setText(bn.getString("ESP"));
			    			bExcluir.setText(bn.getString("Excluir"));
			    			bLimpar.setText(bn.getString("Limpar"));
			    			bCancelar.setText(bn.getString("Cancelar"));
			            }
			         }	
			         );
			
			
			espanhol.addActionListener(
			         new ActionListener()
			         {
			            public void actionPerformed( ActionEvent evento )
			            {
			            	bn = ResourceBundle.getBundle("ex1", new Locale("ex1","ex1"));
			            	setTitle(bn.getString("ExcluirEmpresa"));
			            	portugues.setText(bn.getString("Portugues"));
			            	lNome.setText(bn.getString("Nome"));
			    			lRazaoSocial.setText(bn.getString("RazaoSocial"));
	                        ingles.setText(bn.getString("USA"));
			    			espanhol.setText(bn.getString("ESP"));
			    			bExcluir.setText(bn.getString("Excluir"));
			    			bLimpar.setText(bn.getString("Limpar"));
			    			bCancelar.setText(bn.getString("Cancelar"));
			            }
			         }
			         );
			
		}
	}
		
	
	

