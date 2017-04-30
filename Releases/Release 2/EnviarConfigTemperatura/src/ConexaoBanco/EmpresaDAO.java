package ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Entidades.Empresa;

public class EmpresaDAO {
	private Connection connection;
	String empresaNome;
	String empresaCNPJ;
	String empresaRazaoSocial;
	int empresaConjunto;
	String empresaAbertura;
	String empresaEncerramento;
	String empresaTemperaturaMin;
	String empresaTemperaturaMax;
	String horarioArLigado;
	String horarioArDesligado;

	public EmpresaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// FUNCIONANDO - Cadastrar
	public void adiciona(Empresa empresa)

	{
		String sql = "INSERT INTO empresa(empresaNome,empresaCNPJ,empresaRazaoSocial,empresaConjunto,empresaAbertura,empresaEncerramento,empresaTemperaturaMin,empresaTemperaturaMax,horarioArLigado,horarioArDesligado) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, empresa.getNomeEmpresa());
			stmt.setString(2, empresa.getCNPJ());
			stmt.setString(3, empresa.getRazaoSocial());
			stmt.setInt(4, empresa.getConjuntoNR());
			stmt.setString(5, empresa.getHorarioEntrada());
			stmt.setString(6, empresa.getHorarioEncerramento());
			stmt.setInt(7, empresa.getTemperaturaMin());
			stmt.setInt(8, empresa.getTemperaturaMax());
			stmt.setString(9, empresa.getArLigar());
			stmt.setString(10, empresa.getArDesligar());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			JOptionPane.showMessageDialog(null , "Este (Razao social ou conjunto ou CNPJ) ja esta sendo utilizado , por favor mude");
			throw new RuntimeException(u);
		}
	}
	// FIM CADASTRO

	// FUNCIONADO - Excluir
	public void excluir(Empresa empresa) {
		String sqlDelete = "DELETE FROM empresa WHERE empresaNome = ?";

		
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlDelete);
			stmt.setString(1, empresa.getNomeEmpresa());
			stmt.execute();
			
			
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		}
	
	// FIM EXCLUIR

	// Funcionando - Consultar
	public String carregar(Empresa empresa) throws SQLException {
		String teste = "";
		String sqlSelect = "SELECT * FROM empresa WHERE empresaNome = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlSelect);
			stmt = connection.prepareStatement(sqlSelect);
			stmt.setString(1, empresa.getNomeEmpresa());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				empresa.setCNPJ(rs.getString(2));
				empresa.setRazaoSocial(rs.getString(3));
				empresa.setConjuntoNR(rs.getInt(4));
				empresa.setHorarioEntrada(rs.getString(5));
				empresa.setHorarioEncerramento(rs.getString(6));
				empresa.setTemperaturaMin(rs.getInt(7));
				empresa.setTemperaturaMax(rs.getInt(8));
				empresa.setArLigar(rs.getString(9));
				empresa.setArDesligar(rs.getString(10));
				teste = "Empresa:" + empresa.getNomeEmpresa() + "\n" + "CNPJ:" + empresa.getCNPJ() + "\n"
						+ "Razao Social:" + empresa.getRazaoSocial() + "\n" + "ConjuntoNR:" + empresa.getConjuntoNR()
						+ "\n" + "Horario Entrada:" + empresa.getHorarioEntrada() + "\n" + "Horario Encerramento:"
						+ empresa.getHorarioEncerramento() + "\n" + "Temperatura Min:" + empresa.getTemperaturaMin()
						+ "\n" + "Temperatura Max:" + empresa.getTemperaturaMax() + "\n" + "Ar Ligar:"
						+ empresa.getArLigar() + "\n" + "Ar Desligar:" + empresa.getArDesligar();
				JOptionPane.showMessageDialog(null, teste);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teste;

	}
	// FIM CONSULTAR

	// NAO FUNCIONA --- AINDA
	public void altera(Empresa empresa, String filtro) throws SQLException {
		String sqlAlterar = "UPDATE empresa SET empresaNome = ?,empresaCNPJ = ?,empresaRazaoSocial = ?,empresaConjunto = ?,empresaAbertura = ?,empresaEncerramento = ?,empresaTemperaturaMin = ?,empresaTemperaturaMax = ?,horarioArLigado = ?,horarioArDesligado = ? where empresaNome = ?";
		PreparedStatement stmt = connection.prepareStatement(sqlAlterar);

		try{
		stmt.setString(1, empresa.getNomeEmpresa());
		stmt.setString(2, empresa.getCNPJ());
		stmt.setString(3, empresa.getRazaoSocial());
		stmt.setInt(4, empresa.getConjuntoNR());
		stmt.setString(5, empresa.getHorarioEntrada());
		stmt.setString(6, empresa.getHorarioEncerramento());
		stmt.setInt(7, empresa.getTemperaturaMin());
		stmt.setInt(8, empresa.getTemperaturaMax());
		stmt.setString(9, empresa.getArLigar());
		stmt.setString(10, empresa.getArDesligar());
		stmt.setString(11 , filtro);
		stmt.execute();
		stmt.close();
		} catch (SQLException u) 
		{
			JOptionPane.showMessageDialog(null , "Este (Razao social ou conjunto ou CNPJ) ja esta sendo utilizado , por favor mude");
			throw new RuntimeException(u);
		}

	}
	// FIM ALTERAR

}