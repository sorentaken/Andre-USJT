package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConexaoBanco.ConnectionFactory;

public class Empresa
{

	public Empresa(String nomeEmpresa, String cNPJ, String razaoSocial, int conjuntoNR, String horarioEntrada,
			String horarioEncerramento, int temperaturaMin, int temperaturaMax, String arLigar, String arDesligar) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		CNPJ = cNPJ;
		this.razaoSocial = razaoSocial;
		this.conjuntoNR = conjuntoNR;
		this.horarioEntrada = horarioEntrada;
		this.horarioEncerramento = horarioEncerramento;
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;
		this.arLigar = arLigar;
		this.arDesligar = arDesligar;
	}


	private String nomeEmpresa;
	private String CNPJ;
	private String razaoSocial;
	private int conjuntoNR;
	private String horarioEntrada;
	private String horarioEncerramento;
	private int temperaturaMin;
	private int temperaturaMax;
	private String arLigar;
	private String arDesligar;

		
		public Empresa()
		{
			nomeEmpresa = "";
			CNPJ = "";
			razaoSocial = "";
			conjuntoNR = 0;
			horarioEntrada = "";
			horarioEncerramento = "";
			temperaturaMin = 0;
			temperaturaMax = 0;
			arLigar = "";
			arDesligar = "";
			
			
		}
			
		
		public String getNomeEmpresa() {
			return nomeEmpresa;
		}
		public void setNomeEmpresa(String nomeEmpresa) {
			this.nomeEmpresa = nomeEmpresa;
		}
		public String getCNPJ() {
			return CNPJ;
		}
		public void setCNPJ(String cNPJ) {
			CNPJ = cNPJ;
		}
		public String getRazaoSocial() 
		{
			return razaoSocial;
		}
		
		public void setRazaoSocial(String razãoSocial) 
		{
			this.razaoSocial = razãoSocial;
		}
		
		public int getConjuntoNR() 
		{
			return conjuntoNR;
		}
		
		public void setConjuntoNR(int conjuntoNR) 
		{
			this.conjuntoNR = conjuntoNR;
		}
		
		public String getHorarioEntrada() 
		{
			return horarioEntrada;
		}
		
		public void setHorarioEntrada(String horarioEntrada) 
		{
			this.horarioEntrada = horarioEntrada;
		}
		
		public String getHorarioEncerramento() 
		{
			return horarioEncerramento;
		}
		
		public void setHorarioEncerramento(String horarioEncerramento)
		{
			this.horarioEncerramento = horarioEncerramento;
		}
		
		public int getTemperaturaMin() 
		{
			return temperaturaMin;
		}
		
		public void setTemperaturaMin(int temperaturaMin) 
		{
			this.temperaturaMin = temperaturaMin;
		}
		
		public int getTemperaturaMax() 
		{
			return temperaturaMax;
		}
		
		public void setTemperaturaMax(int temperaturaMax)
		{
			this.temperaturaMax = temperaturaMax;
		}
		
		public String getArLigar()
		{
			return arLigar;
		}
		
		public void setArLigar(String arLigar)
		{
			this.arLigar = arLigar;
		}
		
		public String getArDesligar() 
		{
			return arDesligar;
		}
		
		public void setArDesligar(String arDesligar)
		{
			this.arDesligar = arDesligar;
		}

		public void excluir(String nome) {
			String sqlDelete = "DELETE FROM empresa WHERE  = ?";
			// 
			try (Connection conn = ConnectionFactory.getConnection();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setString(1, nome);
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		
		public Empresa carregar(String nome) {
			Empresa empresa = new Empresa();
			empresa.setNomeEmpresa(nome);
			String sqlSelect = "SELECT empresaNome,empresaCNPJ,empresaRazaoSocial,empresaConjunto,empresaAbertura,empresaEncerramento,empresaTemperaturaMin,empresaTemperaturaMax,horarioArLigado,horarioArDesligado from empresa WHERE nomeEmpresa = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.getConnection();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, empresa.getNomeEmpresa());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						empresa.setNomeEmpresa(rs.getString("Nome"));
						empresa.setCNPJ(rs.getString("CNPJ"));
						empresa.setRazaoSocial(rs.getString("RazaoSocial"));
						empresa.setConjuntoNR(rs.getInt("Conjunto"));
						empresa.setHorarioEntrada(rs.getString("Abertura"));
						empresa.setHorarioEncerramento(rs.getString("Encerramento"));
						empresa.setTemperaturaMin(rs.getInt("TemperaturaMin"));
						empresa.setTemperaturaMax(rs.getInt("TemperaturaMax"));
						
					} else {
						empresa.setNomeEmpresa(null);
						empresa.setCNPJ(null);
						empresa.setRazaoSocial(null);
						empresa.setConjuntoNR((Integer) null);
						empresa.setHorarioEntrada(null);
						empresa.setHorarioEncerramento(null);
						empresa.setTemperaturaMin((Integer) null);
						empresa.setTemperaturaMax((Integer) null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return empresa;
		}


		public void atualizar(Empresa empresa) {
			String sqlUpdate = "UPDATE usuario SET empresaNome=?,empresaCNPJ=?,empresaRazaoSocial=?,empresaConjunto=?,empresaAbertura=?,empresaEncerramento=?,empresaTemperaturaMin=?,empresaTemperaturaMax=?,horarioArLigado=?,horarioArDesligado=? WHERE empresaNome=?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.getConnection();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1,empresa.getNomeEmpresa());
				stm.setString(2,empresa.getCNPJ());
				stm.setString(3,empresa.getRazaoSocial());
				stm.setInt(4,empresa.getConjuntoNR());
				stm.setString(5,empresa.getHorarioEntrada());
				stm.setString(6,empresa.getHorarioEncerramento());
				stm.setInt(7,empresa.getTemperaturaMin());
				stm.setInt(8,empresa.getTemperaturaMax());
				stm.setString(9,empresa.getArLigar());
				stm.setString(10,empresa.getArDesligar());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		
		
		
	}

	
		
		
		
		
		  
		
	
	

