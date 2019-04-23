package ro.tuc.pt.assign1;

import java.util.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{	
	public Polynomial p1;
	public Polynomial p2;
    public AppTest()
    {
       String s1="5*x^100-10*x^2+3*x";
       String s2="3*x^2+4*x^1+2";
       try
       {
    	   this.p1=Model.getPolynom(s1);
    	   this.p2=Model.getPolynom(s2);
       }
       catch(Exception e)
       {
    	   System.out.print(e.getMessage());
       }
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testParsingPolynom()
    {
    	String s2="3*x^2+4*x^1+2";
    	Polynomial p=new Polynomial();
    	List<Term> l1=new LinkedList<Term>();
    	l1.add(new Term(3,2));
    	l1.add(new Term(4,1));
    	l1.add(new Term(2,0));
    	try{
    		p=Model.getPolynom(s2);
    	}
    	catch (Exception ex)
    	{
    		ex.getMessage();
    		assertFalse(true);
    	}
    	finally
    	{
    		assertTrue(p.getTerms().equals(l1));
    	}
    	
    }
    public void testAdd()
    {
    	AddOperation op=new AddOperation();
    	Polynomial p3=op.compute(p1, p2);
    	List<Term> l1=new LinkedList<Term>();
    	l1.add(new Term(5,100));
    	l1.add(new Term(-7,2));
    	l1.add(new Term(7,1));
    	l1.add(new Term(2,0));
    	assertTrue(p3.getTerms().equals(l1));
    }
    
    public void testSubtract()
    {
    	SubtractOperation op=new SubtractOperation();
    	Polynomial p3=op.compute(this.p1, this.p2);
    	List<Term> l1=new LinkedList<Term>();
    	l1.add(new Term(5,100));
    	l1.add(new Term(-13,2));
    	l1.add(new Term(-1,1));
    	l1.add(new Term(-2,0));
    	assertTrue(p3.getTerms().equals(l1));
    }
    
    public void testMultiply()
    {
    	MultiplyOperation op=new MultiplyOperation();
    	Polynomial p3=op.compute(p1, p2);
    	List<Term> l1=new LinkedList<Term>();
    	l1.add(new Term(15,102));
    	l1.add(new Term(20,101));
    	l1.add(new Term(10,100));
    	l1.add(new Term(-30,4));
    	l1.add(new Term(-31,3));
    	l1.add(new Term(-8,2));
    	l1.add(new Term(6,1));
    	assertTrue(p3.getTerms().equals(l1));
    }
    
    public void testDivision()
    {
    	//Modificam valoarile polinoamelor pentru o testare corecta
    	try
    	{
    		this.p1=Model.getPolynom("5*x^4-45*x^3+52*x^2-20*x^1+25");
        	this.p2=Model.getPolynom("5*x^2+2");
        	Division op=new Division();
        	Bipolynom p3=op.compute(p1, p2);
        	List<Term> l1=new LinkedList<Term>();
        	l1.add(new Term(1,2));
        	l1.add(new Term(-9,1));
        	l1.add(new Term(10,0));
        	List<Term> l2=new LinkedList<Term>();
        	l2.add(new Term(-2,1));
        	l2.add(new Term(5,0));
        	assertTrue(p3.p1.getTerms().equals(l1) && p3.p2.getTerms().equals(l2));
    	}
    	catch(Exception e)
    	{
    		e.getMessage();
    		assertTrue(false);
    	}
    }
    public void testIntegration()
    {
    	Integration op=new Integration();  
    	Bipolynom p3=op.compute(p1, p2);
    	List<Term> l1=new LinkedList<Term>();
    	double f1=5.00/101,f2=-10.00/3,f3=3.00/2;
    	l1.add(new Term((float)f1,101));
    	l1.add(new Term((float)f2,3));
    	l1.add(new Term((float)f3,2));
    	List<Term> l2=new LinkedList<Term>();
    	l2.add(new Term(1,3));
    	l2.add(new Term(2,2));
    	l2.add(new Term(2,1));
    	assertTrue(p3.p1.getTerms().equals(l1) && p3.p2.getTerms().equals(l2));
    }
    public void testDerivation()
    {
    	Derivation op=new Derivation();
    	Bipolynom p3=op.compute(p1, p2);
    	List<Term> l1=new LinkedList<Term>();
    	l1.add(new Term(500,99));
    	l1.add(new Term(-20,1));
    	l1.add(new Term(3,0));
    	List<Term> l2=new LinkedList<Term>();
    	l2.add(new Term(6,1));
    	l2.add(new Term(4,0));
    	assertTrue(p3.p1.getTerms().equals(l1) && p3.p2.getTerms().equals(l2));
    }
}
