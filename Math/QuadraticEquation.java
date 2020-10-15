//this program evaluates how much solutions a quadratic equation has
//the quadratic equation should have the following structure:
//ax^2+bx+c=0

import javax.swing.JOptionPane;

public class QuadraticEquation{
	public static void main(String[] args){
		double a;
		double b;
		double c;
		double D;
		String eingabe;
		eingabe = JOptionPane.showInputDialog("Insert the value for a!");
		a = Double.parseDouble(eingabe);
		eingabe = JOptionPane.showInputDialog("Insert the value for b!");
		b = Double.parseDouble(eingabe);
		eingabe = JOptionPane.showInputDialog("Insert the value for c!");
		c = Double.parseDouble(eingabe);

		D = b * b - 4 * a *c;

		if (D<0){ JOptionPane.showMessageDialog(null, "There is no solution!");}
		else {	if (D>0){ JOptionPane.showMessageDialog(null, "There are two solutions!");}
			else { JOptionPane.showMessageDialog(null, "There is one solution!"); }
		}

		
	}
}
