package FigurasGeometricas;

public interface Diagonal
{

	default double diagonalQuadrado(double a)
	{
		return a * Math.sqrt(2);
		
	}
	
	default double diagonalRetangulo(double a , double b)
	{
			return Math.sqrt((a * a) + (b * b));	
	}
	
	
	
}
