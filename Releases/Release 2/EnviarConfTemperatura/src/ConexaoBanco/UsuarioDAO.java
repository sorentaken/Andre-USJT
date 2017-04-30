package ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Entidades.Usuario;
import Funcionalidades.UsuarioLogado;

public class UsuarioDAO {
	private Connection connection;
	String usuarioNome;
	String usuarioRG;
	String usuarioCPF;
	String usuarioSexo;
	String usuarioConta;
	String usuarioSenha;
	String usuarioHorarioEntrada;
	String usuarioEntradaSaida;
	String usuarioTipo;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	//<Cadastrar - Usuario Funcionario>
	public void adiciona(Usuario usuario)

	{
		String sql = "INSERT INTO usuario(usuarioNome,usuarioRG,usuarioCPF,usuarioSexo,usuarioConta,usuarioSenha,usuarioHorarioEntrada,usuarioHorarioSaida,usuarioTipo) VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getRg());
			stmt.setString(3, usuario.getCpf());
			stmt.setString(4, usuario.getSexo());
			stmt.setString(5, usuario.getConta());
			stmt.setString(6, usuario.getSenha());
			stmt.setString(7, usuario.getHorarioEntrada());
			stmt.setString(8, usuario.getHorarioSaida());
			stmt.setString(9, usuario.getTipo());
			stmt.execute();
			stmt.close();
		} catch (SQLException u)
		{
			JOptionPane.showMessageDialog(null , "Este (CPF ou RG ou CONTA) ja esta sendo utilizado , por favor mude");
			throw new RuntimeException(u);
			
		}
	}


	// Consultar <Usuario - Funcionario>
	public void excluir(Usuario usuario) {
		String sqlDelete = "DELETE FROM usuario WHERE usuarioNome = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sqlDelete);
			stmt.setString(1, usuario.getNome());
			stmt.execute();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	// Consultar <Usuario - Funcionario>
	public String carregar(Usuario usuario) throws SQLException {
		String teste = "";
		String sqlSelect = "SELECT * FROM usuario WHERE usuarioNome = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlSelect);
			stmt = connection.prepareStatement(sqlSelect);
			stmt.setString(1, usuario.getNome());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				usuario.setRg(rs.getString(2));
				usuario.setCpf(rs.getString(3));
				usuario.setSexo(rs.getString(4));
				usuario.setConta(rs.getString(5));
				usuario.setSenha(rs.getString(6));
				usuario.setHorarioEntrada(rs.getString(7));
				usuario.setHorarioSaida(rs.getString(8));
				usuario.setTipo(rs.getString(9));

				teste = "Nome do Usuario:" + usuario.getNome() + "\n" + "CPF:" + usuario.getCpf() + "\n"
						+ "CPF:" + usuario.getRg() + "\n" + "Sexo:" + usuario.getSexo()
						+ "\n" + "Conta:" + usuario.getConta() + "\n" + "Senha"
						+ usuario.getSenha() + "\n" + "Horario Entrada:" + usuario.getHorarioEntrada()
						+ "\n" + "Horario Saida:" + usuario.getHorarioSaida() + "\n" + "Tipo:"
						+ usuario.getTipo() ;
				JOptionPane.showMessageDialog(null, teste);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teste;

	}

	
	public void altera(Usuario usuario, String filtro) throws SQLException {
		String sqlAlterar = "UPDATE usuario SET usuarioNome = ?,usuarioRG = ?,usuarioCPF = ?,usuarioSexo = ?,usuarioConta = ?,usuarioSenha = ?,usuarioHorarioEntrada = ?,usuarioHorarioSaida = ?,usuarioTipo = ? where usuarioNome = ?";
		PreparedStatement stmt = connection.prepareStatement(sqlAlterar);
		

		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getRg());
		stmt.setString(3, usuario.getCpf());
		stmt.setString(4, usuario.getSexo());
		stmt.setString(5, usuario.getConta());
		stmt.setString(6, usuario.getSenha());
		stmt.setString(7, usuario.getHorarioEntrada());
		stmt.setString(8, usuario.getHorarioSaida());
		stmt.setString(9, usuario.getTipo());
		stmt.setString(10 , filtro);
		stmt.execute();
		stmt.close();
	}
	
	public boolean validarLogin(String login , String senha ) throws SQLException {
		
		
		String sqlSelect = "SELECT * from usuario where usuarioConta=? and usuarioSenha=?";
		try {
			Usuario usuario = new Usuario();
			PreparedStatement stmt = connection.prepareStatement(sqlSelect);
			stmt = connection.prepareStatement(sqlSelect);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				usuario.setConta(rs.getString("usuarioConta"));
				usuario.setSenha(rs.getString("usuarioSenha"));
				usuario.setTipo(rs.getString("usuarioTipo"));
				UsuarioLogado.usuarioLogado = usuario;
				return true;

				
			}
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null , "Este (CPF ou RG ou CONTA) ja esta sendo utilizado , por favor mude");
			e.printStackTrace();
			
		}
		return false;
	}
	
public boolean validarCatraca(String acesso , String horarioEntrada , String horarioSaida , String senha) throws SQLException {
		
		
		String sqlSelect = "SELECT * from usuario where usuarioTipo=? and usuarioHorarioEntrada=? and usuarioHorarioSaida=? and usuarioSenha=?";
		try {
			Usuario usuario = new Usuario();
			PreparedStatement stmt = connection.prepareStatement(sqlSelect);
			stmt = connection.prepareStatement(sqlSelect);
			stmt.setString(1, acesso);
			stmt.setString(2, horarioEntrada);
			stmt.setString(3, horarioSaida);
			stmt.setString(4, senha);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				usuario.setTipo(rs.getString("usuarioTipo"));
				usuario.setHorarioEntrada(rs.getString("usuarioHorarioEntrada"));
				usuario.setHorarioSaida(rs.getString("usuarioHorarioSaida"));
				usuario.setSenha(rs.getString("usuarioSenha"));
				UsuarioLogado.usuarioLogado = usuario;
				JOptionPane.showMessageDialog(null ,"Informaçoes enviadas !");
				return true;

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	

}