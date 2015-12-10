import java.math.BigInteger;
import java.util.Random;


public class Customer {
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
