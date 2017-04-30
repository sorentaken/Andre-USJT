package Usuario;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class IniciadorCadastroSindico extends JFrame
{
	private ResourceBundle bn = null;
	
	
	
	public IniciadorCadastroSindico()
	{
			setTitle("Cadastro usuario");
		
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
		
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(0,1));
		
		


		JButton bCancelar = new JButton("Cancelar");
		JButton bCadastrarAtendente = new JButton("Cadastrar Atendente");
		JButton bCadastrarFuncionario = new JButton("Cadastrar Funcionario");
		

		
		
		

		c.add(bCadastrarFuncionario);
		c.add(bCadastrarAtendente);
		c.add(bCancelar);
	
		
		setSize(300,250);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		portugues.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	bn = ResourceBundle.getBundle("ex2", new Locale("ex2","ex2"));
                     ingles.setText(bn.getString("USA"));    			
		    			espanhol.setText(bn.getString("ESP"));
		    			portugues.setText(bn.getString("Portugues"));
		    			bCadastrarAtendente.setText(bn.getString("CadastrarUsuario"));
		    			bCadastrarFuncionario.setText(bn.getString("CadastrarFuncionario"));
		            }
		         }
		         );

		
		
		bCadastrarFuncionario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new CadastrarUsuarioFuncionario2();
		            	dispose();
		            }
		         }
		         );
		
		
		
		bCadastrarAtendente.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new CadastrarUsuarioAtendente();
		            	dispose();
		            }
		         }
		         );
		
		
		bCancelar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new IniciadorSindico();
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
		    			portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
		
		
		
		
	}

			
	

}
