package Funcionalidades;

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
import javax.swing.JTable;

import Usuario.IniciadorSindico;

public class AcessoRegistro extends JFrame
{
	
	private ResourceBundle bn = null;

	public AcessoRegistro() {

		setTitle("AcessoRegistro");

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

		String[] columnNames = { "Nome", "Horario", "Sport", "# of Years" };

		Object[][] data = { 
				{ "Nome", "Entrada", "Saida", "Data" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" } };

		JTable table = new JTable(data, columnNames);

		JButton bCancelar = new JButton("Cancelar");

		c.add(table);
		c.add(bCancelar);

		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);

		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new IniciadorSindico();
				dispose();
			}
		});

		portugues.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	bn = ResourceBundle.getBundle("ex2", new Locale("ex2","ex2"));
                     ingles.setText(bn.getString("USA"));    			
		    			espanhol.setText(bn.getString("ESP"));
		    			portugues.setText(bn.getString("Portugues"));
		    			bCancelar.setText(bn.getString("Cancelar"));
		    			setTitle(bn.getString("AcessoRegistro"));

		            }
		         }
		         );
		
		ingles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex", new Locale("ex", "ex"));
				setTitle(bn.getString("AcessoRegistro"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				bCancelar.setText(bn.getString("Cancelar"));
				portugues.setText(bn.getString("Portugues"));

			}
		});

		espanhol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				bn = ResourceBundle.getBundle("ex1", new Locale("ex1", "ex1"));
				setTitle(bn.getString("AcessoRegistro"));
				ingles.setText(bn.getString("USA"));
				espanhol.setText(bn.getString("ESP"));
				bCancelar.setText(bn.getString("Cancelar"));
				portugues.setText(bn.getString("Portugues"));
			}
		});

	}

}
