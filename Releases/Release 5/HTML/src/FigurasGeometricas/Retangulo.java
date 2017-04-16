package FigurasGeometricas;

public class Retangulo extends Poligono implements Diagonal 
{
	
	public Retangulo(double base , double altura)
	{
		super(base,altura);	
    }

	@Override
	public double Area() 
	{
		return base * altura;	
	}
	
	

		
}
