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

import Empresa.AlterarEmpresaAtendente;
import Empresa.CadastrarEmpresaAtendente;
import Empresa.ConsultarEmpresaAtendente;
import Empresa.ExcluirEmpresaAtendente;
import Funcionalidades.AcessoRegistro;
import Funcionalidades.EfetuarLogin;
import Funcionalidades.EnviarArquivoAtendente;
import Funcionalidades.EnviarConfiTemperatura;
import Funcionalidades.MedirTemperaturaAtendente;
import Funcionalidades.MedirTemperaturaFuncionario;



public class IniciadorAtendente extends JFrame
{
	private ResourceBundle bn = null;
	
	
	public IniciadorAtendente()
	{
			setTitle("Painel-Atendente");
		
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
		
		
		JLabel lEmpresa = new JLabel("Empresa");
		JButton bAlterarEmpresa = new JButton("Alterar Empresa");
		JButton bCadastrarEmpresa = new JButton("Cadastrar Empresa");
		JButton bConsultarEmpresa = new JButton("Consultar Empresa");
		JButton bExcluirEmpresa = new JButton("Excluir Empresa");
		JLabel lUsuario = new JLabel("Usuario");
		JButton bAlterarUsuario = new JButton("Alterar Usuario");
		JButton bCadastrarUsuario = new JButton("Cadastrar Usuario");
		JButton bConsultarUsuario = new JButton("Consultar Usuario");
		JButton bExcluirUsuario = new JButton("Excluir Usuario");
		JLabel lFuncionalidade = new JLabel("Funcionalidades");
		JButton bEnviarConfiTemperatura = new JButton("Enviar Configuração Temperatura");
		JButton bLoginCatraca = new JButton("Login Catraca");
		JButton bMedirTemperatura = new JButton("Medir Temperatura");
		JButton bEnviarArquivo = new JButton("Enviar Arquivo");
		
		
		
		
		c.add(lEmpresa);
		c.add(bAlterarEmpresa);
		c.add(bCadastrarEmpresa);
		c.add(bConsultarEmpresa);
		c.add(bExcluirEmpresa);
		c.add(lUsuario);
		c.add(bAlterarUsuario);
		c.add(bCadastrarUsuario);
		c.add(bConsultarUsuario);
		c.add(bExcluirUsuario);
		c.add(lFuncionalidade);
		c.add(bEnviarConfiTemperatura);
		c.add(bMedirTemperatura);
		c.add(bEnviarArquivo);
		
		setSize(600,600);
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
		    			lEmpresa.setText(bn.getString("Empresa"));
		    			bAlterarEmpresa.setText(bn.getString("AlterarEmpresa"));
		    			bCadastrarEmpresa.setText(bn.getString("CadastrarEmpresa"));
		    			bConsultarEmpresa.setText(bn.getString("ConsultarEmpresa"));
		    		    bExcluirEmpresa.setText(bn.getString("Excluir"));
		    		    lUsuario.setText(bn.getString("Usuario"));
		    			bAlterarUsuario.setText(bn.getString("AlterarUsuario"));
		    			bCadastrarUsuario.setText(bn.getString("CadastrarUsuario"));
		    			bConsultarUsuario.setText(bn.getString("ConsultarUsuario"));
		    			bExcluirUsuario.setText(bn.getString("ExcluirUsuario"));
		    			lFuncionalidade.setText(bn.getString("Funcionalidades"));
		    			bEnviarConfiTemperatura.setText(bn.getString("EnviarConfiguraçãoTemperatura"));
		    			bLoginCatraca.setText(bn.getString("LoginCatraca"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));

		            }
		         }
		         );
		
		
		bEnviarArquivo.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new EnviarArquivoAtendente();
		            	dispose();
		            }
		         }
		         );
		
		bAlterarEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new AlterarEmpresaAtendente();
		            	dispose();
		            }
		         }
		         );
		
		bCadastrarEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new CadastrarEmpresaAtendente();
		            	dispose();
		            }
		         }
		         );
		
		
		
		
		
		bConsultarEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ConsultarEmpresaAtendente();
		            	dispose();
		            }
		         }
		         );
		
		
		bExcluirEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ExcluirEmpresaAtendente();
		            	dispose();
		            }
		         }
		         );
		
		
		
	
		
		
		bCadastrarUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new CadastrarUsuarioFuncionario();
		            	dispose();
		            }
		         }
		         );

		
		bConsultarUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ConsultarUsuarioFuncionario();
		            	dispose();
		            }
		         }
		         );
		
		
		bExcluirUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ExcluirUsuarioFuncionario();
		            	dispose();
		            }
		         }
		         );
		
		
		bAlterarUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new AlterarUsuarioFuncionario();	
		            	dispose();
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
		            	new MedirTemperaturaAtendente();
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
		    			lEmpresa.setText(bn.getString("Empresa"));
		    			bAlterarEmpresa.setText(bn.getString("AlterarEmpresa"));
		    			bCadastrarEmpresa.setText(bn.getString("CadastrarEmpresa"));
		    			bConsultarEmpresa.setText(bn.getString("ConsultarEmpresa"));
		    		    bExcluirEmpresa.setText(bn.getString("Excluir"));
		    		    lUsuario.setText(bn.getString("Usuario"));
		    			bAlterarUsuario.setText(bn.getString("AlterarUsuario"));
		    			bCadastrarUsuario.setText(bn.getString("CadastrarUsuario"));
		    			bConsultarUsuario.setText(bn.getString("ConsultarUsuario"));
		    			bExcluirUsuario.setText(bn.getString("ExcluirUsuario"));
		    			lFuncionalidade.setText(bn.getString("Funcionalidades"));
		    			bEnviarConfiTemperatura.setText(bn.getString("EnviarConfiguraçãoTemperatura"));
		    			bLoginCatraca.setText(bn.getString("LoginCatraca"));
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
		    			lEmpresa.setText(bn.getString("Empresa"));
		    			bAlterarEmpresa.setText(bn.getString("AlterarEmpresa"));
		    			bCadastrarEmpresa.setText(bn.getString("CadastrarEmpresa"));
		    			bConsultarEmpresa.setText(bn.getString("ConsultarEmpresa"));
		    		    bExcluirEmpresa.setText(bn.getString("Excluir"));
		    		    lUsuario.setText(bn.getString("Usuario"));
		    			bAlterarUsuario.setText(bn.getString("AlterarUsuario"));
		    			bCadastrarUsuario.setText(bn.getString("CadastrarUsuario"));
		    			bConsultarUsuario.setText(bn.getString("ConsultarUsuario"));
		    			bExcluirUsuario.setText(bn.getString("ExcluirUsuario"));
		    			lFuncionalidade.setText(bn.getString("Funcionalidades"));
		    			bEnviarConfiTemperatura.setText(bn.getString("EnviarConfiguraçãoTemperatura"));
		    			bLoginCatraca.setText(bn.getString("LoginCatraca"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));
		    			portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
		
		
		
		
		

			
	}

}
