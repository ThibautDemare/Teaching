package main;

import exceptions.BorneException;
import tools.Fonction;
import tools.FonctionRacineCarre;
import tools.MethodeIntegrale;

public class Main {

	public static void main(String[] args) {
		Fonction sqrt = new FonctionRacineCarre();
		
		// La pr�cision maximale est ici born�e par le plus grand nombre que l'on peut stocker dans un int
		// Vous pouvez r�duire cette valeur � 100/10 000/... pour acc�lerer le calcul.
		sqrt.setN(Integer.MAX_VALUE);
		try {
			/*
			 * Sur [10-20], on est cens� retrouv� approximativement 38.5466283322052
			 */
			System.out.println("L'int�grale de f(x) = sqrt(x) sur [10-20] en utilisant la m�thode des rectangles = \n" +sqrt.calculIntegral(10, 20, MethodeIntegrale.RECTANGLE));
			System.out.println("L'int�grale de f(x) = sqrt(x) sur [10-20] en utilisant la m�thode des trap�zes = \n" +sqrt.calculIntegral(10, 20, MethodeIntegrale.TRAPEZE));
			
			System.out.println("Le prochain appel devrait d�clencher une execption : ");
			sqrt.calculIntegral(-1, 20, MethodeIntegrale.RECTANGLE);
		} catch (BorneException e) {
			e.printStackTrace();
		}
	}

}
