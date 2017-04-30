package Funcionalidades;

import java.awt.Container;
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
import javax.swing.JTextField;

import Usuario.IniciadorFuncionario;

public class EnviarConfiTemperatura extends JFrame
{
	
	private ResourceBundle bn = null;
	
	public EnviarConfiTemperatura()
	{
		
		setTitle("Enviar Configuração Temperatura");
		
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
		JLabel lNConjunto = new JLabel("Numero Conjunto");
		JTextField tNConjunto = new JTextField(10);
		JButton buscar = new JButton("Buscar");
		JButton limpar = new JButton("Limpar");
		JButton bCancelar = new JButton("Cancelar");
		
		c.add(lNome);
		c.add(tNome);
		c.add(lNConjunto);
		c.add(tNConjunto);
		c.add(buscar);
		c.add(limpar);
		c.add(bCancelar);
		
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		bCancelar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new IniciadorFuncionario();
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
		            	setTitle(bn.getString("EnviarConfiguraçãoTemperatura"));
		    			lNome.setText(bn.getString("Nome"));
		    			lNConjunto.setText(bn.getString("NumeroConjunto"));
		    			buscar.setText(bn.getString("Buscar"));
		    			limpar.setText(bn.getString("Limpar"));
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
		            	setTitle(bn.getString("EnviarConfiguraçãoTemperatura"));
                        ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP"));
		    			lNome.setText(bn.getString("Nome"));
		    			lNConjunto.setText(bn.getString("NumeroConjunto"));
		    			buscar.setText(bn.getString("Buscar"));
		    			limpar.setText(bn.getString("Limpar"));
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
		            	setTitle(bn.getString("EnviarConfiguraçãoTemperatura"));
                        ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP"));
		    			lNome.setText(bn.getString("Nome"));
		    			lNConjunto.setText(bn.getString("NumeroConjunto"));
		    			buscar.setText(bn.getString("Buscar"));
		    			limpar.setText(bn.getString("Limpar"));
		    			bCancelar.setText(bn.getString("Cancelar"));
		    			portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
		
	}
	
	
	
	
	
	
	
	
}
