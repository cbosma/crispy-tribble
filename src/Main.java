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
					Merchant mframe = new Merchant(null);
					Bank bframe = new Bank(null);
					//Bank frame = new Bank();
					cframe.setVisible(true);
					mframe.setVisible(true);
					bframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Customer bob = new Customer();
		
		System.out.println("First, the Customer must create a money order.\n"
				+ "Please enter the value of the money order.");
		
		Scanner in = new Scanner(System.in);
		double moneyOrderValue = in.nextDouble();

		
		
		bob.createMoneyOrderArray(moneyOrderValue);
		
		System.out.println("The ID string that identifies the Customer is: " + bob.getIDString());
		System.out.println("The binary string that identifies the Customer is: " + bob.getBinaryIDString());
		System.out.println("The random binary string L is: " + bob.getIDKeyL());
		System.out.println("The binary string R is: " + bob.getIDKeyR());
		
//		System.out.println("\nThe ID string on the money order is: " + example.getID());

		System.out.println("\nNow, the bank must verify all but one money order and sign the remaining order.");
		
		Bank authority = new Bank (bob.moneyOrderArray);
		
		System.out.println("The MO selector number is: " + authority.getRandomSelector());
		System.out.println("Matching money order values? " + authority.checkValue());
		System.out.println("Money Order unique? " + authority.checkUniqueness());
		System.out.println("Money order stored in records? " + authority.storeUniqueness());
		System.out.println("Money order signed by bank? " + authority.signMoneyOrder());
		
		
		System.out.println("\nNow, it's time for the merchant to verify the money order.");
		
		Merchant store = new Merchant(authority.moneyOrderArrayFromCustomer[authority.moneyOrderSelector]);
		
		System.out.println("Is the money order signed by the bank? " + store.isSignedByBank());
		store.revealIdentityHalf();
		
		
	}
	
	private static void bankGUI() {
		//Create and set up the window.
        JFrame frame = new JFrame("Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the Customer ID label.
        JLabel label = new JLabel("Bank");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
		
	}

	private static void merchantGUI() {
		//Create and set up the window.
        JFrame frame = new JFrame("Merchant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the Customer ID label.
        JLabel label = new JLabel("Merchant ID");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
		
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
