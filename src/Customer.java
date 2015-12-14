import java.math.BigInteger;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class Customer extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextArea txtAmount;
	JTextArea signedText;

	protected static final String name = "Bob";
	protected static final String ssn = "223334444";
	protected static final String phone = "443-555-8888";
	protected static final String email = "bob@generic.org";
	protected static final String address = "7800 York Road Towson Maryland 21252";
	
	public int numOfOrders = 100;
	public static MoneyOrder[] moneyOrderArray = null;
	public double moneyOrderValue = 0.0;
	public static String combinedIdentityString = "";
	public static String binaryIdentityString = "";
	public static String randomKeyL = "";
	public static String identityKeyR = "";
	
	
	public Customer(){
		combinedIdentityString = name + ssn + phone + email + address;
		binaryIdentityString = new BigInteger(combinedIdentityString.getBytes()).toString(2);
		
        for (int i = 0; i < binaryIdentityString.length(); i++) {
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(2);
                randomKeyL += randomInt;
        }
        
        for (int i = 0; i < binaryIdentityString.length() && i < randomKeyL.length(); i++) {
            identityKeyR += binaryIdentityString.charAt(i) ^ randomKeyL.charAt(i);
        }
        
        
        setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 120, 701, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2));		
			
		JLabel lblMonmon = new JLabel("MoneyOrderAmount");
		lblMonmon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonmon.setSize(300, 100);
		contentPane.add(lblMonmon);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		txtAmount = new JTextArea();
		scrollPane.setViewportView(txtAmount);
		txtAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAmount.setText(" ");
			}
		});
		txtAmount.setText("First, the Customer must create a money order.\n"
				+ "Please enter the value of the money order.");
		txtAmount.setSize(300, 100);
		txtAmount.setColumns(10);
		
		JLabel lblSignedByBank = new JLabel("Signed By Bank");
		lblSignedByBank.setSize(300, 100);
		contentPane.add(lblSignedByBank);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);
		
		 signedText = new JTextArea();
		scrollPane_1.setViewportView(signedText);
		btnSubmit.setActionCommand("Submit");
		contentPane.add(btnSubmit);

	}
	
	
	public MoneyOrder[] createMoneyOrderArray(double valueMO){
		moneyOrderArray = new MoneyOrder[numOfOrders];
		for(int i = 0; i < moneyOrderArray.length; i++){
			moneyOrderArray[i] = new MoneyOrder(valueMO, randomKeyL, identityKeyR);
		}
		return moneyOrderArray;
	}
	
	public String getIDString(){
		return combinedIdentityString;
	}
	
	public String getBinaryIDString(){
		return binaryIdentityString;
	}
	
	public String getIDKeyL(){
		return randomKeyL;
	}
	
	public String getIDKeyR(){
		return identityKeyR;
	}
	
	public static MoneyOrder[] returnMO(){
		return moneyOrderArray;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Submit")) {
		moneyOrderValue = Double.valueOf(txtAmount.getText());	
//		if ((txtAmount.getText() != null && !txtAmount.getText().isEmpty())){
			//moneyOrderValue = Double.valueOf(txtAmount.getText());
//		}
		//System.out.println(moneyOrderValue);

		createMoneyOrderArray(moneyOrderValue);
		
		txtAmount.setText(" ");
		txtAmount.setText("The ID string that identifies the Customer is: \n" + getIDString() + "\n" +
		"The binary string that identifies the Customer is: \n" + getBinaryIDString() + "\n" +
		"The random binary string L is: \n" + getIDKeyL() + "\n" +
		"The binary string R is: \n" + getIDKeyR());
		
//		System.out.println("\nThe ID string on the money order is: " + example.getID());

		//System.out.println("\nNow, the bank must verify all but one money order and sign the remaining order.");
		
		//Bank authority = new Bank (bob.moneyOrderArray);
		
		//System.out.println("The MO selector number is: " + authority.getRandomSelector());
		//System.out.println("Matching money order values? " + authority.checkValue());
		//System.out.println("Money Order unique? " + authority.checkUniqueness());
		//System.out.println("Money order stored in records? " + authority.storeUniqueness());
		//System.out.println("Money order signed by bank? " + authority.signMoneyOrder());
		
		
		//System.out.println("\nNow, it's time for the merchant to verify the money order.");
		
		//Merchant store = new Merchant(authority.moneyOrderArrayFromCustomer[authority.moneyOrderSelector]);
		
		//System.out.println("Is the money order signed by the bank? " + store.isSignedByBank());
		//store.revealIdentityHalf();
		}
	}
		
		
}