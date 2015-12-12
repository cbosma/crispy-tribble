import java.math.BigInteger;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextPane;

public class Customer extends JFrame{
	private JPanel contentPane;
	private JTextField txtAmount;

	protected static final String name = "Bob";
	protected static final String ssn = "223334444";
	protected static final String phone = "443-555-8888";
	protected static final String email = "bob@generic.org";
	protected static final String address = "7800 York Road Towson Maryland 21252";
	
	public int numOfOrders = 100;
	public MoneyOrder[] moneyOrderArray = null;
//	public double moneyOrderValue = null;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2));		
			
		JLabel lblMonmon = new JLabel("MoneyOrderAmount");
		lblMonmon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonmon.setSize(300, 100);
		contentPane.add(lblMonmon);
		
		txtAmount = new JTextField();
		txtAmount.setText("Amount");
		txtAmount.setSize(300, 100);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblSignedByBank = new JLabel("Signed By Bank");
		lblSignedByBank.setSize(300, 100);
		contentPane.add(lblSignedByBank);
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane);		
		
		JButton btnSubmit = new JButton("Submit");
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
		
}