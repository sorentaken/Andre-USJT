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
import Empresa.AlterarEmpresaSindico;
import Empresa.CadastrarEmpresaAtendente;
import Empresa.CadastrarEmpresaSindico;
import Empresa.ConsultarEmpresaAtendente;
import Empresa.ConsultarEmpresaSindico;
import Empresa.ExcluirEmpresaAtendente;
import Empresa.ExcluirEmpresaSindico;
import Funcionalidades.AcessoRegistro;
import Funcionalidades.EfetuarLogin;
import Funcionalidades.EnviarArquivoSindico;
import Funcionalidades.EnviarConfiTemperatura;
import Funcionalidades.MedirTemperaturaSindico;


public class IniciadorSindico extends JFrame
{
	private ResourceBundle bn = null;
	
	
	
	public IniciadorSindico()
	{
			setTitle("Painel-Sindico");
		
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
		JButton bAlterarEmpresa = new JButton("Alterar 	Empresa");
		JButton bCadastrarEmpresa = new JButton("Cadastrar Empresa");
		JButton bConsultarEmpresa = new JButton("Consultar Empresa");
		JButton bExcluirEmpresa = new JButton("Excluir Empresa");
		JLabel lUsuario = new JLabel("Usuario");
		JButton bAlterarUsuario = new JButton("Alterar Usuario");
		JButton bCadastrarUsuario = new JButton("Cadastrar Usuario");
		JButton bConsultarUsuario = new JButton("Consultar Usuario");
		JButton bExcluirUsuario = new JButton("Excluir Usuario");
		JLabel lFuncionalidade = new JLabel("Funcionalidades");
		JButton bLoginCatraca = new JButton("Login Catraca");
		JButton bMedirTemperatura = new JButton("Medir Temperatura");
		JButton bAcessoRegistro = new JButton("Acessar Registros");
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
		c.add(bMedirTemperatura);
		c.add(bAcessoRegistro);
		c.add(bEnviarArquivo);
		
		setSize(600,600);
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
		    			bLoginCatraca.setText(bn.getString("LoginCatraca"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));
		    			bAcessoRegistro.setText(bn.getString("AcessarRegistros"));
		    			

		            }
		         }
		         );
		
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
		
		
		
		bAlterarEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new AlterarEmpresaSindico();
		            	dispose();
		            }
		         }
		         );
		
		bEnviarArquivo.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new EnviarArquivoSindico();
		            	dispose();
		            }
		         }
		         );
		
		bCadastrarEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new CadastrarEmpresaSindico();
		            	dispose();
		            }
		         }
		         );
		
		
		
		bConsultarEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ConsultarEmpresaSindico();
		            	dispose();
		            }
		         }
		         );
		
		
		bExcluirEmpresa.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ExcluirEmpresaSindico();
		            	dispose();
		            }
		         }
		         );
		
		
		bCadastrarUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new IniciadorCadastroSindico();
		            	dispose();
		            }
		         }
		         );
		
		
		bConsultarUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ConsultarUsuarioAtendente();
		            	dispose();
		            }
		         }
		         );
		
		
		bExcluirUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new ExcluirUsuarioAtendente();
		            	dispose();
		            }
		         }
		         );
		
		
		bAlterarUsuario.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new AlterarUsuarioAtendente();
		            	dispose();
		            }
		         }
		         );
		
		
		
		bAcessoRegistro.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new AcessoRegistro();
		            	dispose();
		            }
		         }
		         );
		

		


		
		
		bMedirTemperatura.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	new MedirTemperaturaSindico();
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
		    			bLoginCatraca.setText(bn.getString("LoginCatraca"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));
		    			bAcessoRegistro.setText(bn.getString("AcessarRegistros"));
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
		    			bLoginCatraca.setText(bn.getString("LoginCatraca"));
		    			bMedirTemperatura.setText(bn.getString("MedirTemperatura"));
		    			bAcessoRegistro.setText(bn.getString("AcessarRegistros"));
		    			portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
		
		
		
		
	}

			
	

}
