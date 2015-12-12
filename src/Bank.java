import java.awt.GridLayout;
import java.util.Random;
//testpush

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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

public class Bank extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtAmount;
	
	public MoneyOrder[] moneyOrderArrayFromCustomer = null;
	public String[][] uniqueness = new String[100][3];
	public double moneyOrderValue;
	public boolean matchingAmounts = true;
	public boolean isUnique;
	public int moneyOrderSelector;
	private String signature = "1234567890ABCDEFG";
	
	
	public Bank(MoneyOrder[] moneyOrderArray){
		
		moneyOrderArrayFromCustomer = moneyOrderArray;
		
		Random randomSelector = new Random();
        moneyOrderSelector = randomSelector.nextInt(100);
        
        
        
        
        setTitle("Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2));		
			
		JLabel lblMonmon = new JLabel("Transaction Amount");
		lblMonmon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonmon.setSize(300, 100);
		contentPane.add(lblMonmon);
		
		JTextPane textTranactionAmoutn = new JTextPane();
		contentPane.add(textTranactionAmoutn);	
		
		JLabel lblTrustCustomer = new JLabel("Trusted Customer");
		lblTrustCustomer.setSize(300, 100);
		contentPane.add(lblTrustCustomer);
		
		JTextPane textTrustCustomer = new JTextPane();
		contentPane.add(textTrustCustomer);
		
		JLabel lblTrustMerchant = new JLabel("Trusted Merchant");
		lblTrustCustomer.setSize(300, 100);
		contentPane.add(lblTrustMerchant);
		
		JTextPane textTrustMerchant = new JTextPane();
		contentPane.add(textTrustMerchant);		
		
		
		
		
	}
	
	public boolean checkValue(){
		moneyOrderValue = moneyOrderArrayFromCustomer[0].value;
		int counter = 0;
		while(matchingAmounts == true && counter < moneyOrderArrayFromCustomer.length){
			if(moneyOrderValue != moneyOrderArrayFromCustomer[counter].value)
				matchingAmounts = false;
			counter++;
		}
		return matchingAmounts;
	}
	
	public boolean checkUniqueness(){
		isUnique = true;
		int counter = 0;
		while((isUnique == true) && (counter < 100)){
			if(moneyOrderArrayFromCustomer[moneyOrderSelector].uniqueNumber.equals(uniqueness[counter][1]))
				isUnique = false;
		counter++;
		}
		return isUnique;
	}
	
	public int getRandomSelector(){
		return moneyOrderSelector;
	}
	
	public boolean signMoneyOrder(){
		if((isUnique == true) && (matchingAmounts == true)){
			moneyOrderArrayFromCustomer[moneyOrderSelector].bankSignature = signature;
			return true;
		}
		return false;
	}
	
	public boolean storeUniqueness(){
		boolean stored = false;
		int counter = 0;
		if(checkUniqueness() == true){
			while(stored == false && counter < 100){
				if(uniqueness[counter][0] == null){
					uniqueness[counter][0] = moneyOrderArrayFromCustomer[moneyOrderSelector].uniqueNumber;
					uniqueness[counter][1] = moneyOrderArrayFromCustomer[moneyOrderSelector].customerIDLeft;
					uniqueness[counter][2] = moneyOrderArrayFromCustomer[moneyOrderSelector].customerIDRight;
					stored = true;
				}
			counter++;	
			}
		}
		return stored;
	}
	
	

}
