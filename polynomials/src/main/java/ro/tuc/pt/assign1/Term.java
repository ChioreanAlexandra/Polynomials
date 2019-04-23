package ro.tuc.pt.assign1;


public class Term  implements Comparable<Term>{
	
	private float coef;
	private int degree;
	
	public Term(float coef, int degree)
	{
		this.coef=coef;
		this.degree=degree;
	}
	public Term()
	{
		this.coef=0;
		this.degree=0;
	}
	
	public void setCoef(float coef)
	{
		this.coef=coef;
		
	}
	
	public void setDegree(int degree)
	{
		this.degree=degree;
		
	}
	
	public float getCoef()
	{
		return this.coef;
	}
	
	public int getDegree()
	{
		return this.degree;
	}
	public String toString()
	{
		String s;
		if(this.coef==1 && this.degree!=0)
		{
			s="";
		}
		else s=String.format("%.02f", this.coef)+""; //scriem coeficientul doar cu doua zecimale
		if (this.degree==1)
		{
			s=s+"x";
		}
		else
			if(this.degree!=0)
			{
				s=s+"x^"+this.degree;
			}
			
		return s;
	}
	public int compareTo(Term t)	
	{
		if (this.degree<t.degree)
		{
			return 1;
		}
		else
			if(this.degree==t.degree)
			{
				return 0;
			}
			else
				return -1;
	}
	public boolean equals(Object o)
	{
		if (o instanceof Term)
		{
			Term t=(Term) o;
			if(this.coef!=t.getCoef() || this.degree!=t.getDegree())
			{
				return false;
			}
			return true;
		}
		return false;
	}
}

