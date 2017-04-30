package Usuario;

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

import Funcionalidades.EfetuarLogin;
import Funcionalidades.EnviarConfiTemperatura;
import Funcionalidades.MedirTemperaturaFuncionario;



public class IniciadorFuncionario extends JFrame
{
	private ResourceBundle bn = null;
	
	
	public IniciadorFuncionario()
	{
			setTitle("Painel-Funcionario");
		
			JMenu menu = new JMenu("Menu");
			JMenuItem espanhol = new JMenuItem("ESP");
			menu.add(espanhol);
			JMenuItem ingles = new JMenuItem("USA");
			menu.add(ingles);
			JMenuItem portugues = new JMenuItem("ESP");
			menu.add(portugues);
			JMenuItem logar = new JMenuItem("Logar");
			menu.add(logar);
			JMenuBar bar = new JMenuBar();
		    setJMenuBar(bar);
		    bar.add(menu);
		
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(0,1));
		
		

		JLabel lFuncionalidade = new JLabel("Funcionalidades");
		JButton bEnviarConfiTemperatura = new JButton("Enviar Configuração Temperatura");
		JButton bMedirTemperatura = new JButton("Medir Temperatura");
		

		c.add(lFuncionalidade);
		c.add(bEnviarConfiTemperatura);
		c.add(bMedirTemperatura);
		
		setSize(300,175);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		logar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new EfetuarLogin();
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
		    			lFuncionalidade.setText(bn.getString("Funcionalidades"));
		    			bEnviarConfiTemperatura.setText(bn.getString("EnviarConfiguraçãoTemperatura"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));

		            }
		         }
		         );
			
		
		bEnviarConfiTemperatura.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new EnviarConfiTemperatura();
		            	dispose();
		            }
		         }
		         );

		bMedirTemperatura.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new MedirTemperaturaFuncionario();
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
		    			lFuncionalidade.setText(bn.getString("Funcionalidades"));
		    			bEnviarConfiTemperatura.setText(bn.getString("EnviarConfiguraçãoTemperatura"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));
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
		    			lFuncionalidade.setText(bn.getString("Funcionalidades"));
		    			bEnviarConfiTemperatura.setText(bn.getString("EnviarConfiguraçãoTemperatura"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));
		    			portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
		
		
		
		
		

			
	}

}
