package ro.tuc.pt.assign1;


import java.awt.*;
import java.util.Collections;

import javax.swing.JTextField;

public class AddOperation implements Operation <Polynomial>{
	
	public AddOperation()
	{
		super();
	}
	public Polynomial compute(Polynomial p1, Polynomial p2)
	{
		Polynomial p3=new Polynomial();
		Term t=new Term();
		
		p3=p1;
		for(Term j:p2.getTerms())
		{
			p3.addTerm(j);
		}
		
		Collections.sort(p3.getTerms());
		return p3;
	}
}
