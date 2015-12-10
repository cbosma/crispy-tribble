import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}