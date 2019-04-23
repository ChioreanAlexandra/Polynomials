package ro.tuc.pt.assign1;

import java.awt.event.*;
import java.util.regex.*;

import javax.swing.*;

import ro.tuc.pt.assign1.gui.Window;

public class Controller {
	public Window viewWindow;
	public Model model;
	
	public Controller(Window w,Model model) 
	{
		this.viewWindow=w;
		this.model=model;
		viewWindow.b1.addActionListener(new Listeners(viewWindow.b1.getText(),this.viewWindow));
		viewWindow.b2.addActionListener(new Listeners(viewWindow.b2.getText(),this.viewWindow));
		viewWindow.b3.addActionListener(new Listeners(viewWindow.b3.getText(),this.viewWindow));
		viewWindow.b4.addActionListener(new Listeners(viewWindow.b4.getText(),this.viewWindow));
		viewWindow.b5.addActionListener(new Listeners(viewWindow.b5.getText(),this.viewWindow));
		viewWindow.b6.addActionListener(new Listeners(viewWindow.b6.getText(),this.viewWindow));
	}
	public class Listeners implements ActionListener
	{
		public String operationSymbol;
		public Window viewWindow;
		public Listeners(String op,Window w)
		{
			this.operationSymbol=op;
			this.viewWindow=w;
		}
		public void actionPerformed(ActionEvent e)
		{
			
			Polynomial p1=new Polynomial(),p2=new Polynomial();
			try{
				
				p1=Model.getPolynom(viewWindow.tf1.getText()); //transformam inputul in obiecte de tip Polynomial
				p2=Model.getPolynom(viewWindow.tf2.getText());
				if(this.operationSymbol.equals("+")||this.operationSymbol.equals("*")||this.operationSymbol.equals("-")) //operatii care returneaza Polynomial
				{
					Operation<Polynomial> op=Model.getInstance(this.operationSymbol);
					Polynomial p=op.compute(p1, p2);
					p.removeZero();
					viewWindow.result.setText("Result="+p.toString());
				}
				else
				{
					if(this.operationSymbol.equals("/") && viewWindow.tf2.getText().equals("0")) 
					{
						throw new Exception("Impartire la 0");
					}
					Operation<Bipolynom> op=Model.getInstance(this.operationSymbol);
					Bipolynom p=op.compute(p1, p2);
					p.p1.removeZero();
					p.p2.removeZero();
					if(this.operationSymbol.equals("/"))
						viewWindow.result.setText("Cat:"+p.p1+" \n "+"Rest:"+p.p2);
					else
						viewWindow.result.setText("Polinomul 1:"+p.p1+" \n "+"Polinom 2:"+p.p2);
				}
			}
			catch(Exception ex)
			{
				viewWindow.result.setText("Ati introdus un polinom nevalid; "+ex.getMessage());
			}
		}
	
	}

}
