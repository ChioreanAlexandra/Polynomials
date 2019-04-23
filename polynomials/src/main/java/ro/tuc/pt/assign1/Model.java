package ro.tuc.pt.assign1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
	
	public Model()
	{
		
	}

	public static boolean testPolynomStructure(String s)
	{
		if(s.charAt(0)=='-') //pentru a testa forma monomului trebuie ca acesta sa fie pozitiv(sa nu aiba alte caractere)
		{
			s=s.substring(1, s.length());
		}
		String[] sir=s.split("[+-]");
		for(String x:sir)
		{	//regex-ul pentru verificare contine mai multe simboluri pentru cifra deoarece gradul/coeficientul maxim al polinomului am ales sa fie 999
			if(!x.matches("(((\\d)|(\\d\\d)|(\\d\\d\\d))[*]x[^']((\\d)|(\\d\\d)|(\\d\\d\\d)))|(x['^]((\\d)|(\\d\\d)|(\\d\\d\\d)))|(((\\d)|(\\d\\d)|(\\d\\d\\d))[*]x)|(((\\d)|(\\d\\d)|(\\d\\d\\d)))"))
			{
				return false;
			}
		}
		return true;
	}
	public static Polynomial getPolynom(String s) throws Exception  
	{
		if(!testPolynomStructure(s)) throw new Exception(""+s);
		Term t=new Term();
		Polynomial pol=new Polynomial();
		Pattern p=Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");//acest pattern gaseste x-urile din string 
		Matcher m=p.matcher(s);
		int cnt=0;
		while(m.find())
		{
			String str= m.group(1); //grupul este reprezentat de coeficient, x si grad
			if (cnt==0)
			{
				t=new Term();
			}
			if(str.contains("x") && cnt==0) //am tratat cazul in care avem un monom de forma x^b
			{
				cnt=1;
				if(str.contains("-"))
				{
					t.setCoef(-1);
				}
				else
				t.setCoef(1);
			}
			cnt++;
			switch (cnt)
			{
			case 1:t.setCoef(Float.parseFloat(str)); break;
			case 3:t.setDegree(Integer.parseInt(str));
					pol.addTerm(t); cnt=0; break;
			}
			//System.out.println(m.group(1));
		}
		if (cnt==1 || cnt==2) //in cazul in care la sfarsit am introdus un monom de forma a*x sau doar a
		{
			t.setDegree(cnt-1);
			pol.addTerm(t);
		}
		return pol;
	}
	
	//x^2+3*x^1+5*x^0+7*x^3+x^1
	
	public static Operation getInstance(String s) //in functie de simbolul butonului se alege operatia ce trebuie realizata
	{
		if(s.equals("+")) return new AddOperation();
		else
			if(s.equals("-")) return new SubtractOperation();
			else
				if(s.equals("*")) return new MultiplyOperation();
				else 
					if(s.equals("/")) return new Division();
					else 
						if(s.equals("'")) return new Derivation();
						else 
							if(s.equals("S")) return new Integration();
				
		return null;
	}
}
