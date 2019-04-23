package ro.tuc.pt.assign1;

import java.util.Collections;

public class MultiplyOperation implements Operation <Polynomial> {
	public MultiplyOperation()
	{
		super();
	}
	public Polynomial compute(Polynomial p1, Polynomial p2)
	{
		Polynomial p3=new Polynomial();
		Term t=new Term();
		for(Term i:p1.getTerms())
		{
			int ok=0;
			for(Term j:p2.getTerms())
			{
				t=new Term(i.getCoef()*j.getCoef(),i.getDegree()+j.getDegree());
				p3.addTerm(t);	
			}
		}
		Collections.sort(p3.getTerms());
		return p3;
	}
}

