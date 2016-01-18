package tools;

import exceptions.BorneException;

public class FonctionRacineCarre extends Fonction {

	public FonctionRacineCarre() {
		// sqrt(x) est définie sur ]0; +inf [
		super(true, true, 0, Double.POSITIVE_INFINITY);
	}

	public double f(double x) throws BorneException {
		if(testErreurBornes(x))
			throw new BorneException();
		return Math.sqrt(x);
	}

}
