package Empresa;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

public class CadastrarEmpresaAtendente extends JFrame
{
	
	private ResourceBundle bn = null;
	Empresa empresa;
	Connection conn = null;
	
	
	public CadastrarEmpresaAtendente()
	{
		setTitle("Cadastrar Empresa - Atendente");
		
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
		c.add(lNome);
		c.add(tNome);
		JLabel lCnpj = new JLabel("CNPJ");
		JTextField tCnpj = new JTextField(10);
		c.add(lCnpj);
		c.add(tCnpj);
		JLabel lRazaoSocial = new JLabel("Razao Social");
		JTextField tRazaoSocial = new JTextField(10);
		c.add(lRazaoSocial);
		c.add(tRazaoSocial);
		JLabel lConjunto = new JLabel("Conjuto");
		JTextField tConjunto = new JTextField(10);
		c.add(lConjunto);
		c.add(tConjunto);
		JLabel lFuncionalidade = new JLabel("Funcionalidade");
		c.add(lFuncionalidade);
		JLabel lHorarioAbertura = new JLabel("Horario Abetura");
		JTextField tHorarioAbertura = new JTextField(10);
		c.add(lHorarioAbertura);
		c.add(tHorarioAbertura);
		JLabel lTemperaturaMin = new JLabel("Temperatura Min");
		JTextField tTemperaturaMin = new JTextField(10);
		c.add(lTemperaturaMin);
		c.add(tTemperaturaMin);
		JLabel lHorarioEncerramento = new JLabel("Horario Encerramento");
		JTextField tHorarioEncerramento = new JTextField(10);
		c.add(lHorarioEncerramento);
		c.add(tHorarioEncerramento);
		JLabel lTemperaturaMax = new JLabel("Temperatura Max");
		JTextField tTemperaturaMax = new JTextField(10);
		c.add(lTemperaturaMax);
		c.add(tTemperaturaMax);
		JLabel lHorarioLigado = new JLabel("Horario Ar Ligado");
		JTextField tHorarioLigado = new JTextField(10);
		c.add(lHorarioLigado);
		c.add(tHorarioLigado);
		JLabel lHorarioDesligado = new JLabel("Horario Ar Desligado");
		JTextField tHorarioDesligado = new JTextField(10);
		c.add(lHorarioDesligado);
		c.add(tHorarioDesligado);
		JButton bCadastrar = new JButton("Cadastrar");
		JButton bLimpar = new JButton("Limpar");
		JButton bCancelar = new JButton("Cancelar");
		JLabel vazio = new JLabel("");
		c.add(vazio);
		c.add(bCadastrar);
		c.add(bLimpar);
		c.add(bCancelar);
		
		
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	
		
		bCadastrar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	Empresa empresa = new Empresa(); 
		            	empresa.setNomeEmpresa(tNome.getText());
		            	empresa.setCNPJ(tCnpj.getText());
		            	empresa.setRazaoSocial(tRazaoSocial.getText());
		            	empresa.setConjuntoNR(Integer.parseInt(tConjunto.getText()));
		            	empresa.setHorarioEntrada(tHorarioAbertura.getText());
		            	empresa.setHorarioEncerramento(tHorarioEncerramento.getText());
		            	empresa.setTemperaturaMin(Integer.parseInt(tTemperaturaMin.getText()));
		            	empresa.setTemperaturaMax(Integer.parseInt(tTemperaturaMax.getText()));
		            	empresa.setArLigar(tHorarioLigado.getText());
		            	empresa.setArDesligar(tHorarioDesligado.getText());
			            EmpresaDAO empresad = new EmpresaDAO(); 
			            empresad.adiciona(empresa);
			            JOptionPane.showMessageDialog(null, "Empresa "+tNome.getText()+" foi cadastrada com sucesso !! ");
						tNome.setText("");
						tCnpj.setText("");
						tRazaoSocial.setText("");
						tConjunto.setText("");
						tHorarioAbertura.setText("");
						tHorarioEncerramento.setText("");
						tTemperaturaMin.setText("");
						tTemperaturaMax.setText("");
						tHorarioLigado.setText("");
						tHorarioDesligado.setText("");
		            }
		         }
		         );
		
		bLimpar.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	tNome.setText("");
						tCnpj.setText("");
						tRazaoSocial.setText("");
						tConjunto.setText("");
						tHorarioAbertura.setText("");
						tHorarioEncerramento.setText("");
						tTemperaturaMin.setText("");
						tTemperaturaMax.setText("");
						tHorarioLigado.setText("");
						tHorarioDesligado.setText("");
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
                        setTitle(bn.getString("CadastrarEmpresa"));
		    			
		    			lNome.setText(bn.getString("Nome"));

		    			lRazaoSocial.setText(bn.getString("RazaoSocial"));
		    			
		    			lConjunto.setText(bn.getString("Conjunto"));
		    			
		    			lFuncionalidade.setText(bn.getString("Funcionalidade"));
		    			
		    			lHorarioAbertura.setText(bn.getString("HorarioAbertura"));
		    			
		    			lTemperaturaMin.setText(bn.getString("TemperaturaMin"));
		    			
		    			lHorarioEncerramento.setText(bn.getString("HorarioEncerramento"));
		    			
		    			lTemperaturaMax.setText(bn.getString("TemperaturaMax"));
		    			
		    			lHorarioLigado.setText(bn.getString("HorarioArLigado"));
		    			
		    			lHorarioDesligado.setText(bn.getString("HorarioArDesligado"));
		    			
		    			bCadastrar.setText(bn.getString("Cadastrar"));
		    			
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
                        ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP")); 	
		    			portugues.setText(bn.getString("Portugues"));
		    			
                        setTitle(bn.getString("CadastrarEmpresa"));
		    			
		    			lNome.setText(bn.getString("Nome"));

		    			lRazaoSocial.setText(bn.getString("RazaoSocial"));
		    			
		    			lConjunto.setText(bn.getString("Conjunto"));
		    			
		    			lFuncionalidade.setText(bn.getString("Funcionalidade"));
		    			
		    			lHorarioAbertura.setText(bn.getString("HorarioAbertura"));
		    			
		    			lTemperaturaMin.setText(bn.getString("TemperaturaMin"));
		    			
		    			lHorarioEncerramento.setText(bn.getString("HorarioEncerramento"));
		    			
		    			lTemperaturaMax.setText(bn.getString("TemperaturaMax"));
		    			
		    			lHorarioLigado.setText(bn.getString("HorarioArLigado"));
		    			
		    			lHorarioDesligado.setText(bn.getString("HorarioArDesligado"));
		    			
		    			bCadastrar.setText(bn.getString("Cadastrar"));
		    			
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
		            	ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP")); 	
		    			portugues.setText(bn.getString("Portugues"));
                        setTitle(bn.getString("CadastrarEmpresa"));
		    			
		    			lNome.setText(bn.getString("Nome"));

		    			lRazaoSocial.setText(bn.getString("RazaoSocial"));
		    			
		    			lConjunto.setText(bn.getString("Conjunto"));
		    			
		    			lFuncionalidade.setText(bn.getString("Funcionalidade"));
		    			
		    			lHorarioAbertura.setText(bn.getString("HorarioAbertura"));
		    			
		    			lTemperaturaMin.setText(bn.getString("TemperaturaMin"));
		    			
		    			lHorarioEncerramento.setText(bn.getString("HorarioEncerramento"));
		    			
		    			lTemperaturaMax.setText(bn.getString("TemperaturaMax"));
		    			
		    			lHorarioLigado.setText(bn.getString("HorarioArLigado"));
		    			
		    			lHorarioDesligado.setText(bn.getString("HorarioArDesligado"));
		    			
		    			bCadastrar.setText(bn.getString("Cadastrar"));
		    			
		    			bLimpar.setText(bn.getString("Limpar"));
		    			
		    			bCancelar.setText(bn.getString("Cancelar"));
		            }
		         }
		         );
		
	}
	
}
