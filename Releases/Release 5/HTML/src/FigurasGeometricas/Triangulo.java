package FigurasGeometricas;

public class Triangulo extends Poligono {

	public Triangulo(double base, double altura) {
		super(base, altura);
	}

	@Override
	public double Area() 
	{
		return (base * altura) / 2;
	}
	
	
}
