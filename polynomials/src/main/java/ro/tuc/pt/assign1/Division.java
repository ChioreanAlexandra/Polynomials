package ro.tuc.pt.assign1;


public class Division implements Operation<Bipolynom> {
	
	public Division()
	{
		super();
	}
	public Bipolynom compute(Polynomial p1, Polynomial p2)  
	{
		Polynomial cat=new Polynomial();
		Polynomial rest=new Polynomial();
		int pol1Degree=p1.getTerms().get(0).getDegree();
		int pol2Degree=p2.getTerms().get(0).getDegree();
		Operation<Polynomial> op;
		while(pol1Degree>=pol2Degree)
		{
			Term t1=p1.getTerms().get(0);
			Term t2=p2.getTerms().get(0);
			Polynomial p3=new Polynomial();
			Term t3= new Term(t1.getCoef()/t2.getCoef(),t1.getDegree()-t2.getDegree()); // cream un termen cu coeficientul si puterea potivita
			cat.addTerm(t3); //il adaugam in cat
			p3.addTerm(t3); // pentru ca operatiile le facem pe polinoame este necesar sa adaugam termenul intr-un polininom
			op=new MultiplyOperation();
			Polynomial aux=op.compute(p3, p2); //inmultim noul termen cu impartitorul
			op=new SubtractOperation();
			p3=op.compute(p1, aux); //scadem si apoi stergem monomul de grad maxim din deimpartit
			p3.getTerms().remove(0);
			if(!p3.getTerms().isEmpty()) //daca p3 ajunge sa fie gol atunci nu am mai putea extrage gradul maxim
			{
				pol1Degree=p3.getTerms().get(0).getDegree();
				p1=p3;
			}
			else
			{
				pol1Degree=-1;
				p1=p3;
			}
			
		}
		Bipolynom bp=new Bipolynom(cat,p1);
		return bp;
	}
}
