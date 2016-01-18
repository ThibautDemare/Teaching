package main;

import exceptions.BorneException;
import tools.Fonction;
import tools.FonctionRacineCarre;
import tools.MethodeIntegrale;

public class Main {

	public static void main(String[] args) {
		Fonction sqrt = new FonctionRacineCarre();
		
		// La précision maximale est ici bornée par le plus grand nombre que l'on peut stocker dans un int
		// Vous pouvez réduire cette valeur à 100/10 000/... pour accélerer le calcul.
		sqrt.setN(Integer.MAX_VALUE);
		try {
			/*
			 * Sur [10-20], on est censé retrouvé approximativement 38.5466283322052
			 */
			System.out.println("L'intégrale de f(x) = sqrt(x) sur [10-20] en utilisant la méthode des rectangles = \n" +sqrt.calculIntegral(10, 20, MethodeIntegrale.RECTANGLE));
			System.out.println("L'intégrale de f(x) = sqrt(x) sur [10-20] en utilisant la méthode des trapèzes = \n" +sqrt.calculIntegral(10, 20, MethodeIntegrale.TRAPEZE));
			
			System.out.println("Le prochain appel devrait déclencher une execption : ");
			sqrt.calculIntegral(-1, 20, MethodeIntegrale.RECTANGLE);
		} catch (BorneException e) {
			e.printStackTrace();
		}
	}

}
