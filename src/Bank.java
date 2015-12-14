import java.awt.GridLayout;
import java.util.Random;
//testpush

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bank extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtAmount;
	JTextArea textTrustMerchant;
	
	public static MoneyOrder[] moneyOrderArrayFromCustomer = null;
	public String[][] uniqueness = new String[100][3];
	public static double moneyOrderValue = 0;
	public static boolean matchingAmounts = true;
	public boolean isUnique;
	public static int moneyOrderSelector = 0;
	private String signature = "1234567890ABCDEFG";
	
	
	
	public Bank(final Customer cust){
		
		
		Random randomSelector = new Random();
        moneyOrderSelector = randomSelector.nextInt(100);      
        setTitle("Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 600, 590, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblMonmon = new JLabel("Transaction Amount");
		lblMonmon.setLocation(5, 5);
		lblMonmon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonmon.setSize(148, 89);
		contentPane.add(lblMonmon);		
		final JTextArea textTranactionAmoutn = new JTextArea();
		textTranactionAmoutn.setBounds(295, 5, 290, 89);
		contentPane.add(textTranactionAmoutn);			
		JLabel lblTrustCustomer = new JLabel("Trusted Customer");
		lblTrustCustomer.setLocation(5, 94);
		lblTrustCustomer.setSize(148, 100);
		contentPane.add(lblTrustCustomer);		
		JLabel lblTrustMerchant = new JLabel("Trusted Merchant");
		lblTrustMerchant.setBounds(5, 183, 148, 89);		
		final JTextArea textTrustCustomer = new JTextArea();
		textTrustCustomer.setBounds(295, 94, 290, 89);
		contentPane.add(textTrustCustomer);		
		
		contentPane.add(lblTrustMerchant);		
		
		textTrustMerchant = new JTextArea();
		textTrustMerchant.setBounds(295, 183, 290, 89);
		textTrustMerchant.setText(" ");
		contentPane.add(textTrustMerchant);		
		JButton btnCheckForMoney = new JButton("Process Transactions");

		btnCheckForMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moneyOrderArrayFromCustomer = cust.returnMO();
				textTranactionAmoutn.setText("Now, the bank must verify all but one \n money order and sign the remaining order.\n" +
						"The MO selector number is: " + getRandomSelector() + "\n");
						
				textTrustCustomer.setText(
						"Matching money order values? " + checkValue() + "\n" +
						"Money order stored in records? " + storeUniqueness() + "\n" +
						"Money Order unique? " + checkUniqueness()+ "\n" + 
						"Money order signed by bank? " + signMoneyOrder());
						cust.signedText.setText("Money Order Signed By Bank!");
			}
		});
		btnCheckForMoney.setBounds(132, 233, 157, 39);
		contentPane.add(btnCheckForMoney);
		
	}
	
	public MoneyOrder returnMO(){
		return moneyOrderArrayFromCustomer[moneyOrderSelector];
	}
	
	public static boolean checkValue(){
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
