import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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


public class Merchant extends JFrame{
	private String bankSignature = "1234567890ABCDEFG";
	public MoneyOrder moneyOrderFromBank = null;
	private JPanel contentPane;
	private JTextField txtAmount;
	
	
	
	public Merchant(MoneyOrder incomingMoneyOrder){
		moneyOrderFromBank = incomingMoneyOrder;
		
		setTitle("Merchant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2));		
			
		JLabel lblMonmon = new JLabel("Incoming Amount");
		lblMonmon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonmon.setSize(300, 100);
		contentPane.add(lblMonmon);
		
		txtAmount = new JTextField();
		txtAmount.setText("Amount");
		txtAmount.setSize(300, 100);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblBankApproved = new JLabel("Bank Approved");
		lblBankApproved.setSize(300, 100);
		contentPane.add(lblBankApproved);
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane);		
		
		JButton btnSubmit = new JButton("Ship Merchadise");
		contentPane.add(btnSubmit);
		
	}
	
	public boolean isSignedByBank(){
		if(moneyOrderFromBank.bankSignature == bankSignature){
			return true;
		}
		return false;
	}
	
	public void revealIdentityHalf(){
		if (selectorInt() == 0){
			System.out.println("The left identity is: " + moneyOrderFromBank.customerIDLeft);
		}
		else
			System.out.println("The right identity is " + moneyOrderFromBank.customerIDRight);
	}
	
	public int selectorInt(){
        Random randomGenerator2 = new Random();
        int selector = randomGenerator2.nextInt(2);
        //System.out.println("Selector = " + selector);
        return selector;
	}

}
