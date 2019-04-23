package ro.tuc.pt.assign1.gui;

import ro.tuc.pt.assign1.Controller;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window {
	public JTextField tf1;
	public JTextField tf2;
	public JLabel result;
	public JButton b1;
	public JButton b2;
	public JButton b3;
	public JButton b4;
	public JButton b5;
	public JButton b6;
	public Window()
	{
		JFrame f1=new JFrame("Calculator");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(600, 400);
		JPanel p1=new JPanel();
		SpringLayout layout=new SpringLayout();
		p1.setLayout(layout);
		JLabel l1=new JLabel("Polynom 1:");
		tf1=new JTextField(30);
		JLabel l2=new JLabel("Polynom 2:");
		tf2=new JTextField(30);
		b1=new JButton("+");
		//try
		{
			//Image i=ImageIO.read(getClass().getResource("/images/plus.png"));
			//b1.setIcon(new ImageIcon(i));
		}
		//catch(IOException e){}
		//b1.setSize(1, 1);
		
		b2=new JButton("-");
		b3=new JButton("*");
		b4=new JButton("/");
		b5=new JButton("'");
		b6=new JButton("S");
		
		result=new JLabel();
		
		
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf2);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(result);
		
		layout.putConstraint(SpringLayout.WEST, l1, 5, SpringLayout.WEST, p1);
		layout.putConstraint(SpringLayout.NORTH, l1, 5, SpringLayout.NORTH, p1);
		
		layout.putConstraint(SpringLayout.WEST, tf1, 25, SpringLayout.EAST, l1);
		layout.putConstraint(SpringLayout.NORTH, tf1, 5, SpringLayout.NORTH, p1);
		
		layout.putConstraint(SpringLayout.WEST, l2, 5, SpringLayout.WEST, p1);
		layout.putConstraint(SpringLayout.NORTH, l2, 25, SpringLayout.NORTH, l1);
		
		layout.putConstraint(SpringLayout.WEST, tf2, 25, SpringLayout.EAST, l2);
		layout.putConstraint(SpringLayout.NORTH, tf2, 25, SpringLayout.NORTH, tf1);
		
		layout.putConstraint(SpringLayout.WEST, b1, 5, SpringLayout.WEST, p1);
		layout.putConstraint(SpringLayout.NORTH, b1, 50, SpringLayout.NORTH, l2);
		
		//b1.addActionListener(new Button(b1.getText()));
		
		layout.putConstraint(SpringLayout.WEST, b2, 5, SpringLayout.EAST, b1);
		layout.putConstraint(SpringLayout.NORTH, b2, 50, SpringLayout.NORTH, l2);
		
		//b2.addActionListener(new Button(b2.getText()));
		
		layout.putConstraint(SpringLayout.WEST, b3, 5, SpringLayout.EAST, b2);
		layout.putConstraint(SpringLayout.NORTH, b3, 50, SpringLayout.NORTH, l2);
		
		//b3.addActionListener(new Button(b3.getText()));
		
		layout.putConstraint(SpringLayout.WEST, b4, 5, SpringLayout.EAST, b3);
		layout.putConstraint(SpringLayout.NORTH, b4, 50, SpringLayout.NORTH, l2);
		
		//b4.addActionListener(new Button(b4.getText()));
		
		layout.putConstraint(SpringLayout.WEST, b5, 5, SpringLayout.EAST, b4);
		layout.putConstraint(SpringLayout.NORTH, b5, 50, SpringLayout.NORTH, l2);
		
		//b5.addActionListener(new Button(b5.getText()));
		
		layout.putConstraint(SpringLayout.WEST, b6, 5, SpringLayout.EAST, b5);
		layout.putConstraint(SpringLayout.NORTH, b6, 50, SpringLayout.NORTH, l2);
		
		//b6.addActionListener(new Button(b6.getText()));
		
		layout.putConstraint(SpringLayout.WEST, result, 5, SpringLayout.WEST, p1);
		layout.putConstraint(SpringLayout.NORTH, result, 50, SpringLayout.NORTH, b1);
		
		/*b1.addActionListener(new Button(b1.getText(),this));
		b2.addActionListener(new Button(b2.getText(),this));
		b3.addActionListener(new Button(b3.getText(),this));
		b4.addActionListener(new Button(b4.getText(),this));
		b5.addActionListener(new Button(b5.getText(),this));
		b6.addActionListener(new Button(b6.getText(),this));*/
		f1.add(p1);
		f1.setVisible(true);
	}

}
