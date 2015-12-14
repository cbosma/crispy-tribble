import java.awt.GridLayout;
import java.util.Random;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


public class Merchant extends JFrame{
	private String bankSignature = "1234567890ABCDEFG";
	public MoneyOrder moneyOrderFromBank = null;
	private JPanel contentPane;
	private JTextArea txtAmount;
	
	
	
	public Merchant(final Bank bank, final Customer cust){
		
		
		setTitle("Merchant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2));		
			
		JLabel lblMonmon = new JLabel("Incoming Amount");
		lblMonmon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonmon.setSize(300, 100);
		contentPane.add(lblMonmon);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		txtAmount = new JTextArea();
		scrollPane.setViewportView(txtAmount);
		txtAmount.setText("Amount");
		txtAmount.setSize(300, 100);
		txtAmount.setColumns(10);
		
		JLabel lblBankApproved = new JLabel("Bank Approved");
		lblBankApproved.setSize(300, 100);
		contentPane.add(lblBankApproved);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JButton btnSubmit = new JButton("Ship Merchadise");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cust.signedText.setText("Order Recieved by Merchant!");
				bank.textTrustMerchant.setText("Merchant Verified, Order Fulfiled");
			}
		});
		contentPane.add(btnSubmit);
		
		JButton btnCheckOrders = new JButton("Check Orders");
		btnCheckOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moneyOrderFromBank = bank.returnMO();
				txtAmount.setText(bank.returnMO().getValueString());
				textArea.setText("Is the money order signed by the bank? " + isSignedByBank() + " \n" +
				(revealIdentityHalf()));
				
			}
		});
		contentPane.add(btnCheckOrders);
		
	}
	
	public boolean isSignedByBank(){
		if(moneyOrderFromBank.bankSignature == bankSignature){
			return true;
		}
		return false;
	}
	
	public String revealIdentityHalf(){
		String S;
		if (selectorInt() == 0){
			
			 S = "The left identity is: " + moneyOrderFromBank.customerIDLeft;
		}
		else
			S = "The right identity is " + moneyOrderFromBank.customerIDRight;
		return S;
	}
	
	public int selectorInt(){
        Random randomGenerator2 = new Random();
        int selector = randomGenerator2.nextInt(2);
        //System.out.println("Selector = " + selector);
        return selector;
	}

}
