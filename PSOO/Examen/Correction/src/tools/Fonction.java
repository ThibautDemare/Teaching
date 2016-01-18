package tools;

import exceptions.BorneException;

public abstract class Fonction {
	protected boolean estBorneInfOuverte;
	protected boolean estBorneSupOuverte;
	protected double borneInf;
	protected double borneSup;
	protected int n; // nombre de rectangles/trapèzes utilisés pour calculer l'intégrale. Plus n est grand, plus on est précis

	/**
	 * Constructeur
	 * @param estBorneInfOuverte
	 * @param estBorneSupOuverte
	 * @param borneInf
	 * @param borneSup
	 */
	public Fonction(boolean estBorneInfOuverte, boolean estBorneSupOuverte, double borneInf, double borneSup) {
		super();
		this.estBorneInfOuverte = estBorneInfOuverte;
		this.estBorneSupOuverte = estBorneSupOuverte;
		this.borneInf = borneInf;
		this.borneSup = borneSup;
	}
	
	/**
	 * Retourne la valeur de la fonction f en fonction du réel passé en paramètre
	 * @param x
	 * @return
	 * @throws BorneException Retourne une BorneException si x est en dehors de l'intervale de définition de la fonction
	 */
	public abstract double f(double x) throws BorneException;
	
	/**
	 * Test si x est en dehors de l'intervale de définition de la fonction
	 * @param x
	 * @return true si x est en dehors de l'intervale, faux sinon
	 */
	protected boolean testErreurBornes(double x){
		if(estBorneInfOuverte && x <= borneInf)
			return true;
		if(x <= borneInf)
			return true;
		if(estBorneSupOuverte && x >= borneSup)
			return true;
		if(x > borneSup)
			return true;
		return false;
	}
	
	/**
	 * Retourne la valeur de l'intégrale de la fonction entre les deux bornes et selon la méthode passée en paramètre
	 * @param borneInf
	 * @param borneSup
	 * @param methode
	 * @return
	 * @throws BorneException
	 */
	public double calculIntegral(double borneInf, double borneSup, MethodeIntegrale methode) throws BorneException{
		if(testErreurBornes(borneInf, borneSup))
			throw new BorneException();
		switch (methode) {
		case RECTANGLE:
			return calculMethodeRectangle(borneInf, borneSup);
		case TRAPEZE:
			return calculMethodeTrapeze(borneInf, borneSup);
		default:
			return 0; // si on nous passe une méthode inconnu, on renvoit 0 mais si on le voulait on pourrait déclencher une autre exception.
		}
	}
	
	/**
	 * Test si les deux bornes sont comprises dans l'intervale de définition de la fonction
	 * @param inf
	 * @param sup
	 * @return
	 */
	private boolean testErreurBornes(double inf, double sup){
		if(estBorneInfOuverte && inf <= borneInf)
			return true;
		if(inf <= borneInf)
			return true;
		if(estBorneSupOuverte && sup >= borneSup)
			return true;
		if(sup > borneSup)
			return true;
		if(inf > sup)
			return true;
		return false;
	}
	
	/**
	 * Utilise la méthode des rectangles pour calculer l'intégrale de la fonction
	 * @param borneInf
	 * @param borneSup
	 * @return
	 * @throws BorneException
	 */
	private double calculMethodeRectangle(double borneInf, double borneSup) throws BorneException{
		double res = 0;
		double tailleRect = ((borneSup - borneInf) / n );
		for(double i = borneInf; i < borneSup; i+=tailleRect){
			res += f( i );
		}
		return  tailleRect*res;
	}
	
	/**
	 * Utilise la méthode des trapèzes pour calculer l'intégrale de la fonction
	 * @param borneInf
	 * @param borneSup
	 * @return
	 * @throws BorneException
	 */
	private double calculMethodeTrapeze(double borneInf, double borneSup) throws BorneException{
		double res = 0;
		double tailleRect = ((borneSup - borneInf) / n );
		for(double i = borneInf + tailleRect; i < borneSup; i+= tailleRect){
			res += f( i );
		}
		return tailleRect * ( ((f(borneInf) + f(borneSup)) / 2) + res);
	}
	
	/*
	 * Getters et setters
	 */

	public boolean isEstBorneInfOuverte() {
		return estBorneInfOuverte;
	}

	public boolean isEstBorneSupOuverte() {
		return estBorneSupOuverte;
	}

	public double getBorneInf() {
		return borneInf;
	}

	public double getBorneSup() {
		return borneSup;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
