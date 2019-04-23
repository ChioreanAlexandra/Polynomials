package ro.tuc.pt.assign1;

public class Integration implements Operation<Bipolynom>{
	
	public Integration()
	{
		super();
	}
	
	public Bipolynom compute(Polynomial p1, Polynomial p2)
	{
		for(Term i:p1.getTerms())
		{
			i.setCoef(i.getCoef()/(i.getDegree()+1));
			i.setDegree(i.getDegree()+1);
		}
		for(Term i:p2.getTerms())
		{
			i.setCoef(i.getCoef()/(i.getDegree()+1));
			i.setDegree(i.getDegree()+1);
		}
		
		return new Bipolynom(p1,p2);
	}

}
