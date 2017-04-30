package Entidades;

public class Empresa
{

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


	
		  
		
	
	
}
