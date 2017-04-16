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
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//<Cadastrar - Usuario Funcionario>
	public int adiciona(Usuario usuario)

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
		return 0;
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
	public Usuario carregar2(Usuario usuario) throws SQLException {
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
		return usuario;

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

public void atualizar(Usuario usuario) {
	String sqlUpdate = "UPDATE usuario SET usuarioNome,usuarioRG=?,usuarioCPF=?,usuarioSexo=?,usuarioConta=?,usuarioSenha=?,usuarioHorarioEntrada=?,usuarioHorarioSaida=? WHERE nome=?";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		stm.setString(1,usuario.getNome());
		stm.setString(2,usuario.getRg());
		stm.setString(3,usuario.getCpf());
		stm.setString(4,usuario.getSexo());
		stm.setString(5,usuario.getConta());
		stm.setString(6,usuario.getSenha());
		stm.setString(7,usuario.getHorarioEntrada());
		stm.setString(8,usuario.getHorarioSaida());
		stm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//CLASSES PARA USAR NO HTML

public String criar(Usuario usuario) {
	String sqlInsert = "INSERT INTO usuario(usuarioNome,usuarioRG,usuarioCPF,usuarioSexo,usuarioConta,usuarioSenha,usuarioHorarioEntrada,usuarioHorarioSaida) VALUES (?,?,?,?,?,?,?,?)";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setString(1, usuario.getNome());
		stm.setString(2, usuario.getRg());
		stm.setString(3, usuario.getCpf());
		stm.setString(4, usuario.getSexo());
		stm.setString(5, usuario.getConta());
		stm.setString(6, usuario.getSenha());
		stm.setString(7, usuario.getHorarioEntrada());
		stm.setString(8, usuario.getHorarioSaida());
		stm.execute();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return usuario.getNome();
}


public Usuario carregar2(String nome) {
	Usuario usuario = new Usuario();
	usuario.setNome(nome);
	String sqlSelect = "SELECT usuarioNome,usuarioRG,usuarioCPF,usuarioSexo,usuarioConta,usuarioSenha,usuarioHorarioEntrada,usuarioHorarioSaida from usuario WHERE usuarioNome = ?";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setString(1, usuario.getNome());
		try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				usuario.setNome(rs.getString("Nome"));
				usuario.setRg(rs.getString("Rg"));
				usuario.setCpf(rs.getString("Cpf"));
				usuario.setSexo(rs.getString("Sexo"));
				usuario.setConta(rs.getString("Conta"));
				usuario.setSenha(rs.getString("Senha"));
				usuario.setHorarioEntrada(rs.getString("Horario Entrada"));
				usuario.setHorarioSaida(rs.getString("Horario Saida"));
				
			} else {
				usuario.setNome(null);
				usuario.setRg(null);
				usuario.setCpf(null);
				usuario.setSexo(null);
				usuario.setConta(null);
				usuario.setSenha(null);
				usuario.setHorarioEntrada(null);
				usuario.setHorarioSaida(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
	}
	return usuario;
}
	

public void excluir2(String nome) {
	String sqlDelete = "DELETE FROM usuario WHERE id = ?";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setString(1, nome);
		stm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
}


public void atualizar2(Usuario usuario) {
	String sqlUpdate = "UPDATE usuario SET usuarioNome,usuarioRG=?,usuarioCPF=?,usuarioSexo=?,usuarioConta=?,usuarioSenha=?,usuarioHorarioEntrada=?,usuarioHorarioSaida=? WHERE nome=?";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		stm.setString(1,usuario.getNome());
		stm.setString(2,usuario.getRg());
		stm.setString(3,usuario.getCpf());
		stm.setString(4,usuario.getSexo());
		stm.setString(5,usuario.getConta());
		stm.setString(6,usuario.getSenha());
		stm.setString(7,usuario.getHorarioEntrada());
		stm.setString(8,usuario.getHorarioSaida());
		stm.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
}



}