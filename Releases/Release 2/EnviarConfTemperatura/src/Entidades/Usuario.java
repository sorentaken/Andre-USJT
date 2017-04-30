package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexaoBanco.ConnectionFactory;

public class Usuario {

	public Usuario(String nome, String rg, String cpf, String sexo, String conta, String senha, String horarioEntrada,
			String horarioSaida, String tipo) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.conta = conta;
		this.senha = senha;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.tipo = tipo;
	}

	private String nome;
	private String rg;
	private String cpf;
	private String sexo;
	private String conta;
	private String senha;
	private String horarioEntrada;
	private String horarioSaida;
	private String tipo;
	
	public Usuario()
	{
		nome = "";
		rg = "";
		cpf = "";
		sexo = "";
		conta = "";
		senha = "";
		horarioEntrada = "";
		horarioSaida = "";
		tipo = "";
	}
	
	

	
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	public String getHorarioSaida() {
		return horarioSaida;
	}
	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
	public Usuario contaValido(ArrayList<Usuario> usuarios, Usuario usuario){
		
		for (Usuario usuarioArray : usuarios) {
			boolean cond1 = usuario.getTipo().equals(usuarioArray.getTipo());
			boolean cond2 = usuario.getSenha().equals(usuarioArray.getSenha());

			if(cond1==true && cond2 == true){
				return usuario;
			}
		}
		return null;
	}
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (horarioEntrada == null) {
			if (other.horarioEntrada != null)
				return false;
		} else if (!horarioEntrada.equals(other.horarioEntrada))
			return false;
		if (horarioSaida == null) {
			if (other.horarioSaida != null)
				return false;
		} else if (!horarioSaida.equals(other.horarioSaida))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", sexo=" + sexo + ", conta=" + conta
				+ ", senha=" + senha + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", tipo=" + tipo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//BANCO - Testar no JUNIT
//Excluir
	public void excluir(String nome) {
		String sqlDelete = "DELETE FROM usuario WHERE  = ?";
		// 
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, nome);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//Carregar
	public Usuario carregar(String nome) {
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
//Atualizar
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




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((horarioEntrada == null) ? 0 : horarioEntrada.hashCode());
		result = prime * result + ((horarioSaida == null) ? 0 : horarioSaida.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}




	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
