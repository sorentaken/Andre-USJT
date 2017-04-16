package FigurasGeometricas;

public class Quadrado extends Poligono implements Diagonal {

	public Quadrado(double base, double altura) {
		super(base, altura);
	}

	@Override
	public double Area() {
		return altura * altura;
	}

}
