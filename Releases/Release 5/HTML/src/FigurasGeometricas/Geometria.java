package FigurasGeometricas;

import java.util.ArrayList;

public class Geometria
{
	
	public static void main(String[] args)
	{

ArrayList<Figura> figuras = new ArrayList<>();
figuras.add(new Retangulo(2.0,2.0));

for(Figura fig :figuras)
{
	System.out.println(fig.Area());
}
		
	
	}
}