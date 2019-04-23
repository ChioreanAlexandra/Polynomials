package ro.tuc.pt.assign1;

public class Derivation implements Operation<Bipolynom>{
	
	public Derivation()
	{
		super();
	}
	
	public Bipolynom compute(Polynomial p1, Polynomial p2)
	{
		for(Term i:p1.getTerms())
		{
			if(i.getDegree()==0)
			{
				p1.getTerms().remove(i);
			}
			else
			{
				i.setCoef(i.getCoef()*i.getDegree());
				i.setDegree(i.getDegree()-1);
			}
		}
		for(Term i:p2.getTerms())
		{
			if(i.getDegree()==0)
			{
				p2.getTerms().remove(i);
			}
			else
			{
				i.setCoef(i.getCoef()*i.getDegree());
				i.setDegree(i.getDegree()-1);
			}
		}
		return new Bipolynom(p1,p2);
	}

}
