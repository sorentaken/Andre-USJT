package Funcionalidades;

import javax.swing.*;

import ConexaoBanco.UsuarioDAO;
import Entidades.Usuario;
import Usuario.IniciadorAtendente;
import Usuario.IniciadorFuncionario;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

public class EnviarArquivoAtendente extends JFrame
{
	
	private ResourceBundle bn = null;
	
	public EnviarArquivoAtendente()
	{
		setTitle("Enviar Arquivo Texto - Atendente");
		
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
		
		
		JLabel lIndentificacaoA = new JLabel("Indentificaçao Acesso");
		JTextField tIndentificacaoA = new JTextField(10);
		JLabel lHorarioDeEntrada = new JLabel("Horario Entrada");
		JTextField tHorarioDeEntrada = new JTextField(10);
		JLabel lHorarioDeSaida = new JLabel("Horario Saida");
		JTextField tHorarioDeSaida = new JTextField(10);
	    JLabel lSenha = new JLabel("Senha");
	    JTextField tSenha = new JTextField(10);
	    JButton enviar = new JButton("Enviar");
	    JButton limpar = new JButton("Limpar");
	    JButton bCancelar = new JButton("Cancelar");
	    
	    
	    c.add(lIndentificacaoA);
	    c.add(tIndentificacaoA);
	    c.add(lHorarioDeEntrada);
	    c.add(tHorarioDeEntrada);
	    c.add(lHorarioDeSaida);
	    c.add(tHorarioDeSaida);
	    c.add(lSenha);
	    c.add(tSenha);
	    c.add(enviar);
	    c.add(limpar);
	    c.add(bCancelar);
	    
	    setSize(600 , 600);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    
	   
		
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
	    
	    enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento)
			{
				boolean resultado = false;
				Usuario usuario = new Usuario(); 
				UsuarioDAO us = new UsuarioDAO();
				GerarArquivoTexto ga = new GerarArquivoTexto();

			    try {
					resultado = us.validarCatraca(tIndentificacaoA.getText(),tHorarioDeEntrada.getText() , tHorarioDeSaida.getText(), tSenha.getText());
				} 
			    catch (SQLException e)
			    {
					e.printStackTrace();
				}
	            if(resultado == true)
	            {
	            	ga.abrirArquivo();
					try {
						ga.adicionarRegistros(tIndentificacaoA.getText(),tSenha.getText() ,tHorarioDeEntrada.getText() , tHorarioDeSaida.getText());
					} catch (IOException e) {
						e.printStackTrace();
					}
					ga.fecharArquivo();
	            }

			}
		});
	    
	    
	    portugues.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	bn = ResourceBundle.getBundle("ex2", new Locale("ex2","ex2"));
                        ingles.setText(bn.getString("USA"));    			
		    			setTitle(bn.getString("EnviarArquivoTexto"));
		    			espanhol.setText(bn.getString("ESP"));
                        lIndentificacaoA.setText(bn.getString("IndentificaçãoAcesso"));
                        lHorarioDeEntrada.setText(bn.getString("HorarioEntrada"));
                        lHorarioDeSaida.setText(bn.getString("HorarioSaida"));
                        lSenha.setText(bn.getString("Senha"));
                        enviar.setText(bn.getString("Enviar"));
                        limpar.setText(bn.getString("Limpar"));
                        bCancelar.setText(bn.getString("Cancelar"));
                        portugues.setText(bn.getString("Portugues"));


		            }
		         }
		         );
	    
	    ingles.addActionListener(
		         new ActionListener()
		         {
		            public void actionPerformed( ActionEvent evento )
		            {
		            	bn = ResourceBundle.getBundle("ex", new Locale("ex","ex"));
		            	setTitle(bn.getString("EnviarArquivoTexto"));
                        ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP"));
                        lIndentificacaoA.setText(bn.getString("IndentificaçãoAcesso"));
                        lHorarioDeEntrada.setText(bn.getString("HorarioEntrada"));
                        lHorarioDeSaida.setText(bn.getString("HorarioSaida"));
                        lSenha.setText(bn.getString("Senha"));
                        enviar.setText(bn.getString("Enviar"));
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
		            	setTitle(bn.getString("EnviarArquivoTexto"));
                        ingles.setText(bn.getString("USA"));
		    			espanhol.setText(bn.getString("ESP"));
                        lIndentificacaoA.setText(bn.getString("IndentificaçãoAcesso"));
                        lHorarioDeEntrada.setText(bn.getString("HorarioEntrada"));
                        lHorarioDeSaida.setText(bn.getString("HorarioSaida"));
                        lSenha.setText(bn.getString("Senha"));
                        enviar.setText(bn.getString("Enviar"));
                        limpar.setText(bn.getString("Limpar"));
                        bCancelar.setText(bn.getString("Cancelar"));
                        portugues.setText(bn.getString("Portugues"));
		            }
		         }
		         );
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
