package ro.tuc.pt.assign1;

import java.util.*;

public class Polynomial {
	private List<Term> terms;
	
	public Polynomial(List<Term> terms)
	{
		this.terms=terms;
	}
	
	public Polynomial()
	{
		terms=new LinkedList<Term>();
	}
	
	public List<Term> getTerms()
	{
		 return this.terms;
	}
	 
	public void setTerms(List<Term> terms)
	{
		this.terms=terms;
	}
	
	public void addTerm(Term t)
	{
		int ok=0;
		for(Term q:terms)
		{
			if(q.getDegree()==t.getDegree())
			{
				q.setCoef(q.getCoef()+t.getCoef());
				ok=1;
			}
		}
		if (ok==0)
		{
			terms.add(t);
		}
		
	}
	public void removeZero()
	{
		for(Term i:this.terms)
		{
			if(i.getCoef()==0)
			{
				this.terms.remove(i);
			}
		}
	}
	public String toString()
	{
		String s="";
		int ok=0;
		Collections.sort(this.terms);
		if(this.terms.isEmpty()){
			s="0";
		}
		else
		for(Term q:this.terms)
		{
			if(q.getCoef()<0)
			{
				ok=1;
				s=s+q.toString();
			}
			else
			{
				if(ok==0)
				{
					s=q.toString(); ok=1;
				}
				else
					s=s+"+"+q.toString();
				
			}
			
		}
		
		return s;
	}
	public boolean equals(Object o)
	{
		if(o instanceof Polynomial)
		{
			Polynomial p=(Polynomial) o;
			for(int i=0;i<this.terms.size();i++)
			{
				if(!p.getTerms().get(i).equals(this.terms.get(i)))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	

}
