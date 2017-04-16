package Empresa;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import ConexaoBanco.EmpresaDAO;
import Entidades.Empresa;
import Usuario.IniciadorAtendente;

public class AlterarEmpresaAtendente extends JFrame {

	private ResourceBundle bn = null;

	public AlterarEmpresaAtendente()
	{
		setTitle("Alterar Empresa - Atendente");

		Container c = getContentPane();
		c.setLayout(new GridLayout(0, 1));

		JLabel lBusca = new JLabel("Buscar");
		JTextField tBusca = new JTextField(10);
		JLabel lNome = new JLabel("Nome");
		JTextField tNome = new JTextField(10);
		JLabel lCnpj = new JLabel("CNPJ");
		JTextField tCnpj = new JTextField(10);
		JLabel lRazaoSocial = new JLabel("Razao Social");
		JTextField tRazaoSocial = new JTextField(10);
		JLabel lConjunto = new JLabel("Conjuto");
		JTextField tConjunto = new JTextField(10);
		JLabel lFuncionalidade = new JLabel("Funcionalidade");
		JLabel lHorarioAbertura = new JLabel("Horario Abetura");
		JTextField tHorarioAbertura = new JTextField(10);
		JLabel lTemperaturaMin = new JLabel("Temperatura Min");
		JTextField tTemperaturaMin = new JTextField(10);
		JLabel lHorarioEncerramento = new JLabel("Horario Encerramento");
		JTextField tHorarioEncerramento = new JTextField(10);
		JLabel lTemperaturaMax = new JLabel("Temperatura Max");
		JTextField tTemperaturaMax = new JTextField(10);
		JLabel lHorarioLigado = new JLabel("Horario Ar Ligado");
		JTextField tHorarioLigado = new JTextField(10);
		JLabel lHorarioDesligado = new JLabel("Horario Ar Desligado");
		JTextField tHorarioDesligado = new JTextField(10);
		JButton bAlterar = new JButton("Alterar");
		JButton bLimpar = new JButton("Limpar");
		JButton bCancelar = new JButton("Cancelar");

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

		c.add(lBusca);
		c.add(tBusca);
		c.add(lNome);
		c.add(tNome);
		c.add(lCnpj);
		c.add(tCnpj);
		c.add(lRazaoSocial);
		c.add(tRazaoSocial);
		c.add(lConjunto);
		c.add(tConjunto);
		c.add(lFuncionalidade);
		c.add(lHorarioAbertura);
		c.add(tHorarioAbertura);
		c.add(lTemperaturaMin);
		c.add(tTemperaturaMin);
		c.add(lHorarioEncerramento);
		c.add(tHorarioEncerramento);
		c.add(lTemperaturaMax);
		c.add(tTemperaturaMax);
		c.add(lHorarioLigado);
		c.add(tHorarioLigado);
		c.add(lHorarioDesligado);
		c.add(tHorarioDesligado);
		JLabel vazio = new JLabel("");
		c.add(vazio);
		c.add(bAlterar);
		c.add(bLimpar);
		c.add(bCancelar);
		
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		bLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				tBusca.setText("");
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
		});
		
		
		bAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				
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
	            try {
					empresad.altera(empresa , tBusca.getText());
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	            JOptionPane.showMessageDialog(null, "Empresa "+tNome.getText()+" foi alterada com sucesso !! ");
	            tBusca.setText("");
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
		});

		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new IniciadorAtendente();
				dispose();
			}
		});

		portugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex2", new Locale("ex2", "ex2"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				portugues.setText(bn.getString("Portugues"));
				setTitle(bn.getString("AlterarEmpresa"));

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

				bAlterar.setText(bn.getString("Alterar"));

				bLimpar.setText(bn.getString("Limpar"));

				bCancelar.setText(bn.getString("Cancelar"));

			}
		});

		ingles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex", new Locale("ex", "ex"));
				ingles.setText(bn.getString("USA"));

				espanhol.setText(bn.getString("ESP"));
				portugues.setText(bn.getString("Portugues"));

				setTitle(bn.getString("AlterarEmpresa"));

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

				bAlterar.setText(bn.getString("Alterar"));

				bLimpar.setText(bn.getString("Limpar"));

				bCancelar.setText(bn.getString("Cancelar"));

			}
		});

		espanhol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex1", new Locale("ex1", "ex1"));
				ingles.setText(bn.getString("USA"));
				portugues.setText(bn.getString("Portugues"));

				espanhol.setText(bn.getString("ESP"));

				setTitle(bn.getString("AlterarEmpresa"));

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

				bAlterar.setText(bn.getString("Alterar"));

				bLimpar.setText(bn.getString("Limpar"));

				bCancelar.setText(bn.getString("Cancelar"));
				bn = ResourceBundle.getBundle("ex1", new Locale("ex1", "ex1"));
				ingles.setText(bn.getString("USA"));

				espanhol.setText(bn.getString("ESP"));

			}
		});

	}

}
