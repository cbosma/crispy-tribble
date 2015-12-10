import java.util.Random;


public class Merchant {
	private String bankSignature = "1234567890ABCDEFG";
	public MoneyOrder moneyOrderFromBank = null;
	
	
	
	public Merchant(MoneyOrder incomingMoneyOrder){
		moneyOrderFromBank = incomingMoneyOrder;
		
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
