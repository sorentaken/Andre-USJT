package FigurasGeometricas;

public class Circulo extends Figura {

	public double Figura() {

		return 0;
	}

	public double diametro()
	{
		
		int diametro = 4;
		return 2 * diametro;
	}

	
	@Override
	public double Area() {

		return diametro() * 3.14 ;
	}

}
