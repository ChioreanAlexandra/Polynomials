package ro.tuc.pt.assign1;

import java.util.Collections;

public class SubtractOperation implements Operation <Polynomial>{
	public SubtractOperation()
	{
		super();
	}
	
	public Polynomial compute (Polynomial p1, Polynomial p2)
	{
		Polynomial p3=p1;
		
		for(Term i:p2.getTerms())
		{
			i.setCoef(i.getCoef()*(-1)); //inmultim coeficientii din polinomul 2 cu -1 ca apoi sa facem o simpla adunare;
		}
		for(Term i:p2.getTerms())
		{
			p3.addTerm(i);
		}
		Collections.sort(p3.getTerms());
		return p3;
	}
}

