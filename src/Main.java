import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer cframe = new Customer();
					Bank bframe = new Bank(cframe);
					Merchant mframe = new Merchant(bframe,cframe);
					//Bank frame = new Bank();
					cframe.setVisible(true);
					mframe.setVisible(true);
					bframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
		
		
		
		//System.out.println("First, the Customer must create a money order.\n"
		//		+ "Please enter the value of the money order.");

	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
